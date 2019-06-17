/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Scanner;
import javax.swing.JOptionPane;
import model.Oferta.Oferta2BI;

/**
 *
 * @author muzaka
 */
public class GenerarArchivoBItxt {
    
	public static void crearArchivo(ArrayList lista) {
		FileWriter flwriter = null;
                
		try {
                    Calendar c = Calendar.getInstance();
                      String dia = Integer.toString(c.get(Calendar.DATE));
                      String mes = Integer.toString(c.get(Calendar.MONTH));
                      String annio = Integer.toString(c.get(Calendar.YEAR));
                      
                      String fecha=dia+"-"+mes+"-"+annio;
                      
                      String Ruta="src\\Reportes\\ReportesBI";
                      File ReporteBI=new File(Ruta);
                      
                      if(ReporteBI.exists())
                      {
                        System.out.println("La carpeta ya existe.."); 
                      }
                      else
                      {
                          //JOptionPane.showMessageDialog(null, "Se a Creado la carpeta Reporte BI ");
                          System.out.println("Se a Creado la carpeta Reporte BI.."); 
                          ReporteBI.mkdirs();
                      }
                      
			//crea el flujo para escribir en el archivo
			flwriter = new FileWriter("src\\Reportes\\ReportesBI\\ReportesBI "+fecha+".txt");
			//crea un buffer o flujo intermedio antes de escribir directamente en el archivo
			BufferedWriter bfwriter = new BufferedWriter(flwriter);
                    for (Iterator it = lista.iterator(); it.hasNext();) {
                        Oferta2BI ofertas = (Oferta2BI) it.next();
                        //escribe los datos en el archivo
                        bfwriter.write(ofertas.getIdOferta() + ";" + ofertas.getNombreOferta()+ ";" + ofertas.getTienda()
                                + ";" + ofertas.getProducto()+ ";" + ofertas.getMinimoProducto() +
                                ";" + ofertas.getMaximoProducto() +";" + ofertas.getPrecioOferta() +
                                ";" + ofertas.getStockProductoOferta() +";" + ofertas.getEstado() +
                                ";" + ofertas.getVisita() +";" + ofertas.getFechaVisita() +";"
                                + ofertas.getDescuentoOferta());
                        bfwriter.newLine();
                    }
			//cierra el buffer intermedio
			bfwriter.close();
			System.out.println("Archivo creado satisfactoriamente..");
                         //JOptionPane.showMessageDialog(null, "Archivo creado satisfactoriamente.. ");
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (flwriter != null) {
				try {//cierra el flujo principal
					flwriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
    
        
        public static void abrirarchivo(String archivo){

     try {

            File objetofile = new File (archivo);
            Desktop.getDesktop().open(objetofile);

     }catch (IOException ex) {

            System.out.println(ex);

     }

}                         
    
}
