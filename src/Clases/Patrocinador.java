package Clases;

import org.json.JSONObject;

public class Patrocinador extends Asistente {
    private String producto;

    public Patrocinador(String nombre, String mail) {
        super(nombre, mail);
    }
    //Metodo para juegos para regalar productos
    public void regalarProducto(){
        System.out.println("Ha ganado el premio: " + producto);
    }
    @Override
    public JSONObject toJson(){
        JSONObject oj = new JSONObject();
        oj.put("nombre", getNombre());
        oj.put("mail", getMail());
        oj.put("producto", producto);
        return oj;
    }
    @Override
    public String toString() {
        return "\nPratocinador:\n" +
                "nombre:" + getNombre() + '\n' +
                "mail:" + getMail() + '\n' +
                "producto:" + producto + '\n' ;
    }
}
