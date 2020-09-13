
package proyecto_1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.io.File;
import javax.swing.*;


public class CrearCliente extends JFrame implements ActionListener{
    
    public JComboBox<String> box1;
    public JTextField text1, text2, text3, text4;
    public JButton avatar, guardar;
    public File rutaavatar;
    public String nombre, sexo, nit;
    public int edad;
    
    public Clientes[] clientes;
    public int contadorclientes;
    
    public CrearCliente(Clientes[] clientes, int contadorclientes){
        
        this.clientes = clientes;
        this.contadorclientes = contadorclientes;
        
        this.setSize(500,300);
        this.setLocationRelativeTo(null);
        this.setTitle("Crear nuevo Cliente");
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        
        JLabel etiqueta1 = new JLabel("Nombre");
        etiqueta1.setBounds(40,40,50,20);
        this.add(etiqueta1);
        
        text1 = new JTextField();
        text1.setBounds(110,40,200,20);
        this.add(text1);
        
        JLabel etiqueta2 = new JLabel("Edad:");
        etiqueta2.setBounds(40,70,50,20);
        this.add(etiqueta2);
        
        
        text2 = new JTextField();
        text2.setBounds(110,70,200,20);
        this.add(text2);
        
        JLabel etiqueta3 = new JLabel("Sexo:");
        etiqueta3.setBounds(40,100,50,20);
        this.add(etiqueta3);
        
        String [] sexocombo = {"", "M","F"};
        box1 = new JComboBox<String>(sexocombo);
        box1.setBounds(110,100,80,20);
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
        etiqueta4.setBounds(40,130,50,20);
        this.add(etiqueta4);
        
        text4 = new JTextField();
        text4.setBounds(110,130,200,20);
        this.add(text4);
        
        JLabel etiqueta5 = new JLabel("Avatar:");
        etiqueta5.setBounds(40,160,50,20);
        this.add(etiqueta5);
        
        avatar = new JButton("Seleccionar");
        avatar.setBounds(110,160,110,20);
        avatar.addActionListener(this);
        this.add(avatar);
        
        guardar = new JButton("Guardar");
        guardar.setBounds(350,100,110,20);
        guardar.addActionListener(this);
        this.add(guardar);
        
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
        if (ae.getSource() == avatar) {
            
            JFileChooser fc = new JFileChooser();
            int op = fc.showOpenDialog(this);
            if (op == JFileChooser.APPROVE_OPTION) {
                rutaavatar = fc.getSelectedFile();
                System.out.println(rutaavatar);
            }
        } else if (ae.getSource() == guardar) {
            nombre = text1.getText();
            edad = Integer.parseInt(text2.getText());
            nit = text4.getText();
            clientes[contadorclientes] = new Clientes(nombre, edad, sexo, nit, rutaavatar);
            contadorclientes++;
            JOptionPane.showMessageDialog(this, "Cliente Registrado");
            CrearCliente ventana = new CrearCliente(clientes, contadorclientes);
            ventana.setVisible(true);
            this.dispose();
        }
    }
    
}
