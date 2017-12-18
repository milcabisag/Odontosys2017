/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OdontoSysVista;

import OdontoSysModelo.Empresa;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class EmpresaVista {
    
    public static boolean validarEmpresa(Empresa empresa){
        if((empresa.getDireccion() == null) || (empresa.getNombre() == null) || (empresa.getNombreContacto() == null) || (String.valueOf(empresa.getRuc()) == null) || (empresa.getTelefono() == null)){
            JOptionPane.showMessageDialog(null, "Favor complete todos los campos");
            return false;
        }
        int nom = empresa.getNombre().trim().compareTo("");     //n == 0 si existe cadena vacìa en nombre *
        int ruc = empresa.getRuc().trim().compareTo("");
        int tel = empresa.getTelefono().trim().compareTo("");
        int dir = empresa.getDireccion().trim().compareTo(""); 
        int ncon = empresa.getNombreContacto().trim().compareTo("");
                
        if(nom == 0 || nom < 3 || nom > 30){
            JOptionPane.showMessageDialog(null, "El nombre debe tener entre 3 y 30 caracteres");
            return false;
        }else if(ruc == 0 || ruc < 5 || ruc > 15){
            JOptionPane.showMessageDialog(null, "El RUC debe tener entre 6 y 15 caracteres");
            return false;
        }else if(tel == 0 || tel < 6 || tel > 20){
            JOptionPane.showMessageDialog(null, "El teléfono debe tener entre 6 y 20 caracteres");
            return false;
        }else if(dir == 0 || dir < 5 || dir > 50){
            JOptionPane.showMessageDialog(null, "La dirección debe tener entre 5 y 50 caracteres");
            return false;
        }else if(ncon == 0 || ncon < 5 || ncon > 50){
            JOptionPane.showMessageDialog(null, "El nombre del contacto debe tener entre 5 y 50 caracteres");
            return false;
        }
        else{
            return true;
        }
    }
    
}
