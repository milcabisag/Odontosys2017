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
 * DetalleOrden generated by hbm2java
 */
@Entity
@Table(name="detalle_orden"
    ,catalog="odontosys"
)
public class DetalleOrden  implements java.io.Serializable {


     private Integer iddetalleOrden;
     private Servicio servicio;
     private OrdenServicio ordenServicio;
     private int precio;

    public DetalleOrden() {
    }

    public DetalleOrden(Servicio servicio, OrdenServicio ordenServicio, int precio) {
       this.servicio = servicio;
       this.ordenServicio = ordenServicio;
       this.precio = precio;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="iddetalle_orden", unique=true, nullable=false)
    public Integer getIddetalleOrden() {
        return this.iddetalleOrden;
    }
    
    public void setIddetalleOrden(Integer iddetalleOrden) {
        this.iddetalleOrden = iddetalleOrden;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="fk_servicio", nullable=false)
    public Servicio getServicio() {
        return this.servicio;
    }
    
    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="fk_orden_servicio", nullable=false)
    public OrdenServicio getOrdenServicio() {
        return this.ordenServicio;
    }
    
    public void setOrdenServicio(OrdenServicio ordenServicio) {
        this.ordenServicio = ordenServicio;
    }

    
    @Column(name="precio", nullable=false)
    public int getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(int precio) {
        this.precio = precio;
    }




}


