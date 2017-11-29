package OdontoSysModelo;
// Generated 28/11/2017 08:28:36 PM by Hibernate Tools 3.6.0



/**
 * Datos generated by hbm2java
 */
public class Datos  implements java.io.Serializable {


     private Integer iddatos;
     private String nombreEmpresa;
     private String nombrePropietario;
     private String actividad;
     private String ruc;
     private String direccion;
     private String ciudad;
     private String telefono;
     private String datoscol;

    public Datos() {
    }

	
    public Datos(String nombreEmpresa, String nombrePropietario, String actividad, String ruc, String direccion, String ciudad, String telefono) {
        this.nombreEmpresa = nombreEmpresa;
        this.nombrePropietario = nombrePropietario;
        this.actividad = actividad;
        this.ruc = ruc;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.telefono = telefono;
    }
    public Datos(String nombreEmpresa, String nombrePropietario, String actividad, String ruc, String direccion, String ciudad, String telefono, String datoscol) {
       this.nombreEmpresa = nombreEmpresa;
       this.nombrePropietario = nombrePropietario;
       this.actividad = actividad;
       this.ruc = ruc;
       this.direccion = direccion;
       this.ciudad = ciudad;
       this.telefono = telefono;
       this.datoscol = datoscol;
    }
   
    public Integer getIddatos() {
        return this.iddatos;
    }
    
    public void setIddatos(Integer iddatos) {
        this.iddatos = iddatos;
    }
    public String getNombreEmpresa() {
        return this.nombreEmpresa;
    }
    
    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }
    public String getNombrePropietario() {
        return this.nombrePropietario;
    }
    
    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
    }
    public String getActividad() {
        return this.actividad;
    }
    
    public void setActividad(String actividad) {
        this.actividad = actividad;
    }
    public String getRuc() {
        return this.ruc;
    }
    
    public void setRuc(String ruc) {
        this.ruc = ruc;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getCiudad() {
        return this.ciudad;
    }
    
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getDatoscol() {
        return this.datoscol;
    }
    
    public void setDatoscol(String datoscol) {
        this.datoscol = datoscol;
    }




}


