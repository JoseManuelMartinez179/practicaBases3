package dominio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Interfaz extends JFrame {
    
    private JTextField select, from, where, group, order, limit;
    private JButton boton;
            
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
        
        boton = new JButton("Realizar Consulta");
        boton.setBounds(490, 285, 350, 40);
        add(boton);
        
        boton.addActionListener(new OyenteBoton());
        
        setSize(875, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private class OyenteBoton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // Abrir nueva ventana con el resultado de la consulta
            Consulta c1 = new Consulta();
            c1.setSelect(select.getText());
            c1.setFrom(from.getText());
            c1.setWhere(where.getText());
            c1.setGroup(group.getText());
            c1.setOrder(order.getText());
            c1.setLimit(limit.getText());
            System.out.println(c1);
            
        }
    }
    
    
}