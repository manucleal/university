package sistema.Listas;

import sistema.Nodos.Nodo;
import sistema.Nodos.NodoLinea;
import sistema.Nodos.NodoPalabra;

public class ListaPalabra {
    NodoPalabra primero;
    NodoPalabra ultimo;
    int cantidadElementos;
    int MAX_CANT_PALABRAS_X_LINEA;
    
    public ListaPalabra() {
        this.primero = null;
        this.ultimo = null;
        this.cantidadElementos = 0;
        this.MAX_CANT_PALABRAS_X_LINEA = 0;
    }

    public ListaPalabra(NodoPalabra primero, NodoPalabra ultimo, int MAX_CANT_PALABRAS_X_LINEA) {
        this.primero = primero;
        this.ultimo = ultimo;
        this.cantidadElementos = 0;
        this.MAX_CANT_PALABRAS_X_LINEA = MAX_CANT_PALABRAS_X_LINEA;
    }
    
    public int getCantidadElementos() {
        return cantidadElementos;
    }

    public void setCantidadElementos(int cantidadElementos) {
        this.cantidadElementos = cantidadElementos;
    }
    
    public void vaciar() {
        this.primero = null;
        this.ultimo = null;
    }
    
    public boolean esVacia() {
        return (this.primero == null);
    }    
    
    public void agregarFinal(Object dato) {
        NodoPalabra nuevo = new NodoPalabra(dato);   
        if (this.esVacia())
            this.agregarInicio(dato);
        else {
            ultimo.siguiente = nuevo;
            ultimo = nuevo;
            this.cantidadElementos = this.cantidadElementos + 1;
        }
    }

    public void agregarInicio(Object dato) {
        NodoPalabra nuevo = new NodoPalabra(dato);
        if (this.esVacia()){
            this.primero = nuevo;
            this.ultimo = nuevo;
            this.cantidadElementos = this.cantidadElementos + 1;
        }
        else{
            nuevo.siguiente = this.primero;
            this.primero = nuevo;
            this.cantidadElementos = this.cantidadElementos + 1;
        }
    }
    public void agregarNodoPosicion(Object dato, int posicion){
        NodoPalabra nuevo = new NodoPalabra(posicion + "-" + dato + " ");
        if (this.esVacia()){
            this.primero = nuevo;
            this.ultimo = nuevo;
            this.cantidadElementos = this.cantidadElementos + 1;
        }
        else {
            if(posicion == 1){
                this.agregarInicio(posicion+ "-" + dato + " ");
            }
            else if(posicion == (getCantidadElementos() + 1)){
                this.agregarFinal(posicion+ "-" + dato + " ");
            }
            else if(posicion > 1 && posicion < (getCantidadElementos() + 1)){
                Nodo aux, aux2;
                aux = this.primero;
                aux2 = this.primero.siguiente;
                
                for(int i=1; i< posicion; i++){
                    aux2 = aux;
                    aux = aux.siguiente;
                }
                aux2.siguiente = nuevo;
                nuevo.siguiente = aux;
                this.cantidadElementos = this.cantidadElementos + 1;
                while(aux != null){
                    aux.setDato((posicion = posicion + 1) +"-"+ aux.dato );
                    aux = aux.siguiente;
                }
            }
        }
    }    
}
