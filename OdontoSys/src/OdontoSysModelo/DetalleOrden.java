package OdontoSysModelo;
// Generated 24/10/2017 08:56:38 AM by Hibernate Tools 3.6.0



/**
 * DetalleOrden generated by hbm2java
 */
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
   
    public Integer getIddetalleOrden() {
        return this.iddetalleOrden;
    }
    
    public void setIddetalleOrden(Integer iddetalleOrden) {
        this.iddetalleOrden = iddetalleOrden;
    }
    public Servicio getServicio() {
        return this.servicio;
    }
    
    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
    public OrdenServicio getOrdenServicio() {
        return this.ordenServicio;
    }
    
    public void setOrdenServicio(OrdenServicio ordenServicio) {
        this.ordenServicio = ordenServicio;
    }
    public int getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(int precio) {
        this.precio = precio;
    }




}


