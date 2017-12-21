/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OdontoSysVista;

import OdontoSysModelo.Convenio;
import OdontoSysModelo.DetalleConvenio;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * 
 */
public class ConvenioVista {
    
    public static boolean validarConvenio(Convenio c, ArrayList<DetalleConvenio> d){
        
        if(c.getEmpresa()== null){
            JOptionPane.showMessageDialog(null, "Favor escoja la empresa");
            return false;
        }else if(d == null || d.size() <= 0){
            JOptionPane.showMessageDialog(null, "Complete por lo menos un servicio con convenio");
            return false;
        }else{
            for(DetalleConvenio det : d){
                if(det.getPorcentaje()<0 || det.getPorcentaje() > 100){
                    JOptionPane.showMessageDialog(null, "El porcentaje debe estar entre 0 y 100");
                    return false;
                }
            }
            return true;
        }
    }
    
}
