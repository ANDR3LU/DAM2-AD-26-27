package flujos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/** @author ANDRE PAZO */
public class AnalisisTexto {
    public static final String RUTA = "pruebas/pruebaContador.txt";

    public static void main(String[] args) {
        int vocales = 0;
        int consonantes = 0;
        int digitos = 0;
        int blanco = 0;

        try (BufferedReader in = new BufferedReader(new FileReader(RUTA))) {

            int c;
            while ((c = in.read()) != -1) {
                char ch = (char) c;

                if (Character.isDigit(ch)) {
                    digitos++;
                } else if (Character.isWhitespace(ch)) {
                    blanco++;
                } else if (Character.isLetter(ch)) {
                    String vocalesStr = "aeiouAEIOUáéíóúÁÉÍÓÚ";
                    if (vocalesStr.indexOf(ch) != -1) {
                        vocales++;
                    } else {
                        consonantes++;
                    }
                }
            }

            System.out.println("Vocales: " + vocales);
            System.out.println("Consonantes: " + consonantes);
            System.out.println("Digitos: " + digitos);
            System.out.println("Espacios en blanco: " + blanco);

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de E/S: " + e.getMessage());
        }
    }
}
