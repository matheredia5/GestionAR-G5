
package Modelo;

import java.time.LocalDate;

public class Tarea {
    private int idTarea;
    private String nombre;
    private LocalDate fechaCreacion;
    private LocalDate fechaCierre;
    private String estado;
    private EquipoMiembros equipoM;
    private Proyecto proyecto;
    

    public Tarea(int idTarea, String nombre, LocalDate fechaCreacion, LocalDate fechaCierre, String estado, EquipoMiembros equipoM) {
        this.idTarea = idTarea;
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.fechaCierre = fechaCierre;
        this.estado = estado;
        this.equipoM = equipoM;
    }

    public Tarea(String nombre, LocalDate fechaCreacion, LocalDate fechaCierre, String estado, EquipoMiembros equipoM) {
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.fechaCierre = fechaCierre;
        this.estado = estado;
        this.equipoM = equipoM;
    }

    public Tarea() {
    }

    public Tarea(int idTarea, String nombre, EquipoMiembros equipoM, Proyecto proyecto) {
        this.idTarea = idTarea;
        this.nombre = nombre;
        this.equipoM = equipoM;
        this.proyecto = proyecto;
    }
       
    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDate getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(LocalDate fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public EquipoMiembros getEquipoM() {
        return equipoM;
    }

    public void setEquipoM(EquipoMiembros equipoM) {
        this.equipoM = equipoM;
    }
    
    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
    @Override
    public String toString() {
        return  idTarea + "," + nombre ;
    }
    
}
