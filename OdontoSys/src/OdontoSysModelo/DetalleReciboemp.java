package OdontoSysModelo;
// Generated 07/11/2017 09:44:47 AM by Hibernate Tools 3.6.0



/**
 * DetalleReciboemp generated by hbm2java
 */
public class DetalleReciboemp  implements java.io.Serializable {


     private Integer iddetalleReciboEmp;
     private ReciboEmpresa reciboEmpresa;
     private String formaPago;
     private int monto;

    public DetalleReciboemp() {
    }

    public DetalleReciboemp(ReciboEmpresa reciboEmpresa, String formaPago, int monto) {
       this.reciboEmpresa = reciboEmpresa;
       this.formaPago = formaPago;
       this.monto = monto;
    }
   
    public Integer getIddetalleReciboEmp() {
        return this.iddetalleReciboEmp;
    }
    
    public void setIddetalleReciboEmp(Integer iddetalleReciboEmp) {
        this.iddetalleReciboEmp = iddetalleReciboEmp;
    }
    public ReciboEmpresa getReciboEmpresa() {
        return this.reciboEmpresa;
    }
    
    public void setReciboEmpresa(ReciboEmpresa reciboEmpresa) {
        this.reciboEmpresa = reciboEmpresa;
    }
    public String getFormaPago() {
        return this.formaPago;
    }
    
    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }
    public int getMonto() {
        return this.monto;
    }
    
    public void setMonto(int monto) {
        this.monto = monto;
    }




}


