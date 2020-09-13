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
    public static void main(String[] args) {
        
        
        usuarios[0] = new Usuario("Rodrigo Porón","admin","admin");
        for (int i = 1; i < 10; i++) {
            usuarios[i] = new Usuario(); 
        }
        
        for (int i = 0; i < 100; i++) {
            clientes[i] = new Clientes();
        }
        VentanaPrincipal ventanaprincipal = new VentanaPrincipal(usuarios, contadorusuarios, clientes, contadorclientes);
        ventanaprincipal.setVisible(true);
        
    }
    
}

