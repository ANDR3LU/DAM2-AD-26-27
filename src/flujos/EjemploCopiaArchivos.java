package flujos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class EjemploCopiaArchivos {

    public static void main(String[] args) {
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            try {
                in = new FileInputStream("src/origen.txt");
                out = new FileOutputStream("src/destino.txt");
            } catch (FileNotFoundException e) {
                System.out.println("Error encontrando el archivo: " + e.getMessage());
            } 

            int c;
            try {
                while ((c = in.read()) != -1) {
                    out.write(c);
                }
            } catch (IOException e) {
                System.out.println("Error en la escritura del archivo: " + e.getMessage());
            }

        } finally { 
            if (in != null) {
                try {
                    in.close();
                    if (out != null) {
                        out.close();
                    }
                } catch (IOException e) {
                    System.out.println("Error cerrando los archivos: " + e.getMessage());
                }
            }

        }
    }
}
