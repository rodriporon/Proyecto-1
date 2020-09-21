package proyecto_1;

import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class AdministracionProductos extends JFrame implements ActionListener{
    
    public Ventas[] ventas;
    public int contadorventas;
    
    public Usuario[] usuarios;
    public int contadorusuarios;
    
    public Clientes[] clientes;
    public int contadorclientes;
    
    public Productos[] productos;
    public int contadorproductos;
    
    public JButton regresar, dashboard, carga, crear, info, modificar, eliminar;
    
    public AdministracionProductos(Usuario[] usuarios, int contadorUsuarios, Clientes[] clientes, int contadorclientes, Productos[] productos, int contadorproductos, Ventas[] ventas, int contadorventas){
        
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.setTitle("Administracion de Productos");
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        
        this.ventas = ventas;
        this.contadorventas = contadorventas;
        this.productos = productos;
        this.contadorproductos = contadorproductos;
        this.usuarios = usuarios;
        this.contadorusuarios = contadorUsuarios;
        this.clientes = clientes;
        this.contadorclientes = contadorclientes;
        
        regresar = new JButton("Regresar");
        regresar.setBounds(10, 10, 90, 20);
        regresar.addActionListener(this);
        this.add(regresar);

        dashboard = new JButton("Dashboard de Productos");
        dashboard.setBounds(100, 50, 400, 60);
        dashboard.addActionListener(this);
        this.add(dashboard);

        carga = new JButton("Carga masiva de Productos");
        carga.setBounds(100, 130, 400, 60);
        carga.addActionListener(this);
        this.add(carga);

        crear = new JButton("Crear Producto");
        crear.setBounds(100, 210, 400, 60);
        crear.addActionListener(this);
        this.add(crear);

        info = new JButton("Información de Producto");
        info.setBounds(100, 290, 400, 60);
        info.addActionListener(this);
        this.add(info);

        modificar = new JButton("Modificar Producto");
        modificar.setBounds(100, 370, 190, 30);
        modificar.addActionListener(this);
        this.add(modificar);

        eliminar = new JButton("Eliminar Producto");
        eliminar.setBounds(310, 370, 190, 30);
        eliminar.addActionListener(this);
        this.add(eliminar);
    
        
}

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == regresar) {
            MenuPrincipal ventana = new MenuPrincipal(usuarios, contadorusuarios, clientes, contadorclientes, productos, contadorproductos, ventas, contadorventas);
            ventana.setVisible(true);
            this.dispose();
        } else if (ae.getSource() == carga) {
            JFileChooser fc = new JFileChooser();
            int op = fc.showOpenDialog(this);
            if (op == JFileChooser.APPROVE_OPTION) {     
                try {
                String ruta = String.valueOf(fc.getSelectedFile());
                File archivo = new File(ruta);
                FileReader fr = new FileReader(archivo);
                BufferedReader br = new BufferedReader(fr);
                    // Lectura del fichero
                    String linea;
                    if (contadorproductos == 100) {
                        JOptionPane.showMessageDialog(this, "Se alcanzó el límite máximo de productos" , "Límite máximo", JOptionPane.WARNING_MESSAGE);
                    } else {
                        while ((linea = br.readLine()) != null) {
                        String[] datos = linea.split(","); 
                        String nombre = datos[0];
                        float precio = Float.parseFloat(datos[1]);
                        int cantidad = Integer.parseInt(datos[2]);
                        String imagen = datos[3];
                                productos[contadorproductos] = new Productos();
                                productos[contadorproductos].setNombre(nombre);
                                productos[contadorproductos].setPrecio(precio);
                                productos[contadorproductos].setCantidad(cantidad);
                                productos[contadorproductos].setImagen(imagen);
                                contadorproductos++;    
                    }     
                    }
                    
                } catch (Exception e) {
                    e.printStackTrace();
                
                }
            }
        } else if (ae.getSource() == dashboard) {
            DashboardProductos ventana = new DashboardProductos(usuarios, contadorusuarios, clientes, contadorclientes, productos, contadorproductos, ventas, contadorventas);
            ventana.setVisible(true);
            this.dispose();
        } else if (ae.getSource() == crear) {
            CrearProducto ventana = new CrearProducto(usuarios, contadorusuarios, clientes, contadorclientes, productos, contadorproductos, ventas, contadorventas);
            ventana.setVisible(true);
            this.dispose();
        } else if (ae.getSource() == info) {
            InformacionProducto ventana = new InformacionProducto(usuarios, contadorusuarios, clientes, contadorclientes, productos, contadorproductos, ventas, contadorventas);
            ventana.setVisible(true);
            this.dispose();
        } else if (ae.getSource() == modificar) {
            ModificarProducto ventana = new ModificarProducto(usuarios, contadorusuarios, clientes, contadorclientes, productos, contadorproductos, ventas, contadorventas);
            ventana.setVisible(true);
            this.dispose();
        } else if (ae.getSource() == eliminar) {
            EliminarProducto ventana = new EliminarProducto(usuarios, contadorusuarios, clientes, contadorclientes, productos, contadorproductos, ventas, contadorventas);
            ventana.setVisible(true);
            this.dispose();
        }
    }
    
}
