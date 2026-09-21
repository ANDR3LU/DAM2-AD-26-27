package ficherosio;

import java.io.File;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Ejercicio3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            opcion = leerOpcion(sc);

            switch (opcion) {
                case 1 -> crearDirectorio();
                case 2 -> listarRecursivo();
                case 3 -> eliminar();
                case 0 -> System.out.printf("Saliendo del programa");
                default -> System.out.printf("Opción no válida");
            }
            System.out.println();
        } while (opcion != 0);

        sc.close();
    }

    private static void mostrarMenu() {
        System.out.printf("%nGESTOR DE ARCHIVOS Y DIRECTORIOS%n");
        System.out.printf("1. Crear directorio%n");
        System.out.printf("2. Listar contenido recursivo%n");
        System.out.printf("3. Eliminar archivo o directorio%n");
        // System.out.printf("4. Mover / renombrar%n");
        System.out.printf("0. Salir%n");
        System.out.printf("Elige una opción: ");
    }

    private static int leerOpcion(Scanner sc) {
        if (!sc.hasNextInt()) {
            sc.next();
            return -1;
        }
        int op = sc.nextInt();
        sc.nextLine();
        return op;
    }

    private static void crearDirectorio() {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setDialogTitle("Selecciona donde crear el nuevo directorio");

        int resultado = chooser.showOpenDialog(null);

        if (resultado != JFileChooser.APPROVE_OPTION) {
            System.out.printf("Operacion cancelada por el usuario");
            return;
        }

        File padre = chooser.getSelectedFile();
        String nombre = JOptionPane.showInputDialog("Nombre del nuevo directorio:");

        if (nombre == null || nombre.isBlank()) {
            System.out.printf("No se ha indicado nombre valido. Operacion cancelada");
            return;
        }

        File nuevoDir = new File(padre, nombre);

        if (nuevoDir.mkdir()) {
            System.out.printf("Directorio creado correctamente: ", nuevoDir.getAbsolutePath());
        } else {
            System.out.printf("No se pudo crear el directorio",
                    nuevoDir.getAbsolutePath());
        }
    }

    private static void listarRecursivo() {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setDialogTitle("Selecciona el directorio a listar");

        int resultado = chooser.showOpenDialog(null);

        if (resultado != JFileChooser.APPROVE_OPTION) {
            System.out.printf("Operacion cancelada por el usuario");
            return;
        }

        File dir = chooser.getSelectedFile();
        System.out.printf("Contenido de ", dir.getAbsolutePath());
        listarRecursivo(dir, 0);
    }

    private static void listarRecursivo(File dir, int nivel) {
        File[] contenido = dir.listFiles();

        if (contenido == null) {
            System.out.printf("Error listando directorio");
            return;
        }

        for (File f : contenido) {
            System.out.println("  ".repeat(nivel) + f.getName());

            if (f.isDirectory()) {
                listarRecursivo(f, nivel + 1);
            }
        }
    }

    private static void eliminar() {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        chooser.setDialogTitle("Selecciona el archivo o directorio a eliminar");

        int resultado = chooser.showOpenDialog(null);

        if (resultado != JFileChooser.APPROVE_OPTION) {
            System.out.printf("Operación cancelada por el usuario.%n");
            return;
        }

        File seleccionado = chooser.getSelectedFile();

        int confirmacion = JOptionPane.showConfirmDialog(null,
                "¿Seguro que quieres eliminar " + seleccionado.getName() + " y todo su contenido?",
                "Confirmar eliminacion", JOptionPane.YES_NO_OPTION);

        if (confirmacion != JOptionPane.YES_OPTION) {
            System.out.printf("Eliminación cancelada.%n");
            return;
        }

        boolean exito = eliminarRecursivo(seleccionado);
        System.out.printf(exito ? "Eliminado correctamente: " : "No se pudo eliminar por completo: ",
                seleccionado.getAbsolutePath());
    }

    private static boolean eliminarRecursivo(File f) {
        if (f.isDirectory()) {
            File[] hijos = f.listFiles();
            if (hijos != null) {
                for (File hijo : hijos) {
                    eliminarRecursivo(hijo);
                }
            }
        }

        boolean borrado = f.delete();
        if (!borrado) {
            System.out.println("ERROR al borrar");
        }
        System.out.println("Borrado");

        return borrado;
    }

}