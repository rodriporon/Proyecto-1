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
    
    
    public MenuPrincipal(Usuario[] users, int contadorusuarios){
        
        this.setSize(700,500);
        this.setLocationRelativeTo(null);
        this.setTitle("Menú Principal");
        this.setLayout(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        
        usuarios = users;
        contadorUsuarios = contadorusuarios;
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
            ventana = new VentanaPrincipal(usuarios, contadorUsuarios);
            ventana.setVisible(true);
            this.dispose();
        } else if (ae.getSource() == AdminCli) {
            AdministracionClientes ventana = new AdministracionClientes();
            ventana.setVisible(true);
            this.dispose();
        }
        
        
    }
    
    
}