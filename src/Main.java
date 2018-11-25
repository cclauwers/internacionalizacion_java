
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ccc7
 */
public class Main {
    private static final ResourceBundle rb= ResourceBundle.getBundle("Bundle");

    public static void main(String[] args) {
        String language = new String(args[0]);
        String country = new String(args[1]);
        Locale currentLocale = new Locale(language, country);

        Scanner sn = new Scanner(System.in);
        sn.useDelimiter("\n");
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario

        Agenda agendaTelefonica = new Agenda(3);
        String nombre;
        int telefono;

        Contacto c;

        while (!salir) {

            System.out.println(java.util.ResourceBundle.getBundle("Bundle", currentLocale).getString("1. Añadir contacto"));
            System.out.println(java.util.ResourceBundle.getBundle("Bundle", currentLocale).getString("2. Listar contactos"));
            System.out.println(java.util.ResourceBundle.getBundle("Bundle", currentLocale).getString("3. Eliminar contacto"));
            System.out.println(java.util.ResourceBundle.getBundle("Bundle", currentLocale).getString("4. Salir"));
            try {
                System.out.println(java.util.ResourceBundle.getBundle("Bundle", currentLocale).getString("Escribe una de las opciones"));
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:

                        //Pido valores
                        System.out.println(java.util.ResourceBundle.getBundle("Bundle", currentLocale).getString("Escribe un nombre"));
                        nombre = sn.next();

                        System.out.println(java.util.ResourceBundle.getBundle("Bundle", currentLocale).getString("Escribe un telefono"));
                        telefono = sn.nextInt();

                        //Creo el contacto
                        c = new Contacto(nombre, telefono);

                        agendaTelefonica.aniadirContacto(c,currentLocale);

                        break;
                    case 2:

                        agendaTelefonica.listarContactos( currentLocale);

                        break;


                    case 3:

                        //pido el nombre
                        System.out.println(java.util.ResourceBundle.getBundle("Bundle",currentLocale).getString("Escribe un nombre"));
                        nombre = sn.next();

                        //Creo el contacto auxiliar
                        c = new Contacto(nombre, 0);

                        agendaTelefonica.eliminarContacto(c,currentLocale);

                        break;

                    case 4:
                        salir = true;
                        break;
                    default:
                        System.out.println(java.util.ResourceBundle.getBundle("Bundle",currentLocale).getString("Solo números entre 1 y 4"));
                }

            } catch (InputMismatchException e) {
                System.out.println(java.util.ResourceBundle.getBundle("Bundle", currentLocale).getString("Debes insertar un número"));
                sn.next();
            }

        }

    }
}