package OdontoSysModelo;
// Generated 25/10/2017 12:54:45 PM by Hibernate Tools 3.6.0


import java.util.Date;

/**
 * Agenda generated by hbm2java
 */
public class Agenda  implements java.io.Serializable {


     private Integer idAgenda;
     private OrdenServicio ordenServicio;
     private Servicio servicio;
     private Paciente paciente;
     private Doctor doctor;
     private Date fecha;
     private String hora;
     private String estado;

    public Agenda() {
    }

	
    public Agenda(Servicio servicio, Paciente paciente, Doctor doctor, Date fecha, String hora, String estado) {
        this.servicio = servicio;
        this.paciente = paciente;
        this.doctor = doctor;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
    }
    public Agenda(OrdenServicio ordenServicio, Servicio servicio, Paciente paciente, Doctor doctor, Date fecha, String hora, String estado) {
       this.ordenServicio = ordenServicio;
       this.servicio = servicio;
       this.paciente = paciente;
       this.doctor = doctor;
       this.fecha = fecha;
       this.hora = hora;
       this.estado = estado;
    }
   
    public Integer getIdAgenda() {
        return this.idAgenda;
    }
    
    public void setIdAgenda(Integer idAgenda) {
        this.idAgenda = idAgenda;
    }
    public OrdenServicio getOrdenServicio() {
        return this.ordenServicio;
    }
    
    public void setOrdenServicio(OrdenServicio ordenServicio) {
        this.ordenServicio = ordenServicio;
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
    public Doctor getDoctor() {
        return this.doctor;
    }
    
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public String getHora() {
        return this.hora;
    }
    
    public void setHora(String hora) {
        this.hora = hora;
    }
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }




}


