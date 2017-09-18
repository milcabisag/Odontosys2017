package OdontoSysModelo;
// Generated 18/09/2017 01:21:52 PM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Usuario generated by hbm2java
 */
public class Usuario  implements java.io.Serializable {


     private Integer idusuario;
     private Doctor doctor;
     private String nombre;
     private String passw;
     private String rol;
     private String estado;
     private String observacion;
     private Set reciboEmpresas = new HashSet(0);
     private Set diagnosticos = new HashSet(0);
     private Set notaCreditos = new HashSet(0);
     private Set notaCreditoEmpresas = new HashSet(0);
     private Set facturaEmpresas = new HashSet(0);
     private Set facturas = new HashSet(0);
     private Set recibos = new HashSet(0);
     private Set ordenServicios = new HashSet(0);
     private Set odontogramas = new HashSet(0);
     private Set cajas = new HashSet(0);
     private Set facturaConvenios = new HashSet(0);

    public Usuario() {
    }

	
    public Usuario(String nombre, String passw, String rol, String estado) {
        this.nombre = nombre;
        this.passw = passw;
        this.rol = rol;
        this.estado = estado;
    }
    public Usuario(Doctor doctor, String nombre, String passw, String rol, String estado, String observacion, Set reciboEmpresas, Set diagnosticos, Set notaCreditos, Set notaCreditoEmpresas, Set facturaEmpresas, Set facturas, Set recibos, Set ordenServicios, Set odontogramas, Set cajas, Set facturaConvenios) {
       this.doctor = doctor;
       this.nombre = nombre;
       this.passw = passw;
       this.rol = rol;
       this.estado = estado;
       this.observacion = observacion;
       this.reciboEmpresas = reciboEmpresas;
       this.diagnosticos = diagnosticos;
       this.notaCreditos = notaCreditos;
       this.notaCreditoEmpresas = notaCreditoEmpresas;
       this.facturaEmpresas = facturaEmpresas;
       this.facturas = facturas;
       this.recibos = recibos;
       this.ordenServicios = ordenServicios;
       this.odontogramas = odontogramas;
       this.cajas = cajas;
       this.facturaConvenios = facturaConvenios;
    }
   
    public Integer getIdusuario() {
        return this.idusuario;
    }
    
    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }
    public Doctor getDoctor() {
        return this.doctor;
    }
    
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPassw() {
        return this.passw;
    }
    
    public void setPassw(String passw) {
        this.passw = passw;
    }
    public String getRol() {
        return this.rol;
    }
    
    public void setRol(String rol) {
        this.rol = rol;
    }
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getObservacion() {
        return this.observacion;
    }
    
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    public Set getReciboEmpresas() {
        return this.reciboEmpresas;
    }
    
    public void setReciboEmpresas(Set reciboEmpresas) {
        this.reciboEmpresas = reciboEmpresas;
    }
    public Set getDiagnosticos() {
        return this.diagnosticos;
    }
    
    public void setDiagnosticos(Set diagnosticos) {
        this.diagnosticos = diagnosticos;
    }
    public Set getNotaCreditos() {
        return this.notaCreditos;
    }
    
    public void setNotaCreditos(Set notaCreditos) {
        this.notaCreditos = notaCreditos;
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
    public Set getFacturas() {
        return this.facturas;
    }
    
    public void setFacturas(Set facturas) {
        this.facturas = facturas;
    }
    public Set getRecibos() {
        return this.recibos;
    }
    
    public void setRecibos(Set recibos) {
        this.recibos = recibos;
    }
    public Set getOrdenServicios() {
        return this.ordenServicios;
    }
    
    public void setOrdenServicios(Set ordenServicios) {
        this.ordenServicios = ordenServicios;
    }
    public Set getOdontogramas() {
        return this.odontogramas;
    }
    
    public void setOdontogramas(Set odontogramas) {
        this.odontogramas = odontogramas;
    }
    public Set getCajas() {
        return this.cajas;
    }
    
    public void setCajas(Set cajas) {
        this.cajas = cajas;
    }
    public Set getFacturaConvenios() {
        return this.facturaConvenios;
    }
    
    public void setFacturaConvenios(Set facturaConvenios) {
        this.facturaConvenios = facturaConvenios;
    }




}


