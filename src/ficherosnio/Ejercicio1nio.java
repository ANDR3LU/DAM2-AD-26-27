package ficherosnio;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/** @author ANDRE PAZO */

public class Ejercicio1nio {

    public static void main(String[] args) throws IOException{
        String ruta = "src/Prueba.txt";
        Path p = Path.of(ruta);

        if (Files.exists(p)) {
            System.out.println("Ruta absoluta: " + p.toAbsolutePath());
            System.out.println("Nombre: " + p.getFileName());
            System.out.println("Tamaño: " + Files.size(p) + " bin");
            System.out.println("Modificado por última vez: " + Files.getLastModifiedTime(p));
            System.out.println("Es directorio: " + (Files.isDirectory(p) ? "Directorio" : "Archivo"));
        } else {
            System.out.println("El archivo no existe. Creandolo...");
            try {
                Files.createFile(p);
            } catch (IOException e) {
                System.out.println("Error creando nuevo archivo: " + e.getMessage());
            }
        }

    }
}