package Clases;

import Enums.TipoEvento;
import Excepciones.CamposEventoIncompletosExcepcion;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;

public class Evento {
    private String nombre;
    private String lugar;
    private String horario;
    private ArrayList<String> organizadores;
    private boolean requiereInscripcion;
    private double inscripcion; //Si es gratis vale cero
    private int capacidadMax;
    private String fecha;
    private TipoEvento tipo;
    private GestorColecciones<Asistente> asistidores;

    public Evento(String nombre, String lugar, String horario, boolean requiereInscripcion, double inscripcion, int capacidadMax, String fecha, TipoEvento tipo) throws CamposEventoIncompletosExcepcion {
        if (nombre == null || lugar == null || horario == null || fecha == null) {
            throw new CamposEventoIncompletosExcepcion();
        }

        this.nombre = nombre;
        this.lugar = lugar;
        this.horario = horario;
        this.organizadores = new ArrayList<>();
        this.requiereInscripcion = requiereInscripcion;
        this.inscripcion = inscripcion;
        this.capacidadMax = capacidadMax;
        this.fecha = fecha;
        this.tipo = tipo;
        this.asistidores = new GestorColecciones<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public ArrayList<String> getOrganizadores() {
        return organizadores;
    }

    public void setOrganizadores(ArrayList<String> organizadores) {
        this.organizadores = organizadores;
    }

    public void agregarOrganizador(String nombre) {
        organizadores.add(nombre);
    }

    public boolean isRequiereInscripcion() {
        return requiereInscripcion;
    }

    public void setRequiereInscripcion(boolean requiereInscripcion) {
        this.requiereInscripcion = requiereInscripcion;
    }

    public int getCapacidadMax() {
        return capacidadMax;
    }

    public void setCapacidadMax(int capacidadMax) {
        this.capacidadMax = capacidadMax;
    }

    public double getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(double inscripcion) {
        this.inscripcion = inscripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public TipoEvento getTipo() {
        return tipo;
    }

    public void setTipo(TipoEvento tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Si es el mismo objeto, son iguales
        if (o == null || getClass() != o.getClass()) return false; // Si no son de la misma clase, no son iguales
        Evento evento = (Evento) o;
        return Objects.equals(nombre, evento.nombre) &&
                Objects.equals(lugar, evento.lugar) &&
                Objects.equals(fecha, evento.fecha) &&
                tipo == evento.tipo; // Comparación lógica
    }

    public JSONArray asistidoresToJson() {
        JSONArray arr = new JSONArray();
        // Verificar que asistidores no sea null
        if (asistidores != null) {
            for (Asistente a : asistidores.obtenerTodos()) {
                JSONObject obj = a.toJson();
                arr.put(obj);
            }
        }
        return arr;
    }

    public JSONArray organizadoresToJson(){
        JSONArray arr = new JSONArray();
        for (String o : organizadores){
            arr.put(o);
        }
        return arr;
    }
    public JSONObject toJson(){
        JSONObject obj = new JSONObject();
        obj.put("nombre", nombre);
        obj.put("lugar", lugar);
        obj.put("horario", horario);
        obj.put("requiereInscripcion", requiereInscripcion);
        obj.put("inscripcion", inscripcion);
        obj.put("capacidadMax", capacidadMax);
        obj.put("fecha", fecha);
        obj.put("asistidores", asistidoresToJson());
        obj.put("organizadores", organizadoresToJson());
        obj.put("tipo", tipo);
        return obj;
    }
}
