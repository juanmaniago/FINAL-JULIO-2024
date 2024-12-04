package Clases;

import Interfaces.PuedeParticiparJuegos;
import org.json.JSONObject;

public class Participante extends Asistente implements PuedeParticiparJuegos {
    private String direccion;
    private String sexo;

    public Participante(String nombre, String mail, String direccion, String sexo) {
        super(nombre, mail);
        this.direccion = direccion;
        this.sexo = sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    //metodo para jugar para ganar productos ofrecidos por los patrocinadores(usar interface para compartir con expositor)

    @Override
    public void jugaYgana(Patrocinador patrocinador,  boolean gana) {
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
        oj.put("direccion", direccion);
        oj.put("sexo", sexo);

        return oj;
    }
    @Override
    public String toString() {
        return "\nParticipante:\n" +
                "nombre:" + getNombre() + '\n' +
                "mail:" + getMail() + '\n' +
                "direccion:" + direccion + '\n' +
                "sexo:" + sexo + '\n' ;
    }

}
