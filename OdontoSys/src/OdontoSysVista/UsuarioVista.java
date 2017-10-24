/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OdontoSysVista;

import OdontoSysControlador.UsuarioControlador;
import OdontoSysModelo.Usuario;
import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class UsuarioVista {
    
    public static int InsertarUsuario(Usuario nuevo) {
        String r = nuevo.getRol();
        int n = nuevo.getNombre().trim().compareTo("");
        int c = nuevo.getPassw().trim().compareTo(""); 
        
        if(r == "Doctor" && nuevo.getDoctor().getIdDoctor() == null){
            JOptionPane.showMessageDialog(null, "Favor ingrese un Doctor", "Validación de Usuario", WIDTH);
            return -1;
        }else if(n==0  || n < 3 || n > 10){
            JOptionPane.showMessageDialog(null, "El nombre debe tener entre 3 y 10 caracteres", "Validación de Usuario", WIDTH);
            return -1;
        }else if(c == 0 || c < 4 || c > 10){
            JOptionPane.showMessageDialog(null, "La contraseña debe tener entre 4 y 10 caracteres", "Validación de Usuario", WIDTH);
            return -1;
        }else
                return UsuarioControlador.InsertarUsuario(nuevo);
        } 
    }      

