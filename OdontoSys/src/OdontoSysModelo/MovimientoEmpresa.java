package OdontoSysModelo;
// Generated 30/11/2017 03:54:29 PM by Hibernate Tools 3.6.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * MovimientoEmpresa generated by hbm2java
 */
public class MovimientoEmpresa  implements java.io.Serializable {


     private Integer idmovimientoEmpresa;
     private Empresa empresa;
     private Date fecha;
     private String movimiento;
     private int debe;
     private int haber;
     private Set facturaEmpresas = new HashSet(0);
     private Set cajas = new HashSet(0);
     private Set reciboEmpresas = new HashSet(0);

    public MovimientoEmpresa() {
    }

	
    public MovimientoEmpresa(Empresa empresa, Date fecha, String movimiento, int debe, int haber) {
        this.empresa = empresa;
        this.fecha = fecha;
        this.movimiento = movimiento;
        this.debe = debe;
        this.haber = haber;
    }
    public MovimientoEmpresa(Empresa empresa, Date fecha, String movimiento, int debe, int haber, Set facturaEmpresas, Set cajas, Set reciboEmpresas) {
       this.empresa = empresa;
       this.fecha = fecha;
       this.movimiento = movimiento;
       this.debe = debe;
       this.haber = haber;
       this.facturaEmpresas = facturaEmpresas;
       this.cajas = cajas;
       this.reciboEmpresas = reciboEmpresas;
    }
   
    public Integer getIdmovimientoEmpresa() {
        return this.idmovimientoEmpresa;
    }
    
    public void setIdmovimientoEmpresa(Integer idmovimientoEmpresa) {
        this.idmovimientoEmpresa = idmovimientoEmpresa;
    }
    public Empresa getEmpresa() {
        return this.empresa;
    }
    
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
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
    public Set getFacturaEmpresas() {
        return this.facturaEmpresas;
    }
    
    public void setFacturaEmpresas(Set facturaEmpresas) {
        this.facturaEmpresas = facturaEmpresas;
    }
    public Set getCajas() {
        return this.cajas;
    }
    
    public void setCajas(Set cajas) {
        this.cajas = cajas;
    }
    public Set getReciboEmpresas() {
        return this.reciboEmpresas;
    }
    
    public void setReciboEmpresas(Set reciboEmpresas) {
        this.reciboEmpresas = reciboEmpresas;
    }




}


