package proyecto_1;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class InformacionCliente extends JFrame implements ActionListener {
    
    public Usuario[] usuarios;
    public int contadorusuarios;
    
    public ImageIcon imagen;
    public Clientes[] clientes;
    public int contadorclientes, findnit;
    
    public String nombre,sexo = null ,nit,avatar, buscarnit;
    public int edad;
    public JButton regresar, buscar;
    public JTextField tnit;
    public JLabel nombre1,nombre2,edad1,edad2,sexo1,sexo2,nit1,nit2,avatar1,avatar2,titulo;
    public InformacionCliente(Usuario[] usuarios, int contadorusuarios, Clientes[] clientes, int contadorclientes){
        
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setTitle("Informacion del Cliente");
        this.setLayout(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        
        this.usuarios = usuarios;
        this.contadorusuarios = contadorusuarios;
        
        this.clientes = clientes;
        this.contadorclientes = contadorclientes;
        
        Botones();
        Componentes();
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
    
    public void Componentes(){
        
        titulo = new JLabel("Consulta de cliente por NIT:");
        titulo.setBounds(30,100,200,20);
        this.add(titulo);
        
        tnit = new JTextField();
        tnit.setBounds(30,130,150,20);
        this.add(tnit);
        
        nombre1 = new JLabel("Nombre:");
        nombre1.setBounds(300,100,100,20);
        this.add(nombre1);
        
        nombre2 = new JLabel();
        nombre2.setBounds(410,100,100,20);
        this.add(nombre2);
        
        edad1 = new JLabel("Edad:");
        edad1.setBounds(300,130,100,20);
        this.add(edad1);
        
        edad2 = new JLabel();
        edad2.setBounds(410,130,100,20);
        this.add(edad2);
        
        sexo1 = new JLabel("Sexo:");
        sexo1.setBounds(300,160,100,20);
        this.add(sexo1);
        
        sexo2 = new JLabel();
        sexo2.setBounds(410,160,100,20);
        this.add(sexo2);
        
        nit1 = new JLabel("NIT:");
        nit1.setBounds(300,190,100,20);
        this.add(nit1);
        
        nit2 = new JLabel();
        nit2.setBounds(410,190,100,20);
        this.add(nit2);
        
        avatar1 = new JLabel("Avatar:");
        avatar1.setBounds(300,220,100,20);
        this.add(avatar1);
        
        avatar2 = new JLabel();
        avatar2.setBounds(410,220,350,250);
        this.add(avatar2);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == regresar) {
            AdministracionClientes ventana = new AdministracionClientes(usuarios, contadorusuarios, clientes, contadorclientes);
            ventana.setVisible(true);
            this.dispose();
        } else if (ae.getSource() == buscar) {
            buscarnit = tnit.getText();
            for (int i = 0; i < contadorclientes; i++) {
                if (clientes[i].getNIT().equals(buscarnit)) {
                    findnit = i;
                }
            }
                nombre = clientes[findnit].getNombre();
                edad = clientes[findnit].getEdad();
                sexo = clientes[findnit].getSexo();
                nit = clientes[findnit].getNIT();
                avatar = clientes[findnit].getAvatar();
                System.out.println(sexo);
                
                nombre2.setText(nombre);
                edad2.setText(String.valueOf(edad));
                sexo2.setText(sexo);
                nit2.setText(nit);
                
                imagen = new ImageIcon(avatar);
                avatar2.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(350,250, Image.SCALE_SMOOTH)));
        }
    }
    
    
}
