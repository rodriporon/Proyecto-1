package proyecto_1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class ModificarCliente extends JFrame implements ActionListener {
    
    public JComboBox<String> box1;
    public JTextField text1, text2, text3, text4, tnit;
    public JButton avatar, modificar, regresar, buscar;
    public File rutaavatar;
    public String nombre, sexo, nit, verificarnit, avatarruta;
    public int edad, nitLocat, doblei;
    
    public Clientes[] clientes;
    public int contadorclientes;
    
    public Usuario[] usuarios;
    public int contadorusuarios;
    
    public ModificarCliente(Usuario[] usuarios, int contadorusuarios, Clientes[] clientes, int contadorclientes){
        this.usuarios = usuarios;
        this.contadorusuarios = contadorusuarios;
        this.clientes = clientes;
        this.contadorclientes = contadorclientes;
        
        this.setSize(500,500);
        this.setLocationRelativeTo(null);
        this.setTitle("Editar Cliente");
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        
        JLabel labelnit = new JLabel("Ingrese el nit del cliente:");
        labelnit.setBounds(10,30,200,20);
        this.add(labelnit);
        
        tnit = new JTextField();
        tnit.setBounds(10,60,90,20);
        this.add(tnit);
        
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
        
        JLabel etiqueta2 = new JLabel("Edad:");
        etiqueta2.setBounds(40,130,50,20);
        this.add(etiqueta2);
        
        
        text2 = new JTextField();
        text2.setBounds(110,130,200,20);
        this.add(text2);
        
        JLabel etiqueta3 = new JLabel("Sexo:");
        etiqueta3.setBounds(40,160,50,20);
        this.add(etiqueta3);
        
        String [] sexocombo = {"", "M","F"};
        box1 = new JComboBox<String>(sexocombo);
        box1.setBounds(110,160,80,20);
        //box1.addItem("M");
        //box1.addItem("F");
        
        box1.addItemListener(event -> {
            if (event.getStateChange() == ItemEvent.SELECTED) {
                sexo = event.getItem().toString();
            }
        });
        System.out.println(sexo);
        this.add(box1);
        
        JLabel etiqueta4 = new JLabel("NIT:");
        etiqueta4.setBounds(40,190,50,20);
        this.add(etiqueta4);
        
        text4 = new JTextField();
        text4.setBounds(110,190,200,20);
        this.add(text4);
        
        JLabel etiqueta5 = new JLabel("Avatar:");
        etiqueta5.setBounds(40,220,50,20);
        this.add(etiqueta5);
        
        avatar = new JButton("Seleccionar");
        avatar.setBounds(110,220,110,20);
        avatar.addActionListener(this);
        this.add(avatar);
        
        modificar = new JButton("Modificar");
        modificar.setBounds(350,160,110,20);
        modificar.addActionListener(this);
        this.add(modificar);
        
        regresar = new JButton("Regresar");
        regresar.setBounds(350,10,110,20);
        regresar.addActionListener(this);
        this.add(regresar);
        
        
        
        RecorrerClientes();
        
    }
    public void RecorrerClientes(){
        for (int i = 0; i < clientes.length; i++) {
            System.out.print("Nombre: " + clientes[i].getNombre());
            System.out.print(", Edad: " + clientes[i].getEdad());
            System.out.print(", Sexo: " + clientes[i].getSexo());
            System.out.print(", NIT: " + clientes[i].getNIT());
            System.out.print(", Avatar: " + clientes[i].getAvatar());
            System.out.println();
        }
    }
        
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == regresar) {
            AdministracionClientes ventana = new AdministracionClientes(usuarios, contadorusuarios, clientes, contadorclientes);
            ventana.setVisible(true);
            this.dispose();
        } else if (ae.getSource() == buscar) {
            verificarnit = tnit.getText();
            for (int i = 0; i < contadorclientes; i++) {
                if (clientes[i].getNIT().equals(verificarnit)) {
                    nitLocat = i;
                    System.out.println("Se encontró el cliente en la pos: " + nitLocat);
                } 
            }
            text1.setText(clientes[nitLocat].getNombre());
            text2.setText(String.valueOf(clientes[nitLocat].getEdad()));
            text4.setText(clientes[nitLocat].getNIT());
            box1.setSelectedItem(clientes[nitLocat].getSexo());
        } else if (ae.getSource() == modificar) {
            nombre = text1.getText();
            edad = Integer.parseInt(text2.getText());
            nit = text4.getText();
            for (int i = 0; i < clientes.length; i++) {
                if (clientes[i].getNIT().equals(nit) && i != nitLocat) {
                    doblei = i;
                    System.out.println("Se encontró otro nit igual");
                }
            }
            System.out.println(doblei);
            if (doblei != 0) {
                JOptionPane.showMessageDialog(this, "Este NIT ya existe", "NIT ya existente", JOptionPane.WARNING_MESSAGE);
                doblei = 0;
            } else if (doblei == 0) {
            clientes[nitLocat].setNombre(nombre);
            clientes[nitLocat].setEdad(edad);
            clientes[nitLocat].setSexo(sexo);
            clientes[nitLocat].setNIT(nit);
            clientes[nitLocat].setAvatar(avatarruta);
            JOptionPane.showMessageDialog(this, "Cliente modificado");
            }
            
                        
            
        } else if (ae.getSource() == avatar) {
            JFileChooser fc = new JFileChooser();
            int op = fc.showOpenDialog(this);
            if (op == JFileChooser.APPROVE_OPTION) {
                avatarruta = fc.getSelectedFile().toString();
                System.out.println(avatarruta);
            }
        }
    }
    
}
