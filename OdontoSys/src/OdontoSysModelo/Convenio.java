package OdontoSysModelo;
// Generated 07/11/2017 09:44:47 AM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Convenio generated by hbm2java
 */
public class Convenio  implements java.io.Serializable {


     private Integer idconvenio;
     private Empresa empresa;
     private Servicio servicio;
     private Paciente paciente;
     private int porcentaje;
     private String observacion;
     private String estado;
     private Set convPacientes = new HashSet(0);
     private Set detalleConvenios = new HashSet(0);

    public Convenio() {
    }

	
    public Convenio(Empresa empresa, Servicio servicio, Paciente paciente, int porcentaje, String estado) {
        this.empresa = empresa;
        this.servicio = servicio;
        this.paciente = paciente;
        this.porcentaje = porcentaje;
        this.estado = estado;
    }
    public Convenio(Empresa empresa, Servicio servicio, Paciente paciente, int porcentaje, String observacion, String estado, Set convPacientes, Set detalleConvenios) {
       this.empresa = empresa;
       this.servicio = servicio;
       this.paciente = paciente;
       this.porcentaje = porcentaje;
       this.observacion = observacion;
       this.estado = estado;
       this.convPacientes = convPacientes;
       this.detalleConvenios = detalleConvenios;
    }
   
    public Integer getIdconvenio() {
        return this.idconvenio;
    }
    
    public void setIdconvenio(Integer idconvenio) {
        this.idconvenio = idconvenio;
    }
    public Empresa getEmpresa() {
        return this.empresa;
    }
    
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    public Servicio getServicio() {
        return this.servicio;
    }
    
    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
    public Paciente getPaciente() {
        return this.paciente;
    }
    
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    public int getPorcentaje() {
        return this.porcentaje;
    }
    
    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }
    public String getObservacion() {
        return this.observacion;
    }
    
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public Set getConvPacientes() {
        return this.convPacientes;
    }
    
    public void setConvPacientes(Set convPacientes) {
        this.convPacientes = convPacientes;
    }
    public Set getDetalleConvenios() {
        return this.detalleConvenios;
    }
    
    public void setDetalleConvenios(Set detalleConvenios) {
        this.detalleConvenios = detalleConvenios;
    }




}


