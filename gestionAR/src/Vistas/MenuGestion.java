
package Vistas;

public class MenuGestion extends javax.swing.JFrame {

   
    public MenuGestion() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jProyectos = new javax.swing.JMenu();
        jFormProyecto = new javax.swing.JMenuItem();
        jFormProyectosTareas = new javax.swing.JMenuItem();
        jMiembros = new javax.swing.JMenu();
        jVistaMiembros = new javax.swing.JMenuItem();
        jTareas = new javax.swing.JMenu();
        jFormTareas = new javax.swing.JMenuItem();
        jFormEstado = new javax.swing.JMenuItem();
        jFormAvance = new javax.swing.JMenuItem();
        jEquipo = new javax.swing.JMenu();
        jFormEquipo = new javax.swing.JMenuItem();
        jEquipoMiembros = new javax.swing.JMenu();
        jFormEquipoMiembros = new javax.swing.JMenuItem();
        jAgregarMiembroEq = new javax.swing.JMenuItem();

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("File");
        jMenuBar3.add(jMenu5);

        jMenu6.setText("Edit");
        jMenuBar3.add(jMenu6);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        escritorio.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 642, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 463, Short.MAX_VALUE)
        );

        jProyectos.setText("Proyectos");

        jFormProyecto.setText("Formulario Proyectos");
        jFormProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormProyectoActionPerformed(evt);
            }
        });
        jProyectos.add(jFormProyecto);

        jFormProyectosTareas.setText("Proyectos y Tareas");
        jFormProyectosTareas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormProyectosTareasActionPerformed(evt);
            }
        });
        jProyectos.add(jFormProyectosTareas);

        jMenuBar1.add(jProyectos);

        jMiembros.setText("Miembros");

        jVistaMiembros.setText("Agregar Miembros");
        jVistaMiembros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jVistaMiembrosActionPerformed(evt);
            }
        });
        jMiembros.add(jVistaMiembros);

        jMenuBar1.add(jMiembros);

        jTareas.setText("Tareas");

        jFormTareas.setText("Asignar Tareas");
        jFormTareas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormTareasActionPerformed(evt);
            }
        });
        jTareas.add(jFormTareas);

        jFormEstado.setText("Actualizar Estado");
        jFormEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormEstadoActionPerformed(evt);
            }
        });
        jTareas.add(jFormEstado);

        jFormAvance.setText("Avance Tareas");
        jFormAvance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormAvanceActionPerformed(evt);
            }
        });
        jTareas.add(jFormAvance);

        jMenuBar1.add(jTareas);

        jEquipo.setText("Equipo");

        jFormEquipo.setText("Formulario  Equipo");
        jFormEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormEquipoActionPerformed(evt);
            }
        });
        jEquipo.add(jFormEquipo);

        jMenuBar1.add(jEquipo);

        jEquipoMiembros.setText("Equipo Miembros");

        jFormEquipoMiembros.setText("Informacion de equipos");
        jFormEquipoMiembros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormEquipoMiembrosActionPerformed(evt);
            }
        });
        jEquipoMiembros.add(jFormEquipoMiembros);

        jAgregarMiembroEq.setText("Agregar Miembro Equipo");
        jAgregarMiembroEq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAgregarMiembroEqActionPerformed(evt);
            }
        });
        jEquipoMiembros.add(jAgregarMiembroEq);

        jMenuBar1.add(jEquipoMiembros);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jFormProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormProyectoActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        VistaProyectos vp = new VistaProyectos();
        vp.setVisible(true);
        escritorio.add(vp);
        escritorio.moveToFront(vp);
    }//GEN-LAST:event_jFormProyectoActionPerformed

    private void jFormEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormEquipoActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        VistaEquipo ve = new VistaEquipo();
        ve.setVisible(true);
        escritorio.add(ve);
        escritorio.moveToFront(ve);
    }//GEN-LAST:event_jFormEquipoActionPerformed

    private void jFormEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormEstadoActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        VistaTareasEstado vte = new VistaTareasEstado();
        vte.setVisible(true);
        escritorio.add(vte);
        escritorio.moveToFront(vte);
    }//GEN-LAST:event_jFormEstadoActionPerformed

    private void jFormTareasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormTareasActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        VistaTareas vt = new VistaTareas();
        vt.setVisible(true);
        escritorio.add(vt);
        escritorio.moveToFront(vt);
    }//GEN-LAST:event_jFormTareasActionPerformed

    private void jFormAvanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormAvanceActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        VistaAvanceTareas vat = new VistaAvanceTareas();
        vat.setVisible(true);
        escritorio.add(vat);
        escritorio.moveToFront(vat);
    }//GEN-LAST:event_jFormAvanceActionPerformed

    private void jFormEquipoMiembrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormEquipoMiembrosActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        VistaInfoEquipo vie = new VistaInfoEquipo();
        vie.setVisible(true);
        escritorio.add(vie);
        escritorio.moveToFront(vie);
    }//GEN-LAST:event_jFormEquipoMiembrosActionPerformed

    private void jFormProyectosTareasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormProyectosTareasActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        VistaProyectoTareas vpt = new VistaProyectoTareas();
        vpt.setVisible(true);
        escritorio.add(vpt);
        escritorio.moveToFront(vpt);
    }//GEN-LAST:event_jFormProyectosTareasActionPerformed

    private void jVistaMiembrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jVistaMiembrosActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        VistaMiembros vmiem = new VistaMiembros();
        vmiem.setVisible(true);
        escritorio.add(vmiem);
        escritorio.moveToFront(vmiem);
    }//GEN-LAST:event_jVistaMiembrosActionPerformed

    private void jAgregarMiembroEqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAgregarMiembroEqActionPerformed
        // TODO add your handling code here:
         escritorio.removeAll();
        escritorio.repaint();
        VistaEquipoMiembros vemiem = new VistaEquipoMiembros();
        vemiem.setVisible(true);
        escritorio.add(vemiem);
        escritorio.moveToFront(vemiem);
    }//GEN-LAST:event_jAgregarMiembroEqActionPerformed

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
            java.util.logging.Logger.getLogger(MenuGestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuGestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuGestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuGestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuGestion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuItem jAgregarMiembroEq;
    private javax.swing.JMenu jEquipo;
    private javax.swing.JMenu jEquipoMiembros;
    private javax.swing.JMenuItem jFormAvance;
    private javax.swing.JMenuItem jFormEquipo;
    private javax.swing.JMenuItem jFormEquipoMiembros;
    private javax.swing.JMenuItem jFormEstado;
    private javax.swing.JMenuItem jFormProyecto;
    private javax.swing.JMenuItem jFormProyectosTareas;
    private javax.swing.JMenuItem jFormTareas;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenu jMiembros;
    private javax.swing.JMenu jProyectos;
    private javax.swing.JMenu jTareas;
    private javax.swing.JMenuItem jVistaMiembros;
    // End of variables declaration//GEN-END:variables
}
