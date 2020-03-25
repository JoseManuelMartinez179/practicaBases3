package dominio;

import java.sql.*;

public class ConexionBaseDatos {
    String driver = "com.mysql.jdbc.Driver";
    Connection conexion;
    Statement statement;
    ResultSet resultado;
    
    String usuario = "usuario1";
    String contrasenna = "contraseña1";
    
    public void consultaSakila(String consulta) {
        try{
            String url = "jdbc:mysql://localhost:3306/sakila";
            Class.forName(driver);  
            conexion = DriverManager.getConnection(url, usuario, contrasenna);  
            statement = conexion.createStatement();
            statement.executeQuery("use sakila;");
            resultado = statement.executeQuery(consulta);  
        
            while(resultado.next())  
            System.out.println(resultado.getInt(1) +"  "+ resultado.getString(2) +"  "+ resultado.getString(3));  
        
            conexion.close();  
        }
        catch(Exception e){ 
            System.out.println(e);
        }
    }
    
    public void consultaWorld(String consulta) {
        try{
            String url = "jdbc:mysql://localhost:3306/world";
            
            Class.forName(driver);  
            conexion = DriverManager.getConnection(url, usuario, contrasenna);  
            statement = conexion.createStatement();
            statement.executeQuery("use world;");
            resultado = statement.executeQuery(consulta);  
        
            while(resultado.next()){
            System.out.println(resultado.getInt(1) +"  "+ resultado.getString(2) +"  "+ resultado.getString(3));  
            }
            conexion.close();  
        }
        catch(Exception e){ 
            System.out.println(e);
        }
    }
}
