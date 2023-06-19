
package Control;

import Modelo.Comentarios;
import Modelo.Tarea;
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


public class ComentariosData {
    private Connection con;
    private TareaData tData = new TareaData();
    
    public ComentariosData(){
        con= Conexion.getConexion();
    }

    public void registrarComentario(Comentarios com) {
        try {
            String sql = "INSERT INTO comentarios(comentario, fechaAvance, idTarea) VALUES (?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, com.getComentario());
            ps.setDate(2, Date.valueOf(com.getFechaAvance()));
            ps.setInt(3, com.getTarea().getIdTarea());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                com.setIdComentario(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Comentario agregado.");
            } else {
                System.out.println("El comentario no se pudo agregar");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "El comentario no se pudo agregar");
            Logger.getLogger(ProyectoData.class.getName()).log(Level.SEVERE, null, ex);
        }
}

    public List<Comentarios> listarComentarios(){
              List<Comentarios> comentario = new ArrayList<>();    

            try {
                String query = "SELECT comentario, fechaAvance, idTarea FROM comentarios;";
                PreparedStatement ps;
                ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery();

                while(rs.next()){

                    Comentarios comen = new Comentarios();
                    comen.setComentario(rs.getString("comentario"));
                    comen.setFechaAvance(rs.getDate("fechaAvance").toLocalDate());
                    Tarea tar = tData.buscarTarea(rs.getInt("idTarea"));                    
                    comen.setTarea(tar.getIdTarea());                   
                                 
                    comentario.add(comen);

                }      
                ps.close();
            }catch (SQLException ex) {
                JOptionPane.showInternalMessageDialog(null, "Error al listar tareas "+ex.getMessage());
            }
            return comentario;

        }
    
    public List<Comentarios> obtenerComentariosDeTarea(int idTarea) {
    List<Comentarios> comentarios = new ArrayList<>();

    try {
        String sql = "SELECT idComentario, comentario, fechaAvance FROM comentarios WHERE idTarea = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idTarea);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            Comentarios comentario = new Comentarios();
            comentario.setIdComentario(rs.getInt("idComentario"));
            comentario.setComentario(rs.getString("comentario"));
            comentario.setFechaAvance(rs.getDate("fechaAvance").toLocalDate());
            comentarios.add(comentario);
        }
        
        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al obtener comentarios de la tarea");
    }
    
    return comentarios;
}
    
    public void actualizarComentario(String comentario, LocalDate fechaAvance, int idTarea){
        try {
            String sql= "UPDATE comentarios SET comentario=?, fechaAvance=? WHERE idTarea=?";
            
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
           
            ps.setString(1, comentario);
            ps.setDate(2, Date.valueOf(fechaAvance));
            ps.setInt(3, idTarea);
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Comentario actualizado");
            ps.close();
            
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "El comentario no se pudo actualizar");
            Logger.getLogger(TareaData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

    