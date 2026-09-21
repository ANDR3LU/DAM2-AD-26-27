package flujos;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/** @author ANDRE PAZO */
public class ComparadorBinario {
    public static final String RUTA1 = "pruebas/CifradoBinarioOriginal.dat";
    public static final String RUTA2 = "pruebas/CifradoBinarioDescifrado.dat";

    public static void main(String[] args) {
        try (
                BufferedInputStream in1 = new BufferedInputStream(new FileInputStream(RUTA1));
                BufferedInputStream in2 = new BufferedInputStream(new FileInputStream(RUTA2))
        ) {
            int b1, b2;
            boolean iguales = true;

            do {
                b1 = in1.read();
                b2 = in2.read();

                if (b1 != b2) {
                    iguales = false;
                    break;
                }
            } while (b1 != -1);

            System.out.println("¿Son iguales? " + iguales);

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de E/S: " + e.getMessage());
        }
    }
}