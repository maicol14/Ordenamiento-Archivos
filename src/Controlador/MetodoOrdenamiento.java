
package Controlador;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.JOptionPane;



/**
 *
 * @author Oscar - Cambio de metodos - John Culma - Juan Guzman
 */

public class MetodoOrdenamiento {
	

	FileInputStream entrada; // objeto  de entrada para  leer el archivo
	  FileOutputStream salida;// objeto de  de salida 
    public String AbrirArchivo(File archivo) {// metodo de abrir el  archivo 
        String documento = ""; // variable  conversion 
        try {
            entrada = new FileInputStream(archivo);// lectura del archivo con el nombre que recibe el  metodo(archivo)
            int ascci; 
            while ((ascci = entrada.read()) != -1) {//condicional  para  leer linea a linea el  contendio del archivo
                char caracter = (char) ascci;//conversion
                documento += caracter;
            }
        } catch (Exception e) {// excepcion por si sucede alguana novedad en la lectura del archivo 
        }
        return documento;// retornar  variable de lectura del archivo 
    }

    public String GuardarArchivo(File archivo, String documento) {// metodo  guardar  Archivo 
        String mensaje = null; // varaible temporal  mensaje
        try {
            salida = new FileOutputStream(archivo);// Salida para guardar el archivo 
            byte[] bytxt = documento.getBytes();//conversion 
            salida.write(bytxt);//escribir  el  archivo  guardado en la varaible  (bytxt)
            mensaje = "Archivo Guardado";// mensaje del archivo si se guardo 
        } catch (Exception e) {// excepciones  por si no guarda el  archivo  correctamente 
        }
        return mensaje;// return  del metodo para generar adecaudamente el archivo 
    }


    
}
