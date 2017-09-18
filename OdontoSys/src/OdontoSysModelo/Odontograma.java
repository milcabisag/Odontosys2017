package OdontoSysModelo;
// Generated 18/09/2017 01:21:52 PM by Hibernate Tools 3.6.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Odontograma generated by hbm2java
 */
public class Odontograma  implements java.io.Serializable {


     private Integer idodontograma;
     private Usuario usuario;
     private Paciente paciente;
     private Doctor doctor;
     private Date fecha;
     private String tipo;
     private Set diagnosticos = new HashSet(0);
     private Set ordenServicios = new HashSet(0);
     private Set detalleHallazgos = new HashSet(0);
     private Set tratamientos = new HashSet(0);

    public Odontograma() {
    }

	
    public Odontograma(Usuario usuario, Paciente paciente, Date fecha, String tipo) {
        this.usuario = usuario;
        this.paciente = paciente;
        this.fecha = fecha;
        this.tipo = tipo;
    }
    public Odontograma(Usuario usuario, Paciente paciente, Doctor doctor, Date fecha, String tipo, Set diagnosticos, Set ordenServicios, Set detalleHallazgos, Set tratamientos) {
       this.usuario = usuario;
       this.paciente = paciente;
       this.doctor = doctor;
       this.fecha = fecha;
       this.tipo = tipo;
       this.diagnosticos = diagnosticos;
       this.ordenServicios = ordenServicios;
       this.detalleHallazgos = detalleHallazgos;
       this.tratamientos = tratamientos;
    }
   
    public Integer getIdodontograma() {
        return this.idodontograma;
    }
    
    public void setIdodontograma(Integer idodontograma) {
        this.idodontograma = idodontograma;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Paciente getPaciente() {
        return this.paciente;
    }
    
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    public Doctor getDoctor() {
        return this.doctor;
    }
    
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public String getTipo() {
        return this.tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public Set getDiagnosticos() {
        return this.diagnosticos;
    }
    
    public void setDiagnosticos(Set diagnosticos) {
        this.diagnosticos = diagnosticos;
    }
    public Set getOrdenServicios() {
        return this.ordenServicios;
    }
    
    public void setOrdenServicios(Set ordenServicios) {
        this.ordenServicios = ordenServicios;
    }
    public Set getDetalleHallazgos() {
        return this.detalleHallazgos;
    }
    
    public void setDetalleHallazgos(Set detalleHallazgos) {
        this.detalleHallazgos = detalleHallazgos;
    }
    public Set getTratamientos() {
        return this.tratamientos;
    }
    
    public void setTratamientos(Set tratamientos) {
        this.tratamientos = tratamientos;
    }




}


