package OdontoSysModelo;
// Generated 24/07/2014 08:45:38 PM by Hibernate Tools 3.6.0


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * FacturaConvenio generated by hbm2java
 */
@Entity
@Table(name="factura_convenio"
    ,catalog="odontosys"
)
public class FacturaConvenio  implements java.io.Serializable {


     private Integer idfacturaConvenio;
     private Empresa empresa;
     private Factura factura;
     private FacturaEmpresa facturaEmpresa;
     private String estado;
     private int monto;

    public FacturaConvenio() {
    }

	
    public FacturaConvenio(Empresa empresa, Factura factura, String estado, int monto) {
        this.empresa = empresa;
        this.factura = factura;
        this.estado = estado;
        this.monto = monto;
    }
    public FacturaConvenio(Empresa empresa, Factura factura, FacturaEmpresa facturaEmpresa, String estado, int monto) {
       this.empresa = empresa;
       this.factura = factura;
       this.facturaEmpresa = facturaEmpresa;
       this.estado = estado;
       this.monto = monto;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idfactura_convenio", unique=true, nullable=false)
    public Integer getIdfacturaConvenio() {
        return this.idfacturaConvenio;
    }
    
    public void setIdfacturaConvenio(Integer idfacturaConvenio) {
        this.idfacturaConvenio = idfacturaConvenio;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="fk_empresa", nullable=false)
    public Empresa getEmpresa() {
        return this.empresa;
    }
    
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="fk_factura", nullable=false)
    public Factura getFactura() {
        return this.factura;
    }
    
    public void setFactura(Factura factura) {
        this.factura = factura;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="fk_facturaemp")
    public FacturaEmpresa getFacturaEmpresa() {
        return this.facturaEmpresa;
    }
    
    public void setFacturaEmpresa(FacturaEmpresa facturaEmpresa) {
        this.facturaEmpresa = facturaEmpresa;
    }

    
    @Column(name="estado", nullable=false, length=10)
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    @Column(name="monto", nullable=false)
    public int getMonto() {
        return this.monto;
    }
    
    public void setMonto(int monto) {
        this.monto = monto;
    }




}


