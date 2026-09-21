package serializacion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class FlujosSerializado {
    public static void main(String[] args) {
        Persona persona1 = new Persona(
                "Pepe",
                LocalDate.of(2000, 3, 1),
                "123abc");
        Persona persona2 = new Persona(
                "Ana",
                LocalDate.of(1973, 4, 1),
                "abc123");

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("pruebas/personas.dat"))) {

            out.writeObject(persona1);
            out.writeObject(persona2);

        } catch (FileNotFoundException e) {
            System.out.println();
        } catch (IOException e) {
            System.out.println();
        } catch (NullPointerException e) {
            System.out.println();
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("pruebas/personas.dat"))) {

            Persona persona3 = (Persona) in.readObject();
            Persona persona4 = (Persona) in.readObject();
            System.out.println(persona3.toString());
            System.out.println(persona4.toString());

        } catch (FileNotFoundException e) {
            System.out.println();
        } catch (IOException e) {
            System.out.println();
        } catch (NullPointerException e) {
            System.out.println();
        } catch (ClassNotFoundException e) {
            System.out.println();
        }
    }
}
