package flujos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/** @author ANDRE PAZO */
public class EstadisticasAlumnado {
    public static final String RUTA = "pruebas/RegistroAlumnado.txt";

    public static void main(String[] args) {
        double notaMedia = 0;
        double notaMin = 0;
        double notaMax = 0;
        int numAprobados = 0;
        String mejorAlumno = null;
        int numLineas = 0;

        try (BufferedReader in = new BufferedReader(new FileReader(RUTA))) {

            String linea;
            String[] alumno;
            double nota;
            while ((linea = in.readLine()) != null) {
                alumno = linea.split(";");
                nota = Double.parseDouble(alumno[1].replace("Nota_", ""));

                notaMedia = notaMedia + nota;

                if (nota > notaMax) {
                    notaMax = nota;
                    mejorAlumno = alumno[0];
                }

                if (nota < notaMin || notaMin == 0) {
                    notaMin = nota;
                }

                if (nota >= 5) {
                    numAprobados++;
                }

                numLineas++;
            }

            double notaMediaFinal = notaMedia / numLineas;
            System.out.println("Nota media: " + notaMediaFinal);
            System.out.println("Nota maxima: " + notaMax);
            System.out.println("Nota minima: " + notaMin);
            System.out.println("Aprobados: " + numAprobados);
            System.out.println("Mejor alumno: " + mejorAlumno);
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de E/S: " + e.getMessage());
        }
    }
}
