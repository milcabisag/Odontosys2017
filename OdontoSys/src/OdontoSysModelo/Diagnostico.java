package OdontoSysModelo;
// Generated 29/11/2017 05:15:01 PM by Hibernate Tools 3.6.0


import java.util.Date;

/**
 * Diagnostico generated by hbm2java
 */
public class Diagnostico  implements java.io.Serializable {


     private Integer idDiagnostico;
     private Odontograma odontograma;
     private Usuario usuario;
     private Paciente paciente;
     private Date fecha;
     private String resumenHallazgos;
     private String planTratamiento;
     private String tipo;
     private String empresa;
     private String observaciones;
     private String diagnosticocol;

    public Diagnostico() {
    }

	
    public Diagnostico(Usuario usuario, Paciente paciente, Date fecha, String resumenHallazgos, String planTratamiento, String tipo) {
        this.usuario = usuario;
        this.paciente = paciente;
        this.fecha = fecha;
        this.resumenHallazgos = resumenHallazgos;
        this.planTratamiento = planTratamiento;
        this.tipo = tipo;
    }
    public Diagnostico(Odontograma odontograma, Usuario usuario, Paciente paciente, Date fecha, String resumenHallazgos, String planTratamiento, String tipo, String empresa, String observaciones, String diagnosticocol) {
       this.odontograma = odontograma;
       this.usuario = usuario;
       this.paciente = paciente;
       this.fecha = fecha;
       this.resumenHallazgos = resumenHallazgos;
       this.planTratamiento = planTratamiento;
       this.tipo = tipo;
       this.empresa = empresa;
       this.observaciones = observaciones;
       this.diagnosticocol = diagnosticocol;
    }
   
    public Integer getIdDiagnostico() {
        return this.idDiagnostico;
    }
    
    public void setIdDiagnostico(Integer idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }
    public Odontograma getOdontograma() {
        return this.odontograma;
    }
    
    public void setOdontograma(Odontograma odontograma) {
        this.odontograma = odontograma;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Paciente getPaciente() {
        return this.paciente;
    }
    
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public String getResumenHallazgos() {
        return this.resumenHallazgos;
    }
    
    public void setResumenHallazgos(String resumenHallazgos) {
        this.resumenHallazgos = resumenHallazgos;
    }
    public String getPlanTratamiento() {
        return this.planTratamiento;
    }
    
    public void setPlanTratamiento(String planTratamiento) {
        this.planTratamiento = planTratamiento;
    }
    public String getTipo() {
        return this.tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getEmpresa() {
        return this.empresa;
    }
    
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
    public String getObservaciones() {
        return this.observaciones;
    }
    
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    public String getDiagnosticocol() {
        return this.diagnosticocol;
    }
    
    public void setDiagnosticocol(String diagnosticocol) {
        this.diagnosticocol = diagnosticocol;
    }




}


