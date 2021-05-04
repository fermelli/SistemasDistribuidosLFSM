/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package votacionjgroups;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.jgroups.View;
import org.jgroups.util.Util;

/**
 *
 * @author fermelli
 */
public class VotacionJGROUPS extends ReceiverAdapter {

    private final String nombreUsuario;
    private final Votacion[] votacion = new Votacion[3];
    JChannel channel;
    final List<String> state = new LinkedList<>();

    public VotacionJGROUPS(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
        setVotacion();
    }

    public void setVotacion() {
        String[] nombresCandidatos = {"Juan", "Pedro", "Maria"};
        for (int i = 0; i < votacion.length; i++) {
            Votacion votos = new Votacion(nombresCandidatos[i], 0);
            votacion[i] = votos;
        }
    }

    public void viewAccepted(View new_view) {
        System.out.println("*** Vista: " + new_view + "***");
    }

    public void receive(Message msg) {
        String line = "\n" + msg.getSrc() + ": " + msg.getObject();
        System.out.println(line);
        synchronized (state) {
            state.add(line);
        }
    }

    public void getState(OutputStream output) throws Exception {
        synchronized (state) {
            Util.objectToStream(state, new DataOutputStream(output));
        }
    }

    public void setState(InputStream input) throws Exception {
        List<String> list = (List<String>) Util.objectFromStream(new DataInputStream(input));
        synchronized (state) {
            state.clear();
            state.addAll(list);
        }
        System.out.println("estado recibido (" + list.size() + " mensajes en la historia del chat ):");
        for (String str : list) {
            System.out.println(str);
        }
    }

    private void start() throws Exception {
        channel = new JChannel();
        channel.setReceiver(this);
        channel.connect("Votos");
        channel.getState(null, 0);
        eventLoop();
        channel.close();
    }

    private void eventLoop() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int index = 0;
        while (true) {
            if (index < votacion.length) {
                for (Votacion votos : votacion) {
                    index ++;
                    try {

                        System.out.print("Votos para " + votos.getCandidato() + ": ");
                        System.out.flush();
                        String conteoCadena = in.readLine();
                        int conteo = Integer.parseInt(conteoCadena);
                        votos.setVotos(conteo);
                        String line = "Los votos registrados por [" + nombreUsuario + "] para el candidato " + votos.getCandidato() + " son:" + conteo;
                        Message msg = new Message(null, line);
                        channel.send(msg);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }

        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca su nombre: ");
        String nombre;
        nombre = sc.nextLine();
        new VotacionJGROUPS(nombre).start();
    }

}
