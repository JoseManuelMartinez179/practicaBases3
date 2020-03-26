package interfaz;

import dominio.ConversorResultSet;
import dominio.TablaDeDatos;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class InterfazSolucion {
    private TablaDeDatos tabla;
    private DefaultTableModel modelo;
    
    String driver = "com.mysql.cj.jdbc.Driver";
    Connection conexion;
    Statement statement;
    ResultSet resultado;
    
    String usuario = "usuario1";
    String contrasenna = "contraseña1";
    
   long inicio, fin, tiempo;
    
    public InterfazSolucion(String consulta, String database) {        
        try{
            String url = "jdbc:mysql://localhost:3306/" + database;
            String base = "use " + database;
            
            
            Class.forName(driver);
            conexion = DriverManager.getConnection(url, usuario, contrasenna);  
            statement = conexion.createStatement();
            statement.executeQuery(base);
            inicio = System.nanoTime();
            resultado = statement.executeQuery(consulta);
            fin = System.nanoTime();
            
            modelo = new DefaultTableModel();
            ConversorResultSet.rellena(resultado, modelo);
            tabla = new TablaDeDatos();
            tabla.creaYMuestraVentana();
            tabla.tomaDatos(modelo);
            
            setTiempoConsulta(inicio, fin);
            
            conexion.close();
        }
        catch(Exception e){ 
            System.out.println(e);
        }
    }
    
    private void setTiempoConsulta(long incio, long fin) {
        tiempo = fin - incio;
    }
    
    public long getTiempoConsulta() {
        return tiempo;
    }
}