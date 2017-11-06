package OdontoSysModelo;
// Generated 06/11/2017 10:05:22 AM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Empresa generated by hbm2java
 */
public class Empresa  implements java.io.Serializable {


     private Integer idempresa;
     private String nombre;
     private int ruc;
     private String direccion;
     private String telefono;
     private String email;
     private String nombreContacto;
     private String telContacto;
     private String observaciones;
     private String estado;
     private Set convenios = new HashSet(0);
     private Set facturaConvenios = new HashSet(0);
     private Set reciboEmpresas = new HashSet(0);
     private Set movimientoEmpresas = new HashSet(0);
     private Set notaCreditoEmpresas = new HashSet(0);
     private Set facturaEmpresas = new HashSet(0);

    public Empresa() {
    }

	
    public Empresa(String nombre, int ruc, String direccion, String telefono, String estado) {
        this.nombre = nombre;
        this.ruc = ruc;
        this.direccion = direccion;
        this.telefono = telefono;
        this.estado = estado;
    }
    public Empresa(String nombre, int ruc, String direccion, String telefono, String email, String nombreContacto, String telContacto, String observaciones, String estado, Set convenios, Set facturaConvenios, Set reciboEmpresas, Set movimientoEmpresas, Set notaCreditoEmpresas, Set facturaEmpresas) {
       this.nombre = nombre;
       this.ruc = ruc;
       this.direccion = direccion;
       this.telefono = telefono;
       this.email = email;
       this.nombreContacto = nombreContacto;
       this.telContacto = telContacto;
       this.observaciones = observaciones;
       this.estado = estado;
       this.convenios = convenios;
       this.facturaConvenios = facturaConvenios;
       this.reciboEmpresas = reciboEmpresas;
       this.movimientoEmpresas = movimientoEmpresas;
       this.notaCreditoEmpresas = notaCreditoEmpresas;
       this.facturaEmpresas = facturaEmpresas;
    }
   
    public Integer getIdempresa() {
        return this.idempresa;
    }
    
    public void setIdempresa(Integer idempresa) {
        this.idempresa = idempresa;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getRuc() {
        return this.ruc;
    }
    
    public void setRuc(int ruc) {
        this.ruc = ruc;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getNombreContacto() {
        return this.nombreContacto;
    }
    
    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }
    public String getTelContacto() {
        return this.telContacto;
    }
    
    public void setTelContacto(String telContacto) {
        this.telContacto = telContacto;
    }
    public String getObservaciones() {
        return this.observaciones;
    }
    
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public Set getConvenios() {
        return this.convenios;
    }
    
    public void setConvenios(Set convenios) {
        this.convenios = convenios;
    }
    public Set getFacturaConvenios() {
        return this.facturaConvenios;
    }
    
    public void setFacturaConvenios(Set facturaConvenios) {
        this.facturaConvenios = facturaConvenios;
    }
    public Set getReciboEmpresas() {
        return this.reciboEmpresas;
    }
    
    public void setReciboEmpresas(Set reciboEmpresas) {
        this.reciboEmpresas = reciboEmpresas;
    }
    public Set getMovimientoEmpresas() {
        return this.movimientoEmpresas;
    }
    
    public void setMovimientoEmpresas(Set movimientoEmpresas) {
        this.movimientoEmpresas = movimientoEmpresas;
    }
    public Set getNotaCreditoEmpresas() {
        return this.notaCreditoEmpresas;
    }
    
    public void setNotaCreditoEmpresas(Set notaCreditoEmpresas) {
        this.notaCreditoEmpresas = notaCreditoEmpresas;
    }
    public Set getFacturaEmpresas() {
        return this.facturaEmpresas;
    }
    
    public void setFacturaEmpresas(Set facturaEmpresas) {
        this.facturaEmpresas = facturaEmpresas;
    }




}


