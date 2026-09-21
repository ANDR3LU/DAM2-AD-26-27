package flujos;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

public class ParticipacionEnClase {
    public static void main(String[] args) {
        try (FileReader in = new FileReader("pruebas/alumnos.txt");
                FileWriter out = new FileWriter("pruebas/participaciones", true);) {

            List<String> alumnos = in.readAllLines();
            Random random = new Random();
            String alumnoSeleccionado = alumnos.get(random.nextInt(alumnos.size()));
            System.out.println(alumnoSeleccionado);

            out.write(alumnoSeleccionado + " (" +
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + ")\n");

        } catch (FileNotFoundException e) {
            System.out.println("El archivo no existe");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
        }
    }
}
