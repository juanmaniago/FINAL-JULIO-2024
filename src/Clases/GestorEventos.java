package Clases;

import Enums.TipoEvento;
import Excepciones.CamposEventoIncompletosExcepcion;
import Excepciones.EventoRepetidoExcepcion;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class GestorEventos extends GestorColecciones<Evento> {


    public boolean eventoExiste(Evento evento) {
        boolean existe = false;
        for(Evento e : elementos){
            if(evento.equals(e)){
                existe = true;
            }
        }
        return existe;
    }
    public int devolverCantidadEventos(){
        return obtenerTamanioSet();
    }
    public boolean eliminarEvento(Evento evento){
       return eliminar(evento);
    }

    public JSONArray toJson(){
        JSONArray arr = new JSONArray();
        for (Evento e : elementos){
            JSONObject obj = e.toJson();
            arr.put(obj);
        }
        return arr;
    }
}
