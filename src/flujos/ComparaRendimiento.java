package flujos;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/** @author ANDRE PAZO */
public class ComparaRendimiento {

    public static final String RUTA1= "pruebas/ComparaRendimientoDirecto.dat";
    public static final String RUTA2 = "pruebas/ComparaRendimientoBuffer.dat";
    public static final int NUM_BYTES_DEFECTO = 1_000_000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Numero de bytes a escribir (Enter para " + NUM_BYTES_DEFECTO + "): ");
        String entrada = sc.nextLine();
        sc.close();

        int numBytes = entrada.isBlank() ? NUM_BYTES_DEFECTO : Integer.parseInt(entrada);

        long tiempoDirecto = escribirSinBuffer(numBytes);
        long tiempoBuffer = escribirConBuffer(numBytes);

        System.out.println("Sin buffer: " + tiempoDirecto + " ns");
        System.out.println("Con buffer: " + tiempoBuffer + " ns");
    }

    private static long escribirSinBuffer(int numBytes) {
        long inicio = System.nanoTime();

        try (FileOutputStream out = new FileOutputStream(RUTA1)) {
            for (int i = 0; i < numBytes; i++) {
                out.write(0);
            }
        } catch (IOException e) {
            System.out.println("Error de E/S: " + e.getMessage());
        }

        return System.nanoTime() - inicio;
    }

    private static long escribirConBuffer(int numBytes) {
        long inicio = System.nanoTime();

        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(RUTA2))) {
            for (int i = 0; i < numBytes; i++) {
                out.write(0);
            }
        } catch (IOException e) {
            System.out.println("Error de E/S: " + e.getMessage());
        }

        return System.nanoTime() - inicio;
    }
}