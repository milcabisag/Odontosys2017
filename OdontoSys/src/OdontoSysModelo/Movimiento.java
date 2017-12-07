package OdontoSysModelo;
// Generated 01/12/2017 04:41:36 PM by Hibernate Tools 3.6.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Movimiento generated by hbm2java
 */
public class Movimiento  implements java.io.Serializable {


     private Integer idmovimiento;
     private Paciente paciente;
     private Date fecha;
     private String movimiento;
     private int debe;
     private int haber;
     private Set recibos = new HashSet(0);
     private Set facturas = new HashSet(0);
     private Set cajas = new HashSet(0);

    public Movimiento() {
    }

	
    public Movimiento(Paciente paciente, Date fecha, String movimiento, int debe, int haber) {
        this.paciente = paciente;
        this.fecha = fecha;
        this.movimiento = movimiento;
        this.debe = debe;
        this.haber = haber;
    }
    public Movimiento(Paciente paciente, Date fecha, String movimiento, int debe, int haber, Set recibos, Set facturas, Set cajas) {
       this.paciente = paciente;
       this.fecha = fecha;
       this.movimiento = movimiento;
       this.debe = debe;
       this.haber = haber;
       this.recibos = recibos;
       this.facturas = facturas;
       this.cajas = cajas;
    }
   
    public Integer getIdmovimiento() {
        return this.idmovimiento;
    }
    
    public void setIdmovimiento(Integer idmovimiento) {
        this.idmovimiento = idmovimiento;
    }
    public Paciente getPaciente() {
        return this.paciente;
    }
    
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public String getMovimiento() {
        return this.movimiento;
    }
    
    public void setMovimiento(String movimiento) {
        this.movimiento = movimiento;
    }
    public int getDebe() {
        return this.debe;
    }
    
    public void setDebe(int debe) {
        this.debe = debe;
    }
    public int getHaber() {
        return this.haber;
    }
    
    public void setHaber(int haber) {
        this.haber = haber;
    }
    public Set getRecibos() {
        return this.recibos;
    }
    
    public void setRecibos(Set recibos) {
        this.recibos = recibos;
    }
    public Set getFacturas() {
        return this.facturas;
    }
    
    public void setFacturas(Set facturas) {
        this.facturas = facturas;
    }
    public Set getCajas() {
        return this.cajas;
    }
    
    public void setCajas(Set cajas) {
        this.cajas = cajas;
    }




}


