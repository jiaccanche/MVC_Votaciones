/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Controlador.ControladorVotoVista;
import Modelo.ArchivoProducto;
import Vista.VotoVista;

/**
 *
 * @author jorge canche
 */
public class testvoto{
    
    public static void main(String[] args) {
        VotoVista vista = new VotoVista();
        ArchivoProducto archivo = new ArchivoProducto();
        ControladorVotoVista control = new ControladorVotoVista(vista,archivo,"productos.txt");
        vista.setVisible(true);
    
    }
}
