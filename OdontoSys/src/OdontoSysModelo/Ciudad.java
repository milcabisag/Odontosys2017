package OdontoSysModelo;
// Generated 22/11/2017 11:55:38 AM by Hibernate Tools 3.6.0



/**
 * Ciudad generated by hbm2java
 */
public class Ciudad  implements java.io.Serializable {


     private Integer idciudad;
     private String nombre;

    public Ciudad() {
    }

    public Ciudad(String nombre) {
       this.nombre = nombre;
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




}


