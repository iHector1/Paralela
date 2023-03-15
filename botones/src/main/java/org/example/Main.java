package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main  extends JFrame implements ActionListener {

    JPanel panel;
    JButton hola;
    JButton adios;
    JLabel letrero;

    Main(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.panel=new JPanel();
        this.panel.setLayout(null);
        this.panel.setBounds(0,0,500,500);
        this.setTitle("Saludos");
        add(panel);

        this.hola=new JButton("Hola");
        this.hola.setLayout(null);
        this.hola.setBounds(100,150,80,30);
        this.hola.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                letrero.setText("Hola");
            }
        });
        this.panel.add(this.hola);

        this.adios=new JButton("Adios");
        this.adios.setLayout(null);
        this.adios.setBounds(300,150,80,30);
        this.adios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                letrero.setText("Adios");
            }
        });
        this.panel.add(this.adios);

        this.letrero=new JLabel("Letrero");
        this.letrero.setLayout(null);
        this.letrero.setBounds(230,250,80,30);
        this.panel.add(this.letrero);

        setVisible(true);
        setResizable(false);
    }

    public static void main(String[] args) {

        Main m = new Main();
        m.setBounds(50,50,500,500);
    }



    @Override
    public void actionPerformed(ActionEvent e) {

    }
}