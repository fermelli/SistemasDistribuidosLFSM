/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteserviciowebjava;

/**
 *
 * @author fermelli
 */
public class ClienteServicioWebJava extends javax.swing.JFrame {

    int a;
    int b;
    clienteserviciowebjava.Operaciones service;
    clienteserviciowebjava.OperacionesSoap port;

    /**
     * Creates new form ClienteServicioWebJava
     */
    public ClienteServicioWebJava() {
        initComponents();
        service = new clienteserviciowebjava.Operaciones();
        port = service.getOperacionesSoap();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtA = new javax.swing.JTextField();
        txtB = new javax.swing.JTextField();
        btnSumar = new javax.swing.JButton();
        btnRestar = new javax.swing.JButton();
        btnMultiplicar = new javax.swing.JButton();
        btnDividir = new javax.swing.JButton();
        lblResultado = new javax.swing.JLabel();
        txtResultado = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("valor de A:");

        jLabel2.setText("valor de B:");

        btnSumar.setText("Sumar");
        btnSumar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSumarActionPerformed(evt);
            }
        });

        btnRestar.setText("Restar");
        btnRestar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestarActionPerformed(evt);
            }
        });

        btnMultiplicar.setText("Multiplicar");
        btnMultiplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMultiplicarActionPerformed(evt);
            }
        });

        btnDividir.setText("Dividir");
        btnDividir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDividirActionPerformed(evt);
            }
        });

        lblResultado.setText("resultado:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnSumar)
                                        .addGap(40, 40, 40)
                                        .addComponent(btnRestar)
                                        .addGap(29, 29, 29)
                                        .addComponent(btnMultiplicar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(129, 129, 129)
                                        .addComponent(lblResultado)))
                                .addGap(0, 37, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtA, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtB, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(txtResultado)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDividir)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSumar)
                    .addComponent(btnRestar)
                    .addComponent(btnMultiplicar)
                    .addComponent(btnDividir))
                .addGap(18, 18, 18)
                .addComponent(lblResultado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void leerValores() {
        a = Integer.parseInt(txtA.getText());
        b = Integer.parseInt(txtB.getText());
    }

    private void btnSumarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSumarActionPerformed
        leerValores();

        int resultado = port.suma(a, b);

        txtResultado.setText("El Resultado es: " + resultado);
    }//GEN-LAST:event_btnSumarActionPerformed

    private void btnRestarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestarActionPerformed
        leerValores();

        int resultado = port.resta(a, b);

        txtResultado.setText("El Resultado es: " + resultado);
    }//GEN-LAST:event_btnRestarActionPerformed

    private void btnMultiplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMultiplicarActionPerformed
        leerValores();

        int resultado = port.multiplicacion(a, b);

        txtResultado.setText("El Resultado es: " + resultado);
    }//GEN-LAST:event_btnMultiplicarActionPerformed

    private void btnDividirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDividirActionPerformed
        leerValores();

        if (b != 0) {
            float resultado = port.division(a, b);

            txtResultado.setText("El Resultado es: " + resultado);
        } else {
            txtResultado.setText("No se puede dividir entre 0");
        }

    }//GEN-LAST:event_btnDividirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClienteServicioWebJava.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteServicioWebJava.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteServicioWebJava.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteServicioWebJava.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClienteServicioWebJava().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDividir;
    private javax.swing.JButton btnMultiplicar;
    private javax.swing.JButton btnRestar;
    private javax.swing.JButton btnSumar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblResultado;
    private javax.swing.JTextField txtA;
    private javax.swing.JTextField txtB;
    private javax.swing.JTextField txtResultado;
    // End of variables declaration//GEN-END:variables

}
