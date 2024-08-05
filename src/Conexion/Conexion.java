/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

/**
 *
 * @author migue
 */
import java.sql.*;
public class Conexion {
    
    
    public static Connection conectar(){
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost3306/urgencias","root","IamPaoHL14*");
            return cn;
        }catch(Exception e){
            System.out.print("Error en la conexión local:"+e);
        }
        return null;
    }
}


