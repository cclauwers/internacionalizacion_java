
import java.util.Locale;
import java.util.ResourceBundle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ccc7
 */
public class Agenda {
  //Atributos
    private Contacto[] contactos;
    
    //Constructores
    public Agenda() {
        this.contactos = new Contacto[10]; //por defecto
    }

    public Agenda(int tamanio) {
        this.contactos = new Contacto[tamanio]; //tamaño que nosotros queramos
    }

    //Metodos
    /**
     * Añade un contacto a la agenda
     *
     * @param c
     */
    public void aniadirContacto(Contacto c,Locale currentLocale) {

        if (existeContacto(c)) { //Indico si existe el contacto
            System.out.println(java.util.ResourceBundle.getBundle("Bundle",currentLocale).getString("El contacto con ese nombre ya existe"));
        } else if (agendaLlena()) { //Indico si la agenda esta o no llena
            System.out.println(java.util.ResourceBundle.getBundle("Bundle",currentLocale).getString("La agenda esta llena, no se pueden meter mas contactos"));
        } else {

            boolean encontrado = false;
            for (int i = 0; i < contactos.length && !encontrado; i++) {
                if (contactos[i] == null) { //controlo los nulos
                    contactos[i] = c; //Inserto el contacto
                    encontrado = true; //Indico que lo he encontrado
                }
            }

            if (encontrado) {
                System.out.println(java.util.ResourceBundle.getBundle("Bundle",currentLocale).getString("Se ha añadido"));
            } else {
                System.out.println(java.util.ResourceBundle.getBundle("Bundle",currentLocale).getString("No se ha podido añadir"));
            }
        }

    }

    /**
     * Indica si existe un contacto
     *
     * @param c
     * @return
     */
    public boolean existeContacto(Contacto c) {

        for (int i = 0; i < contactos.length; i++) {
            //Controlo nulos e indico si el contacto es el mismo
            if (contactos[i] != null && c.equals(contactos[i])) {
                return true;
            }
        }
        return false;

    }

    /**
     * Lista los contactos de la agenda
     */
    public void listarContactos(Locale currentLocale) {

        if (huecosLibre() == contactos.length) {
            System.out.println(java.util.ResourceBundle.getBundle("Bundle",currentLocale).getString("No hay contactos que mostrar"));
        } else {
            for (int i = 0; i < contactos.length; i++) {
                if (contactos[i] != null) { //Controlo nulos
                    System.out.println(contactos[i]);
                }
            }
        }

    }


    /**
     * Indica si la agenda esta llena o no
     *
     * @return
     */
    public boolean agendaLlena() {

        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] == null) { //Controlo nulos
                return false; //indico que no esta llena
            }
        }

        return true; //esta llena

    }

    /**
     * Elimina el contacto de la agenda
     *
     * @param c
     */
    public void eliminarContacto(Contacto c,Locale currentLocale) {

        boolean encontrado = false;
        for (int i = 0; i < contactos.length && !encontrado; i++) {
            if (contactos[i] != null && contactos[i].equals(c)) {
                contactos[i] = null; //Controlo nulos
                encontrado = true; //Indico que lo he encontrado
            }
        }

        if (encontrado) {
            System.out.println(java.util.ResourceBundle.getBundle("Bundle",currentLocale).getString("Se ha eliminado el contacto"));
        } else {
            System.out.println(java.util.ResourceBundle.getBundle("Bundle",currentLocale).getString("No se ha eliminado el contacto"));

        }
    }

    /**
     * Indica cuantos contactos más podemos meter
     *
     * @return
     */
    public int huecosLibre() {

        int contadorLibres = 0;
        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] == null) { //Controlo nulos
                contadorLibres++; //Acumulo
            }
        }
        return contadorLibres;

    }

  

}
