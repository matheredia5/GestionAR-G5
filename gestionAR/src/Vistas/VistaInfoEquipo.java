
package Vistas;

import Control.EquipoData;
import Control.EquipoMiembrosData;
import Control.MiembroData;
import Modelo.Equipo;
import Modelo.EquipoMiembros;
import Modelo.Miembro;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public class VistaInfoEquipo extends javax.swing.JInternalFrame {
    private EquipoMiembrosData emData=new EquipoMiembrosData();
    private MiembroData mData=new MiembroData();
    private EquipoData eData = new EquipoData();
    private DefaultTableModel modelo=new DefaultTableModel(){
    
        @Override
        public boolean isCellEditable(int row,int colum){
            if(colum==0||colum==1||colum==2||colum==3||colum==4){
                return false;
            }else{
                return true;
            }
        }
    };
    
    public VistaInfoEquipo() {
        initComponents();
        cargarEquipoMiembros();
        armarCabecera();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jcMiembroEquipo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jbSalir = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Informacion Del Equipo");

        jLabel2.setText("ID Miembro Equipo:");

        jcMiembroEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcMiembroEquipoActionPerformed(evt);
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

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbSalir)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(jcMiembroEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(145, 145, 145))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcMiembroEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jbSalir)
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jcMiembroEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcMiembroEquipoActionPerformed
        // TODO add your handling code here
         llenarTabla();
    }//GEN-LAST:event_jcMiembroEquipoActionPerformed

    private void cargarEquipoMiembros() {
         List<Equipo> equipo=eData.listarEquipos();
        for(Equipo em:equipo){
            jcMiembroEquipo.addItem(em);
        }       
   
    }
    
    private void armarCabecera() {
        ArrayList<Object> titulos=new ArrayList<>();
        titulos.add("idMiembro");
        titulos.add("DNI");
        titulos.add("Apellido");
        titulos.add("Nombre");
        titulos.add("Estado");
        for(Object tit:titulos){
        
            modelo.addColumn(tit);
        }
        jTable.setModel(modelo);
        
    }
       
    private void llenarTabla() {
      Equipo eqmSeleccionada = (Equipo) jcMiembroEquipo.getSelectedItem();   
        modelo.setRowCount(0);
       
        List<Miembro> lista = mData.listarMiembrosPorEquipo(eqmSeleccionada.getIdEquipo());

        for (Miembro miembro : lista) {
            Object[] fila = {
                miembro.getIdMiembro(),
                miembro.getDni(),
                miembro.getApellido(),
                miembro.getNombre(),
                miembro.isEstado(),
            };
            modelo.addRow(fila);
        }

        jTable.setModel(modelo);
 }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox<Equipo> jcMiembroEquipo;
    // End of variables declaration//GEN-END:variables
}
