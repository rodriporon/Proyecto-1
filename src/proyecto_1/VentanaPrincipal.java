package proyecto_1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class VentanaPrincipal extends JFrame implements ActionListener {
    
    public int posicion = 0, recuperarPass = -1;
    public String Same;
    
    public JTextField username_T, user_R, nombre_R;
    public JPasswordField password_T, password_R, password_RC;
    public JButton ingresar, registrar, recuperar;
    public JLabel etiqueta_L, etiqueta_L2, etiqueta_L3;
    
    public MenuPrincipal menu;
    public String nombre2, username1, password1, username2, passwordR, confpasswordR;
    public String[] arreglo;
    public int contadorUsuarios;
    public Usuario[] usuarios;

    public VentanaPrincipal(Usuario[] users, int contadorusuarios){
        
        
        this.setSize(600,400);
        this.setLocationRelativeTo(null);
        this.setTitle("Autenticacion");

        this.setLayout(null);
        this.setResizable(false);

       
        usuarios = users;
        contadorUsuarios = contadorusuarios;
        RecorrerUsuarios();
        EntradaDatos();

        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void RecorrerUsuarios(){
        for (int i = 0; i < usuarios.length; i++) {
            System.out.print("Usuario: " + usuarios[i].getNombre());
            System.out.print(", Username: " + usuarios[i].getUser());
            System.out.print(", Password: " + usuarios[i].getPass());
            System.out.println();
        }
    }
    
    public void EntradaDatos(){
        
        JPanel panel = new JPanel();
        //panel.setBackground(Color.GREEN);
        this.getContentPane().add(panel);
        panel.setLayout(null);
        panel.setSize(250,400);
        etiqueta_L = new JLabel("Login");
        etiqueta_L.setBounds(20, 20, 50, 20);
        etiqueta_L2 = new JLabel("Usuario");
        etiqueta_L2.setBounds(30,70,60,20);
        etiqueta_L3 = new JLabel("Contraseña");
        etiqueta_L3.setBounds(30,110,70,20);
        panel.add(etiqueta_L);
        panel.add(etiqueta_L2);
        panel.add(etiqueta_L3);
        
        
 
        
      /*  username_T = new JTextField();
        username_T.setBounds(150, 50, 100, 50);
        this.add(username_T);
*/        
        
        JPanel panel2 = new JPanel();
        //panel2.setBackground(Color.BLUE);
        this.getContentPane().add(panel2);
        panel2.setLayout(null);
        panel2.setBounds(250,0,400,500);
        JLabel etiqueta1 = new JLabel("Registro de Usuario");
        etiqueta1.setBounds(20,20,150,20);
        JLabel etiqueta2 = new JLabel("Usuario");
        etiqueta2.setBounds(30,70,100,20);
        JLabel etiqueta3 = new JLabel("Nombre");
        etiqueta3.setBounds(30,110,100,20);
        JLabel etiqueta4 = new JLabel("Contraseña");
        etiqueta4.setBounds(30,150,100,20);
        JLabel etiqueta5 = new JLabel("Confirmar Contraseña");
        etiqueta5.setBounds(30,190,150,20);
        panel2.add(etiqueta1);
        panel2.add(etiqueta2);
        panel2.add(etiqueta3);
        panel2.add(etiqueta4);
        panel2.add(etiqueta5);
        
        username_T = new JTextField();
        username_T.setBounds(110,70,100,20);
        panel.add(username_T);
        
        password_T = new JPasswordField();
        password_T.setBounds(110,110,100,20);
        panel.add(password_T);
        
        //JText de Registro
        
        user_R = new JTextField();
        user_R.setBounds(175,70,120,20);
        panel2.add(user_R);
        
        nombre_R = new JTextField();
        nombre_R.setBounds(175,110,120,20);
        panel2.add(nombre_R);
        
        password_R = new JPasswordField();
        password_R.setBounds(175,150,120,20);
        panel2.add(password_R);
        
        password_RC = new JPasswordField();
        password_RC.setBounds(175,190,120,20);
        panel2.add(password_RC);
        
        ingresar = new JButton("Ingresar");
        ingresar.setBounds(75,150,100,20);
        ingresar.addActionListener(this);
        panel.add(ingresar);
        
        recuperar = new JButton("Recuperar Contraseña");
        recuperar.setBounds(20,180,200,20);
        recuperar.addActionListener(this);
        panel.add(recuperar);
        
        registrar = new JButton("Registrar");
        registrar.setBounds(115,230,100,20);
        registrar.addActionListener(this);
        panel2.add(registrar);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == ingresar) {
            username1 = username_T.getText();
            password1 = password_T.getText();
            boolean validacion = false;
            for (int i = 0; i < usuarios.length; i++) {
                if (usuarios[i].getUser().equals(username1) && usuarios[i].getPass().equals(password1)) {
                    validacion = true;
                    posicion = i;
                }
            }
            if (validacion) {
                JOptionPane.showMessageDialog(this, "Bienvenido " + usuarios[posicion].getNombre());
                menu = new MenuPrincipal(usuarios, contadorUsuarios);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos", "Error de autenticación", JOptionPane.WARNING_MESSAGE);
                VentanaPrincipal ventana = new VentanaPrincipal(usuarios, contadorUsuarios);
                ventana.setVisible(true);
                this.dispose();
            }

                
            
            
        } else if (ae.getSource() == registrar) {
            nombre2 = nombre_R.getText();
            username2 = user_R.getText();
            passwordR = password_R.getText();
            confpasswordR = password_RC.getText();
            for (int i = 0; i < 10; i++) {
                if (usuarios[i].getUser().equals(username2)) {
                    Same = usuarios[i].getUser();
                    
                }
            }
            if (contadorUsuarios == 10) {
                JOptionPane.showMessageDialog(this, "Se ha llegado al límite de usuarios", "Límite Máximo", JOptionPane.WARNING_MESSAGE);
            } else if (username2.equals(Same)) {
                JOptionPane.showMessageDialog(this, "Ya existe el mismo usuario", "Error", JOptionPane.WARNING_MESSAGE);
            }  else if (!passwordR.equals(confpasswordR)) {
                JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden");
            } else {
                usuarios[contadorUsuarios] = new Usuario(nombre2, username2, passwordR);
                contadorUsuarios++;
                JOptionPane.showMessageDialog(this, "Usuario registrado");
                VentanaPrincipal ventana = new VentanaPrincipal(usuarios, contadorUsuarios);
                ventana.setVisible(true);
                this.dispose();
            }
                
        } else if (ae.getSource() == recuperar) {
            username1 = username_T.getText();
            password1 = password_T.getText();
            for (int i = 0; i < usuarios.length; i++) {
                if (usuarios[i].getUser().equals(username1)) {
                    recuperarPass = i;
                }
            }
            if (recuperarPass != -1) {
                JOptionPane.showMessageDialog(this, "La contraseña del usuario " + usuarios[recuperarPass].getUser() + " es: " + usuarios[recuperarPass].getPass());
            } else if (recuperarPass == -1) {
                JOptionPane.showMessageDialog(this, "No existe este usuario");
            }
        }
    }
    
    
}
