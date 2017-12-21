/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OdontoSysVista;

import OdontoSysModelo.Doctor;
import static java.awt.image.ImageObserver.WIDTH;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class DoctorVista {
    public static boolean validarDoctor(Doctor doctor) {
        if((doctor.getNombre() == null) || (doctor.getApellido()) == null || (String.valueOf(doctor.getNroCi()) == null) || (doctor.getSexo() == null) || (doctor.getFechaNac() == null) || (doctor.getTeLb() == null) || (doctor.getTelCel() == null) || (doctor.getDireccion() == null) || (doctor.getCiudad() == null) || (doctor.getEmail() == null) || (doctor.getRegProf() == null)){
            JOptionPane.showMessageDialog(null, "Favor complete todos los campos", "Validación de datos Doctor", WIDTH);
            return false;
        }
        int nom = doctor.getNombre().trim().compareTo("");//n == 0 si existe cadena en nombre *
        int ape = doctor.getApellido().trim().compareTo("");//igual a * para apellido
        int ci = doctor.getNroCi();
        int s = (doctor.getSexo().compareToIgnoreCase("F") == 0) ? 0 : (doctor.getSexo().compareToIgnoreCase("M") == 0 ? 0 : 1); 
        int tel = doctor.getTeLb().trim().compareTo("");
        int cel = doctor.getTelCel().trim().compareTo("");
        int dir = doctor.getDireccion().trim().compareTo("");
        int email = doctor.getEmail().trim().compareTo("");
        int reg = doctor.getRegProf().trim().compareTo("");
        Date hoy = new Date();
        int f = 0;
        if(doctor.getFechaNac() != null){
            f = doctor.getFechaNac().compareTo(hoy);
        }
                       
        
        if(nom == 0 || nom < 3 || nom > 30){
            JOptionPane.showMessageDialog(null, "El nombre debe tener entre 3 y 30 caracteres");
            return false;
        }else if(ape == 0 || ape < 3 || ape > 30){
            JOptionPane.showMessageDialog(null, "El apellido debe tener entre 3 y 30 caracteres");
            return false;
        }else if(ci < 10000 || ci > 99999999){
            JOptionPane.showMessageDialog(null, "La cédula debe tener entre 5 y 8 caracteres");
            return false;
        }if(tel == 0 || tel > 20){
            JOptionPane.showMessageDialog(null, "El número de teléfono puede tener hasta 20 caracteres");
            return false;
        }else if(cel == 0 || cel > 20){
            JOptionPane.showMessageDialog(null, "El número de celular puede tener hasta 20 caracteres");
            return false;
        }if(dir == 0 || dir < 5 || dir > 50){
            JOptionPane.showMessageDialog(null, "La dirección debe tener entre 5 y 50 caracteres");
            return false;
        }else if(email == 0 || email > 20){
            JOptionPane.showMessageDialog(null, "El email puede tener hasta 20 caracteres");
            return false;
        }else if(!emailValido(doctor.getEmail())){
            JOptionPane.showMessageDialog(null, "Ingrese un email válido");
            return false;
        }else if(reg == 0 || reg > 30){
            JOptionPane.showMessageDialog(null, "El registro puede tener hasta 30 caracteres");
            return false;
        }else if(f >= 0){
            JOptionPane.showMessageDialog(null, "Ingrese una fecha de nacimiento válida");
            return false;
        }else if(doctor.getFechaNac().before(hoy)){              // Fecha es antes de hoy
            return true;
        }else{
            JOptionPane.showMessageDialog(null, "Fecha de Nacimiento debe ser antes de hoy", "Validación de datos Doctor", WIDTH);
            return false;
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
