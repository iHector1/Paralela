package org.example;

import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class d extends JFrame {

    private JLabel etiquetaNombre, etiquetaEdad, etiquetaGenero, etiquetaPais;
    private JTextField campoNombre, campoEdad;
    private JTextArea areaTexto;
    private JButton botonAgregar, botonLimpiar;
    private JRadioButton radioBotonMasculino, radioBotonFemenino;
    private JCheckBox checkBoxCasado;
    private JComboBox comboBoxPaises;
    private JTable tablaPersonas;
    private DefaultTableModel modeloTabla;
    private JScrollPane scrollTabla;
    private JMenuBar barraMenu;
    private JMenu menuArchivo, menuAyuda;
    private JMenuItem itemNuevo, itemSalir, itemAcercaDe;

    public d() {
        // Configuración básica del JFrame
        setTitle("Formulario de agregar personas");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 2));

        // Creación de los elementos de la interfaz
        etiquetaNombre = new JLabel("Nombre:");
        add(etiquetaNombre);
        campoNombre = new JTextField(20);
        add(campoNombre);

        etiquetaEdad = new JLabel("Edad:");
        add(etiquetaEdad);
        campoEdad = new JTextField(20);
        add(campoEdad);

        etiquetaGenero = new JLabel("Género:");
        add(etiquetaGenero);
        radioBotonMasculino = new JRadioButton("Masculino");
        radioBotonFemenino = new JRadioButton("Femenino");
        ButtonGroup grupoGenero = new ButtonGroup();
        grupoGenero.add(radioBotonMasculino);
        grupoGenero.add(radioBotonFemenino);
        JPanel panelGenero = new JPanel();
        panelGenero.add(radioBotonMasculino);
        panelGenero.add(radioBotonFemenino);
        add(panelGenero);

        etiquetaPais = new JLabel("País:");
        add(etiquetaPais);
        comboBoxPaises = new JComboBox();
        comboBoxPaises.addItem("Seleccione un país...");
        comboBoxPaises.addItem("Argentina");
        comboBoxPaises.addItem("Brasil");
        comboBoxPaises.addItem("Chile");
        comboBoxPaises.addItem("Colombia");
        comboBoxPaises.addItem("México");
        add(comboBoxPaises);

        areaTexto = new JTextArea(5, 20);
        JScrollPane scrollPane = new JScrollPane(areaTexto);
        add(scrollPane);

        checkBoxCasado = new JCheckBox("Casado/a");
        add(checkBoxCasado);

        botonAgregar = new JButton("Agregar");
        botonAgregar.setBackground(Color.GREEN);
        botonAgregar.setForeground(Color.WHITE);
        add(botonAgregar);

        botonLimpiar = new JButton("Limpiar");
        botonLimpiar.setBackground(Color.RED);
        botonLimpiar.setForeground(Color.WHITE);
        add(botonLimpiar);


        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Edad");
        modeloTabla.addColumn("Género");
        modeloTabla.addColumn("País");
        modeloTabla.addColumn("Casado/a");
        tablaPersonas = new JTable(modeloTabla);
        scrollTabla = new JScrollPane(tablaPersonas);
        tablaPersonas.setBackground(Color.YELLOW);
        add(scrollTabla);


        barraMenu = new JMenuBar();
        menuArchivo= new JMenu("Archivo");
        itemNuevo = new JMenuItem("Nuevo");
        itemSalir = new JMenuItem("Salir");
        menuArchivo.add(itemNuevo);
        menuArchivo.add(itemSalir);
        barraMenu.add(menuArchivo);

        menuAyuda = new JMenu("Ayuda");
        itemAcercaDe = new JMenuItem("Acerca de...");
        menuAyuda.add(itemAcercaDe);
        barraMenu.add(menuAyuda);

        setJMenuBar(barraMenu);


        botonAgregar.addActionListener(e -> agregarPersona());
        botonLimpiar.addActionListener(e -> limpiarFormulario());
        itemNuevo.addActionListener(e -> limpiarFormulario());
        itemSalir.addActionListener(e -> System.exit(0));
        itemAcercaDe.addActionListener(e -> JOptionPane.showMessageDialog(this, "Formulario de agregar personas\nVersión 1.0"));


        setVisible(true);
    }
    private void agregarPersona() {
        String nombre = campoNombre.getText();
        String edad = campoEdad.getText();
        String genero = radioBotonMasculino.isSelected() ? "Masculino" : "Femenino";
        String pais = (String) comboBoxPaises.getSelectedItem();
        String casado = checkBoxCasado.isSelected() ? "Sí" : "No";
        Vector<String> datos = new Vector<>();
        datos.add(nombre);
        datos.add(edad);
        datos.add(genero);
        datos.add(pais);
        datos.add(casado);
        modeloTabla.addRow(datos);
        campoNombre.setText("");
        campoEdad.setText("");
        radioBotonMasculino.setSelected(true);
        comboBoxPaises.setSelectedIndex(0);
        checkBoxCasado.setSelected(false);
        JOptionPane.showMessageDialog(null,"Agregado Correctamente");
        areaTexto.setText("");
    }
    private void limpiarFormulario() {

        campoNombre.setText("");
        campoEdad.setText("");
        radioBotonMasculino.setSelected(true);
        comboBoxPaises.setSelectedIndex(0);
        checkBoxCasado.setSelected(false);
        areaTexto.setText("");


        int rowCount = modeloTabla.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            modeloTabla.removeRow(i);
        }
    }
    public static void main(String[] args) {
        new d();
    }
}
