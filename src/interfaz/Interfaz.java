package interfaz;

import dominio.Consulta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


// Interfaz principal en la cual el usuario realiza la consulta
public class Interfaz extends JFrame {
    
    private JTextField select, from, where, group, order, limit;
    private JButton boton;
    private JRadioButton sakila, world;
    private JLabel tiempo;
            
    public Interfaz() {
        super("Aplicación Consultas");
        setLayout(null);
        
        JLabel s = new JLabel("SELECT");
        s.setBounds(20, 20, 50, 40);
        add(s);
        
        select = new JTextField(80);
        select.setBounds(90, 20, 750, 40);
        add(select);
        
        JLabel f = new JLabel("FROM");
        f.setBounds(20, 60, 130, 40);
        add(f);
        
        from = new JTextField(80);
        from.setBounds(90, 60, 750, 40);
        add(from);
        
        JLabel w = new JLabel("WHERE");
        w.setBounds(20, 100, 130, 40);
        add(w);
        
        where = new JTextField(80);
        where.setBounds(90, 100, 750, 40);
        add(where);
        
        JLabel g = new JLabel("GROUP BY");
        g.setBounds(20, 140, 130, 40);
        add(g);
        
        group = new JTextField(80);
        group.setBounds(90, 140, 750, 40);
        add(group);
        
        JLabel o = new JLabel("ORDER BY");
        o.setBounds(20, 180, 130, 40);
        add(o);
        
        order = new JTextField(80);
        order.setBounds(90, 180, 750, 40);
        add(order);
        
        JLabel l = new JLabel("LIMIT");
        l.setBounds(20, 220, 130, 40);
        add(l);
        
        limit = new JTextField(80);
        limit.setBounds(90, 220, 750, 40);
        add(limit);
        
        JLabel t = new JLabel("Tiempo de Ejecución:");
        t.setBounds(90, 285, 140, 40);
        add(t);
        
        tiempo = new JLabel();
        tiempo.setBounds(232, 285, 180, 40);
        add(tiempo);
        
        ButtonGroup group = new ButtonGroup();
        
        sakila = new JRadioButton("sakila", true);
        sakila.setBounds(850, 100, 100, 40);
        group.add(sakila);
        add(sakila);
        
        world = new JRadioButton("world");
        world.setBounds(850, 140, 100, 40);
        group.add(world);
        add(world);
        
        boton = new JButton("Realizar Consulta");
        boton.setBounds(490, 285, 350, 40);
        add(boton);
        
        boton.addActionListener(new OyenteBoton());
        
        setSize(950, 375);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private class OyenteBoton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Consulta c1 = new Consulta();
            c1.setSelect(select.getText());
            c1.setFrom(from.getText());
            c1.setWhere(where.getText());
            c1.setGroup(group.getText());
            c1.setOrder(order.getText());
            c1.setLimit(limit.getText());
            if(sakila.isSelected() == true) {
                InterfazSolucion is1 = new InterfazSolucion(c1.toString(), "sakila");
                long tiempoTotal = is1.getTiempoConsulta();
                tiempo.setText(Long.toString(tiempoTotal) + " nanosegundos");
            }
            else {
                InterfazSolucion is1 = new InterfazSolucion(c1.toString(), "world");
                System.out.println(is1.getTiempoConsulta());
                long tiempoTotal = is1.getTiempoConsulta();
                tiempo.setText(Long.toString(tiempoTotal) + " nanosegundos");
            }
        }
    }
}