package org.example;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class GeneradorNumeros extends JFrame implements ActionListener {
    private JLabel lblCantidadNumeros;
    private JTextField txtCantidadNumeros;
    private JButton btnGenerarNumeros;
    private JTextArea txtNumerosGenerados;
    private JScrollPane scrollNumerosGenerados;
    private JButton btnMergeNumeros;
    private JTextArea txtNumerosInsertados;
    private JScrollPane scrollNumerosInsertados;
    private ArrayList<Integer> numeros;

    public GeneradorNumeros() {
        //Inicializacion de la lista
        numeros = new ArrayList<>();

        // Configuración de la ventana principal
        setTitle("Generador de números");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Configuración de los componentes
        lblCantidadNumeros = new JLabel("Cantidad de números a generar:");
        txtCantidadNumeros = new JTextField();
        txtCantidadNumeros.setPreferredSize(new Dimension(150, 30)); // Establecer tamaño preferido
        txtNumerosGenerados = new JTextArea();
        txtNumerosGenerados.setColumns(20);
        txtNumerosGenerados.setRows(5);
        scrollNumerosGenerados = new JScrollPane();
        scrollNumerosGenerados.setViewportView(txtNumerosGenerados);

        btnGenerarNumeros = new JButton("Generar números");
        btnGenerarNumeros.addActionListener(this);

        txtNumerosGenerados.setEditable(false);
        btnMergeNumeros = new JButton("Merge");
        btnMergeNumeros.addActionListener(this);
        txtNumerosInsertados = new JTextArea();
        txtNumerosInsertados.setEditable(false);
        txtNumerosInsertados.setColumns(20);
        txtNumerosInsertados.setRows(5);
        scrollNumerosInsertados = new JScrollPane();
        scrollNumerosInsertados.setViewportView(txtNumerosInsertados);


        // Configuración del layout
        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        contentPane.add(lblCantidadNumeros);
        contentPane.add(txtCantidadNumeros);
        contentPane.add(btnGenerarNumeros);
        contentPane.add(scrollNumerosGenerados);
        contentPane.add(btnMergeNumeros);
        contentPane.add(scrollNumerosInsertados);

        // Configuración de los bordes
        lblCantidadNumeros.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));
        txtCantidadNumeros.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));
        btnGenerarNumeros.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));
        btnMergeNumeros.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnGenerarNumeros) {
            // Generar números aleatorios
            int cantidadNumeros = Integer.parseInt(txtCantidadNumeros.getText());
            StringBuilder numerosGenerados = new StringBuilder();
            for (int i = 0; i < cantidadNumeros; i++) {
                int numero = (int) (Math.random() * 100) + 1;
                numerosGenerados.append(numero + ", ");
                numeros.add(numero);
            }
            txtNumerosGenerados.setText(numerosGenerados.toString());

        } else if (e.getSource() == btnMergeNumeros) {
            // Insertar números generados
            String numerosGenerados = txtNumerosGenerados.getText();
            merge Merge = new merge();
             ArrayList<Integer> resultado=Merge.merge(numeros);
            txtNumerosInsertados.setText("");
            for (int numero : resultado) {
                txtNumerosInsertados.append(String.valueOf(numero) + ", ");
            }
            System.out.println(numeros);
            numeros.clear();
        }
    }

    public static void main(String[] args) {
        GeneradorNumeros ventana = new GeneradorNumeros();
        ventana.setVisible(true);
    }
}