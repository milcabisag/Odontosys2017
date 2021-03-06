package OdontoSysModelo;
// Generated 24/10/2017 08:56:38 AM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Hallazgo generated by hbm2java
 */
public class Hallazgo  implements java.io.Serializable {


     private Integer idhallazgo;
     private String nombre;
     private String simbolol;
     private Set detalleHallazgos = new HashSet(0);

    public Hallazgo() {
    }

	
    public Hallazgo(String nombre) {
        this.nombre = nombre;
    }
    public Hallazgo(String nombre, String simbolol, Set detalleHallazgos) {
       this.nombre = nombre;
       this.simbolol = simbolol;
       this.detalleHallazgos = detalleHallazgos;
    }
   
    public Integer getIdhallazgo() {
        return this.idhallazgo;
    }
    
    public void setIdhallazgo(Integer idhallazgo) {
        this.idhallazgo = idhallazgo;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getSimbolol() {
        return this.simbolol;
    }
    
    public void setSimbolol(String simbolol) {
        this.simbolol = simbolol;
    }
    public Set getDetalleHallazgos() {
        return this.detalleHallazgos;
    }
    
    public void setDetalleHallazgos(Set detalleHallazgos) {
        this.detalleHallazgos = detalleHallazgos;
    }




}


