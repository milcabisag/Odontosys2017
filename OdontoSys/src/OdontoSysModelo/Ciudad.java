package OdontoSysModelo;
// Generated 25/10/2017 11:24:35 AM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Ciudad generated by hbm2java
 */
public class Ciudad  implements java.io.Serializable {


     private Integer idciudad;
     private String nombre;
     private Set empresas = new HashSet(0);
     private Set doctors = new HashSet(0);
     private Set pacientes = new HashSet(0);

    public Ciudad() {
    }

	
    public Ciudad(String nombre) {
        this.nombre = nombre;
    }
    public Ciudad(String nombre, Set empresas, Set doctors, Set pacientes) {
       this.nombre = nombre;
       this.empresas = empresas;
       this.doctors = doctors;
       this.pacientes = pacientes;
    }
   
    public Integer getIdciudad() {
        return this.idciudad;
    }
    
    public void setIdciudad(Integer idciudad) {
        this.idciudad = idciudad;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Set getEmpresas() {
        return this.empresas;
    }
    
    public void setEmpresas(Set empresas) {
        this.empresas = empresas;
    }
    public Set getDoctors() {
        return this.doctors;
    }
    
    public void setDoctors(Set doctors) {
        this.doctors = doctors;
    }
    public Set getPacientes() {
        return this.pacientes;
    }
    
    public void setPacientes(Set pacientes) {
        this.pacientes = pacientes;
    }




}

