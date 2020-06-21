package sistema.Listas;

import sistema.Nodos.NodoUnidad;

public class ListaUnidad{
    NodoUnidad primero;
    NodoUnidad ultimo;
    
    public ListaUnidad() {
        this.primero = null;
        this.ultimo = null;
    }

    public NodoUnidad getPrimero() {
        return primero;
    }

    public NodoUnidad getUltimo() {
        return ultimo;
    }

    public void setPrimero(NodoUnidad primero) {
        this.primero = primero;
    }
    
    public void setUltimo(NodoUnidad ultimo) {
        this.ultimo = ultimo;
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
    public void agregarFinal(Object dato) {
        NodoUnidad nuevo = new NodoUnidad(dato);
           
        if (this.esVacia())
            this.agregarInicio(dato);
        else {
            ultimo.siguiente = nuevo;
            ultimo = nuevo;
        }
    }    

    public boolean buscarElemento(Object dato) {
        NodoUnidad aux = this.primero;
        while (aux!=null){
            if (aux.getDato()==dato){
                return true;
            }
            aux.setSiguiente(aux);
        }     
        return false;
    }
    
    public NodoUnidad obtenerNodoUnidadPorNombre(String dato) {
        NodoUnidad aux = this.primero;
        while (aux != null){
            if (aux.getDato() == dato){
                return aux;
            }
            aux.setSiguiente(aux);            
            //aux=aux.siguiente; 
        }
        return null;
    }

    public void borrarInicio() {     
        if (!this.esVacia()){
            if (this.primero==this.ultimo){
                this.primero=null;
                this.ultimo=null;
            }
            else{                     
                 //this.primero=this.primero.siguiente;
                 this.primero.setSiguiente(this.primero.getSiguiente());
            } 
        }
    }
}
