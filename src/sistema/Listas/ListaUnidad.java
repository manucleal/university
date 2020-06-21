package sistema.Listas;
import sistema.Nodos.Nodo;
import sistema.Nodos.NodoUnidad;

public class ListaUnidad {
    NodoUnidad primero;
    NodoUnidad ultimo;
    
    public ListaUnidad() {
        this.primero = null;
        this.ultimo = null;
    }
    
    public boolean esVacia() {
        return (this.primero == null);
    }
    
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

    public NodoUnidad obtenerNodoPorNombre(Object dato) {
        Nodo aux = this.primero;
        while (aux != null){
            if (aux.getDato() == dato){
                return (NodoUnidad)aux;
            }
            aux = aux.getSiguiente();
        }
        return null;
    }
}
