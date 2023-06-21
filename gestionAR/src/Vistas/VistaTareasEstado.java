

package Vistas;

import Control.TareaData;
import Modelo.Tarea;
import java.util.List;


public class VistaTareasEstado extends javax.swing.JInternalFrame {
    
    private TareaData tData=new TareaData();

    public VistaTareasEstado() {
        initComponents();
        cargarTareas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLTareas = new javax.swing.JLabel();
        jcTareas = new javax.swing.JComboBox<>();
        jcEstado = new javax.swing.JComboBox<>();
        jLEstado = new javax.swing.JLabel();
        jbSalir = new javax.swing.JButton();
        jbActualizar = new javax.swing.JButton();
        jbLimpiar = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("Actualizar Estado");

        jLTareas.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLTareas.setText("Tareas:");

        jcTareas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcTareasActionPerformed(evt);
            }
        });

        jcEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Completada", "En Progreso", "Pendiente" }));

        jLEstado.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLEstado.setText("Estado:");

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jbActualizar.setText("Actualizar");
        jbActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActualizarActionPerformed(evt);
            }
        });

        jbLimpiar.setText("Limpiar");
        jbLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(132, Short.MAX_VALUE)
                .addComponent(jbLimpiar)
                .addGap(18, 18, 18)
                .addComponent(jbActualizar)
                .addGap(18, 18, 18)
                .addComponent(jbSalir)
                .addGap(42, 42, 42))
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLTareas)
                        .addGap(18, 18, 18)
                        .addComponent(jcTareas, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLEstado)
                        .addGap(18, 18, 18)
                        .addComponent(jcEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLTareas)
                    .addComponent(jcTareas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLEstado)
                    .addComponent(jcEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbActualizar)
                    .addComponent(jbSalir)
                    .addComponent(jbLimpiar))
                .addGap(51, 51, 51))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarActionPerformed
        // TODO add your handling code here:
        Tarea tareaSeleccionada = (Tarea) jcTareas.getSelectedItem();
        int idTareaSeleccionada = tareaSeleccionada.getIdTarea();
        String estadoSeleccionado = (String) jcEstado.getSelectedItem();
        
        tData.actualizarEstado(estadoSeleccionado , idTareaSeleccionada);
        limpiar();
    }//GEN-LAST:event_jbActualizarActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jcTareasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcTareasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcTareasActionPerformed

    private void jbLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpiarActionPerformed
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_jbLimpiarActionPerformed
    
    public void limpiar(){
        jcTareas.setSelectedItem(null);
        jcEstado.setSelectedItem(" ");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLEstado;
    private javax.swing.JLabel jLTareas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jbActualizar;
    private javax.swing.JButton jbLimpiar;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox<String> jcEstado;
    private javax.swing.JComboBox<Tarea> jcTareas;
    // End of variables declaration//GEN-END:variables

    private void cargarTareas() {
        List<Tarea> tareas=tData.listarTareas();
        for(Tarea tar:tareas){
            jcTareas.addItem(tar);
        }       
   
    }
    
    
    
}
