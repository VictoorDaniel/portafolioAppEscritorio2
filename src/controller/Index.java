/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.UnsupportedLookAndFeelException;
import model.Oferta.Oferta2BI;
import view.crudProductos.createProductos;
import view.menuPrincipal;

/**
 *
 * @author muzaka
 */
public class Index {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InstantiationException, InstantiationException, UnsupportedLookAndFeelException, InstantiationException, UnsupportedLookAndFeelException {
        // TODO code application logic her
          TimerTask task=new TimerTask(){
        @Override
        public void run() {
            try { 
          // Your task process 
                //creamos el archivo BI en formato TXT
                System.out.println("........creando Archivo.....");
               Oferta2BI.EscribirOfertas();
               
              
            } catch (Exception ex) 
            { 
       System.out.println("error running thread " + ex.getMessage());
            
            } } };
        //Establecer el tiempo de ejecución de la tarea
          Timer time=new Timer();
              /*El timer es para programar una tarea para que se ejecuta un Dia de la semana*/
      
 //Definimos una fecha 
  Calendar calendar = Calendar.getInstance();
 int dia =  calendar.get(Calendar.DAY_OF_WEEK);
 


//cambiar el Monday por el dia atual si quieres probar que pasa <3
if(dia==Calendar.MONDAY){
   //Lunes
   /*le decimos que comience a ejecutarce desde el lunes 
     cada 168 horas los cual es equvalente a cada7 dias*/
   time.scheduleAtFixedRate(task,0,1000*60*60*168);
 }
   //   lo redireccionamos al menu principal
   menuPrincipal m = new menuPrincipal();
        m.setVisible(true);
        m.pack();
        
    }
    
}
