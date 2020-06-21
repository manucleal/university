package sistema.Listas;

import sistema.Nodos.Nodo;

public abstract class Lista {
    
    public Nodo primero;
    public Nodo ultimo;
    
    public Lista() {
        this.primero = null;
        this.ultimo = null;
    }
    
    public Lista(Nodo primero, Nodo ultimo) {
        this.primero = primero;
        this.ultimo = ultimo;
    }

    public Object getPrimero() {
        return primero;
    }

    public void setPrimero(Nodo primero) {
        this.primero = primero;
    }

    public Object getUltimo() {
        return ultimo;
    }

    public void setUltimo(Nodo ultimo) {
        this.ultimo = ultimo;
    }
       
    public boolean esVacia() {
        return (this.primero == null);
    }
    
    public void vaciar() {
        this.primero = null;
        this.ultimo = null;
    }

    public abstract void agregarFinal(Object dato);
    
    public abstract void agregarInicio(Object dato);
//    {
//        Nodo nuevo = new Nodo(dato);
//           
//        if (this.esVacia())
//            this.agregarInicio(dato);
//        else {
//            ultimo.siguiente = nuevo;
//            ultimo = nuevo;
//        }
////    }
//    public Nodo obtenerNodoPorNombre(String dato) {
//        Nodo aux = this.primero;
//        while (aux != null){
//            if (aux.getDato() == dato){
//                return aux;
//            }
//            aux=aux.getSiguiente();
//        }
//        return null;
//    }
//    public boolean buscarElemento(Object dato) {
//        Nodo aux = this.primero;
//        while (aux!=null){
//            if (aux.getDato()==dato){
//                return true;
//            }
//            aux.setSiguiente(aux);
//        }     
//        return false;
//    }
//    public void borrarInicio() {     
//        if (!this.esVacia()){
//            if (this.primero == this.ultimo){
//                this.primero = null;
//                this.ultimo = null;
//            }
//            else{                     
//                //this.primero=this.primero.siguiente;
//                this.primero.setSiguiente(this.primero.getSiguiente());
//            } 
//        }
//    }
}