package Clases;

import org.json.JSONObject;

public abstract class Asistente {
    private String nombre;
    private String mail;

    public Asistente(String nombre, String mail) {
        this.nombre = nombre;
        this.mail = mail;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    public abstract JSONObject toJson();
}
