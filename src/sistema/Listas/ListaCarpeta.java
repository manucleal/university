package sistema.Listas;

import sistema.Nodos.Nodo;
import sistema.Nodos.NodoCarpeta;

public class ListaCarpeta {
    NodoCarpeta primero;
    NodoCarpeta ultimo;
    
    public ListaCarpeta() {
        this.primero = null;
        this.ultimo = null;
    }

    public ListaCarpeta(NodoCarpeta primero, NodoCarpeta ultimo) {
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
        NodoCarpeta aux = this.primero;
        while (aux != null){
            System.out.println(" Nombre Carpeta - " + aux.getDato());
            aux.getListaDocumento().mostrar();
            aux = (NodoCarpeta)aux.siguiente;
        }
    }
    
    public void agregarInicio(Object dato) {
        NodoCarpeta nuevo = new NodoCarpeta(dato);
        if (this.esVacia()){
            this.primero = nuevo;
            this.ultimo = nuevo;
        }
        else{
            nuevo.siguiente = this.primero;
            this.primero = nuevo;                      
        }
    }
    
    public void agregarFinal(Object dato) {
        NodoCarpeta nuevo = new NodoCarpeta(dato);       
        if (this.esVacia())
            this.agregarInicio(dato);
        else {
            ultimo.siguiente = nuevo;
            ultimo = nuevo;
        }
    }
    //en uso
    public void borrarFinal(){
        if (!this.esVacia()){
            if (this.primero == this.ultimo)
                this.borrarInicio();
            else{
                Nodo aux = this.primero;
                while (aux.getSiguiente().getSiguiente() != null){
                    aux = aux.getSiguiente();
                }    
                this.ultimo = (NodoCarpeta)aux;
                this.ultimo.setSiguiente(null);
            }
        }
    }
    //en uso
    public NodoCarpeta borrarElemento(Object dato){
        Nodo aux = this.obtenerNodoPorNombre(dato);
        if(aux != null && !this.esVacia()){
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
        return (NodoCarpeta)aux;
    }
    //en uso
    public void borrarInicio() {     
        if (!this.esVacia()){
            if (this.primero == this.ultimo){
                this.vaciar();
            }
            else{                     
                //this.primero=this.primero.siguiente;
                this.primero.setSiguiente(this.primero.getSiguiente());
            } 
        }
    }
    //en uso
    public NodoCarpeta obtenerNodoPorNombre(Object dato) {
        Nodo aux = this.primero;
        while (aux != null){
            if (aux.getDato() == dato){
                return (NodoCarpeta)aux;
            }
            aux = aux.getSiguiente();
        }
        return null;
    }
}
