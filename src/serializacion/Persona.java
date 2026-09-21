package serializacion;

import java.io.Serializable;
import java.time.LocalDate;

public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
   
    private String nombre;
    private LocalDate nacimiento;
    private transient String contrasenia;

    
    public Persona(String nombre, LocalDate nacimiento, String contrasenia) {
        this.nombre = nombre;
        this.nacimiento = nacimiento;
        this.contrasenia = contrasenia;
    }


    @Override
    public String toString() {
        return "Persona [nombre=" + nombre + ", nacimiento=" + nacimiento + ", contrasenia=" + contrasenia + "]";
    } 

    
}