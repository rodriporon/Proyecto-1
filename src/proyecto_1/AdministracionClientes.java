package proyecto_1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AdministracionClientes extends JFrame implements ActionListener{
    
    public JButton regresar, dashboard, carga, crear, info, modificar, eliminar;
    
    public Usuario[] usuarios;
    public int contadorUsuarios;
    
    public Clientes[] clientes;
    public int contadorclientes;
    
    public AdministracionClientes(Usuario[] usuarios, int contadorUsuarios, Clientes[] clientes, int contadorclientes){
        
        this.setSize(600,600);
        this.setLocationRelativeTo(null);
        this.setTitle("Administracion de Clientes");
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        
        this.usuarios = usuarios;
        this.contadorUsuarios = contadorUsuarios;
        this.clientes = clientes;
        this.contadorclientes = contadorclientes;
        
        regresar = new JButton("Regresar");
        regresar.setBounds(10,10,90,20);
        regresar.addActionListener(this);
        this.add(regresar);
        
        dashboard = new JButton("Dashboard de Clientes");
        dashboard.setBounds(100,50,400,60);
        dashboard.addActionListener(this);
        this.add(dashboard);
        
        carga = new JButton("Carga masiva de Clientes");
        carga.setBounds(100,130,400,60);
        carga.addActionListener(this);
        this.add(carga);
        
        crear = new JButton("Crear Cliente");
        crear.setBounds(100,210,400,60);
        crear.addActionListener(this);
        this.add(crear);
        
        info = new JButton("Información de Cliente");
        info.setBounds(100,290,400,60);
        info.addActionListener(this);
        this.add(info);
        
        modificar = new JButton("Modificar Cliente");
        modificar.setBounds(100,370,190,30);
        modificar.addActionListener(this);
        this.add(modificar);
        
        eliminar = new JButton("Eliminar Cliente");
        eliminar.setBounds(310,370,190,30);
        eliminar.addActionListener(this);
        this.add(eliminar);



        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == regresar) {
            MenuPrincipal ventana = new MenuPrincipal(usuarios, contadorUsuarios, clientes, contadorclientes);
            ventana.setVisible(true);
            this.dispose();
        } else if (ae.getSource() == crear) {
            CrearCliente ventana = new CrearCliente(clientes, contadorclientes);
            ventana.setVisible(true);
            this.dispose();
        }
        
    }
    
    
    
}
