package OdontoSysModelo;
// Generated 22/11/2017 02:37:09 PM by Hibernate Tools 3.6.0



/**
 * DetalleNotaEmp generated by hbm2java
 */
public class DetalleNotaEmp  implements java.io.Serializable {


     private Integer iddetalleNotaEmp;
     private NotaCreditoEmpresa notaCreditoEmpresa;
     private String descripcion;
     private int monto;

    public DetalleNotaEmp() {
    }

    public DetalleNotaEmp(NotaCreditoEmpresa notaCreditoEmpresa, String descripcion, int monto) {
       this.notaCreditoEmpresa = notaCreditoEmpresa;
       this.descripcion = descripcion;
       this.monto = monto;
    }
   
    public Integer getIddetalleNotaEmp() {
        return this.iddetalleNotaEmp;
    }
    
    public void setIddetalleNotaEmp(Integer iddetalleNotaEmp) {
        this.iddetalleNotaEmp = iddetalleNotaEmp;
    }
    public NotaCreditoEmpresa getNotaCreditoEmpresa() {
        return this.notaCreditoEmpresa;
    }
    
    public void setNotaCreditoEmpresa(NotaCreditoEmpresa notaCreditoEmpresa) {
        this.notaCreditoEmpresa = notaCreditoEmpresa;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public int getMonto() {
        return this.monto;
    }
    
    public void setMonto(int monto) {
        this.monto = monto;
    }




}


