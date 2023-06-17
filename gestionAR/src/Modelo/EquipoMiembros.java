
package Modelo;

import java.time.LocalDate;
import Modelo.Equipo;

public class EquipoMiembros {
    private int idMiembroEq;
    private LocalDate fechaIncorporacion;
    private Equipo equipo;
    private Miembro miembro;

    public EquipoMiembros(int idMiembroEq, LocalDate fechaIncorporacion, Equipo equipo, Miembro miembro) {
        this.idMiembroEq = idMiembroEq;
        this.fechaIncorporacion = fechaIncorporacion;
        this.equipo = equipo;
        this.miembro = miembro;
    }

    public EquipoMiembros(LocalDate fechaIncorporacion, Equipo equipo, Miembro miembro) {
        this.fechaIncorporacion = fechaIncorporacion;
        this.equipo = equipo;
        this.miembro = miembro;
    }
    
    public EquipoMiembros() {
    }

    public int getIdMiembroEq() {
        return idMiembroEq;
    }

    public void setIdMiembroEq(int idMiembroEq) {
        this.idMiembroEq = idMiembroEq;
    }

    public LocalDate getFechaIncorporacion() {
        return fechaIncorporacion;
    }

    public void setFechaIncorporacion(LocalDate fechaIncorporacion) {
        this.fechaIncorporacion = fechaIncorporacion;
    }

    public int getEquipo() {
        return equipo.getIdEquipo();
    }

    public void setEquipo(int idEquipo) {
        this.equipo.setIdEquipo(idEquipo);
    }
   
    public int getMiembro() {
        return miembro.getIdMiembro();
    }

    public void setMiembro(int idMiembro) {
        this.miembro.setIdMiembro(idMiembro);
    }
   
    @Override
    public String toString() {
        return "equipoMiembros{" + "idMiembroEq=" + idMiembroEq + ", fechaIncorporacion=" + fechaIncorporacion + ", equipo=" + equipo + ", miembro=" + miembro + '}';
    }
    
}
