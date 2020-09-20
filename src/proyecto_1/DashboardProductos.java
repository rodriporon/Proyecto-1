package proyecto_1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class DashboardProductos extends JFrame implements ActionListener{
    
    public JButton regresar;
    public int rango1 = 0, rango2 = 0, rango3 = 0, rango4 = 0, rango5 = 0;
    public JPanel gpanel, bpanel;
    JTable tablac;
    JScrollPane mibarra, scroll;
    public Usuario[] usuarios;
    public int contadorusuarios;
    
    public Clientes[] clientes;
    public int contadorclientes;
    
    public Productos[] productos;
    public int contadorproductos;
    
    public DashboardProductos(Usuario[] usuarios, int contadorusuarios, Clientes[] clientes, int contadorclientes, Productos[] productos, int contadorproductos){
        
        this.productos = productos;
        this.contadorproductos = contadorproductos;
        this.usuarios = usuarios;
        this.contadorusuarios = contadorusuarios;
        this.clientes = clientes;
        this.contadorclientes = contadorclientes;
        
        this.setSize(1300,1000);
        this.setLocationRelativeTo(null);
        this.setTitle("Dashboard de Productos");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        
        //recorrerProductos();
        graficaBarras();
        inicializarComponentes();
        construirTabla();
        botones();
    }
    
    public void recorrerProductos(){
        for (int i = 0; i < productos.length; i++) {
            System.out.println("Nombre: " + productos[i].getNombre());
        }
    }
    
    public void construirTabla(){
        String[] nombreColumnas = {"Nombre", "Precio", "Cantidad"};
        String[][] data = obtenerMatriz();
                
        tablac = new JTable(data, nombreColumnas);
        mibarra.setViewportView(tablac);
    }
    public String[][] obtenerMatriz(){
        
        String matrizInfo[][] = new String[contadorproductos][3];
        for (int i = 0; i < contadorproductos; i++) {
            matrizInfo[i][0] = productos[i].getNombre()+"";
            matrizInfo[i][1] = productos[i].getPrecio()+"";
            matrizInfo[i][2] = productos[i].getCantidad()+"";
                        
        }
        return matrizInfo;
    }
    
    public void graficaBarras(){
        for (int i = 0; i < productos.length; i++) {
            if (productos[i].getPrecio() >= 1 && productos[i].getPrecio() < 500) {
                rango1++;
            } else if (productos[i].getPrecio() >= 500 && productos[i].getPrecio() < 1000) {
                rango2++;
            } else if (productos[i].getPrecio() >= 1000 && productos[i].getPrecio() < 1500) {
                rango3++;
            } else if (productos[i].getPrecio() >= 1500 && productos[i].getPrecio() < 2000) {
                rango4++;
            } else if (productos[i].getPrecio() >= 2000) {
                rango5++;
            } 
        }
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        String title = "No. de productos";
        dataset.addValue(rango1, title, "1-499");
        
        dataset.addValue(rango2, title, "500-999");
        dataset.addValue(rango3, title, "1000-1499");
        dataset.addValue(rango4, title, "1500-1999");
        dataset.addValue(rango5, title, "2000-más");
        
        JFreeChart barChart = ChartFactory.createBarChart("Grafica de Rango Precios","","No. de Productos", dataset, PlotOrientation.VERTICAL, true, true, false);
        
        ChartPanel panel = new ChartPanel(barChart);
        bpanel = new JPanel();
        this.getContentPane().add(bpanel);
        //gpanel.setLayout(null);
        bpanel.setBounds(620,240,660,400);
        bpanel.add(panel);
    }
    
    public void botones(){
        regresar = new JButton("Regresar");
        regresar.setBounds(800,30,110,20);
        regresar.addActionListener(this);
        this.add(regresar);
    }
    
    public void inicializarComponentes(){
        getContentPane().setLayout(null);
        
        Label labelTitulo = new Label();
        labelTitulo.setBounds(10,10,400,30);
        labelTitulo.setAlignment(SwingConstants.CENTER);
        labelTitulo.setText("Productos");
        getContentPane().add(labelTitulo);
        
        mibarra = new JScrollPane();
        mibarra.setBounds(10,40,600,200);
        add(mibarra);
        

    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == regresar) {
            AdministracionProductos ventana = new AdministracionProductos(usuarios, contadorusuarios, clientes, contadorclientes, productos, contadorproductos);
            ventana.setVisible(true);
            this.dispose();
        }
        
        
    }
    
    
    
}
