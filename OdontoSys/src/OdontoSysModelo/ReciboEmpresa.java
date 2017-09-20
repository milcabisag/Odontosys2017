package OdontoSysModelo;
// Generated 20/09/2017 01:46:33 PM by Hibernate Tools 3.6.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * ReciboEmpresa generated by hbm2java
 */
public class ReciboEmpresa  implements java.io.Serializable {


     private Integer idreciboEmpresa;
     private Empresa empresa;
     private Usuario usuario;
     private FacturaEmpresa facturaEmpresa;
     private Date fecha;
     private int monto;
     private Set movimientoEmpresas = new HashSet(0);
     private Set detalleReciboemps = new HashSet(0);

    public ReciboEmpresa() {
    }

	
    public ReciboEmpresa(Empresa empresa, Usuario usuario, FacturaEmpresa facturaEmpresa, Date fecha, int monto) {
        this.empresa = empresa;
        this.usuario = usuario;
        this.facturaEmpresa = facturaEmpresa;
        this.fecha = fecha;
        this.monto = monto;
    }
    public ReciboEmpresa(Empresa empresa, Usuario usuario, FacturaEmpresa facturaEmpresa, Date fecha, int monto, Set movimientoEmpresas, Set detalleReciboemps) {
       this.empresa = empresa;
       this.usuario = usuario;
       this.facturaEmpresa = facturaEmpresa;
       this.fecha = fecha;
       this.monto = monto;
       this.movimientoEmpresas = movimientoEmpresas;
       this.detalleReciboemps = detalleReciboemps;
    }
   
    public Integer getIdreciboEmpresa() {
        return this.idreciboEmpresa;
    }
    
    public void setIdreciboEmpresa(Integer idreciboEmpresa) {
        this.idreciboEmpresa = idreciboEmpresa;
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
    public FacturaEmpresa getFacturaEmpresa() {
        return this.facturaEmpresa;
    }
    
    public void setFacturaEmpresa(FacturaEmpresa facturaEmpresa) {
        this.facturaEmpresa = facturaEmpresa;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public int getMonto() {
        return this.monto;
    }
    
    public void setMonto(int monto) {
        this.monto = monto;
    }
    public Set getMovimientoEmpresas() {
        return this.movimientoEmpresas;
    }
    
    public void setMovimientoEmpresas(Set movimientoEmpresas) {
        this.movimientoEmpresas = movimientoEmpresas;
    }
    public Set getDetalleReciboemps() {
        return this.detalleReciboemps;
    }
    
    public void setDetalleReciboemps(Set detalleReciboemps) {
        this.detalleReciboemps = detalleReciboemps;
    }




}


