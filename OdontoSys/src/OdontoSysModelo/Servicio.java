package OdontoSysModelo;
// Generated 21/12/2017 11:53:02 AM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Servicio generated by hbm2java
 */
public class Servicio  implements java.io.Serializable {


     private Integer idservicio;
     private String descripcion;
     private int precio;
     private String estado;
     private Set detalleOrdenEmpresas = new HashSet(0);
     private Set detalleOrdens = new HashSet(0);
     private Set agendas = new HashSet(0);
     private Set tratamientos = new HashSet(0);
     private Set detalleConvenios = new HashSet(0);

    public Servicio() {
    }

	
    public Servicio(String descripcion, int precio, String estado) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.estado = estado;
    }
    public Servicio(String descripcion, int precio, String estado, Set detalleOrdenEmpresas, Set detalleOrdens, Set agendas, Set tratamientos, Set detalleConvenios) {
       this.descripcion = descripcion;
       this.precio = precio;
       this.estado = estado;
       this.detalleOrdenEmpresas = detalleOrdenEmpresas;
       this.detalleOrdens = detalleOrdens;
       this.agendas = agendas;
       this.tratamientos = tratamientos;
       this.detalleConvenios = detalleConvenios;
    }
   
    public Integer getIdservicio() {
        return this.idservicio;
    }
    
    public void setIdservicio(Integer idservicio) {
        this.idservicio = idservicio;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public int getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public Set getDetalleOrdenEmpresas() {
        return this.detalleOrdenEmpresas;
    }
    
    public void setDetalleOrdenEmpresas(Set detalleOrdenEmpresas) {
        this.detalleOrdenEmpresas = detalleOrdenEmpresas;
    }
    public Set getDetalleOrdens() {
        return this.detalleOrdens;
    }
    
    public void setDetalleOrdens(Set detalleOrdens) {
        this.detalleOrdens = detalleOrdens;
    }
    public Set getAgendas() {
        return this.agendas;
    }
    
    public void setAgendas(Set agendas) {
        this.agendas = agendas;
    }
    public Set getTratamientos() {
        return this.tratamientos;
    }
    
    public void setTratamientos(Set tratamientos) {
        this.tratamientos = tratamientos;
    }
    public Set getDetalleConvenios() {
        return this.detalleConvenios;
    }
    
    public void setDetalleConvenios(Set detalleConvenios) {
        this.detalleConvenios = detalleConvenios;
    }




}


