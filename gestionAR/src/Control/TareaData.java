
package Control;

import Modelo.EquipoMiembros;
import Modelo.Tarea;
import Control.EquipoMiembrosData;
import Modelo.Equipo;
import Modelo.Miembro;
import Modelo.Proyecto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class TareaData {
    private Connection con;
    private EquipoMiembrosData EquipmData= new EquipoMiembrosData();
    private EquipoData equipData = new EquipoData();
    private MiembroData mData = new MiembroData();
    
    public TareaData(){
        con= Conexion.getConexion();
    }
    
    public void asignarTarea(Tarea tarea){
        try {
            String sql= "INSERT INTO tarea(nombre, fechaCreacion, fechaCierre, estado, idMiembroEq) values(?,?,?,?,?)";
            
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, tarea.getNombre());
            ps.setDate(2, Date.valueOf(tarea.getFechaCreacion()));
            ps.setDate(3, Date.valueOf(tarea.getFechaCierre()));
            ps.setString(4, tarea.getEstado());
            ps.setInt(5, tarea.getEquipoM());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if(rs.next()){
                tarea.setIdTarea(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Tarea asignada.");
            }else
                System.out.println("La tarea no se pudo asignar.");
                
             ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "La tarea no se pudo asignar.");
            Logger.getLogger(ProyectoData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void actualizarTarea(Tarea tarea){
        try {
            String sql= "UPDATE tarea SET  nombre=?, fechaCreacion=?, fechaCierre=?, estado=?, idMiembroEq=? WHERE tarea.idTarea=?";
            
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, tarea.getNombre());
            ps.setDate(2, Date.valueOf( tarea.getFechaCreacion()));
            ps.setDate(3, Date.valueOf( tarea.getFechaCierre()));            
            ps.setString(4, tarea.getEstado());
            ps.setInt(5, tarea.getEquipoM());
            ps.setInt(6, tarea.getIdTarea());
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Tarea actualizada");
            ps.close();
            
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "La tarea no se pudo actualizar");
            Logger.getLogger(TareaData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarTarea(int idTarea) {
    try {
        String sql = "UPDATE tarea SET estado = 0 WHERE idTarea = ?;";
        
        PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, idTarea);
        ps.executeUpdate();
        
        ps.close();
        
    } catch (SQLException ex) {
        Logger.getLogger(TareaData.class.getName()).log(Level.SEVERE, null, ex);
    }
} 
    
    public Tarea buscarTarea(int idTarea){
        Tarea tarea = null;
        String sql = "SELECT  nombre, fechaCreacion, fechaCierre, estado, equipoM FROM tarea WHERE idTarea = ? ";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idTarea);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                tarea=new Tarea();
                tarea.setIdTarea(idTarea);
                tarea.setNombre(rs.getString("nombre"));
                tarea.setFechaCreacion(rs.getDate("fechaCreacion").toLocalDate());
                tarea.setFechaCierre(rs.getDate("fechaCierre").toLocalDate());
                tarea.setEstado(rs.getString("estado"));
                tarea.setEquipoM(rs.getInt("equipoM"));
              
               

            } else {
                JOptionPane.showMessageDialog(null, "No existe la Tarea.");
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Tarea. "+ex.getMessage());
        }

        return tarea;
    }
    
    public List<Tarea> listarTareas(){
              List<Tarea> tarea = new ArrayList<>();    

            try {
                String query = "SELECT idTarea, nombre FROM tarea;";
                PreparedStatement ps;
                ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery();

                while(rs.next()){

                    Tarea tar = new Tarea();
                    tar.setIdTarea(rs.getInt("idTarea"));
                    tar.setNombre(rs.getString("nombre"));
                                 
                    tarea.add(tar);

                }      
                ps.close();
            }catch (SQLException ex) {
                JOptionPane.showInternalMessageDialog(null, "Error al listar tareas "+ex.getMessage());
            }
            return tarea;

        }
    
    public EquipoMiembros obtenerEquipoMiembros(int equipoMiembrosId) 
        throws SQLException {
        EquipoMiembros equipoM = null;
        String sql = "SELECT * FROM equipoMiembros WHERE idMiembroEq = ?";

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, equipoMiembrosId);
            rs = ps.executeQuery();

            if (rs.next()) {
                equipoM = new EquipoMiembros();
                equipoM.setIdMiembroEq(rs.getInt("idMiembroEq"));
                equipoM.setFechaIncorporacion(rs.getDate("fechaIncorporacion").toLocalDate());
                Equipo eq = equipData.obtenerEquipo(rs.getInt("idEquipo"));
                equipoM.setEquipo(eq.getIdEquipo());
                Miembro miem = mData.obtenerMiembro(rs.getInt("idMiembro"));
                equipoM.setMiembro(miem.getIdMiembro());

            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
        }

        return equipoM;
    }
    
    public void actualizarEstado(String estado, int idTarea){
        try {
            String sql= "UPDATE tarea SET estado=? WHERE idTarea=?";
            
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
           
            ps.setString(1, estado);
            ps.setInt(2, idTarea);
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Tarea actualizada");
            ps.close();
            
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "La tarea no se pudo actualizar");
            Logger.getLogger(TareaData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Tarea> obtenerTareasProyecto(int idProyecto) {
        List<Tarea> tareas = new ArrayList<>();

        try {
            String sql = "SELECT t.idTarea, t.nombre, t.estado " +
                         "FROM tarea t " +
                         "INNER JOIN equipomiembros em ON em.idMiembroEq = t.idMiembroEq " +
                         "INNER JOIN equipo e ON em.idEquipo = e.idEquipo " +
                         "WHERE e.idProyecto = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idProyecto);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Tarea tarea = new Tarea();
                tarea.setIdTarea(rs.getInt("idTarea"));
                tarea.setNombre(rs.getString("nombre"));
                tarea.setEstado(rs.getString("estado"));
                tareas.add(tarea);
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener las tareas del proyecto");
        }

        return tareas;
    }

    
}
