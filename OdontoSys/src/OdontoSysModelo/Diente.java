package OdontoSysModelo;
// Generated 06/11/2017 05:50:41 PM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Diente generated by hbm2java
 */
public class Diente  implements java.io.Serializable {


     private Integer iddiente;
     private String nombre;
     private int nomenclatura;
     private Set detalleHallazgos = new HashSet(0);
     private Set tratamientos = new HashSet(0);

    public Diente() {
    }

	
    public Diente(String nombre, int nomenclatura) {
        this.nombre = nombre;
        this.nomenclatura = nomenclatura;
    }
    public Diente(String nombre, int nomenclatura, Set detalleHallazgos, Set tratamientos) {
       this.nombre = nombre;
       this.nomenclatura = nomenclatura;
       this.detalleHallazgos = detalleHallazgos;
       this.tratamientos = tratamientos;
    }
   
    public Integer getIddiente() {
        return this.iddiente;
    }
    
    public void setIddiente(Integer iddiente) {
        this.iddiente = iddiente;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getNomenclatura() {
        return this.nomenclatura;
    }
    
    public void setNomenclatura(int nomenclatura) {
        this.nomenclatura = nomenclatura;
    }
    public Set getDetalleHallazgos() {
        return this.detalleHallazgos;
    }
    
    public void setDetalleHallazgos(Set detalleHallazgos) {
        this.detalleHallazgos = detalleHallazgos;
    }
    public Set getTratamientos() {
        return this.tratamientos;
    }
    
    public void setTratamientos(Set tratamientos) {
        this.tratamientos = tratamientos;
    }




}


