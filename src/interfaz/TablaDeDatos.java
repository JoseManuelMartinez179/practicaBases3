package interfaz;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

// En esta ventana quiero que salga el resultado de la consulta
public class TablaDeDatos {
    private JTable tabla;
    private JFrame ventana;
    private JScrollPane scroll;


    public void creaYMuestraVentana() {
        ventana = new JFrame("Contenido base de datos");
        if (tabla == null) tabla = new JTable();
        scroll = new JScrollPane(tabla);
        ventana.getContentPane().add(scroll);
        ventana.pack();
        ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
    
    public void tomaDatos(DefaultTableModel modelo)
    {
        if (tabla == null)
            tabla = new JTable();
        tabla.setModel(modelo);
    }
}
