package ficherosio;
import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class EjInformacionFichero {
    public static void main(String[] args) {
        String ruta = "F:/DAM3/ADAT";
        // Para formatear la fecha de modificacion con el formato dd de mes de año en
        // español
        SimpleDateFormat formateador = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy", new Locale("es", "ES"));
        File f = new File(ruta);
        if (f.exists()) {

            System.out.println("\n\tNombre: " + f.getName());
            System.out.println("\tTamaño: " + f.length() + " bytes");
            System.out.println("\tRuta absoluta: " + f.getAbsolutePath());
            System.out.println("\tPuede leerse: " + f.canRead());
            System.out.println("\tPuede modificar: " + f.canWrite());
            System.out.println("\tEs archivo: " + f.isFile());
            System.out.println("\tEs oculto: " + f.isHidden());
            System.out.println("\tModificado por última vez: " +
                    formateador.format(new Date(f.lastModified())));
            System.out.println("\tEs directorio: " + f.isDirectory());

            if (f.isDirectory()) {
                System.out.println("\n- ----Contenido del directorio: " + ruta + "- -------");
                /* El método list() devuelve un array con el contenido de un directorio */
                String[] lista = f.list();
                for (int i = 0; i < lista.length; i++) {
                    System.out.println(ruta + "/" + lista[i]);
                }
            }

        } else {

            System.out.println("El " + ruta + " no existe");

        }

    }
}