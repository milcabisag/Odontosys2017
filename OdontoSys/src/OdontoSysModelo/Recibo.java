package OdontoSysModelo;
// Generated 17/09/2017 10:00:28 PM by Hibernate Tools 3.6.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Recibo generated by hbm2java
 */
public class Recibo  implements java.io.Serializable {


     private Integer idrecibo;
     private Factura factura;
     private Usuario usuario;
     private Paciente paciente;
     private int monto;
     private Date fecha;
     private Set detalleRecibos = new HashSet(0);

    public Recibo() {
    }

	
    public Recibo(Factura factura, Usuario usuario, Paciente paciente, int monto, Date fecha) {
        this.factura = factura;
        this.usuario = usuario;
        this.paciente = paciente;
        this.monto = monto;
        this.fecha = fecha;
    }
    public Recibo(Factura factura, Usuario usuario, Paciente paciente, int monto, Date fecha, Set detalleRecibos) {
       this.factura = factura;
       this.usuario = usuario;
       this.paciente = paciente;
       this.monto = monto;
       this.fecha = fecha;
       this.detalleRecibos = detalleRecibos;
    }
   
    public Integer getIdrecibo() {
        return this.idrecibo;
    }
    
    public void setIdrecibo(Integer idrecibo) {
        this.idrecibo = idrecibo;
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
    public int getMonto() {
        return this.monto;
    }
    
    public void setMonto(int monto) {
        this.monto = monto;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Set getDetalleRecibos() {
        return this.detalleRecibos;
    }
    
    public void setDetalleRecibos(Set detalleRecibos) {
        this.detalleRecibos = detalleRecibos;
    }




}


