package OdontoSysModelo;
// Generated 24/10/2017 08:56:38 AM by Hibernate Tools 3.6.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Doctor generated by hbm2java
 */
public class Doctor  implements java.io.Serializable {


     private Integer idDoctor;
     private Ciudad ciudad;
     private String nombre;
     private String apellido;
     private int nroCi;
     private Date fechaNac;
     private String sexo;
     private String teLb;
     private String telCel;
     private String direccion;
     private String email;
     private String regProf;
     private String estado;
     private Set agendas = new HashSet(0);
     private Set usuarios = new HashSet(0);
     private Set odontogramas = new HashSet(0);

    public Doctor() {
    }

	
    public Doctor(String nombre, String apellido, int nroCi, Date fechaNac, String sexo, String direccion, String regProf) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nroCi = nroCi;
        this.fechaNac = fechaNac;
        this.sexo = sexo;
        this.direccion = direccion;
        this.regProf = regProf;
    }
    public Doctor(Ciudad ciudad, String nombre, String apellido, int nroCi, Date fechaNac, String sexo, String teLb, String telCel, String direccion, String email, String regProf, String estado, Set agendas, Set usuarios, Set odontogramas) {
       this.ciudad = ciudad;
       this.nombre = nombre;
       this.apellido = apellido;
       this.nroCi = nroCi;
       this.fechaNac = fechaNac;
       this.sexo = sexo;
       this.teLb = teLb;
       this.telCel = telCel;
       this.direccion = direccion;
       this.email = email;
       this.regProf = regProf;
       this.estado = estado;
       this.agendas = agendas;
       this.usuarios = usuarios;
       this.odontogramas = odontogramas;
    }
   
    public Integer getIdDoctor() {
        return this.idDoctor;
    }
    
    public void setIdDoctor(Integer idDoctor) {
        this.idDoctor = idDoctor;
    }
    public Ciudad getCiudad() {
        return this.ciudad;
    }
    
    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
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
    public String getTeLb() {
        return this.teLb;
    }
    
    public void setTeLb(String teLb) {
        this.teLb = teLb;
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
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getRegProf() {
        return this.regProf;
    }
    
    public void setRegProf(String regProf) {
        this.regProf = regProf;
    }
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public Set getAgendas() {
        return this.agendas;
    }
    
    public void setAgendas(Set agendas) {
        this.agendas = agendas;
    }
    public Set getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Set usuarios) {
        this.usuarios = usuarios;
    }
    public Set getOdontogramas() {
        return this.odontogramas;
    }
    
    public void setOdontogramas(Set odontogramas) {
        this.odontogramas = odontogramas;
    }




}


