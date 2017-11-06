package OdontoSysModelo;
// Generated 06/11/2017 05:50:41 PM by Hibernate Tools 3.6.0



/**
 * FacturaConvenio generated by hbm2java
 */
public class FacturaConvenio  implements java.io.Serializable {


     private Integer idfacturaConvenio;
     private Empresa empresa;
     private Factura factura;
     private Usuario usuario;
     private FacturaEmpresa facturaEmpresa;
     private String estado;
     private int monto;

    public FacturaConvenio() {
    }

	
    public FacturaConvenio(Empresa empresa, Factura factura, Usuario usuario, String estado, int monto) {
        this.empresa = empresa;
        this.factura = factura;
        this.usuario = usuario;
        this.estado = estado;
        this.monto = monto;
    }
    public FacturaConvenio(Empresa empresa, Factura factura, Usuario usuario, FacturaEmpresa facturaEmpresa, String estado, int monto) {
       this.empresa = empresa;
       this.factura = factura;
       this.usuario = usuario;
       this.facturaEmpresa = facturaEmpresa;
       this.estado = estado;
       this.monto = monto;
    }
   
    public Integer getIdfacturaConvenio() {
        return this.idfacturaConvenio;
    }
    
    public void setIdfacturaConvenio(Integer idfacturaConvenio) {
        this.idfacturaConvenio = idfacturaConvenio;
    }
    public Empresa getEmpresa() {
        return this.empresa;
    }
    
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
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
    public FacturaEmpresa getFacturaEmpresa() {
        return this.facturaEmpresa;
    }
    
    public void setFacturaEmpresa(FacturaEmpresa facturaEmpresa) {
        this.facturaEmpresa = facturaEmpresa;
    }
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public int getMonto() {
        return this.monto;
    }
    
    public void setMonto(int monto) {
        this.monto = monto;
    }




}


