/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alumnos;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

/**
 *
 * @author fermelli
 */
public class Alumnos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Alumno> alumnos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcion;
        int posicion;

        do {
            opcion = menu();
            switch (opcion) {
                case 1:
                    Alumno alumno = agregarAlumno();
                    alumnos.add(alumno);
                    break;
                case 2:
                    if (alumnos.size() > 0) {
                        mostrarAlumnos(alumnos);
                        System.out.println("--- Editar ---");
                        do {
                            System.out.print("Introduzca la posicion del alumno: ");
                            posicion = scanner.nextInt() - 1;
                            if (posicion < 0 || posicion > alumnos.size() - 1) {
                                System.out.println("La posicion no es válida");
                            }
                        } while (posicion < 0 || posicion > alumnos.size() - 1);

                        Alumno alumnoAEditar = alumnos.get(posicion);
                        editarAlumno(alumnoAEditar);
                        System.out.println("Alumno editado");
                        System.out.println("--------------");
                    } else {
                        System.out.println("No hay alumnos para editar");
                    }
                    break;
                case 3:
                    if (alumnos.size() > 0) {
                        mostrarAlumnos(alumnos);
                        System.out.println("--- Eliminar ---");
                        do {
                            System.out.print("Introduzca la posicion del alumno: ");
                            posicion = scanner.nextInt() - 1;
                            if (posicion < 0 || posicion > alumnos.size() - 1) {
                                System.out.println("La posicion no es válida");
                            }
                        } while (posicion < 0 || posicion > alumnos.size() - 1);

                        alumnos.remove(posicion);
                        System.out.println("Alumno eliminado");
                        System.out.println("--------------");
                    } else {
                        System.out.println("No hay alumnos para editar");
                    }
                    break;
                default:
                    System.out.println("Saliendo...");

            }
        } while (opcion != 4);

    }

    public static int menu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("--- Menú de Opciones ---");
            System.out.println("1. Agregar alumno");
            System.out.println("2. Editar alumno");
            System.out.println("3. Eliminar alumno");
            System.out.println("4. Salir");

            opcion = scanner.nextInt();

            if (opcion < 1 || opcion > 4) {
                System.out.println("¡Introduzca una opción válida!");
            }
        } while (opcion < 1 || opcion > 4);

        return opcion;
    }

    public static Alumno agregarAlumno() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Alumno nuevo ---");
        System.out.print("Nombres: ");
        String names = scanner.nextLine();
        System.out.print("Apellido Paterno: ");
        String paternalSurname = scanner.nextLine();
        System.out.print("Apellido Materno: ");
        String maternalSurname = scanner.nextLine();
        String collegeID = UUID.randomUUID().toString();

        return new Alumno(names, paternalSurname, maternalSurname, collegeID);
    }

    public static void editarAlumno(Alumno alumno) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Alumno editado ---");
        System.out.print("Nombres: ");
        alumno.setNames(scanner.nextLine());
        System.out.print("Apellido Paterno: ");
        alumno.setPaternalSurname(scanner.nextLine());
        System.out.print("Apellido Materno: ");
        alumno.setMaternalSurname(scanner.nextLine());
        alumno.setCollegeID(alumno.getCollegeID());
    }

    public static void mostrarAlumnos(ArrayList<Alumno> alumnos) {
        int posicion = 1;
        System.out.println("--- Alumnos ---");
        for (Alumno alumno : alumnos) {
            System.out.println(String.format("------ Posición: %d ------", posicion));
            System.out.println(String.format("ID: %s", alumno.getCollegeID()));
            System.out.println(String.format("Nombres: %s", alumno.getNames()));
            System.out.println(String.format("Apellidos: %s %s", alumno.getPaternalSurname(), alumno.getMaternalSurname()));
            posicion++;
        }
        System.out.println("-------------");
    }

}
