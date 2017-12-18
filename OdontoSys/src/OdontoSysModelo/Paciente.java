package OdontoSysModelo;
// Generated 12/12/2017 03:57:45 PM by Hibernate Tools 3.6.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Paciente generated by hbm2java
 */
public class Paciente  implements java.io.Serializable {


     private Integer idPaciente;
     private String nombres;
     private String apellidos;
     private int nroCi;
     private Date fechaNac;
     private String sexo;
     private String telLb;
     private String telCel;
     private String direccion;
     private String ciudad;
     private String email;
     private int peso;
     private String enfermedades;
     private String medicamentos;
     private String alergias;
     private String cirugias;
     private String observaciones;
     private String estado;
     private Set facturas = new HashSet(0);
     private Set convPacientes = new HashSet(0);
     private Set agendas = new HashSet(0);
     private Set ordenServicios = new HashSet(0);
     private Set diagnosticos = new HashSet(0);
     private Set movimientos = new HashSet(0);
     private Set odontogramas = new HashSet(0);
     private Set recibos = new HashSet(0);

    public Paciente() {
    }

	
    public Paciente(String nombres, String apellidos, int nroCi, Date fechaNac, String sexo, String direccion, String ciudad, int peso, String enfermedades, String medicamentos, String alergias, String cirugias, String observaciones, String estado) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.nroCi = nroCi;
        this.fechaNac = fechaNac;
        this.sexo = sexo;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.peso = peso;
        this.enfermedades = enfermedades;
        this.medicamentos = medicamentos;
        this.alergias = alergias;
        this.cirugias = cirugias;
        this.observaciones = observaciones;
        this.estado = estado;
    }
    public Paciente(String nombres, String apellidos, int nroCi, Date fechaNac, String sexo, String telLb, String telCel, String direccion, String ciudad, String email, int peso, String enfermedades, String medicamentos, String alergias, String cirugias, String observaciones, String estado, Set facturas, Set convPacientes, Set agendas, Set ordenServicios, Set diagnosticos, Set movimientos, Set odontogramas, Set recibos) {
       this.nombres = nombres;
       this.apellidos = apellidos;
       this.nroCi = nroCi;
       this.fechaNac = fechaNac;
       this.sexo = sexo;
       this.telLb = telLb;
       this.telCel = telCel;
       this.direccion = direccion;
       this.ciudad = ciudad;
       this.email = email;
       this.peso = peso;
       this.enfermedades = enfermedades;
       this.medicamentos = medicamentos;
       this.alergias = alergias;
       this.cirugias = cirugias;
       this.observaciones = observaciones;
       this.estado = estado;
       this.facturas = facturas;
       this.convPacientes = convPacientes;
       this.agendas = agendas;
       this.ordenServicios = ordenServicios;
       this.diagnosticos = diagnosticos;
       this.movimientos = movimientos;
       this.odontogramas = odontogramas;
       this.recibos = recibos;
    }
   
    public Integer getIdPaciente() {
        return this.idPaciente;
    }
    
    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }
    public String getNombres() {
        return this.nombres;
    }
    
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getApellidos() {
        return this.apellidos;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public int getNroCi() {
        return this.nroCi;
    }
    
    public void setNroCi(int nroCi) {
        this.nroCi = nroCi;
    }
    public Date getFechaNac() {
        return this.fechaNac;
    }
    
    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }
    public String getSexo() {
        return this.sexo;
    }
    
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public String getTelLb() {
        return this.telLb;
    }
    
    public void setTelLb(String telLb) {
        this.telLb = telLb;
    }
    public String getTelCel() {
        return this.telCel;
    }
    
    public void setTelCel(String telCel) {
        this.telCel = telCel;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getCiudad() {
        return this.ciudad;
    }
    
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public int getPeso() {
        return this.peso;
    }
    
    public void setPeso(int peso) {
        this.peso = peso;
    }
    public String getEnfermedades() {
        return this.enfermedades;
    }
    
    public void setEnfermedades(String enfermedades) {
        this.enfermedades = enfermedades;
    }
    public String getMedicamentos() {
        return this.medicamentos;
    }
    
    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }
    public String getAlergias() {
        return this.alergias;
    }
    
    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }
    public String getCirugias() {
        return this.cirugias;
    }
    
    public void setCirugias(String cirugias) {
        this.cirugias = cirugias;
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
    public Set getFacturas() {
        return this.facturas;
    }
    
    public void setFacturas(Set facturas) {
        this.facturas = facturas;
    }
    public Set getConvPacientes() {
        return this.convPacientes;
    }
    
    public void setConvPacientes(Set convPacientes) {
        this.convPacientes = convPacientes;
    }
    public Set getAgendas() {
        return this.agendas;
    }
    
    public void setAgendas(Set agendas) {
        this.agendas = agendas;
    }
    public Set getOrdenServicios() {
        return this.ordenServicios;
    }
    
    public void setOrdenServicios(Set ordenServicios) {
        this.ordenServicios = ordenServicios;
    }
    public Set getDiagnosticos() {
        return this.diagnosticos;
    }
    
    public void setDiagnosticos(Set diagnosticos) {
        this.diagnosticos = diagnosticos;
    }
    public Set getMovimientos() {
        return this.movimientos;
    }
    
    public void setMovimientos(Set movimientos) {
        this.movimientos = movimientos;
    }
    public Set getOdontogramas() {
        return this.odontogramas;
    }
    
    public void setOdontogramas(Set odontogramas) {
        this.odontogramas = odontogramas;
    }
    public Set getRecibos() {
        return this.recibos;
    }
    
    public void setRecibos(Set recibos) {
        this.recibos = recibos;
    }




}


