/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OdontoSysVista;

import OdontoSysControlador.PacienteControlador;
import OdontoSysModelo.Paciente;
import static java.awt.image.ImageObserver.WIDTH;
import java.util.Date;
import javax.swing.JOptionPane;
import org.hibernate.Session;

/**
 *
 * @author user
 */
public class PacienteVista {

    /**
     *
     * @param nrocedula
     * @return paciente
     */
    public static Paciente BuscarCedula(String nrocedula){
        
        
        //uso Trim() para borrar espacios en blanco inicial y final
       // String numeroString = jTextFieldCedula.getText();
        nrocedula = nrocedula.trim();
        //si esta vacio el NumeroString
        if(nrocedula.isEmpty()){
            //proceso cadena vacia
            System.out.println("escriibi algo");
            return null;
        }
         
        int cedula = Integer.parseInt(nrocedula);
        Paciente paciente = PacienteControlador.BuscarCedula(cedula);
        
        
        return paciente;
    }

    public static int insertarPaciente(Paciente nuevoPaciente) {
        int nom = nuevoPaciente.getNombres().trim().compareTo("");//n == 0 si existe cadena en nombre *
        int ape = nuevoPaciente.getApellidos().trim().compareTo("");//igual a * para apellido
        int ci = nuevoPaciente.getNroCi();
        int f = nuevoPaciente.getFechaNac().compareTo(new Date());
        int s = (nuevoPaciente.getSexo().compareToIgnoreCase("F") == 0) ? 0 : (nuevoPaciente.getSexo().compareToIgnoreCase("M") == 0 ? 0 : 1); 
        int dir = nuevoPaciente.getDireccion().trim().compareTo("");
        int tel = nuevoPaciente.getTelCel().trim().compareTo("");
        int cel = nuevoPaciente.getTelCel().trim().compareTo("");
        int em =  nuevoPaciente.getEmail().trim().compareTo("");
        
        
        if(nom == 0 || nom < 3 || nom > 25){
            JOptionPane.showMessageDialog(null, "El nombre debe tener entre 3 y 25 caracteres");
            return -1;
        }else if(ape == 0 || ape < 3 || ape > 25){
            JOptionPane.showMessageDialog(null, "El apellido debe tener entre 6 y 15 caracteres");
            return -1;
        }else if(ci < 10000 || ci > 99999999 ){
            JOptionPane.showMessageDialog(null, "La cédula debe tener entre 5 y 8 cifras");
            return -1;
        }else if(f > 0 ){
            JOptionPane.showMessageDialog(null, "Elija la fecha de nacimiento");
            return -1;
        }else if(s != 0){
            JOptionPane.showMessageDialog(null, "Escoja el sexo del paciente");
            return -1;
        }else if(tel == 0 && cel ==0){
            JOptionPane.showMessageDialog(null, "Debe cargar por lo menos un teléfono");
            return -1;
        }else if(dir == 0 || dir < 5 || dir > 50){
            JOptionPane.showMessageDialog(null, "La direccion  debe tener entre 5 y 50 caracteres");
            return -1;
        }else if(em > 20){
            JOptionPane.showMessageDialog(null, "El email puede tener 20 caracteres como máximo");
            return -1;
        }
        else{
            return PacienteControlador.insertarPaciente(nuevoPaciente);
        }
    }

    public static int UpDatePaciente(Paciente nuevoPaciente) {
        
        int nom = nuevoPaciente.getNombres().trim().compareTo("");//n == 0 si existe cadena en nombre *
        int ape = nuevoPaciente.getApellidos().trim().compareTo("");//igual a * para apellido
        int ci = nuevoPaciente.getNroCi();
        int f = nuevoPaciente.getFechaNac().compareTo(new Date());
        int s = (nuevoPaciente.getSexo().compareToIgnoreCase("F") == 0) ? 0 : (nuevoPaciente.getSexo().compareToIgnoreCase("M") == 0 ? 0 : 1); 
        int dir = nuevoPaciente.getDireccion().trim().compareTo("");
        int tel = nuevoPaciente.getTelCel().trim().compareTo("");
        int cel = nuevoPaciente.getTelCel().trim().compareTo("");
        int em =  nuevoPaciente.getEmail().trim().compareTo("");
        
        
        if(nom == 0 || nom < 3 || nom > 25){
            JOptionPane.showMessageDialog(null, "El nombre debe tener entre 3 y 25 caracteres");
            return -1;
        }else if(ape == 0 || ape < 3 || ape > 25){
            JOptionPane.showMessageDialog(null, "El apellido debe tener entre 6 y 15 caracteres");
            return -1;
        }else if(ci < 10000 || ci > 99999999 ){
            JOptionPane.showMessageDialog(null, "La cédula debe tener entre 5 y 8 cifras");
            return -1;
        }else if(f > 0 ){
            JOptionPane.showMessageDialog(null, "Elija la fecha de nacimiento");
            return -1;
        }else if(s != 0){
            JOptionPane.showMessageDialog(null, "Escoja el sexo del paciente");
            return -1;
        }else if(tel == 0 && cel ==0){
            JOptionPane.showMessageDialog(null, "Debe cargar por lo menos un teléfono");
            return -1;
        }else if(dir == 0 || dir < 5 || dir > 50){
            JOptionPane.showMessageDialog(null, "La direccion  debe tener entre 5 y 50 caracteres");
            return -1;
        }else if(em > 20){
            JOptionPane.showMessageDialog(null, "El email puede tener 20 caracteres como máximo");
            return -1;
        }
        else{
            return 0;
        }
    }    
    
    public static int UpDateHojaClinica(Paciente nuevoPaciente) {
        int p = nuevoPaciente.getPeso();
        int e = nuevoPaciente.getEnfermedades().trim().compareTo("");
        int m = nuevoPaciente.getMedicamentos().compareTo("");
        int a = nuevoPaciente.getAlergias().compareTo(""); 
        int c = nuevoPaciente.getCirugias().trim().compareTo("");
        
        if(p > 0){
            if(e!=0 && m!=0 && a!=0 && c!=0){
                return PacienteControlador.UpDatePaciente(nuevoPaciente);
            }else{
                JOptionPane.showMessageDialog(null, "Favor complete todos los campos", "Validación de datos Paciente", WIDTH);
                return -1;
            }
        }else{
            JOptionPane.showMessageDialog(null, "Peso debe ser mayor a 0", "Validación de datos Paciente", WIDTH);
            return -1;
        }        
    }    
    
}
