import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JSpinner.DefaultEditor;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jose_
 */
public class PantallaPonerMulta extends Pantalla {

    private static InterfazMultas stub;
    private final Contador contador;
    private final PantallaGestion padre;
    
    /**
     * Creates new form PantallaConsultarPuntos
     * @param stub Para acceder a los métodos del servidor.
     * @param contador Servirá para comprobar el tiempo. Si han pasado 5 minutos, no se dejará hacer ninguna acción.
     * @param padre Pantalla que me creó. La cerraré cuando pasen los 5 minutos.
     */
    public PantallaPonerMulta(InterfazMultas stub, Contador contador, PantallaGestion padre) {
        
        initComponents();
        super.inicializar(450, 200, "Poner multa");
        PantallaPonerMulta.stub = stub;
        this.contador = contador;
        this.padre = padre;
        ((DefaultEditor) spPuntos.getEditor()).getTextField().setEditable(false);
    }
    
    /**
     * Se llamará para saber la fecha y la hora actuales.
     * @return Devuelve la fecha y hora actuales en un String.
     */
    private String obtenerFecha()
    {
        return (new SimpleDateFormat("dd/MM/yyyy-HH:mm").format(new Date()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        btMultar = new javax.swing.JButton();
        jlInfo = new javax.swing.JLabel();
        cbMat = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        spPuntos = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Matrícula:");

        btMultar.setText("Multar");
        btMultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMultarActionPerformed(evt);
            }
        });

        jlInfo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jlInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        cbMat.setEditable(true);
        cbMat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "7861-HJI", "5661-LLK", "0988-HKP" }));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Puntos:");

        spPuntos.setModel(new javax.swing.SpinnerNumberModel(6, 1, 12, 1));
        spPuntos.setFocusable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(cbMat, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(spPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btMultar)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btMultar)
                    .addComponent(cbMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(spPuntos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jlInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btMultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMultarActionPerformed
        
        if(!contador.getTimeout())
        {
            contador.reset();
            
            String mat = cbMat.getSelectedItem().toString();
        
            if(mat.isEmpty())
                jlInfo.setText("Los datos especificados no son correctos.");

            else
            {
                try 
                {
                    int result = stub.ponerMulta(mat, this.obtenerFecha(), (int) spPuntos.getModel().getValue());

                    if(result == 1)
                        jlInfo.setText("Se ha puesto la multa correctamente.");

                    else
                        jlInfo.setText("Los datos especificados no son correctos.");
                } 

                catch (RemoteException ex) 
                {

                }
            }
        }
        
        else
        {
            JOptionPane.showMessageDialog(null, "Han pasado 5 minutos, te tienes que volver a identificar.");
            
            padre.dispose();
            this.dispose();
            new PantallaIdentificacion(stub).setVisible(true);
        }
    }//GEN-LAST:event_btMultarActionPerformed

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
            java.util.logging.Logger.getLogger(PantallaConsultarPuntos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaConsultarPuntos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaConsultarPuntos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaConsultarPuntos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaConsultarPuntos(stub).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btMultar;
    private javax.swing.JComboBox<String> cbMat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jlInfo;
    private javax.swing.JSpinner spPuntos;
    // End of variables declaration//GEN-END:variables
}
