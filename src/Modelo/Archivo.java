package Modelo;
import java.io.File;
import java.io.IOException;

public class Archivo {
    
    
    public Archivo(){
    }

    public void crearArchivo(String nombre){

        File archivo = new File(nombre);

        if(archivo.exists())
        {
            return;
        }else{
           try{
               archivo.createNewFile();
           }catch (IOException e){
               System.out.println(e.getMessage());
           }
        }

    }
}
