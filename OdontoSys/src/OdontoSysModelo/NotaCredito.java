package OdontoSysModelo;
// Generated 24/10/2017 08:56:38 AM by Hibernate Tools 3.6.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * NotaCredito generated by hbm2java
 */
public class NotaCredito  implements java.io.Serializable {


     private Integer idnotaCredito;
     private Factura factura;
     private Usuario usuario;
     private Paciente paciente;
     private Date fecha;
     private int total;
     private Set detalleNotas = new HashSet(0);

    public NotaCredito() {
    }

	
    public NotaCredito(Factura factura, Usuario usuario, Paciente paciente, Date fecha, int total) {
        this.factura = factura;
        this.usuario = usuario;
        this.paciente = paciente;
        this.fecha = fecha;
        this.total = total;
    }
    public NotaCredito(Factura factura, Usuario usuario, Paciente paciente, Date fecha, int total, Set detalleNotas) {
       this.factura = factura;
       this.usuario = usuario;
       this.paciente = paciente;
       this.fecha = fecha;
       this.total = total;
       this.detalleNotas = detalleNotas;
    }
   
    public Integer getIdnotaCredito() {
        return this.idnotaCredito;
    }
    
    public void setIdnotaCredito(Integer idnotaCredito) {
        this.idnotaCredito = idnotaCredito;
    }
    public Factura getFactura() {
        return this.factura;
    }
    
    public void setFactura(Factura factura) {
        this.factura = factura;
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
    public int getTotal() {
        return this.total;
    }
    
    public void setTotal(int total) {
        this.total = total;
    }
    public Set getDetalleNotas() {
        return this.detalleNotas;
    }
    
    public void setDetalleNotas(Set detalleNotas) {
        this.detalleNotas = detalleNotas;
    }




}


