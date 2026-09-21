package flujos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/** @author ANDRE PAZO */
public class LineasNumeradas {
    public static final String RUTA_ENTRADA = "pruebas/LineasNumeradasIn.txt";
    public static final String RUTA_SALIDA = "pruebas/LineasNumeradasOut.txt";

    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new FileReader(RUTA_ENTRADA));
                BufferedWriter out = new BufferedWriter(new FileWriter(RUTA_SALIDA))) {

            String linea;
            int c = 1;
            while ((linea = in.readLine()) != null) {
                out.write(c + ": " + linea);
                out.newLine();
                c++;
            }

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de E/S: " + e.getMessage());
        }
    }
}
