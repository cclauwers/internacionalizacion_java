
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
public class Contacto {
  
    private String nombre;
    private int telefono;


    public Contacto(String nombre, int telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public Contacto(String nombre) {
        this.nombre = nombre;
        this.telefono = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public boolean equals(Contacto c){

        if(this.nombre.trim().equalsIgnoreCase(c.getNombre().trim())){
            return true;
        }
        return false;

    }

    @Override
    public String toString() {
        return java.text.MessageFormat.format(java.util.ResourceBundle.getBundle("Bundle").getString("nombre={0}, telefono={1}"), new Object[] {nombre, telefono});
    }
}

