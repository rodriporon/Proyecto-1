package proyecto_1;

/**
 *
 * @author Rodrigo Porón
 */
public class Usuario {
    
    private String nombre;
    private String user;
    private String pass;
    
    public Usuario(){
        nombre = "";
        user = "";
        pass = "";
    }

    public Usuario(String nombre, String user, String pass) {
        this.nombre = nombre;
        this.user = user;
        this.pass = pass;
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
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }
    
    
    
}
