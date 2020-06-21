package sistema.Listas;

import sistema.Interfaces.ILista;
import sistema.Nodos.Nodo;
import sistema.Nodos.NodoUnidad;

public class ListaUnidad implements ILista{
    NodoUnidad primero;
    NodoUnidad ultimo;
    
    public ListaUnidad() {
        this.primero = null;
        this.ultimo = null;
    }

//    public NodoUnidad getPrimero() {
//        return primero;
//    }

//    public NodoUnidad getUltimo() {
//        return ultimo;
//    }

//    public void setPrimero(NodoUnidad primero) {
//        this.primero = primero;
//    }
//    
//    public void setUltimo(NodoUnidad ultimo) {
//        this.ultimo = ultimo;
//    }
    
    @Override
    public boolean esVacia() {
        return (this.primero == null);
    }
    
    @Override
    public void vaciar() {
        this.primero = null;
        this.ultimo = null;
    }

    public void agregarInicio(Object dato) {
        NodoUnidad nuevo = new NodoUnidad(dato);
        if (this.esVacia()){
            this.primero = nuevo;
            this.ultimo = nuevo;
        }
        else{
            nuevo.siguiente = this.primero;
            this.primero = nuevo;                      
        }
    }
    
    @Override
    public NodoUnidad obtenerNodoPorNombre(String dato) {
        Nodo aux = this.primero;
        while (aux != null){
            if (aux.getDato() == dato){
                return (NodoUnidad)aux;
            }
            aux = aux.siguiente;
        }
        return null;
    }
}
