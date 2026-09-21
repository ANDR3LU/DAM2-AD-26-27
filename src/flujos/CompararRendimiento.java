import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class ComparaRendimiento {

    private static final int BYTES_POR_DEFECTO = 1_000_000;

    public static void main(String[] args) {
        int n = leerNumeroBytes();
        Path fichero = null;
        try {
            fichero = Files.createTempFile("rendimiento", ".bin");

            long tDirecto = escribirDirecto(fichero, n);
            long tBuffer = escribirConBuffer(fichero, n);

            // TODO: mostrar tiempos en ms y la relación entre ambos
         } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de E/S: " + e.getMessage());
        }  // TODO: borrar el fichero temporal si existe
