package flujos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/** @author ANDRE PAZO */
public class ComparadorFicheros {
    public static final String RUTA1 = "pruebas/ComparadorFicheros1.txt";
    public static final String RUTA2 = "pruebas/ComparadorFicheros2.txt";

    public static void main(String[] args) {
        try (BufferedReader in1 = new BufferedReader(new FileReader(RUTA1));
                BufferedReader in2 = new BufferedReader(new FileReader(RUTA2))) {

            int numLinea = 0;

            while (true) {
                String linea1 = in1.readLine();
                String linea2 = in2.readLine();
                numLinea++;

                if (linea1 == null && linea2 == null) {
                    System.out.println("Son exactamente iguales");
                    return;
                }

                if (linea1 == null || linea2 == null) {
                    System.out.println("No son iguales en: " + numLinea + "/1");
                    return;
                }

                if (!linea1.equals(linea2)) {
                    int min = Math.min(linea1.length(), linea2.length());
                    int numColumna = min + 1;

                    for (int i = 0; i < min; i++) {
                        if (linea1.charAt(i) != linea2.charAt(i)) {
                            numColumna = i + 1;
                            break;
                        }
                    }

                    System.out.println("No son iguales en: " + numLinea + "/" + numColumna);
                    return;
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de E/S: " + e.getMessage());
        }
    }
}