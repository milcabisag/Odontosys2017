package OdontoSysModelo;
// Generated 28/11/2017 08:28:36 PM by Hibernate Tools 3.6.0



/**
 * Tratamiento generated by hbm2java
 */
public class Tratamiento  implements java.io.Serializable {


     private Integer idtratamiento;
     private Odontograma odontograma;
     private Servicio servicio;
     private Diente diente;
     private String estado;
     private String especificacion;

    public Tratamiento() {
    }

    public Tratamiento(Odontograma odontograma, Servicio servicio, Diente diente, String estado, String especificacion) {
       this.odontograma = odontograma;
       this.servicio = servicio;
       this.diente = diente;
       this.estado = estado;
       this.especificacion = especificacion;
    }
   
    public Integer getIdtratamiento() {
        return this.idtratamiento;
    }
    
    public void setIdtratamiento(Integer idtratamiento) {
        this.idtratamiento = idtratamiento;
    }
    public Odontograma getOdontograma() {
        return this.odontograma;
    }
    
    public void setOdontograma(Odontograma odontograma) {
        this.odontograma = odontograma;
    }
    public Servicio getServicio() {
        return this.servicio;
    }
    
    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
    public Diente getDiente() {
        return this.diente;
    }
    
    public void setDiente(Diente diente) {
        this.diente = diente;
    }
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getEspecificacion() {
        return this.especificacion;
    }
    
    public void setEspecificacion(String especificacion) {
        this.especificacion = especificacion;
    }




}


