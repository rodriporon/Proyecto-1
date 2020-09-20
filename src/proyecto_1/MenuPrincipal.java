package proyecto_1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Rodrigo Porón
 */
public class MenuPrincipal extends JFrame implements ActionListener{
    
    public VentanaPrincipal ventana;
    public JButton AdminCli;
    public JButton AdminPro;
    public JButton AdminVen;
    public JButton Reportes;
    public JButton Regresar;
    
    public Usuario[] usuarios;
    public int contadorUsuarios;
    
    public Clientes[] clientes;
    public int contadorclientes;
    
    public Productos[] productos;
    public int contadorproductos;
    
    
    public MenuPrincipal(Usuario[] users, int contadorusuarios, Clientes[] clientes, int contadorclientes, Productos[] productos, int contadorproductos){
        
        this.setSize(700,500);
        this.setLocationRelativeTo(null);
        this.setTitle("Menú Principal");
        this.setLayout(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        
        this.productos = productos;
        this.contadorproductos = contadorproductos;
        usuarios = users;
        contadorUsuarios = contadorusuarios;
        
        this.clientes = clientes;
        this.contadorclientes = contadorclientes;
        Botones();

        
    }
        
        
        public void Botones(){
        AdminCli = new JButton("Administración de Clientes");
        AdminCli.setBounds(100,100,500,60);
        AdminCli.addActionListener(this);
        this.add(AdminCli);
        
        AdminPro = new JButton("Administración de Productos");
        AdminPro.setBounds(100,170,500,60);
        AdminPro.addActionListener(this);
        this.add(AdminPro);
        
        AdminVen = new JButton("Administración de Ventas");
        AdminVen.setBounds(100,240,500,60);
        AdminVen.addActionListener(this);
        this.add(AdminVen);
        
        Reportes = new JButton("Reportes");
        Reportes.setBounds(100,310,500,60);
        Reportes.addActionListener(this);
        this.add(Reportes);
        
        Regresar = new JButton("Regresar");
        Regresar.setBounds(300,380,100,20);
        Regresar.addActionListener(this);
        this.add(Regresar);
            
        
        }


    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Regresar) {
            ventana = new VentanaPrincipal(usuarios, contadorUsuarios, clientes, contadorclientes, productos, contadorproductos);
            ventana.setVisible(true);
            this.dispose();
        } else if (ae.getSource() == AdminCli) {
            AdministracionClientes ventana = new AdministracionClientes(usuarios, contadorUsuarios, clientes, contadorclientes, productos, contadorproductos);
            ventana.setVisible(true);
            this.dispose();
        } else if (ae.getSource() == AdminPro) {
            AdministracionProductos ventana = new AdministracionProductos(usuarios, contadorUsuarios, clientes, contadorclientes, productos, contadorproductos);
            ventana.setVisible(true);
            this.dispose();
        }        
        
    }
    
    
}
