package Clases;

import Enums.TipoEvento;
import Excepciones.CamposEventoIncompletosExcepcion;
import Excepciones.EventoRepetidoExcepcion;

public class SistemaEventos {
    private GestorEventos eventos;

    public SistemaEventos() {
        this.eventos = new GestorEventos();
    }

    public GestorEventos getEventos() {
        return eventos;
    }

    public boolean agregarEvento(String nombre, String lugar, String horario, boolean requiereInscripcion, double inscripcion, int capMax, String fecha, TipoEvento tipo) throws EventoRepetidoExcepcion, CamposEventoIncompletosExcepcion {
        Evento e = new Evento(nombre, lugar, horario, requiereInscripcion, inscripcion, capMax, fecha, tipo);
        if (eventos.eventoExiste(e)){
            throw new EventoRepetidoExcepcion();
        }
        eventos.agregar(e);
        return true;
    }

    public boolean eliminar
}
