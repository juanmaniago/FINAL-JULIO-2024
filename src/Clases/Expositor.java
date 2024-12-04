package Clases;

import Interfaces.PuedeParticiparJuegos;
import org.json.JSONObject;

import java.util.ArrayList;

public class Expositor extends Asistente implements PuedeParticiparJuegos{
    private String tema;


    public Expositor(String nombre, String mail, String tema) {
        super(nombre, mail);
        this.tema = tema;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    //metodo para jugar para ganar productos ofrecidos por los patrocinadores(usar interface para compartir con participante)

    @Override
    public void jugaYgana(Patrocinador patrocinador, boolean gana) {
        if(gana == true){
            System.out.println("El participante ha ganado.");
            patrocinador.regalarProducto();
        } else {
            System.out.println("El participante ha perdido. ");
        }
    }
    @Override
    public JSONObject toJson(){
        JSONObject oj = new JSONObject();
        oj.put("nombre", getNombre());
        oj.put("mail", getMail());
        oj.put("tema", tema);
        return oj;
    }
    @Override
    public String toString() {
        return "\nExpositor:\n" +
                "nombre:" + getNombre() + '\n' +
                "mail:" + getMail() + '\n' +
                "tema:" + tema + '\n' ;
    }
}
