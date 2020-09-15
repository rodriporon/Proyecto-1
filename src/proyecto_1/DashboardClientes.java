package proyecto_1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class DashboardClientes extends JFrame implements ActionListener{
    
    
    JTable tablac;
    JScrollPane mibarra, scroll;
    public ChartPanel panel;
    public int sexoM = 0, sexoF = 0, rango1 = 0, rango2 = 0, rango3 = 0, rango4 = 0, rango5 = 0;
    public JPanel gpanel, bpanel;
    public JButton regresar;
    
    public Usuario[] usuarios;
    public int contadorusuarios;
    
    public Clientes[] clientes;
    public int contadorclientes;

    public DashboardClientes(Usuario[] usuarios, int contadorusuarios, Clientes[] clientes, int contadorclientes) {
        
        this.usuarios = usuarios;
        this.contadorusuarios = contadorusuarios;
        
        this.clientes = clientes;
        this.contadorclientes = contadorclientes;
        
        this.setSize(1300,1000);
        this.setLocationRelativeTo(null);
        this.setTitle("Dashboard de Clientes");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        
        
        graficaPie();
        graficaBarras();
        inicializarComponentes();
        construirTabla();
        botones();

    }
    public void graficaBarras(){
        for (int i = 0; i < contadorclientes; i++) {
            if (clientes[i].getEdad() >= 1 && clientes[i].getEdad() <= 20) {
                rango1++;
            } else if (clientes[i].getEdad() >= 21 && clientes[i].getEdad() <= 40) {
                rango2++;
            } else if (clientes[i].getEdad() >= 41 && clientes[i].getEdad() <= 60) {
                rango3++;
            } else if (clientes[i].getEdad() >= 61 && clientes[i].getEdad() <= 80) {
                rango4++;
            } else if (clientes[i].getEdad() >= 81 && clientes[i].getEdad() <= 150) {
                rango5++;
            }
        }
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        String title = "No. clientes";
        dataset.addValue(rango1, title, "1-20");
        
        dataset.addValue(rango2, title, "21-40");
        dataset.addValue(rango3, title, "41-60");
        dataset.addValue(rango4, title, "61-80");
        dataset.addValue(rango5, title, "81-más");
        
        JFreeChart barChart = ChartFactory.createBarChart("Grafica de Rango Edad","","No. Clientes", dataset, PlotOrientation.VERTICAL, true, true, false);
        
        ChartPanel panel = new ChartPanel(barChart);
        bpanel = new JPanel();
        this.getContentPane().add(bpanel);
        //gpanel.setLayout(null);
        bpanel.setBounds(620,240,660,400);
        bpanel.add(panel);
    }
    public void graficaPie(){
        for (int i = 0; i < contadorclientes; i++) {
            if (clientes[i].getSexo().equals("M")) {
                sexoM++;
            } else if (clientes[i].getSexo().equals("F")) {
                sexoF++;
            }
        }
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Masculinos", new Double(sexoM));
        dataset.setValue("Femeninos", new Double(sexoF));
        
        JFreeChart chart = ChartFactory.createPieChart(
        "Sexo de los Clientes", dataset, true, true, false);
        
        panel = new ChartPanel(chart);
        gpanel = new JPanel();
        this.getContentPane().add(gpanel);
        //gpanel.setLayout(null);
        gpanel.setBounds(10,240,600,400);
        gpanel.add(panel);
        
    }
    public void botones(){
        regresar = new JButton("Regresar");
        regresar.setBounds(800,30,110,20);
        regresar.addActionListener(this);
        this.add(regresar);
    }
    
    public void construirTabla(){
        String[] nombreColumnas = {"Nombre", "Edad", "Sexo", "NIT"};
        String[][] data = obtenerMatriz();
                
        tablac = new JTable(data, nombreColumnas);
        mibarra.setViewportView(tablac);
    }
    
    public void inicializarComponentes(){
        getContentPane().setLayout(null);
        
        Label labelTitulo = new Label();
        labelTitulo.setBounds(10,10,400,30);
        labelTitulo.setAlignment(SwingConstants.CENTER);
        labelTitulo.setText("Clientes");
        getContentPane().add(labelTitulo);
        
        mibarra = new JScrollPane();
        mibarra.setBounds(10,40,600,200);
        add(mibarra);
        

    }
    
    
    public String[][] obtenerMatriz(){
        
        String matrizInfo[][] = new String[contadorclientes][4];
        for (int i = 0; i < contadorclientes; i++) {
            matrizInfo[i][0] = clientes[i].getNombre()+"";
            matrizInfo[i][1] = clientes[i].getEdad()+"";
            matrizInfo[i][2] = clientes[i].getSexo()+"";
            matrizInfo[i][3] = clientes[i].getNIT()+"";
            
        }
        return matrizInfo;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == regresar) {
            AdministracionClientes ventana = new AdministracionClientes(usuarios, contadorusuarios, clientes, contadorclientes);
            ventana.setVisible(true);
            this.dispose();
        }
    }
    
}
