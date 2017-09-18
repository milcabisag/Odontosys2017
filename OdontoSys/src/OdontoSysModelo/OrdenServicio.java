package OdontoSysModelo;
// Generated 17/09/2017 10:00:28 PM by Hibernate Tools 3.6.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * OrdenServicio generated by hbm2java
 */
public class OrdenServicio  implements java.io.Serializable {


     private Integer idordenServicio;
     private Odontograma odontograma;
     private Usuario usuario;
     private Paciente paciente;
     private Date fecha;
     private String estado;
     private Set agendas = new HashSet(0);
     private Set facturas = new HashSet(0);
     private Set detalleOrdens = new HashSet(0);

    public OrdenServicio() {
    }

	
    public OrdenServicio(Odontograma odontograma, Usuario usuario, Paciente paciente, Date fecha, String estado) {
        this.odontograma = odontograma;
        this.usuario = usuario;
        this.paciente = paciente;
        this.fecha = fecha;
        this.estado = estado;
    }
    public OrdenServicio(Odontograma odontograma, Usuario usuario, Paciente paciente, Date fecha, String estado, Set agendas, Set facturas, Set detalleOrdens) {
       this.odontograma = odontograma;
       this.usuario = usuario;
       this.paciente = paciente;
       this.fecha = fecha;
       this.estado = estado;
       this.agendas = agendas;
       this.facturas = facturas;
       this.detalleOrdens = detalleOrdens;
    }
   
    public Integer getIdordenServicio() {
        return this.idordenServicio;
    }
    
    public void setIdordenServicio(Integer idordenServicio) {
        this.idordenServicio = idordenServicio;
    }
    public Odontograma getOdontograma() {
        return this.odontograma;
    }
    
    public void setOdontograma(Odontograma odontograma) {
        this.odontograma = odontograma;
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
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public Set getAgendas() {
        return this.agendas;
    }
    
    public void setAgendas(Set agendas) {
        this.agendas = agendas;
    }
    public Set getFacturas() {
        return this.facturas;
    }
    
    public void setFacturas(Set facturas) {
        this.facturas = facturas;
    }
    public Set getDetalleOrdens() {
        return this.detalleOrdens;
    }
    
    public void setDetalleOrdens(Set detalleOrdens) {
        this.detalleOrdens = detalleOrdens;
    }




}


