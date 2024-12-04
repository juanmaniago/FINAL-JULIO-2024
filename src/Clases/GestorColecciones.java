package Clases;

import java.util.ArrayList;
import java.util.HashSet;

public class GestorColecciones <T>{
    public HashSet<T> elementos;

    public GestorColecciones() {
        this.elementos = new HashSet<>();
    }

    public boolean eliminar(T t){
        return elementos.remove(t);
    }

    public boolean agregar(T t){
        if (!existe(t)){
            elementos.add(t);
            return true;
        } else {
            return false;
        }
    }

    public boolean existe(T t){
        if (elementos.contains(t)){
            return true;
        } else {
            return false;
        }
    }

    public int obtenerTamanioSet(){
        return elementos.size();
    }
    public ArrayList<T> obtenerTodos() {
        return new ArrayList<>(elementos); // Retorna una copia de la lista para evitar modificaciones externas
    }
}
