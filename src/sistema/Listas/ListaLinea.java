package sistema.Listas;
import sistema.Nodos.Nodo;
import sistema.Nodos.NodoLinea;
import sistema.Nodos.NodoPalabra;

public class ListaLinea {
    NodoLinea primero;
    NodoLinea ultimo;
    
    int cantidadElementos;
    
    public ListaLinea() {
        this.primero = null;
        this.ultimo = null;
        this.cantidadElementos = 0;
    }

    public ListaLinea(NodoLinea primero, NodoLinea ultimo) {
        this.primero = primero;
        this.ultimo = ultimo;
        this.cantidadElementos = 0;
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

    public void mostrar() {
        NodoLinea aux = this.primero;
        while (aux != null){
            System.out.print("Linea: " + aux.getDato()+" - ");
            NodoPalabra aux2 = aux.getListaPalabra().primero;
            if(aux2 == null){
                System.out.println();
            }
            while(aux2 != null){
                System.out.print(aux2.getDato());
                aux2 = (NodoPalabra)aux2.siguiente;
            }
            System.out.println();
            aux = (NodoLinea)aux.siguiente;
        }
    }    
      
    public void agregarFinal(Object dato) {
        NodoLinea nuevo = new NodoLinea(dato);   
        if (this.esVacia())
            this.agregarInicio(dato);
        else {
            ultimo.siguiente = nuevo;
            ultimo = nuevo;
            this.cantidadElementos = this.cantidadElementos + 1;
        }
    }

    public void agregarInicio(Object dato) {
        NodoLinea nuevo = new NodoLinea(dato);
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
        NodoLinea nuevo = new NodoLinea(dato);
        if (this.esVacia()){
            this.primero = nuevo;
            this.ultimo = nuevo;
            this.cantidadElementos = this.cantidadElementos + 1;
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
                
                for(int i=1; i< posicion; i++){
                    aux2 = aux;
                    aux = aux.siguiente;
                }
                aux2.siguiente = nuevo;
                nuevo.siguiente = aux;
                this.cantidadElementos = this.cantidadElementos + 1;
                while(aux != null){
                    aux.setDato(posicion  = posicion + 1);
                    aux = aux.siguiente;
                }
            }
        }
    }
    
    public void borrarNodoPosicion(int posicion){
        if(posicion == 1){
            this.borrarInicio();
        } 
        else if(posicion == getCantidadElementos()){
            this.borrarFinal();
        }
        else if(posicion > 1 && posicion < getCantidadElementos()){
            Nodo aux, aux2;
            aux = this.primero;
            aux2 = this.primero.siguiente;

            for(int i=1; i< posicion; i++){
                aux2 = aux;
                aux = aux.siguiente;
            }
            aux2.siguiente = aux.siguiente;
            //aux.siguiente = aux2.siguiente;
            
            this.cantidadElementos = this.cantidadElementos + 1;
            aux.setDato(posicion);
            while(aux != null){
                aux.setDato(posicion = posicion + 1);
                aux = aux.siguiente;
            }
        }
    }
    
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
    
    public void borrarFinal(){
        if (!this.esVacia()){
            if (this.primero == this.ultimo)
                this.borrarInicio();
            else{
                Nodo aux = this.primero;
                while (aux.getSiguiente().getSiguiente() != null){
                    aux = aux.getSiguiente();
                }    
                this.ultimo = (NodoLinea)aux;
                this.ultimo.setSiguiente(null);
            }
        }
    }
    
    public NodoLinea obtenerNodoLineaPorNombre(Object dato) {
        Nodo aux = this.primero;
        while (aux != null){
            if (aux.getDato() == dato){
                return (NodoLinea)aux;
            }
            aux = aux.getSiguiente();
        }
        return null;
    }    
}
