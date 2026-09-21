package flujos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/** @author ANDRE PAZO */
public class RegistroAlumnado {

    private static final String FICHERO = "pruebas/RegistroAlumnado.txt";
    private static final int NUM_ALUMNOS = 1000;

    public static void main(String[] args) {
        Random rnd = new Random();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FICHERO))) {
            for (int i = 1; i <= NUM_ALUMNOS; i++) {
                double nota = rnd.nextDouble(10);
                // bw.write("Alumno_" + i + ";" + nota);
                bw.write(String.format("Alumno_%d;%.2f", i, nota));
                bw.newLine();
            }
            System.out.println("Fichero " + FICHERO + " generado con " + NUM_ALUMNOS + " líneas");
        } catch (IOException e) {
            System.err.println("Error de entrada/salida: " + e.getMessage());
        }
    }
}