package proyecto_1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

public class AdministracionClientes extends JFrame implements ActionListener {

    public JButton regresar, dashboard, carga, crear, info, modificar, eliminar;

    public Productos[] productos;
    public int contadorproductos;
    
    public Usuario[] usuarios;
    public int contadorUsuarios;

    public Clientes[] clientes;
    public int contadorclientes;

    public AdministracionClientes(Usuario[] usuarios, int contadorUsuarios, Clientes[] clientes, int contadorclientes, Productos[] productos, int contadorproductos) {

        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.setTitle("Administracion de Clientes");
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        this.productos = productos;
        this.contadorproductos = contadorproductos;
        this.usuarios = usuarios;
        this.contadorUsuarios = contadorUsuarios;
        this.clientes = clientes;
        this.contadorclientes = contadorclientes;

        regresar = new JButton("Regresar");
        regresar.setBounds(10, 10, 90, 20);
        regresar.addActionListener(this);
        this.add(regresar);

        dashboard = new JButton("Dashboard de Clientes");
        dashboard.setBounds(100, 50, 400, 60);
        dashboard.addActionListener(this);
        this.add(dashboard);

        carga = new JButton("Carga masiva de Clientes");
        carga.setBounds(100, 130, 400, 60);
        carga.addActionListener(this);
        this.add(carga);

        crear = new JButton("Crear Cliente");
        crear.setBounds(100, 210, 400, 60);
        crear.addActionListener(this);
        this.add(crear);

        info = new JButton("Información de Cliente");
        info.setBounds(100, 290, 400, 60);
        info.addActionListener(this);
        this.add(info);

        modificar = new JButton("Modificar Cliente");
        modificar.setBounds(100, 370, 190, 30);
        modificar.addActionListener(this);
        this.add(modificar);

        eliminar = new JButton("Eliminar Cliente");
        eliminar.setBounds(310, 370, 190, 30);
        eliminar.addActionListener(this);
        this.add(eliminar);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == regresar) {
            MenuPrincipal ventana = new MenuPrincipal(usuarios, contadorUsuarios, clientes, contadorclientes, productos, contadorproductos);
            ventana.setVisible(true);
            this.dispose();
        } else if (ae.getSource() == crear) {
            CrearCliente ventana = new CrearCliente(usuarios, contadorUsuarios, clientes, contadorclientes, productos, contadorproductos);
            ventana.setVisible(true);
            this.dispose();
        } else if (ae.getSource() == dashboard) {
            DashboardClientes ventana = new DashboardClientes(usuarios, contadorUsuarios, clientes, contadorclientes, productos, contadorproductos);
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
                    if (contadorclientes == 100) {
                        JOptionPane.showMessageDialog(this, "Se alcanzó el límite máximo de clientes" , "Límite máximo", JOptionPane.WARNING_MESSAGE);
                    } else {
                        while ((linea = br.readLine()) != null) {
                        String[] datos = linea.split(","); 
                        String nombre = datos[0];
                        int edad = Integer.parseInt(datos[1]);
                        String sexo = datos[2];
                        String NIT = datos[3];
                        String avatar = datos[4];
                                clientes[contadorclientes] = new Clientes();
                                clientes[contadorclientes].setNombre(nombre);
                                clientes[contadorclientes].setEdad(edad);
                                clientes[contadorclientes].setSexo(sexo);
                                clientes[contadorclientes].setNIT(NIT);
                                clientes[contadorclientes].setAvatar(avatar);
                                contadorclientes++;    
                    }     
                    }
                    
                } catch (Exception e) {
                    e.printStackTrace();
                
                }
            }

        } else if (ae.getSource() == info) {
            InformacionCliente ventana = new InformacionCliente(usuarios, contadorUsuarios, clientes, contadorclientes, productos, contadorproductos);
            ventana.setVisible(true);
            this.dispose();
        } else if (ae.getSource() == modificar) {
            ModificarCliente ventana = new ModificarCliente(usuarios, contadorUsuarios, clientes, contadorclientes, productos, contadorproductos);
            ventana.setVisible(true);
            this.dispose();
        } else if (ae.getSource() == eliminar) {
            EliminarCliente ventana = new EliminarCliente(usuarios, contadorUsuarios, clientes, contadorclientes, productos, contadorproductos);
            ventana.setVisible(true);
            this.dispose();
        }

    }

}
