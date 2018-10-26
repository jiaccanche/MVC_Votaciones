package test;

import Controlador.ControladorVotacion;
import Modelo.ArchivoProducto;
import Vista.Votacion;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jorge canche
 */
public class testArchivos {
    
    public static void main(String[] args) {

          Votacion vista  = new Votacion();
          ControladorVotacion control = new ControladorVotacion(vista,"productos.txt");
          vista.setVisible(true);
          vista.getClass().getName();
        
    }
}
