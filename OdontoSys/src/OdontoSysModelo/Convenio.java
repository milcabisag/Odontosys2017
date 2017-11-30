package OdontoSysModelo;
// Generated 30/11/2017 03:54:29 PM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Convenio generated by hbm2java
 */
public class Convenio  implements java.io.Serializable {


     private Integer idconvenio;
     private Empresa empresa;
     private String nomConv;
     private String observacion;
     private String estado;
     private Set detalleConvenios = new HashSet(0);
     private Set convPacientes = new HashSet(0);

    public Convenio() {
    }

	
    public Convenio(Empresa empresa, String nomConv, String estado) {
        this.empresa = empresa;
        this.nomConv = nomConv;
        this.estado = estado;
    }
    public Convenio(Empresa empresa, String nomConv, String observacion, String estado, Set detalleConvenios, Set convPacientes) {
       this.empresa = empresa;
       this.nomConv = nomConv;
       this.observacion = observacion;
       this.estado = estado;
       this.detalleConvenios = detalleConvenios;
       this.convPacientes = convPacientes;
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
    public String getNomConv() {
        return this.nomConv;
    }
    
    public void setNomConv(String nomConv) {
        this.nomConv = nomConv;
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
    public Set getDetalleConvenios() {
        return this.detalleConvenios;
    }
    
    public void setDetalleConvenios(Set detalleConvenios) {
        this.detalleConvenios = detalleConvenios;
    }
    public Set getConvPacientes() {
        return this.convPacientes;
    }
    
    public void setConvPacientes(Set convPacientes) {
        this.convPacientes = convPacientes;
    }




}


