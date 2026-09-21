package ficherosio;
import java.io.File;

import javax.swing.JFileChooser;

/** @author ANDRE PAZO */

public class Ejercico2 {
    public static void main(String[] args) {
        File directorio = null;
        JFileChooser selector = new JFileChooser();
        selector.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        // selector.setCurrentDirectory(new File(System.getProperty("user.dir")));

        directorio = (selector.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
                ? selector.getSelectedFile()
                : null;

        if (directorio == null) {
            System.out.println("Seleccion cancelada.");
            return;
        }

        File[] archivos = directorio.listFiles();
        if (archivos == null) {
            System.out.println("No se pudo listar el contenido.");
            return;
        }

        System.out.println(directorio.getName().toUpperCase() 
            + " (" + directorio.getAbsolutePath() +  "):");
        for (File f : directorio.listFiles()) {
            System.out.printf("%30s %10d bytes   %s%n",
                    f.getName(),
                    f.length(),
                    f.isDirectory() ? "Directorio" : "Archivo");
        }
    }
}
