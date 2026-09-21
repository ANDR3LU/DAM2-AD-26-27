package flujos;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/** @author ANDRE PAZO */
public class CifradoBinario {

    public static final String RUTA_ORIGINAL = "pruebas/CifradoBinarioOriginal.dat";
    public static final String RUTA_CIFRADO = "pruebas/CifradoBinarioCifrado.dat";
    public static final String RUTA_DESCIFRADO = "pruebas/CifradoBinarioDescifrado.dat";

    public static void main(String[] args) {
        cifrar(RUTA_ORIGINAL, RUTA_CIFRADO);
        cifrar(RUTA_CIFRADO, RUTA_DESCIFRADO);
    }

    private static void cifrar(String rutaEntrada, String rutaSalida) {
        try (
                BufferedInputStream in = new BufferedInputStream(new FileInputStream(rutaEntrada));
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(rutaSalida))) {
                    
            int b;
            while ((b = in.read()) != -1) {
                out.write(~b);
            }
            System.out.println("Generado " + rutaSalida);

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de E/S: " + e.getMessage());
        }
    }
}