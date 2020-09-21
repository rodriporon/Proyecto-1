package proyecto_1;

/**
 *
 * @author Rodrigo Porón
 */
public class Proyecto_1 {
    
    //public static String[] datos = new String[10];
    public static Usuario[] usuarios = new Usuario[10];
    public static int contadorusuarios = 1;
    public static Clientes[] clientes = new Clientes[100];
    public static int contadorclientes = 0;
    public static Productos[] productos = new Productos[100];
    public static int contadorproductos = 0;
    public static Ventas[] ventas = new Ventas[100];
    public static int contadorventas;
    
    public static void main(String[] args) {
        
        
        usuarios[0] = new Usuario("Rodrigo Porón","admin","admin");
        for (int i = 1; i < 10; i++) {
            usuarios[i] = new Usuario(); 
        }
        
        for (int i = 0; i < 100; i++) {
            clientes[i] = new Clientes();
        }
        
        for (int i = 0; i < 100; i++) {
            productos[i] = new Productos();
        }
        for (int i = 0; i < 100; i++) {
            ventas[i] = new Ventas();
        }
        VentanaPrincipal ventanaprincipal = new VentanaPrincipal(usuarios, contadorusuarios, clientes, contadorclientes, productos, contadorproductos, ventas, contadorventas);
        ventanaprincipal.setVisible(true);
        
    }
    
}

