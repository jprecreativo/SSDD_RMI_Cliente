import java.rmi.RemoteException;
import java.util.LinkedList;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jose_
 */
public class PantallaConsultarMultas extends Pantalla {

   private static InterfazMultas stub;
    
    /**
     * Creates new form PantallaConsultarMultas
     * @param stub Para acceder a los métodos del servidor.
     */
    public PantallaConsultarMultas(InterfazMultas stub) {
        initComponents();
        super.inicializar(500, 500, "Consultar multas");
        PantallaConsultarMultas.stub = stub;
        this.centrarColumnas();
    }
    
    /**
     * Hace que el contenido de todas las celdas de la tabla esté centrado.
     */
    private void centrarColumnas()
    {
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();

        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        
        for(int i = 0; i < tablaMultas.getColumnCount(); i++)
            tablaMultas.getColumnModel().getColumn(i).setCellRenderer(renderer);
    }
    
    /**
     * Limpia la tabla, dejando todas sus celdas vacías de contenido.
     */
    private void limpiarTabla()
    {
        for(int i = 0; i < tablaMultas.getRowCount(); i++)
            for(int j = 0; j < tablaMultas.getColumnCount(); j++)
                tablaMultas.setValueAt("", i, j);
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
        btConsultar = new javax.swing.JButton();
        jlInfo = new javax.swing.JLabel();
        cbDNI = new javax.swing.JComboBox<>();
        cbMat = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMultas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("DNI:");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Matrícula:");

        btConsultar.setText("Consultar");
        btConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsultarActionPerformed(evt);
            }
        });

        jlInfo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jlInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        cbDNI.setEditable(true);
        cbDNI.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "45134789", "45111786" }));

        cbMat.setEditable(true);
        cbMat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "7861-HJI", "5661-LLK", "0988-HKP" }));

        tablaMultas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "#", "Matrícula", "Fecha", "Puntos perdidos"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaMultas.setFocusable(false);
        tablaMultas.setName(""); // NOI18N
        tablaMultas.setRowSelectionAllowed(false);
        tablaMultas.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaMultas);
        if (tablaMultas.getColumnModel().getColumnCount() > 0) {
            tablaMultas.getColumnModel().getColumn(0).setMinWidth(20);
            tablaMultas.getColumnModel().getColumn(0).setMaxWidth(30);
            tablaMultas.getColumnModel().getColumn(1).setResizable(false);
            tablaMultas.getColumnModel().getColumn(2).setResizable(false);
            tablaMultas.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlInfo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(cbDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(cbMat, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                                .addComponent(btConsultar)))
                        .addGap(28, 28, 28))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(btConsultar)
                    .addComponent(cbDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jlInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultarActionPerformed
        
        this.limpiarTabla();
        
        String DNI = cbDNI.getSelectedItem().toString();
        String mat = cbMat.getSelectedItem().toString();
        
        if(DNI.isEmpty() || mat.isEmpty() || !DNI.matches("^[0-9]\\d*$"))
            jlInfo.setText("Los datos especificados no son correctos.");
        
        else
        {
            try 
            {
                LinkedList<Multa> result = stub.comprobarMultas(Integer.parseInt(DNI), mat);

                if(result.isEmpty())
                    jlInfo.setText("El vehículo especificado no tiene multas o los datos son erróneos.");

                else
                {
                    int numMultas = result.size();
                    DefaultTableModel modelo = (DefaultTableModel) tablaMultas.getModel();
                    
                    if(numMultas == 1)
                        jlInfo.setText("El conductor de DNI " + DNI + " tiene " + result.size() + " multa.");
                    
                    else
                        jlInfo.setText("El conductor de DNI " + DNI + " tiene " + result.size() + " multas.");
                    
                    for(int i = 0; i < numMultas; i++)
                    {
                        Multa m = result.get(i);
                        
                        modelo.setValueAt(i + 1, i, 0);
                        modelo.setValueAt(m.getMat(), i, 1);
                        modelo.setValueAt(m.getFecha(), i, 2);
                        modelo.setValueAt(m.getPuntos(), i, 3);
                    }
                }
            } 

            catch (RemoteException ex) 
            {
                
            }
        }
    }//GEN-LAST:event_btConsultarActionPerformed

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
    private javax.swing.JButton btConsultar;
    private javax.swing.JComboBox<String> cbDNI;
    private javax.swing.JComboBox<String> cbMat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlInfo;
    private javax.swing.JTable tablaMultas;
    // End of variables declaration//GEN-END:variables
}
