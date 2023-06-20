
package Vistas;

import Control.ComentariosData;
import Control.TareaData;
import Modelo.Comentarios;
import Modelo.Tarea;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class VistaAvanceTareas extends javax.swing.JInternalFrame {
    private TareaData tData=new TareaData();
    private ComentariosData cData = new ComentariosData();
    private DefaultTableModel modelo=new DefaultTableModel(){
    
        @Override
        public boolean isCellEditable(int row,int colum){
            if(colum==0||colum==1||colum==2){
                return false;
            }else{
                return true;
            }
        }
    };
    
    public VistaAvanceTareas() {
        initComponents();
        cargarTareas();
        armarCabecera();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLTareas = new javax.swing.JLabel();
        jcTareas = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtComentarios = new javax.swing.JTable();
        jbSalir = new javax.swing.JButton();
        jbComentar = new javax.swing.JButton();
        jbActualizar = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Dialog", 3, 16)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Avance de Tareas");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLTareas.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLTareas.setText("Tareas:");

        jcTareas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcTareasActionPerformed(evt);
            }
        });

        jtComentarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtComentarios);

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jbComentar.setText("Comentar");
        jbComentar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbComentarActionPerformed(evt);
            }
        });

        jbActualizar.setText("Actualizar");
        jbActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jLTareas)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcTareas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbComentar)
                        .addGap(18, 18, 18)
                        .addComponent(jbActualizar)
                        .addGap(18, 18, 18)
                        .addComponent(jbSalir))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLTareas)
                    .addComponent(jcTareas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbActualizar)
                    .addComponent(jbSalir)
                    .addComponent(jbComentar))
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarActionPerformed
        // TODO add your handling code here:
        Tarea tareaSeleccionada = (Tarea) jcTareas.getSelectedItem();
        int filaSeleccionada = jtComentarios.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(null, "Selecciona una fila de la tabla.");
            return;
        } 

        int idTarea = tareaSeleccionada.getIdTarea();
        String nuevoComentario;
        LocalDate nuevaFechaAvance;

        try {
            nuevoComentario = JOptionPane.showInputDialog("Ingrese el nuevo comentario:");
            String nuevaFechaStr = JOptionPane.showInputDialog("Ingrese la nueva fecha de avance (YYYY-MM-DD):");
            nuevaFechaAvance = LocalDate.parse(nuevaFechaStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese un comentario y una fecha válidos.");
            return;
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Ingrese una fecha válida en el formato YYYY-MM-DD.");
            return;
        }

        cData.actualizarComentario(nuevoComentario, nuevaFechaAvance, idTarea);
        borrarFilas();
        
    }//GEN-LAST:event_jbActualizarActionPerformed

    private void jbComentarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbComentarActionPerformed
        // TODO add your handling code here:
        Tarea tareaSeleccionada = (Tarea) jcTareas.getSelectedItem();

        int idTarea = tareaSeleccionada.getIdTarea();
        String nuevoComentario;
        LocalDate nuevaFechaAvance;

        try {
            nuevoComentario = JOptionPane.showInputDialog("Ingrese el nuevo comentario:");
            String nuevaFechaStr = JOptionPane.showInputDialog("Ingrese la nueva fecha de avance (YYYY-MM-DD):");
            nuevaFechaAvance = LocalDate.parse(nuevaFechaStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese un comentario y una fecha válidos.");
            return;
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Ingrese una fecha válida en el formato YYYY-MM-DD.");
            return;
        }

        Comentarios comen = new Comentarios(nuevoComentario, nuevaFechaAvance, idTarea);
        cData.registrarComentario(comen);
        borrarFilas();
    }//GEN-LAST:event_jbComentarActionPerformed

    private void jcTareasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcTareasActionPerformed
        // TODO add your handling code here:
        llenarTabla();
    }//GEN-LAST:event_jcTareasActionPerformed
    
    private void cargarTareas() {
        List<Tarea> tareas=tData.listarTareas();
        for(Tarea tar:tareas){
            jcTareas.addItem(tar);
        }       
   
    }
    
    public void limpiar(){
        jcTareas.setSelectedItem(null);
       
    }
    
    private void armarCabecera() {
        ArrayList<Object> titulos=new ArrayList<>();
        titulos.add("Comentario");
        titulos.add("FechaAvance");
        for(Object tit:titulos){
        
            modelo.addColumn(tit);
        }
        jtComentarios.setModel(modelo);
        
    }
    
    private void llenarTabla() {
    Tarea tareaSeleccionada = (Tarea) jcTareas.getSelectedItem();

    modelo.setRowCount(0);

    List<Comentarios> lista = cData.obtenerComentariosDeTarea(tareaSeleccionada.getIdTarea());

    for (Comentarios comentario : lista) {
        Object[] fila = {
            comentario.getComentario(),
            comentario.getFechaAvance(),
        };
        modelo.addRow(fila);
    }

    jtComentarios.setModel(modelo);
}
    
    private void borrarFilas(){
        int filas=modelo.getRowCount()-1;
        for(int i=filas;i >=0;i--){
        
            modelo.removeRow(i);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLTareas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbActualizar;
    private javax.swing.JButton jbComentar;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox<Tarea> jcTareas;
    private javax.swing.JTable jtComentarios;
    // End of variables declaration//GEN-END:variables
}
