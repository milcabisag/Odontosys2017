package OdontoSysModelo;
// Generated 17/09/2017 10:00:28 PM by Hibernate Tools 3.6.0



/**
 * DetalleHallazgo generated by hbm2java
 */
public class DetalleHallazgo  implements java.io.Serializable {


     private Integer iddetalleHallazgo;
     private Odontograma odontograma;
     private Diente diente;
     private Hallazgo hallazgo;
     private String sigla;
     private String ubicacion;
     private String especificacion;

    public DetalleHallazgo() {
    }

	
    public DetalleHallazgo(Odontograma odontograma, Diente diente, Hallazgo hallazgo, String sigla, String ubicacion) {
        this.odontograma = odontograma;
        this.diente = diente;
        this.hallazgo = hallazgo;
        this.sigla = sigla;
        this.ubicacion = ubicacion;
    }
    public DetalleHallazgo(Odontograma odontograma, Diente diente, Hallazgo hallazgo, String sigla, String ubicacion, String especificacion) {
       this.odontograma = odontograma;
       this.diente = diente;
       this.hallazgo = hallazgo;
       this.sigla = sigla;
       this.ubicacion = ubicacion;
       this.especificacion = especificacion;
    }
   
    public Integer getIddetalleHallazgo() {
        return this.iddetalleHallazgo;
    }
    
    public void setIddetalleHallazgo(Integer iddetalleHallazgo) {
        this.iddetalleHallazgo = iddetalleHallazgo;
    }
    public Odontograma getOdontograma() {
        return this.odontograma;
    }
    
    public void setOdontograma(Odontograma odontograma) {
        this.odontograma = odontograma;
    }
    public Diente getDiente() {
        return this.diente;
    }
    
    public void setDiente(Diente diente) {
        this.diente = diente;
    }
    public Hallazgo getHallazgo() {
        return this.hallazgo;
    }
    
    public void setHallazgo(Hallazgo hallazgo) {
        this.hallazgo = hallazgo;
    }
    public String getSigla() {
        return this.sigla;
    }
    
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
    public String getUbicacion() {
        return this.ubicacion;
    }
    
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    public String getEspecificacion() {
        return this.especificacion;
    }
    
    public void setEspecificacion(String especificacion) {
        this.especificacion = especificacion;
    }




}


