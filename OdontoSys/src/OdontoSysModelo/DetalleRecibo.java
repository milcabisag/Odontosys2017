package OdontoSysModelo;
// Generated 24/10/2017 08:56:38 AM by Hibernate Tools 3.6.0



/**
 * DetalleRecibo generated by hbm2java
 */
public class DetalleRecibo  implements java.io.Serializable {


     private Integer iddetalleRecibo;
     private Recibo recibo;
     private String formaPago;
     private int monto;

    public DetalleRecibo() {
    }

    public DetalleRecibo(Recibo recibo, String formaPago, int monto) {
       this.recibo = recibo;
       this.formaPago = formaPago;
       this.monto = monto;
    }
   
    public Integer getIddetalleRecibo() {
        return this.iddetalleRecibo;
    }
    
    public void setIddetalleRecibo(Integer iddetalleRecibo) {
        this.iddetalleRecibo = iddetalleRecibo;
    }
    public Recibo getRecibo() {
        return this.recibo;
    }
    
    public void setRecibo(Recibo recibo) {
        this.recibo = recibo;
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


