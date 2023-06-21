
package Vistas;
import Control.MiembroData;
import Control.ProyectoData;
import Control.TareaData;
import Modelo.Miembro;
import Modelo.Proyecto;
import Modelo.Tarea;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class VistaProyectoTareas extends javax.swing.JInternalFrame {
    ProyectoData pData = new ProyectoData();
    MiembroData mData = new MiembroData();
    TareaData tData = new TareaData();
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
    
    public VistaProyectoTareas() {
        initComponents();
        cargarProyectos();
        armarCabecera();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jcProyectos = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jrbMiembros = new javax.swing.JRadioButton();
        jrbTareas = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jSalir = new javax.swing.JButton();

        jcProyectos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcProyectosActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Consultar Proyectos y Tareas");

        jLabel2.setText("Proyectos:");

        jrbMiembros.setText("Miembros");
        jrbMiembros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbMiembrosActionPerformed(evt);
            }
        });

        jrbTareas.setText("Tareas");
        jrbTareas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbTareasActionPerformed(evt);
            }
        });

        jTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable);

        jSalir.setText("Salir");
        jSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSalir)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jrbMiembros)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jrbTareas))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcProyectos, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jLabel1)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcProyectos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbMiembros)
                    .addComponent(jrbTareas))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jSalir)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jSalirActionPerformed

    private void jrbMiembrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbMiembrosActionPerformed
        // TODO add your handling code here:
        borrarFilas();
        jrbTareas.setSelected(false);
        jrbMiembros.setEnabled(true);
        llenarTabla();
    }//GEN-LAST:event_jrbMiembrosActionPerformed

    private void jrbTareasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbTareasActionPerformed
        // TODO add your handling code here:
        borrarFilas();
        jrbMiembros.setSelected(false);
        jrbTareas.setEnabled(true);
        llenarTabla();
    }//GEN-LAST:event_jrbTareasActionPerformed

    private void jcProyectosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcProyectosActionPerformed
        // TODO add your handling code here:
        borrarFilas();
        jrbMiembros.setSelected(false);
        jrbTareas.setSelected(false);
    }//GEN-LAST:event_jcProyectosActionPerformed

    private void cargarProyectos() {
        List<Proyecto> proy=pData.listarProyectos();
        for(Proyecto pr:proy){
            jcProyectos.addItem(pr);
        }       
   
    }
    
    private void armarCabecera() {
        ArrayList<Object> titulos=new ArrayList<>();
        titulos.add("ID");
        titulos.add("Nombre");
        titulos.add("Estado");
        for(Object tit:titulos){
        
            modelo.addColumn(tit);
        }
        jTable.setModel(modelo);
    }
    
    private void llenarTabla(){
    
        Proyecto proyectoSeleccionado=(Proyecto)jcProyectos.getSelectedItem();
        if(jrbMiembros.isSelected()){
        
            List<Miembro> lista=mData.obtenerMiembrosProyecto(proyectoSeleccionado.getIdProyecto());
            for(Miembro m:lista){
            
                modelo.addRow(new Object[]{m.getIdMiembro(),m.getNombre(),m.isEstado()});
            }
            
        }else {
            System.out.println("cargando...");
            List<Tarea> lista=tData.obtenerTareasProyecto(proyectoSeleccionado.getIdProyecto());
            for(Tarea t:lista){
            
                modelo.addRow(new Object[]{t.getIdTarea(),t.getNombre(),t.getEstado()});
            }
        
        }
    }
    
    private void borrarFilas(){
        int filas=modelo.getRowCount()-1;
        for(int i=filas;i >=0;i--){
        
            modelo.removeRow(i);
        }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JComboBox<Proyecto> jcProyectos;
    private javax.swing.JRadioButton jrbMiembros;
    private javax.swing.JRadioButton jrbTareas;
    // End of variables declaration//GEN-END:variables
}
