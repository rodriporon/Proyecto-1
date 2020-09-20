package proyecto_1;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import javax.swing.*;

public class CrearProducto extends JFrame implements ActionListener{
    public Usuario[] usuarios;
    public Clientes[] clientes;
    public Productos[] productos;
    public int contadorusuarios, contadorclientes, contadorproductos;
    public String rutaimagen, nombre, verificarnombre;
    public int cantidad;
    public float precio;
    JTextField text1, text2, text3, text4;
    JButton regresar, guardar, imagen;
    public CrearProducto (Usuario[] usuarios, int contadorusuarios, Clientes[] clientes, int contadorclientes, Productos[] productos, int contadorproductos) {
        
        this.usuarios = usuarios;
        this.contadorusuarios = contadorusuarios;
        this.clientes = clientes;
        this.contadorclientes = contadorclientes;
        this.productos = productos;
        this.contadorproductos = contadorproductos;
        
        this.setSize(500,300);
        this.setLocationRelativeTo(null);
        this.setTitle("Crear nuevo Producto");
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        
        JLabel etiqueta1 = new JLabel("Nombre");
        etiqueta1.setBounds(40,40,50,20);
        this.add(etiqueta1);
        
        text1 = new JTextField();
        text1.setBounds(110,40,200,20);
        this.add(text1);
        
        JLabel etiqueta2 = new JLabel("Precio:");
        etiqueta2.setBounds(40,70,50,20);
        this.add(etiqueta2);
        
        
        text2 = new JTextField();
        text2.setBounds(110,70,200,20);
        this.add(text2);
        
        JLabel etiqueta3 = new JLabel("Cantidad");
        etiqueta3.setBounds(40,100,50,20);
        this.add(etiqueta3);
        
        text3 = new JTextField();
        text3.setBounds(110,100,80,20);
        this.add(text3);
        
        JLabel etiqueta4 = new JLabel("Imagen: ");
        etiqueta4.setBounds(40,130,50,20);
        this.add(etiqueta4);
        
        imagen = new JButton("Seleccionar");
        imagen.setBounds(110,130,200,20);
        imagen.addActionListener(this);
        this.add(imagen);
        
        guardar = new JButton("Guardar");
        guardar.setBounds(350,100,110,20);
        guardar.addActionListener(this);
        this.add(guardar);
        
        regresar = new JButton("Regresar");
        regresar.setBounds(350,10,110,20);
        regresar.addActionListener(this);
        this.add(regresar);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == imagen) {
            JFileChooser fc = new JFileChooser();
            int op = fc.showOpenDialog(this);
            if (op == JFileChooser.APPROVE_OPTION) {
                rutaimagen = fc.getSelectedFile().toString();
                System.out.println(rutaimagen);
            }
        } else if (ae.getSource() == guardar) {
            nombre = text1.getText();
            precio = Float.parseFloat(text2.getText());
            cantidad = Integer.parseInt(text3.getText());
            for (int i = 0; i < 100; i++) {
                if (productos[i].getNombre().equals(nombre)) {
                    verificarnombre = productos[i].getNombre();
                }
            }
            if (contadorproductos == 100) {
                JOptionPane.showMessageDialog(this, "Se ha llegado al límite de 100 productos", "Límite alcanzado", JOptionPane.WARNING_MESSAGE);
            } else if (nombre.equals(verificarnombre)) {
                JOptionPane.showMessageDialog(this, "Ya existe este nombre en un producto anterior", "Nombre existente", JOptionPane.WARNING_MESSAGE);
            } else {
                productos[contadorproductos] = new Productos(nombre, rutaimagen, precio, cantidad);
                contadorproductos++;
                JOptionPane.showMessageDialog(this, "Producto Registrado");
                CrearProducto ventana = new CrearProducto(usuarios, contadorusuarios, clientes, contadorclientes, productos, contadorproductos);
                ventana.setVisible(true);
                this.dispose();
            }
        } else if (ae.getSource() == regresar) {
            AdministracionProductos ventana = new AdministracionProductos(usuarios, contadorusuarios, clientes, contadorclientes, productos, contadorproductos);
            ventana.setVisible(true);
            this.dispose();
        }
        
    }
    
}
