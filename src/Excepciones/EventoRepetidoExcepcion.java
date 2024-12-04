package Excepciones;

public class EventoRepetidoExcepcion extends RuntimeException {
    public EventoRepetidoExcepcion() {
        super("Error: el evento que desea agregar ya ha sido agregado");
    }
}
