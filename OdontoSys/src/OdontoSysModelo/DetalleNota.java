package OdontoSysModelo;
// Generated 07/11/2017 09:44:47 AM by Hibernate Tools 3.6.0



/**
 * DetalleNota generated by hbm2java
 */
public class DetalleNota  implements java.io.Serializable {


     private Integer iddetalleNota;
     private NotaCredito notaCredito;
     private String descripcion;
     private int monto;

    public DetalleNota() {
    }

    public DetalleNota(NotaCredito notaCredito, String descripcion, int monto) {
       this.notaCredito = notaCredito;
       this.descripcion = descripcion;
       this.monto = monto;
    }
   
    public Integer getIddetalleNota() {
        return this.iddetalleNota;
    }
    
    public void setIddetalleNota(Integer iddetalleNota) {
        this.iddetalleNota = iddetalleNota;
    }
    public NotaCredito getNotaCredito() {
        return this.notaCredito;
    }
    
    public void setNotaCredito(NotaCredito notaCredito) {
        this.notaCredito = notaCredito;
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


