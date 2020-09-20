package proyecto_1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class InformacionProducto extends JFrame implements ActionListener{
    
    public Usuario[] usuarios;
    public Clientes[] clientes;
    public Productos[] productos;
    public int contadorusuarios, contadorclientes, contadorproductos;
    public JButton regresar, buscar;
    public ImageIcon imagen;
    public String nombre, imagenP, buscarnombre;
    public int cantidad, findnombre = -1;
    public float precio;
    JTextField tnombre;
    JLabel nombre1,nombre2,precio1,precio2,cantidad1,cantidad2,imagen1,imagen2,titulo;
    
    public InformacionProducto(Usuario[] usuarios, int contadorusuarios, Clientes[] clientes, int contadorclientes, Productos[] productos, int contadorproductos) {
        
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setTitle("Informacion del Producto");
        this.setLayout(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        
        this.usuarios = usuarios;
        this.contadorusuarios = contadorusuarios;
        this.clientes = clientes;
        this.contadorclientes = contadorclientes;
        this.productos = productos;
        this.contadorproductos = contadorproductos;
        
        Botones();
        Componentes();
    }
    
    public void Componentes(){
        
        titulo = new JLabel("Consulta de producto por Nombre:");
        titulo.setBounds(30,100,200,20);
        this.add(titulo);
        
        tnombre = new JTextField();
        tnombre.setBounds(30,130,150,20);
        this.add(tnombre);
        
        nombre1 = new JLabel("Nombre:");
        nombre1.setBounds(300,100,100,20);
        this.add(nombre1);
        
        nombre2 = new JLabel();
        nombre2.setBounds(410,100,100,20);
        this.add(nombre2);
        
        precio1 = new JLabel("Precio:");
        precio1.setBounds(300,130,100,20);
        this.add(precio1);
        
        precio2 = new JLabel();
        precio2.setBounds(410,130,100,20);
        this.add(precio2);
        
        cantidad1 = new JLabel("Cantidad:");
        cantidad1.setBounds(300,160,100,20);
        this.add(cantidad1);
        
        cantidad2 = new JLabel();
        cantidad2.setBounds(410,160,100,20);
        this.add(cantidad2);
        
        imagen1 = new JLabel("Imagen:");
        imagen1.setBounds(300,190,100,20);
        this.add(imagen1);
        
        imagen2 = new JLabel();
        imagen2.setBounds(410,190,350,250);
        this.add(imagen2);
        
    }

    public void Botones(){
        
        regresar = new JButton("Regresar");
        regresar.setBounds(10, 10, 90, 20);
        regresar.addActionListener(this);
        this.add(regresar);
        
        buscar = new JButton("Buscar");
        buscar.setBounds(90, 150, 90, 20);
        buscar.addActionListener(this);
        this.add(buscar);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == regresar) {
            AdministracionProductos ventana = new AdministracionProductos(usuarios, contadorusuarios, clientes, contadorclientes, productos, contadorproductos);
            ventana.setVisible(true);
            this.dispose();
        } else if (ae.getSource() == buscar) {
            buscarnombre = tnombre.getText();
            for (int i = 0; i < contadorproductos; i++) {
                if (productos[i].getNombre().equals(buscarnombre)) {
                    findnombre = i;
                }
            }
            if (findnombre != -1) {
                nombre = productos[findnombre].getNombre();
                precio = productos[findnombre].getPrecio();
                cantidad = productos[findnombre].getCantidad();
                imagenP = productos[findnombre].getImagen();
                
                nombre2.setText(nombre);
                precio2.setText(String.valueOf(precio));
                cantidad2.setText(String.valueOf(cantidad));
                imagen = new ImageIcon(imagenP);
                imagen2.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(350,250, Image.SCALE_SMOOTH)));
                findnombre = -1;
            } else if (findnombre == -1) {
                JOptionPane.showMessageDialog(this, "No se encontró el producto");
                
            }
                
        }
    }
    
}
