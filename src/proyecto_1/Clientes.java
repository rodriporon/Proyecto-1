package proyecto_1;

/**
 *
 * @author Rodrigo Porón
 */
public class Clientes {
    
    private String nombre;
    private int telefono;
    private int NIT;
    
    public Clientes() {
    
}

    public Clientes(String nombre, int telefono, int NIT) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.NIT = NIT;
    }
    
    
    

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the telefono
     */
    public int getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the NIT
     */
    public int getNIT() {
        return NIT;
    }

    /**
     * @param NIT the NIT to set
     */
    public void setNIT(int NIT) {
        this.NIT = NIT;
    }
    
}
