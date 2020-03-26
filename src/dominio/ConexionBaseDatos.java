package dominio;

import interfaz.TablaDeDatos;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class ConexionBaseDatos {
    private TablaDeDatos tabla;
    private DefaultTableModel modelo;
    
    String driver = "com.mysql.cj.jdbc.Driver";
    Connection conexion;
    Statement statement;
    ResultSet resultado;
    
    String usuario = "usuario1";
    String contrasenna = "contraseña1";
    
    public ConexionBaseDatos(String consulta, String database) {
        try{
            String url = "jdbc:mysql://localhost:3306/" + database;
            String base = "use " + database;
            
            Class.forName(driver);
            conexion = DriverManager.getConnection(url, usuario, contrasenna);  
            statement = conexion.createStatement();
            statement.executeQuery(base);
            resultado = statement.executeQuery(consulta);
            
            modelo = new DefaultTableModel();
            ConversorResultSet.rellena(resultado, modelo);
            tabla = new TablaDeDatos();
            
            tabla.creaYMuestraVentana();
            tabla.tomaDatos(modelo);
            
            conexion.close();  
        }
        catch(Exception e){ 
            System.out.println(e);
        }
    }
}