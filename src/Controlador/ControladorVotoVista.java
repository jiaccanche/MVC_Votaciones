/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ArchivoProducto;
import Modelo.Fecha;
import Modelo.Producto;
import Vista.Grafica;
import Vista.VotoVista;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author jorge canche
 */
public class ControladorVotoVista implements ActionListener{
    
    private final VotoVista ventana;
    private LinkedList<Producto> productos;
    private final LinkedList<JButton> botones = new LinkedList();
    private final LinkedList<JLabel>  texto = new LinkedList();
    private final ArchivoProducto archivo;
    private Grafica graficap;
    private Grafica graficab;
    private ControladorGrafica controlgraficas;
    
    public ControladorVotoVista(VotoVista ventana, ArchivoProducto archivo, String nombre){
        
        this.ventana = ventana;
        this.productos = new LinkedList();
        this.productos = archivo.getProductos(nombre);
        this.archivo = archivo;
        agregarComponentes();
        mostrarGraficas();
    
    }
    
    private void agregarComponentes(){
        
       if(!this.productos.isEmpty()){
        
        GridLayout grid = new GridLayout(this.productos.size(),0);
        Container content = this.ventana.getContentPane(); 
        content.setLayout(grid); 
        
        JButton boton = null;
        JLabel label = null;
        for (int i = 0; i < this.productos.size(); i++) {
        
            boton = new JButton(this.productos.get(i).getNombre());
            this.botones.add(boton);
            this.botones.get(i).addActionListener(this);
            content.add(this.botones.get(i));
            
            label = new JLabel(Integer.toString(this.productos.get(i).getVotos()));
            this.texto.add(label);
            content.add(this.texto.get(i));
    }
    
            
    
    this.ventana.pack();
       }else{
           JOptionPane.showMessageDialog(null,"No hay datos","ERROR",JOptionPane.ERROR_MESSAGE) ;
       }
    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        for(int i = 0; i < this.botones.size(); i++) {
            
            if(ae.getSource()== this.botones.get(i)){
                votar(i);
            }
        }
        
    }
    
    public void votar(int i){
        
        Date date = new Date(); 
        Fecha FormatoFecha = new Fecha();
        String nombre = this.productos.get(i).getNombre()+".txt";
        this.archivo.guardarVoto(nombre, FormatoFecha.Fecha(date));
        this.productos.get(i).Votar();
        this.texto.get(i).setText(Integer.toString(this.productos.get(i).getVotos()));
        
        actualizarGraficos();
        
    }
    
    public void mostrarGraficas(){
        this.graficab = new Grafica(); this.graficap = new Grafica();
        this.controlgraficas = new ControladorGrafica(this.productos,this.graficab,this.graficap);
        this.graficab.setVisible(true); this.graficap.setVisible(true);
    }
    
    public void actualizarGraficos(){
        this.controlgraficas.actualizarGrafica(productos);
    }
    
    }

