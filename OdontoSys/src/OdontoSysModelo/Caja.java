package OdontoSysModelo;
// Generated 24/10/2017 08:56:38 AM by Hibernate Tools 3.6.0



/**
 * Caja generated by hbm2java
 */
public class Caja  implements java.io.Serializable {


     private Integer idcaja;
     private Usuario usuario;
     private MovimientoEmpresa movimientoEmpresa;
     private Movimiento movimiento;
     private String descripcion;
     private Integer entrada;
     private Integer salida;
     private String tipo;

    public Caja() {
    }

	
    public Caja(Usuario usuario, String descripcion, String tipo) {
        this.usuario = usuario;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }
    public Caja(Usuario usuario, MovimientoEmpresa movimientoEmpresa, Movimiento movimiento, String descripcion, Integer entrada, Integer salida, String tipo) {
       this.usuario = usuario;
       this.movimientoEmpresa = movimientoEmpresa;
       this.movimiento = movimiento;
       this.descripcion = descripcion;
       this.entrada = entrada;
       this.salida = salida;
       this.tipo = tipo;
    }
   
    public Integer getIdcaja() {
        return this.idcaja;
    }
    
    public void setIdcaja(Integer idcaja) {
        this.idcaja = idcaja;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public MovimientoEmpresa getMovimientoEmpresa() {
        return this.movimientoEmpresa;
    }
    
    public void setMovimientoEmpresa(MovimientoEmpresa movimientoEmpresa) {
        this.movimientoEmpresa = movimientoEmpresa;
    }
    public Movimiento getMovimiento() {
        return this.movimiento;
    }
    
    public void setMovimiento(Movimiento movimiento) {
        this.movimiento = movimiento;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Integer getEntrada() {
        return this.entrada;
    }
    
    public void setEntrada(Integer entrada) {
        this.entrada = entrada;
    }
    public Integer getSalida() {
        return this.salida;
    }
    
    public void setSalida(Integer salida) {
        this.salida = salida;
    }
    public String getTipo() {
        return this.tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }




}


