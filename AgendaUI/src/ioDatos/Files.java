/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ioDatos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumno
 */
public class Files {
    
    //////////////// rellenar el vector
    public static void rellenar(){
      File f = new File("usuarios.dat");
        FileOutputStream fo;
          ObjectOutputStream oo;
          
          
            if (!f.exists()) {
          try {
              f.createNewFile();
          } catch (IOException ex) {
              System.out.println("Error al crear el archivo");
          }
        }
            
            
            
        
         if (f.exists()) {    
            
          
        try {
            fo = new FileOutputStream(f);
            oo = new ObjectOutputStream(fo);
            ArrayList<Users> v = new ArrayList<>();
            v.add(new Users("marcos", "marcos"));
               oo.writeObject(v);
        oo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Files.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
              Logger.getLogger(Files.class.getName()).log(Level.SEVERE, null, ex);
          }
      
      }
    }
            
            
    /////////////////////// 
    public static int Entrar(String user, String clave){
        int bandera=1;
       
       ArrayList<Users> vUsuarios = new ArrayList();        
        
      File f = new File("usuarios.dat");
      FileInputStream fi = null;
      ObjectInputStream oi = null;   
      
      
      
        if (!f.exists()) {
          try {
              f.createNewFile();
          } catch (IOException ex) {
              System.out.println("Error al crear el archivo");
          }
        }
        
        if (f.exists()) {
             
          try {
              ObjectInputStream leyendoFichero;
              leyendoFichero = new ObjectInputStream( 
              new FileInputStream(f) );
              
             vUsuarios =  (ArrayList<Users>) leyendoFichero.readObject();
               
              for (int i = 0; i < vUsuarios.size(); i++) {
                  
                  if (vUsuarios.get(i).getUsuario().equalsIgnoreCase(user) && vUsuarios.get(i).getClave().equalsIgnoreCase(clave)) {                                            
                    bandera=1;
                    break;
                  }else{
                      bandera=0;
                  }
                  
              }
              
              
            leyendoFichero.close();
          } catch (IOException ex) {
              System.out.println("Error al leer el archivo");
          } catch (ClassNotFoundException ex) {
                Logger.getLogger(Files.class.getName()).log(Level.SEVERE, null, ex);
            }
         
        }
        
        
            return bandera;
      
    }
    
    

    
    
    
}
