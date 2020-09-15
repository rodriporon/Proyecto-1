package proyecto_1;

import java.io.File;


public class Clientes {
    
    private String nombre;
    private int edad;
    private String sexo;
    private String NIT;
    private String avatar;

    public Clientes(String nombre, int edad, String sexo, String NIT, String avatar) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.NIT = NIT;
        this.avatar = avatar;
    }

    Clientes() {
        this.nombre = "";
        this.edad = 0;
        this.sexo = "";
        this.NIT = "";
        this.avatar = null;
        
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
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the NIT
     */
    public String getNIT() {
        return NIT;
    }

    /**
     * @param NIT the NIT to set
     */
    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    /**
     * @return the avatar
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * @param avatar the avatar to set
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
