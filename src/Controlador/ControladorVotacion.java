/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ArchivoBitacora;
import Modelo.ArchivoProducto;
import Modelo.Fecha;
import Modelo.Producto;
import Vista.Grafica;

import Vista.Votacion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import javax.swing.JFrame;

/**
 *
 * @author jorge canche
 */
public class ControladorVotacion implements ActionListener {
    private Votacion ventanita;
    private ArchivoProducto producto;
    private ArchivoBitacora bitacora;
    private String nombre;
    private LinkedList<Producto> productos;
    private ControladorGrafica grafica;
    private Grafica ventanap;
    private  Grafica ventanab;
    private String extencion = ".txt";
    
    public ControladorVotacion(Votacion venitanita, String nombre){
        this.productos = new LinkedList();
        this.ventanita = venitanita;
        this.nombre = nombre;
        this.ventanita.getBoton1().addActionListener(this);
        this.ventanita.getBoton2().addActionListener(this);
        this.ventanita.getBoton3().addActionListener(this);
         this.ventanita.setResizable(false);
        this.cambiaNombres();
        this.votosActuales();
        ventanap = new Grafica();
        ventanab  = new Grafica();
         grafica = new ControladorGrafica(this.productos,this.ventanab, this.ventanap);
         this.ventanab.setVisible(true);
         this.ventanap.setVisible(true);
        
      
        
    }
    
    public void cambiaNombres(){
        this.producto = new ArchivoProducto();
        
        this.productos = this.producto.getProductos(this.nombre);
        this.ventanita.getBoton1().setText(this.productos.get(0).getNombre());
        this.ventanita.getBoton2().setText(this.productos.get(1).getNombre());
        this.ventanita.getBoton3().setText(this.productos.get(2).getNombre());
        
    }
    
    public void votosActuales(){
        
        this.ventanita.getProducto1().setText(Integer.toString(this.productos.get(0).getVotos()));
        this.ventanita.getProducto2().setText(Integer.toString(this.productos.get(1).getVotos()));
        this.ventanita.getProducto3().setText(Integer.toString(this.productos.get(2).getVotos()));
        
        
    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
         
         Date fechaac = new Date();
         Fecha tiempo = new Fecha();
         
        if(ae.getSource()==this.ventanita.getBoton1()){
      
            String votoa = votar(0,tiempo);
            this.ventanita.getProducto1().setText(votoa);
            this.grafica.actualizarGrafica(productos);
        
        }
        
        if(ae.getSource()==this.ventanita.getBoton2()){
            
            String votoa = votar(1,tiempo);
            this.ventanita.getProducto2().setText(votoa);
             this.grafica.actualizarGrafica(productos);
        }
        
        if(ae.getSource()==this.ventanita.getBoton3()){
           
           String voto = votar(2,tiempo);
            this.ventanita.getProducto3().setText(voto);
             this.grafica.actualizarGrafica(productos);
        }
        
    }
    
    public String votar(int i, Fecha tiempo){
        
         this.producto.guardarVoto(this.productos.get(i).getNombre()+ extencion, tiempo.toString());
         this.productos.get(i).Votar();
         return Integer.toString(this.productos.get(i).getVotos());
    
    }
    
    
}
