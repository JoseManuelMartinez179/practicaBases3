package dominio;

import java.sql.*;

public class ConexionBaseDatos {
    String driver = "com.mysql.jdbc.Driver";
    Connection conexion;
    Statement statement;
    ResultSet resultado;
    
    String url = "jdbc:mysql:";
    String usuario = ;
    String contrasenna = ;
    
    public void consulta() {
        try{
            Class.forName(driver);  
            conexion = DriverManager.getConnection(url, usuario, contrasenna);  
            statement = conexion.createStatement();  
            resultado = statement.executeQuery("");  
        
            while(resultado.next())  
            System.out.println(resultado.getInt(1) +"  "+ resultado.getString(2) +"  "+ resultado.getString(3));  
        
            conexion.close();  
        }
        catch(Exception e){ 
            System.out.println(e);
        }
    }
}
