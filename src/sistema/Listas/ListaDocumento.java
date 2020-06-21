package sistema.Listas;

import sistema.Nodos.Nodo;
import sistema.Nodos.NodoDocumento;

public class ListaDocumento {
    NodoDocumento primero;
    NodoDocumento ultimo;
    
    public ListaDocumento() {
        this.primero = null;
        this.ultimo = null;
    }
    
    public ListaDocumento(NodoDocumento primero, NodoDocumento ultimo) {
        this.primero = primero;
        this.ultimo = ultimo;
    }
       
    public boolean esVacia() {
        return (this.primero == null);
    }
    
    public void vaciar() {
        this.primero = null;
        this.ultimo = null;
    }
    
    public void mostrar() {
        Nodo aux = this.primero;
        while (aux != null){
            System.out.println("Documento: " + aux.getDato());
            aux = aux.siguiente;
        }
    }
    public void agregarInicio(Object dato) {
        NodoDocumento nuevo = new NodoDocumento(dato);
        if (this.esVacia()){
            this.primero = nuevo;
            this.ultimo = nuevo;
        }
        else{
            nuevo.siguiente = this.primero;
            this.primero = nuevo;                      
        }
    }
    //en uso
    public void agregarFinal(Object dato) {
        NodoDocumento nuevo = new NodoDocumento(dato);
           
        if (this.esVacia())
            this.agregarInicio(dato);
        else {
            ultimo.siguiente = nuevo;
            ultimo = nuevo;
        }
    }

    public boolean buscarElemento(Object dato) {
        NodoDocumento aux = this.primero;
        while (aux!=null){
            if (aux.getDato()==dato){
                return true;
            }
            aux.setSiguiente(aux);
        }     
        return false;
    }
    
    public void borrarInicio() {     
        if (!this.esVacia()){
            if (this.primero == this.ultimo){
                this.primero = null;
                this.ultimo = null;
            }
            else{                     
                this.primero = (NodoDocumento)this.primero.siguiente;
            } 
        }
    } 
    
    //recibe nombre documento y devuelve un nodo documento
    public NodoDocumento obtenerNodoPorNombre(Object dato) {
        Nodo aux = this.primero;
        while (aux != null){
            if (aux.getDato() == dato){
                return (NodoDocumento)aux;
            }
            aux = aux.getSiguiente();
        }
        return null;
    }

    public void borrarFinal(){
        if (!this.esVacia()){
            if (this.primero == this.ultimo)
                this.borrarInicio();
            else{
                Nodo aux = this.primero;
                while (aux.getSiguiente().getSiguiente() != null){
                    aux = aux.getSiguiente();
                }    
                this.ultimo = (NodoDocumento)aux;
                this.ultimo.setSiguiente(null);
            }
        }
    }
    
    public NodoDocumento borrarElemento(Object dato){
        Nodo aux = this.obtenerNodoPorNombre(dato);
        if(!this.esVacia()){
            if(this.primero == this.ultimo && aux == this.primero.dato){
                this.vaciar();
            }
            else if(aux == this.primero){
                this.borrarInicio();
            }
            else if (aux == this.ultimo){
                this.borrarFinal();
            }
            else {
                Nodo anterior,temporal;
                anterior = this.primero;
                temporal = this.primero.siguiente;
                while(temporal != null && temporal != aux){
                    anterior = anterior.siguiente;
                    temporal = temporal.siguiente;
                }
                //lo encontro
                if(temporal != null){
                    anterior.siguiente = temporal.siguiente;
                }
            }
        }
        return (NodoDocumento)aux;
    }
}
