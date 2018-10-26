/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Producto;
import Vista.Grafica;
import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author jorge canche
 */
public class ControladorGrafica {
    private Grafica barras;
    private Grafica pastel;
    private  JFreeChart graficapastel;
    private JFreeChart graficabarras;
    private DefaultCategoryDataset datab;
    private DefaultPieDataset datap;
    
    public ControladorGrafica(LinkedList<Producto> productos, Grafica b,Grafica p){
        this.barras = b;
        this.pastel = p;
        graficapastel =crearGraficaPastel(productos);
        graficabarras =crearGraficaBarras(productos);
        ChartPanel panel = new ChartPanel(this.graficabarras);
        ChartPanel panel2 = new ChartPanel(this.graficapastel);
       
        this.barras.setContentPane(panel);
        this.pastel.setContentPane(panel2);
        this.barras.pack();
        this.pastel.pack();
        
        
    }
    
    public void actualizarGrafica(LinkedList<Producto> pro){
        
       
        
        pro.stream().forEach(e->{
            datab.setValue(e.getVotos(),e.getNombre(),"votos");
        });
        
         pro.stream().forEach(e->{
          datap.setValue(e.getNombre(),e.getVotos());
        });
         
    
    }
    
    
    public  JFreeChart crearGraficaPastel(LinkedList<Producto> productos){
        datap = new DefaultPieDataset();
        
        productos.stream().forEach(e->{
          datap.setValue(e.getNombre(),e.getVotos());
        });
        
        JFreeChart pastel = ChartFactory.createPieChart3D("Productos",datap, true, true, true);
        
        return pastel;
        
    }
    
    public  JFreeChart crearGraficaBarras(LinkedList<Producto> productos){
         datab = new DefaultCategoryDataset();
        
        productos.stream().forEach(e->{
            datab.setValue(e.getVotos(),e.getNombre(),"votos");
        });
        
        JFreeChart barra = ChartFactory.createBarChart3D("Votos de cereales","Votos","Productos", 
                datab,PlotOrientation.VERTICAL,true,true,false);
        return barra;
    }
    
    
}
   
