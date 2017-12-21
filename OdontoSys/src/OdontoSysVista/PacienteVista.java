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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
        int f = 0;
        if(nuevoPaciente.getFechaNac() != null){
            f = nuevoPaciente.getFechaNac().compareTo(new Date());
        }
        int s = (nuevoPaciente.getSexo().compareToIgnoreCase("F") == 0) ? 0 : (nuevoPaciente.getSexo().compareToIgnoreCase("M") == 0 ? 0 : 1); 
        int dir = nuevoPaciente.getDireccion().trim().compareTo("");
        int tel = nuevoPaciente.getTelCel().trim().compareTo("");
        int cel = nuevoPaciente.getTelCel().trim().compareTo("");
        int em =  0;
        if(nuevoPaciente.getEmail() != null){
            em = nuevoPaciente.getEmail().trim().compareTo("");
        }
        
        
        if(nom == 0 || nom < 3 || nom > 25){
            JOptionPane.showMessageDialog(null, "El nombre debe tener entre 4 y 25 caracteres");
            return -1;
        }else if(ape == 0 || ape < 3 || ape > 25){
            JOptionPane.showMessageDialog(null, "El apellido debe tener entre 4 y 25 caracteres");
            return -1;
        }else if(ci < 10000 || ci > 99999999 ){
            JOptionPane.showMessageDialog(null, "La cédula debe tener entre 5 y 8 cifras");
            return -1;
        }else if(f >= 0 ){
            JOptionPane.showMessageDialog(null, "Escoja una fecha de nacimiento válida");
            return -1;
        }else if(s != 0){
            JOptionPane.showMessageDialog(null, "Escoja el sexo del paciente");
            return -1;
        }else if(tel == 0 && cel ==0){
            JOptionPane.showMessageDialog(null, "Debe cargar por lo menos un teléfono");
            return -1;
        }else if(dir == 0 || dir < 5 || dir > 50){
            JOptionPane.showMessageDialog(null, "La direccion  debe tener entre 4 y 50 caracteres");
            return -1;
        }else if(em > 20){
            JOptionPane.showMessageDialog(null, "El email puede tener 20 caracteres como máximo");
            return -1;
        }else if(em < 20 && em > 0 && emailValido(nuevoPaciente.getEmail()) == false){
            JOptionPane.showMessageDialog(null, "Ingrese un email válido");
            return -1;       
        }else{
            return PacienteControlador.insertarPaciente(nuevoPaciente);             
        }
    }

    public static int UpDatePaciente(Paciente nuevoPaciente) {
        
        int nom = nuevoPaciente.getNombres().trim().compareTo("");//n == 0 si existe cadena en nombre *
        int ape = nuevoPaciente.getApellidos().trim().compareTo("");//igual a * para apellido
        int ci = nuevoPaciente.getNroCi();
        int f = 0;
        if(nuevoPaciente.getFechaNac() != null){
            f = nuevoPaciente.getFechaNac().compareTo(new Date());
        }
        int s = (nuevoPaciente.getSexo().compareToIgnoreCase("F") == 0) ? 0 : (nuevoPaciente.getSexo().compareToIgnoreCase("M") == 0 ? 0 : 1); 
        int dir = nuevoPaciente.getDireccion().trim().compareTo("");
        int tel = nuevoPaciente.getTelCel().trim().compareTo("");
        int cel = nuevoPaciente.getTelCel().trim().compareTo("");
        int em = 0;
        if(nuevoPaciente.getEmail() != null){
            em =  nuevoPaciente.getEmail().trim().compareTo("");
        }        
        
        if(nom == 0 || nom < 3 || nom > 25){
            JOptionPane.showMessageDialog(null, "El nombre debe tener entre 3 y 25 caracteres");
            return -1;
        }else if(ape == 0 || ape < 3 || ape > 25){
            JOptionPane.showMessageDialog(null, "El apellido debe tener entre 6 y 15 caracteres");
            return -1;
        }else if(ci < 10000 || ci > 99999999 ){
            JOptionPane.showMessageDialog(null, "La cédula debe tener entre 5 y 8 cifras");
            return -1;
        }else if(f >= 0 ){
            JOptionPane.showMessageDialog(null, "Escoja una fecha de nacimiento válida");
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
        }else if(em < 20 && em > 0 && emailValido(nuevoPaciente.getEmail()) == false){
            JOptionPane.showMessageDialog(null, "Ingrese un email válido");
            return -1;
        }else{
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
                return 0;
            }else{
                JOptionPane.showMessageDialog(null, "Favor complete todos los campos", "Validación de datos Paciente", WIDTH);
                return -1;
            }
        }else{
            JOptionPane.showMessageDialog(null, "Peso debe ser mayor a 0", "Validación de datos Paciente", WIDTH);
            return -1;
        }        
    }    
    
    public static boolean emailValido(String email) {  // Comprueba que el email tena @ y .com
        
        boolean valido = false;
        
        Pattern patronEmail = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        
        Matcher mEmail = patronEmail.matcher(email.toLowerCase());
        if (mEmail.find()){
           valido = true;  
        }
        return valido;
    }
    
}
