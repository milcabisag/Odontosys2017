package OdontoSysModelo;
// Generated 21/12/2017 11:53:02 AM by Hibernate Tools 3.6.0



/**
 * DetalleOrdenEmpresa generated by hbm2java
 */
public class DetalleOrdenEmpresa  implements java.io.Serializable {


     private Integer iddetalleOrdenEmpresa;
     private Servicio servicio;
     private OrdenEmpresa ordenEmpresa;
     private int monto;

    public DetalleOrdenEmpresa() {
    }

    public DetalleOrdenEmpresa(Servicio servicio, OrdenEmpresa ordenEmpresa, int monto) {
       this.servicio = servicio;
       this.ordenEmpresa = ordenEmpresa;
       this.monto = monto;
    }
   
    public Integer getIddetalleOrdenEmpresa() {
        return this.iddetalleOrdenEmpresa;
    }
    
    public void setIddetalleOrdenEmpresa(Integer iddetalleOrdenEmpresa) {
        this.iddetalleOrdenEmpresa = iddetalleOrdenEmpresa;
    }
    public Servicio getServicio() {
        return this.servicio;
    }
    
    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
    public OrdenEmpresa getOrdenEmpresa() {
        return this.ordenEmpresa;
    }
    
    public void setOrdenEmpresa(OrdenEmpresa ordenEmpresa) {
        this.ordenEmpresa = ordenEmpresa;
    }
    public int getMonto() {
        return this.monto;
    }
    
    public void setMonto(int monto) {
        this.monto = monto;
    }




}


