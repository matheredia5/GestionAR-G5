
package Control;

import Modelo.Equipo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class EquipoData {
    
    private Connection con;
    
    public EquipoData(){
        con= Conexion.getConexion();
    }

    public void crearEquipo(Equipo equipo){
        try {
            String sql= "INSERT INTO equipo(idProyecto, nombre, fechaCreacion, estado) values(?,?,?,?)";
            
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                     
            ps.setInt(1, equipo.getProyecto());
            ps.setString(2, equipo.getNombre());
            ps.setDate(3, Date.valueOf(equipo.getFechaCreacion()));
            ps.setBoolean(4, equipo.isEstado());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if(rs.next()){
                equipo.setIdEquipo(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Equipo agregado.");
            }else
                System.out.println("El equipo no se pudo agregar");
                
             ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "El equipo no se pudo agregar");
            Logger.getLogger(ProyectoData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Equipo obtenerEquipo(int idEquipo) throws SQLException {
    Equipo equipo = null;
    String sql = "SELECT * FROM equipo WHERE idEquipo = ?";

    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        ps = con.prepareStatement(sql);
        ps.setInt(1, idEquipo);

        rs = ps.executeQuery();

        if (rs.next()) {
            equipo = new Equipo();
            equipo.setIdEquipo(rs.getInt("idEquipo"));
            equipo.setNombre(rs.getString("nombre"));
            // Establecer el resto de propiedades del equipo según la estructura de la tabla
        }
    } catch (SQLException ex) {
        Logger.getLogger(EquipoData.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        if (rs != null) {
            rs.close();
        }
        if (ps != null) {
            ps.close();
        }
    }

    return equipo;
}

    public List<Equipo> listarEquipos() {
        List<Equipo> equipo = new ArrayList<>();    

            try {
                String query = "SELECT idEquipo, nombre FROM equipo;";
                PreparedStatement ps;
                ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery();

                while(rs.next()){

                    Equipo e = new Equipo();
                    e.setIdEquipo(rs.getInt("idEquipo"));               
                    e.setNombre(rs.getString("nombre"));                  
                                    
                                 
                    equipo.add(e);

                }      
                ps.close();
            }catch (SQLException ex) {
                JOptionPane.showInternalMessageDialog(null, "Error al listar Equipo "+ex.getMessage());
            }
            return equipo;

        }
        
        
    }



