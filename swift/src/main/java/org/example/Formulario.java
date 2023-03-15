package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Formulario extends JFrame {

    // Componentes del formulario
    private JTextField campoTexto;
    private JTextArea areaTexto;
    private JComboBox<String> comboBox;
    private JCheckBox checkBox1;
    private JCheckBox checkBox2;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem menuItem;

    public Formulario() {
        // Configuración del formulario
        setTitle("Formulario de ejemplo");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creación de los componentes
        campoTexto = new JTextField();
        areaTexto = new JTextArea();
        comboBox = new JComboBox<>(new String[]{"Opción 1", "Opción 2", "Opción 3"});
        checkBox1 = new JCheckBox("Opción 1");
        checkBox2 = new JCheckBox("Opción 2");

        // Creación del menú
        menuBar = new JMenuBar();
        menu = new JMenu("Archivo");
        menuItem = new JMenuItem("Salir");
        menu.add(menuItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        // Diseño del formulario
        setLayout(new GridLayout(6, 1));
        add(new JLabel("Campo de texto:"));
        add(campoTexto);
        add(new JLabel("Área de texto:"));
        add(new JScrollPane(areaTexto));
        add(new JLabel("Opciones:"));
        JPanel opcionesPanel = new JPanel();
        opcionesPanel.setLayout(new GridLayout(1, 3));
        opcionesPanel.add(comboBox);
        opcionesPanel.add(checkBox1);
        opcionesPanel.add(checkBox2);
        add(opcionesPanel);

        // Agregar validación de entrada al campo de texto
        campoTexto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = campoTexto.getText();
                if (input.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(Formulario.this, "El campo de texto no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
                    campoTexto.setText("");
                    campoTexto.requestFocus();
                }
            }
        });

        // Mostrar el formulario
        setVisible(true);
    }

    public static void main(String[] args) {
       // new Formulario();
    }
}
