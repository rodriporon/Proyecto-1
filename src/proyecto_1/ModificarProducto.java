package proyecto_1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ModificarProducto extends JFrame implements ActionListener {
    
    public Clientes[] clientes;
    public int contadorclientes;
    
    public Usuario[] usuarios;
    public int contadorusuarios;
    
    public Productos[] productos;
    public int contadorproductos, locatNombre = -1;
    JButton buscar, imagen, modificar, regresar;
    public JTextField text1, text2, text3, text4, tnombre;
    public String verificarnombre, nombre, imagenruta;
    public int cantidad, doblei = -1;
    public float precio;
    
    public ModificarProducto(Usuario[] usuarios, int contadorusuarios, Clientes[] clientes, int contadorclientes, Productos[] productos, int contadorproductos) {
        this.usuarios = usuarios;
        this.contadorusuarios = contadorusuarios;
        this.clientes = clientes;
        this.contadorclientes = contadorclientes;
        this.productos = productos;
        this.contadorproductos = contadorproductos;
        
        this.setSize(500,500);
        this.setLocationRelativeTo(null);
        this.setTitle("Editar Producto");
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        
        JLabel labelnit = new JLabel("Ingrese el nombre del producto:");
        labelnit.setBounds(10,30,200,20);
        this.add(labelnit);
        
        tnombre = new JTextField();
        tnombre.setBounds(10,60,90,20);
        this.add(tnombre);
        
        buscar = new JButton("Buscar");
        buscar.setBounds(110,60,100,20);
        buscar.addActionListener(this);
        this.add(buscar);
        
        JLabel etiqueta1 = new JLabel("Nombre");
        etiqueta1.setBounds(40,100,50,20);
        this.add(etiqueta1);
        
        text1 = new JTextField();
        text1.setBounds(110,100,200,20);
        this.add(text1);
        
        JLabel etiqueta2 = new JLabel("Precio:");
        etiqueta2.setBounds(40,130,50,20);
        this.add(etiqueta2);
        
        text2 = new JTextField();
        text2.setBounds(110,130,200,20);
        this.add(text2);
        
        JLabel etiqueta3 = new JLabel("Cantidad:");
        etiqueta3.setBounds(40,160,50,20);
        this.add(etiqueta3);
        
        text3 = new JTextField();
        text3.setBounds(110,160,80,20);
        this.add(text3);
        
        JLabel etiqueta4 = new JLabel("Imagen:");
        etiqueta4.setBounds(40,190,50,20);
        this.add(etiqueta4);
        
        imagen = new JButton("Seleccionar");
        imagen.setBounds(110,190,200,20);
        imagen.addActionListener(this);
        this.add(imagen);
                
        modificar = new JButton("Modificar");
        modificar.setBounds(350,160,110,20);
        modificar.addActionListener(this);
        this.add(modificar);
        
        regresar = new JButton("Regresar");
        regresar.setBounds(350,10,110,20);
        regresar.addActionListener(this);
        this.add(regresar);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == regresar) {
            AdministracionProductos ventana = new AdministracionProductos(usuarios, contadorusuarios, clientes, contadorclientes, productos, contadorproductos);
            ventana.setVisible(true);
            this.dispose();
        } else if (ae.getSource() == buscar) {
            verificarnombre = tnombre.getText();
            for (int i = 0; i < productos.length; i++) {
                if (productos[i].getNombre().equals(verificarnombre)) {
                    locatNombre = i;
                    System.out.println("Se encontró el cliente en la pos: " + locatNombre);
                }    
            } if (locatNombre == -1) {
                JOptionPane.showMessageDialog(this, "No se encontró el producto");
            } else {
                text1.setText(productos[locatNombre].getNombre());
                text2.setText(String.valueOf(productos[locatNombre].getPrecio()));
                text3.setText(String.valueOf(productos[locatNombre].getCantidad()));
            }
        } else if (ae.getSource() == modificar) {
            nombre = text1.getText();
            precio = Float.parseFloat(text2.getText());
            cantidad = Integer.parseInt(text3.getText());
            for (int i = 0; i < productos.length; i++) {
                if (productos[i].getNombre().equals(nombre) && i != locatNombre) {
                    doblei = i;
                }
            }
            if (doblei != -1) {
                JOptionPane.showMessageDialog(this, "Este producto ya existe", "Producto ya existente", JOptionPane.WARNING_MESSAGE);
                doblei = -1;
            } else if (doblei == -1) {
            productos[locatNombre].setNombre(nombre);
            productos[locatNombre].setPrecio(precio);
            productos[locatNombre].setCantidad(cantidad);
            productos[locatNombre].setImagen(imagenruta);
            JOptionPane.showMessageDialog(this, "Cliente modificado");
            ModificarProducto ventana = new ModificarProducto(usuarios, contadorusuarios, clientes, contadorclientes, productos, contadorproductos);
            ventana.setVisible(true);
            this.dispose();
            }
        } else if (ae.getSource() == imagen) {
            JFileChooser fc = new JFileChooser();
            int op = fc.showOpenDialog(this);
            if (op == JFileChooser.APPROVE_OPTION) {
                imagenruta = fc.getSelectedFile().toString();
                System.out.println(imagenruta);
            }
        }
    }
    
}
