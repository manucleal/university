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
        this.MAX_CANT_PALABRAS_X_LINEA = 3;
    }

    public ListaPalabra(NodoPalabra primero, NodoPalabra ultimo, int MAX_CANT_PALABRAS_X_LINEA) {
        this.primero = primero;
        this.ultimo = ultimo;
        this.cantidadElementos = 1;
        this.MAX_CANT_PALABRAS_X_LINEA = MAX_CANT_PALABRAS_X_LINEA;
    }

    public NodoPalabra getUltimo() {
        return ultimo;
    }
    
    public int getCantidadElementos() {
        return cantidadElementos;
    }
    
    public int getMAX_CANT_PALABRAS_X_LINEA() {
        return MAX_CANT_PALABRAS_X_LINEA;
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
        NodoPalabra nuevo = new NodoPalabra(dato);
        if (this.esVacia()){
            this.agregarInicio(dato);
        }
        else {
            if(posicion == 1){
                this.agregarInicio(dato);
            }
            else if(posicion == (getCantidadElementos() + 1)){
                this.agregarFinal(dato);
            }
            else if(posicion > 1 && posicion < (getCantidadElementos() + 1)){
                Nodo aux, aux2;
                aux = this.primero;
                aux2 = this.primero.siguiente;
                //recorro y me posiciono en posicion anterior a la deseada
                for(int i=1; i< posicion; i++){
                    aux2 = aux;
                    aux = aux.siguiente;
                }
                aux2.siguiente = nuevo;
                nuevo.siguiente = aux;
                this.cantidadElementos = this.cantidadElementos + 1;
                while(aux != null){
                    aux.setDato(aux.dato);
                    aux = aux.siguiente;
                }
            }
        }
    }
    
    public void borrarInicio() {     
        if (!this.esVacia()){
            if (this.primero == this.ultimo){
                this.vaciar();
            }
            else{                     
                this.primero = (NodoPalabra)this.primero.siguiente;
            } 
        }
    }    
    
    public void borrarFinal(){
        if (!this.esVacia()){
            if (this.primero == this.ultimo)
                this.borrarInicio();
            else {
                Nodo aux = this.primero;
                while (aux.siguiente.siguiente != null){
                    aux = aux.siguiente;
                }    
                this.ultimo = (NodoPalabra)aux;
                this.ultimo.setSiguiente(null);
            }
        }
    }    
    
    public NodoPalabra borrarElemento(Object dato){
        Nodo aux = this.obtenerNodoPalabraPorNombre(dato);
        if(!this.esVacia()){
            if(this.primero == this.ultimo && aux == this.primero){
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
        return (NodoPalabra)aux;
    }
    public NodoPalabra obtenerNodoPalabraPorNombre(Object dato) {
        Nodo aux = this.primero;
        while (aux != null){
            if (aux.getDato() == dato){
                return (NodoPalabra)aux;
            }
            aux = aux.getSiguiente();
        }
        return null;
    }    
}
