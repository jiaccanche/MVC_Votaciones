/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author jorge canche
 */
public class Fecha {
    
    public Fecha()
    {
    }
    
    public String Fecha(Date date)
    {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
        return dateFormat.format(date) +","+ hourFormat.format(date);
        
    }
    
    
    
}
