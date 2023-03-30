package org.example;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
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
    private JLabel lblTiempo;
    private JLabel lblTiempoFork;
    private JLabel lblTiempoService;

    private JButton btnMergeNumerosFork;

    private JButton btnMergeNumerosService;

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
        btnMergeNumerosFork = new JButton("Fork");
        btnMergeNumerosFork.addActionListener(this);
        btnMergeNumerosService = new JButton("Service");
        btnMergeNumerosService.addActionListener(this);
        txtNumerosInsertados = new JTextArea();
        txtNumerosInsertados.setEditable(false);
        txtNumerosInsertados.setColumns(20);
        txtNumerosInsertados.setRows(5);
        scrollNumerosInsertados = new JScrollPane();
        scrollNumerosInsertados.setViewportView(txtNumerosInsertados);
        //tiempo
        lblTiempo = new JLabel("Tiempo : ");
        lblTiempoFork = new JLabel("Tiempo Fork: ");
        lblTiempoService = new JLabel("Tiempo Service: ");

        // Configuración del layout
        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        contentPane.add(lblCantidadNumeros);

        contentPane.add(txtCantidadNumeros);
        contentPane.add(btnGenerarNumeros);
        contentPane.add(scrollNumerosGenerados);
        contentPane.add(btnMergeNumeros);
        contentPane.add(scrollNumerosInsertados);
       contentPane.add(btnMergeNumerosFork);
        contentPane.add(btnMergeNumerosService);
        contentPane.add(lblTiempo);


        // Configuración de los bordes
        lblCantidadNumeros.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));
        txtCantidadNumeros.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));
        btnGenerarNumeros.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));
        btnMergeNumeros.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));
        btnMergeNumerosFork.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));
        btnMergeNumerosService.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));
        lblTiempo.setBorder(BorderFactory.createEmptyBorder(0,0,0,20));
        lblTiempoFork.setBorder(BorderFactory.createEmptyBorder(0,0,0,20));
        lblTiempoService.setBorder(BorderFactory.createEmptyBorder(0,0,0,20));

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnGenerarNumeros) {
            numeros.clear();
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
            long tiempo1 = System.currentTimeMillis();
            // Insertar números generados
            merge Merge = new merge();
            ArrayList<Integer> resultado=Merge.merge(numeros);
            txtNumerosInsertados.setText("");
            for (int numero : resultado) {
                txtNumerosInsertados.append(String.valueOf(numero) + ", ");
            }
            //System.out.println(numeros);
            long tiempo2 = System.currentTimeMillis()-tiempo1;
            lblTiempo.setText("Tiempo Merge: "+tiempo2+" milisegundos");

        }else if (e.getSource() == btnMergeNumerosFork) {
            int[] array = new int[this.numeros.size()];
            for (int i = 0; i < this.numeros.size(); i++) {
                array[i] = this.numeros.get(i);
            }
            long tiempo1 = System.currentTimeMillis();
            Forkjoin forkjoin= new Forkjoin(array);
            ForkJoinPool fork = new ForkJoinPool();
            fork.invoke(forkjoin);
            //fork.
            txtNumerosInsertados.setText("");
            txtNumerosInsertados.setText(Arrays.toString(array));

            //System.out.println(numeros);
            long tiempo2 = System.currentTimeMillis()-tiempo1;
            lblTiempo.setText("Tiempo Fork: "+tiempo2+" milisegundos");
        }
    }

    public static void main(String[] args) {
        GeneradorNumeros ventana = new GeneradorNumeros();
        ventana.setVisible(true);
    }
}