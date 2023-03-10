/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.intsuperior.controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author pc
 */
public class Conexion {
    Controlador controlador;

    public Conexion(Controlador controlador) {
        this.controlador=controlador;
    }
    
   static Connection conex=null;
    
    public static Connection conexion(){
        String user="root";
        String passwd="Jerson22.*";
        String url="jdbc:mysql://localhost:3306/procesadoraRosasBIMAL?serverTimezone=UTC";
        try {
            conex=DriverManager.getConnection(url,user,passwd);
            JOptionPane.showMessageDialog(null,"Se conecto exitosamente");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("No se pudo conectar a la base de datos");
        }
        return conex;
    }
    
    public void consultarUser(){
       try {
           Statement stm= conexion().createStatement();
           ResultSet rst=stm.executeQuery("select clientes from bdProcesadorarosasbimal");
           while (rst.next()){
               System.out.println("IDCliente: " + rst.getInt(1)
                        + "\nclienombre" + rst.getString(2)
                        + "\nIDCliente: " + rst.getString(3));
                System.out.println("**********************************");
           }
       } catch (SQLException ex) {
           Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
       }
        
    }
    
}
