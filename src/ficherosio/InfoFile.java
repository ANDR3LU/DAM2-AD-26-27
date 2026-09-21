package ficherosio;
import java.io.*;

import static java.lang.System.out;



public class InfoFile {

   public static void main(String args[]) throws IOException {

       out.print("Raíz del sistema de ficheros");

       for (File raiz: File.listRoots()) {

           out.format("%s ", raiz);

       }

       out.println();

       for (String nome : args) {

           out.format("%n------%new File(%s)%n", nome);

           File f = new File(nome);

           out.format("toString(): %s%n", f);

           out.format("exists(): %b%n", f.exists());

           out.format("lastModified(): %tc%n", f.lastModified());

           out.format("isFile(): %b%n", f.isFile());

           out.format("isDirectory(): %b%n", f.isDirectory());

           out.format("isHidden(): %b%n", f.isHidden());

           out.format("canRead(): %b%n", f.canRead());

           out.format("canWrite(): %b%n", f.canWrite());

           out.format("canExecute(): %b%n", f.canExecute());

           out.format("isAbsolute(): %b%n", f.isAbsolute());

           out.format("length(): %d%n", f.length());

           out.format("getName(): %s%n", f.getName());

           out.format("getPath(): %s%n", f.getPath());

           out.format("getAbsolutePath(): %s%n", f.getAbsolutePath());

           out.format("getCanonicalPath(): %s%n", f.getCanonicalPath());

           out.format("getParent(): %s%n", f.getParent());

           out.format("toURI: %s%n", f.toURI());

       }

   }

}
