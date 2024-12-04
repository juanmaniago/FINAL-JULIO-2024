package Excepciones;

public class CamposEventoIncompletosExcepcion extends RuntimeException {
    public CamposEventoIncompletosExcepcion() {
        super("Error: falta completar un campo del evento");
    }
}
