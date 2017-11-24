package OdontoSysModelo;
// Generated 24/11/2017 07:30:01 AM by Hibernate Tools 3.6.0



/**
 * DetalleConvenio generated by hbm2java
 */
public class DetalleConvenio  implements java.io.Serializable {


     private Integer iddetalleConvenio;
     private Servicio servicio;
     private Convenio convenio;
     private int porcentaje;
     private String estado;

    public DetalleConvenio() {
    }

    public DetalleConvenio(Servicio servicio, Convenio convenio, int porcentaje, String estado) {
       this.servicio = servicio;
       this.convenio = convenio;
       this.porcentaje = porcentaje;
       this.estado = estado;
    }
   
    public Integer getIddetalleConvenio() {
        return this.iddetalleConvenio;
    }
    
    public void setIddetalleConvenio(Integer iddetalleConvenio) {
        this.iddetalleConvenio = iddetalleConvenio;
    }
    public Servicio getServicio() {
        return this.servicio;
    }
    
    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
    public Convenio getConvenio() {
        return this.convenio;
    }
    
    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }
    public int getPorcentaje() {
        return this.porcentaje;
    }
    
    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }




}


