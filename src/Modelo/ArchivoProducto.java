/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

/**
 *
 * @author jorge canche
 */
public class ArchivoProducto extends Archivo{
    
    public static String SALTO = System.lineSeparator();
    
    public ArchivoProducto(){
        super();
    }
    
    public int getNumVotos(String nombre){ 
        int votos=0;
        this.crearArchivo(nombre);
        File archivo = new File(nombre);
        
        try{
            FileReader reader = new FileReader(archivo); //Archivo para lectura
            BufferedReader linea = new BufferedReader(reader); //Buffer que toma linea, por linea del archivo
            
            String cadena;
            while((cadena = linea.readLine())!= null){
                votos++;
            }
              
              linea.close();
              return votos;
            
        }catch(IOException e){
            System.out.println(e.getMessage()+" No fue posible leer el archivo");
            return 0;
        }
    }
    
    public LinkedList<String> getVotos(String nombre){ 
        LinkedList<String> votos = new LinkedList();
        this.crearArchivo(nombre);
        File archivo = new File(nombre);
        
        try{
            FileReader reader = new FileReader(archivo); //Archivo para lectura
            BufferedReader line = new BufferedReader(reader); //Buffer que toma linea, por linea del archivo
            
            String cadena;
            while((cadena = line.readLine())!= null){
                votos.add(cadena);
            }
              
              line.close();
              
            return votos;
        }catch(IOException e){
            System.out.println(e.getMessage()+" No fue posible leer el archivo");
            return votos;
        }
    }
    
    public void guardarVoto(String nombre, String fecha){
       
        LinkedList<String> cadena = this.getVotos(nombre);
        cadena.add(fecha);
        
        File archivo = new File(nombre);
        try{
            FileWriter writer = new FileWriter(archivo);
  
                for (int i = 0; i < cadena.size(); i++) {
                String movimiento = cadena.get(i);
                writer.write(movimiento + SALTO);
                }
                writer.close();
            }
            
        catch(IOException ex){
            
        }
        
        
    }
    
    public LinkedList<Producto> getProductos(String nombre){
        LinkedList<Producto> out= new LinkedList();
        String extencion = ".txt";
        this.crearArchivo(nombre);
        File archivo = new File(nombre);
        
        try{
            FileReader reader = new FileReader(archivo);
            BufferedReader linea = new BufferedReader(reader);
            
            String cadena;
            while((cadena=linea.readLine())!=null){
                
                int i = this.getNumVotos(cadena+extencion);
                Producto producto = new Producto(cadena,i);
                out.add(producto);
                
            }
            linea.close();
            return out;
             
        }catch(IOException e){
            System.out.println(e.getMessage() + "No fue posible leer el archivo");
            return out;
        }
    }
    
}
