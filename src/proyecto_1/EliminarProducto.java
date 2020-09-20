package proyecto_1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class EliminarProducto extends JFrame implements ActionListener{
    
    public Clientes[] clientes;
    public int contadorclientes;
    
    public Usuario[] usuarios;
    public int contadorusuarios;
    
    public Productos[] productos;
    public int contadorproductos;
    
    public JTextField tnombre;
    public JLabel titulo;
    public JButton eliminar;
    public String nombre;
    public int verificarnombre;
    
    public EliminarProducto(Usuario[] usuarios, int contadorusuarios, Clientes[] clientes, int contadorclientes, Productos[] productos, int contadorproductos) {
        
        this.productos = productos;
        this.contadorproductos = contadorproductos;
        this.usuarios = usuarios;
        this.contadorusuarios = contadorusuarios;
        this.clientes = clientes;
        this.contadorclientes = contadorclientes;
        
        this.setSize(300,300);
        this.setLocationRelativeTo(null);
        this.setTitle("Eliminar Producto");
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);        
        
        JLabel titulo = new JLabel("Nombre del Producto");
        titulo.setBounds(5,5,200,20);
        this.add(titulo);
        
        tnombre = new JTextField();
        tnombre.setBounds(5,35,200,20);
        this.add(tnombre);
        
        eliminar = new JButton("Eliminar");
        eliminar.setBounds(35,65,110,20);
        eliminar.addActionListener(this);
        this.add(eliminar);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getSource() == eliminar) {
            nombre = tnombre.getText();
            for (int i = 0; i < productos.length; i++) {
                if (productos[i].getNombre().equals(nombre)) {
                    verificarnombre = i;
                }
            }
            for (int i = verificarnombre; i < contadorproductos; i++) {
                productos[i] = productos[i+1];
            }
            contadorproductos--;
            JOptionPane.showMessageDialog(this,"Producto eliminado");
            AdministracionProductos ventana = new AdministracionProductos(usuarios, contadorusuarios, clientes, contadorclientes, productos, contadorproductos);
            ventana.setVisible(true);
            this.dispose();
        }
    }
    
}
