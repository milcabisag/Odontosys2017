package OdontoSysUtil;
// Generated 06/11/2017 10:05:22 AM by Hibernate Tools 3.6.0


public class TipoPago { // implements java.io.Serializable {


     private String tipo;
     private int monto;

    public TipoPago() {
    }

	
    public TipoPago(String tipo, int monto) {
        this.tipo = tipo;
        this.monto = monto;
    }
   
    public String getTipo() {
        return this.tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public int getMonto() {
        return this.monto;
    }
    
    public void setMonto(int monto) {
        this.monto = monto;
    }



}


