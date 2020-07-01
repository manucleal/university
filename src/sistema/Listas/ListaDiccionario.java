package sistema.Listas;

import sistema.Nodos.Nodo;
import sistema.Nodos.NodoPalabra;

public class ListaDiccionario {
    NodoPalabra primero;
    NodoPalabra ultimo;
    
    public ListaDiccionario(){
        this.primero = null;
        this.ultimo = null;
    }

    public NodoPalabra getPrimero() {
        return primero;
    }
    
    public void vaciar() {
        this.primero = null;
        this.ultimo = null;
    }
    
    public boolean esVacia() {
        return (this.primero == null);
    }
    
    public void mostrar() {
        NodoPalabra aux = this.primero;
        if(aux == null){
            System.out.println("Diccionario Vacio");
        }
        else {        
            while (aux != null){
                System.out.print(aux.getDato());
                System.out.println();
                aux = (NodoPalabra)aux.siguiente;
            }
        }
    }
    
    public void insertarOrdenado(Object dato) {
        NodoPalabra nuevo = new NodoPalabra(dato);

        if (primero == null) {
            primero = nuevo;
        } else {
            if (String.valueOf(dato).compareTo(String.valueOf(primero.getDato())) < 0) {
                nuevo.setSiguiente(primero);
                primero = nuevo;
            } else {
                NodoPalabra reco = primero;
                NodoPalabra atras = primero;

                while (String.valueOf(dato).compareTo(String.valueOf(reco.getDato())) >= 0 && reco.getSiguiente() != null) {
                    atras = reco;
                    reco = (NodoPalabra)reco.getSiguiente();
                }

                if (String.valueOf(dato).compareTo(String.valueOf(reco.getDato())) >= 0) {
                    reco.setSiguiente(nuevo);
                } else {
                    nuevo.setSiguiente(reco);
                    atras.setSiguiente(nuevo);
                }
            }
        }
    }
    
    public Nodo borrarInicio() {     
        if (!this.esVacia()){
            if (this.primero == this.ultimo){
                this.vaciar();
            }
            else{                     
                this.primero = (NodoPalabra)this.primero.siguiente;
            } 
        }
        return this.primero;
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
                this.ultimo = (NodoPalabra)aux;
                this.ultimo.setSiguiente(null);
            }
        }
    }    
    
    public void agregarInicio(Object dato) {
        NodoPalabra nuevo = new NodoPalabra(dato);
        if (this.esVacia()){
            this.primero = nuevo;
            this.ultimo = nuevo;
        }
        else{
            nuevo.siguiente = this.primero;
            this.primero = nuevo;                      
        }
    }
    
    public void borrarOcurrenciaPalabraTexto(Object dato){
        NodoPalabra aux = this.primero;
        while (aux != null){
            this.borrarElemento(dato);
            aux = (NodoPalabra)aux.siguiente;
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

    public boolean buscarElemento(Object dato) {
        NodoPalabra aux = this.primero;
        while (aux != null){
            if (aux.getDato() == dato){
                return true;
            }
            aux = (NodoPalabra)aux.siguiente;
        }     
        return false;
    }    
}
