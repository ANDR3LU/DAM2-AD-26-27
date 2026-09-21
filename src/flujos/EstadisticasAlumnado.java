package flujos;

import java.io.BufferedReader;
import java.io.FileReader;

public class EstadisticasAlumnado {
    public static final String RUTA = "pruebas/EstadisticasAlumnado.txt";

    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new FileReader(RUTA))) {
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
