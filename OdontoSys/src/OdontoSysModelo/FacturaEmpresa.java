package OdontoSysModelo;
// Generated 12/12/2017 03:57:45 PM by Hibernate Tools 3.6.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * FacturaEmpresa generated by hbm2java
 */
public class FacturaEmpresa  implements java.io.Serializable {


     private Integer idfacturaEmpresa;
     private Talonario talonario;
     private Empresa empresa;
     private Usuario usuario;
     private MovimientoEmpresa movimientoEmpresa;
     private Date fecha;
     private String tipo;
     private String estado;
     private int montoTotal;
     private int saldo;
     private Set ordenEmpresas = new HashSet(0);
     private Set reciboEmpresas = new HashSet(0);

    public FacturaEmpresa() {
    }

	
    public FacturaEmpresa(Talonario talonario, Empresa empresa, Usuario usuario, MovimientoEmpresa movimientoEmpresa, Date fecha, String tipo, String estado, int montoTotal, int saldo) {
        this.talonario = talonario;
        this.empresa = empresa;
        this.usuario = usuario;
        this.movimientoEmpresa = movimientoEmpresa;
        this.fecha = fecha;
        this.tipo = tipo;
        this.estado = estado;
        this.montoTotal = montoTotal;
        this.saldo = saldo;
    }
    public FacturaEmpresa(Talonario talonario, Empresa empresa, Usuario usuario, MovimientoEmpresa movimientoEmpresa, Date fecha, String tipo, String estado, int montoTotal, int saldo, Set ordenEmpresas, Set reciboEmpresas) {
       this.talonario = talonario;
       this.empresa = empresa;
       this.usuario = usuario;
       this.movimientoEmpresa = movimientoEmpresa;
       this.fecha = fecha;
       this.tipo = tipo;
       this.estado = estado;
       this.montoTotal = montoTotal;
       this.saldo = saldo;
       this.ordenEmpresas = ordenEmpresas;
       this.reciboEmpresas = reciboEmpresas;
    }
   
    public Integer getIdfacturaEmpresa() {
        return this.idfacturaEmpresa;
    }
    
    public void setIdfacturaEmpresa(Integer idfacturaEmpresa) {
        this.idfacturaEmpresa = idfacturaEmpresa;
    }
    public Talonario getTalonario() {
        return this.talonario;
    }
    
    public void setTalonario(Talonario talonario) {
        this.talonario = talonario;
    }
    public Empresa getEmpresa() {
        return this.empresa;
    }
    
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public MovimientoEmpresa getMovimientoEmpresa() {
        return this.movimientoEmpresa;
    }
    
    public void setMovimientoEmpresa(MovimientoEmpresa movimientoEmpresa) {
        this.movimientoEmpresa = movimientoEmpresa;
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
    public Set getOrdenEmpresas() {
        return this.ordenEmpresas;
    }
    
    public void setOrdenEmpresas(Set ordenEmpresas) {
        this.ordenEmpresas = ordenEmpresas;
    }
    public Set getReciboEmpresas() {
        return this.reciboEmpresas;
    }
    
    public void setReciboEmpresas(Set reciboEmpresas) {
        this.reciboEmpresas = reciboEmpresas;
    }




}


