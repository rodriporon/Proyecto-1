package proyecto_1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.*;


public class EliminarCliente extends JFrame implements ActionListener{
    
    public Clientes[] clientes;
    public int contadorclientes;
    
    public Usuario[] usuarios;
    public int contadorusuarios;
    
    public Productos[] productos;
    public int contadorproductos;
    
    public JTextField tnit;
    public JLabel titulo;
    public JButton eliminar;
    public String nit;
    public int verificarnit;
    
    public EliminarCliente(Usuario[] usuarios, int contadorusuarios, Clientes[] clientes, int contadorclientes, Productos[] productos, int contadorproductos) {
        
        this.productos = productos;
        this.contadorproductos = contadorproductos;
        this.usuarios = usuarios;
        this.contadorusuarios = contadorusuarios;
        this.clientes = clientes;
        this.contadorclientes = contadorclientes;
        
        this.setSize(300,300);
        this.setLocationRelativeTo(null);
        this.setTitle("Eliminar Cliente");
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);        
        
        JLabel titulo = new JLabel("NIT del Cliente");
        titulo.setBounds(5,5,200,20);
        this.add(titulo);
        
        tnit = new JTextField();
        tnit.setBounds(5,35,200,20);
        this.add(tnit);
        
        eliminar = new JButton("Eliminar");
        eliminar.setBounds(35,65,110,20);
        eliminar.addActionListener(this);
        this.add(eliminar);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == eliminar) {
            nit = tnit.getText();
            for (int i = 0; i < clientes.length; i++) {
                if (clientes[i].getNIT().equals(nit)) {
                    verificarnit = i;
                }
            }
            for (int i = verificarnit; i < contadorclientes; i++) {
                clientes[i] = clientes[i+1];
            }
            contadorclientes--;
            JOptionPane.showMessageDialog(this,"Cliente eliminado");
            AdministracionClientes ventana = new AdministracionClientes(usuarios, contadorusuarios, clientes, contadorclientes, productos, contadorproductos);
            ventana.setVisible(true);
            this.dispose();
        }
    }
    
}
