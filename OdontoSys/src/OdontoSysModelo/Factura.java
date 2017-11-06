package OdontoSysModelo;
// Generated 06/11/2017 10:05:22 AM by Hibernate Tools 3.6.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Factura generated by hbm2java
 */
public class Factura  implements java.io.Serializable {


     private Integer idfactura;
     private Talonario talonario;
     private OrdenServicio ordenServicio;
     private Usuario usuario;
     private Paciente paciente;
     private Movimiento movimiento;
     private Date fecha;
     private String tipoFactura;
     private int descuento;
     private String estado;
     private int montoTotal;
     private int saldo;
     private Set notaCreditos = new HashSet(0);
     private Set recibos = new HashSet(0);
     private Set facturaConvenios = new HashSet(0);

    public Factura() {
    }

	
    public Factura(Talonario talonario, OrdenServicio ordenServicio, Usuario usuario, Paciente paciente, Movimiento movimiento, Date fecha, String tipoFactura, int descuento, String estado, int montoTotal, int saldo) {
        this.talonario = talonario;
        this.ordenServicio = ordenServicio;
        this.usuario = usuario;
        this.paciente = paciente;
        this.movimiento = movimiento;
        this.fecha = fecha;
        this.tipoFactura = tipoFactura;
        this.descuento = descuento;
        this.estado = estado;
        this.montoTotal = montoTotal;
        this.saldo = saldo;
    }
    public Factura(Talonario talonario, OrdenServicio ordenServicio, Usuario usuario, Paciente paciente, Movimiento movimiento, Date fecha, String tipoFactura, int descuento, String estado, int montoTotal, int saldo, Set notaCreditos, Set recibos, Set facturaConvenios) {
       this.talonario = talonario;
       this.ordenServicio = ordenServicio;
       this.usuario = usuario;
       this.paciente = paciente;
       this.movimiento = movimiento;
       this.fecha = fecha;
       this.tipoFactura = tipoFactura;
       this.descuento = descuento;
       this.estado = estado;
       this.montoTotal = montoTotal;
       this.saldo = saldo;
       this.notaCreditos = notaCreditos;
       this.recibos = recibos;
       this.facturaConvenios = facturaConvenios;
    }
   
    public Integer getIdfactura() {
        return this.idfactura;
    }
    
    public void setIdfactura(Integer idfactura) {
        this.idfactura = idfactura;
    }
    public Talonario getTalonario() {
        return this.talonario;
    }
    
    public void setTalonario(Talonario talonario) {
        this.talonario = talonario;
    }
    public OrdenServicio getOrdenServicio() {
        return this.ordenServicio;
    }
    
    public void setOrdenServicio(OrdenServicio ordenServicio) {
        this.ordenServicio = ordenServicio;
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
    public Movimiento getMovimiento() {
        return this.movimiento;
    }
    
    public void setMovimiento(Movimiento movimiento) {
        this.movimiento = movimiento;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public String getTipoFactura() {
        return this.tipoFactura;
    }
    
    public void setTipoFactura(String tipoFactura) {
        this.tipoFactura = tipoFactura;
    }
    public int getDescuento() {
        return this.descuento;
    }
    
    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public int getMontoTotal() {
        return this.montoTotal;
    }
    
    public void setMontoTotal(int montoTotal) {
        this.montoTotal = montoTotal;
    }
    public int getSaldo() {
        return this.saldo;
    }
    
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    public Set getNotaCreditos() {
        return this.notaCreditos;
    }
    
    public void setNotaCreditos(Set notaCreditos) {
        this.notaCreditos = notaCreditos;
    }
    public Set getRecibos() {
        return this.recibos;
    }
    
    public void setRecibos(Set recibos) {
        this.recibos = recibos;
    }
    public Set getFacturaConvenios() {
        return this.facturaConvenios;
    }
    
    public void setFacturaConvenios(Set facturaConvenios) {
        this.facturaConvenios = facturaConvenios;
    }




}


