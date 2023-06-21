
package Control;

import Modelo.Miembro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class MiembroData {
    private Connection con;
    
    public MiembroData(){
        con= Conexion.getConexion();
    }
    
    public void crearMiembro(Miembro miembro){
        try {
            String sql= "INSERT INTO miembro (dni, nombre, apellido, estado) values(?,?,?,?)";
            
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                     
            ps.setInt(1, miembro.getDni());
            ps.setString(2, miembro.getNombre());
            ps.setString(3, miembro.getApellido());
            ps.setBoolean(4, miembro.isEstado());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if(rs.next()){
                miembro.setIdMiembro(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Miembro agregado.");
            }else
                System.out.println("El miembro no se pudo agregar");
                
             ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "El miembro no se pudo agregar");
            Logger.getLogger(ProyectoData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Miembro obtenerMiembro(int idMiembro) throws SQLException {
    Miembro miembro = null;
    String sql = "SELECT * FROM miembro WHERE idMiembro = ?";

    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        ps = con.prepareStatement(sql);
        ps.setInt(1, idMiembro);

        rs = ps.executeQuery();

        if (rs.next()) {
            miembro = new Miembro();
            miembro.setIdMiembro(rs.getInt("idMiembro"));
            miembro.setNombre(rs.getString("nombre"));
         
        }
    } catch (SQLException ex) {
        Logger.getLogger(MiembroData.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        if (rs != null) {
            rs.close();
        }
        if (ps != null) {
            ps.close();
        }
    }

    return miembro;
}

    public List<Miembro> listarMiembros(){
              List<Miembro> miembro = new ArrayList<>();    

            try {
                String query = "SELECT idMiembro, dni, apellido, nombre, estado FROM miembro;";
                PreparedStatement ps;
                ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery();

                while(rs.next()){

                    Miembro m = new Miembro();
                    m.setIdMiembro(rs.getInt("idMiembro"));
                    m.setDni(rs.getInt("dni"));
                    m.setApellido(rs.getString("apellido"));
                    m.setNombre(rs.getString("nombre"));
                    m.setEstado(rs.getBoolean("estado"));
                                    
                                 
                    miembro.add(m);

                }      
                ps.close();
            }catch (SQLException ex) {
                JOptionPane.showInternalMessageDialog(null, "Error al listar Miembros "+ex.getMessage());
            }
            return miembro;

        }
    
    public List<Miembro> listarMiembrosPorEquip(int idMiembroEquipo) {
            List<Miembro> listaMiembros = new ArrayList<>();
            
            String sql = "SELECT m.idMiembro, m.DNI, m.Apellido, m.Nombre, m.Estado "
                    + "FROM miembro m "
                    + "INNER JOIN equipomiembros em ON m.idMiembro = em.idMiembro "
                    + "WHERE em.idMiembroEq = ?";

            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, idMiembroEquipo);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    int idMiembro = rs.getInt("idMiembro");
                    int dni = rs.getInt("DNI");
                    String apellido = rs.getString("Apellido");
                    String nombre = rs.getString("Nombre");
                    boolean estado = rs.getBoolean("estado");

                    Miembro miembro = new Miembro(idMiembro, dni, apellido, nombre, estado);
                    listaMiembros.add(miembro);
                }

                ps.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al obtener los miembros por equipo: " + ex.getMessage());
            }

            return listaMiembros;
        }
    
    public List<Miembro> obtenerMiembrosProyecto(int idProyecto) {
        List<Miembro> miembros = new ArrayList<>();

        try {
            String sql = "SELECT m.idMiembro, m.nombre, m.estado " +
                         "FROM miembro m " +
                         "INNER JOIN equipomiembros em ON em.idMiembro = m.idMiembro " +
                         "INNER JOIN equipo e ON em.idEquipo = e.idEquipo " +
                         "WHERE e.idProyecto = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idProyecto);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Miembro miembro = new Miembro();
                miembro.setIdMiembro(rs.getInt("idMiembro"));
                miembro.setNombre(rs.getString("nombre"));
                miembro.setEstado(rs.getBoolean("estado"));
                miembros.add(miembro);
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener los miembros del proyecto");
        }

        return miembros;
    }

    public List<Miembro> listarMiembrosPorEquipo(int idEquipo) {
    List<Miembro> listaMiembros = new ArrayList<>();
    
    String sql = "SELECT m.idMiembro, m.DNI, m.Apellido, m.Nombre, m.Estado "
            + "FROM miembro m "
            + "INNER JOIN equipomiembros me ON m.idMiembro = me.idMiembro "
            + "WHERE me.idEquipo = ?";

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idEquipo);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int idMiembro = rs.getInt("idMiembro");
            int dni = rs.getInt("DNI");
            String apellido = rs.getString("Apellido");
            String nombre = rs.getString("Nombre");
            boolean estado = rs.getBoolean("estado");

            Miembro miembro = new Miembro(idMiembro, dni, apellido, nombre, estado);
            listaMiembros.add(miembro);
        }

        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al obtener los miembros por equipo: " + ex.getMessage());
    }

    return listaMiembros;
}


    
}