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
        this.cantidadElementos = 1;
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
        if(aux == null){
            System.out.println("Texto Vacio");
        }
        else {        
            while (aux != null){
                System.out.print("Linea: " + aux.getDato()+" - ");
                NodoPalabra aux2 = aux.getListaPalabra().primero;
                if(aux2 == null){
                    System.out.println();
                }
                while(aux2 != null){
                    System.out.print(aux2.getDato()+" ");
                    aux2 = (NodoPalabra)aux2.siguiente;
                }
                System.out.println();
                aux = (NodoLinea)aux.siguiente;
            }
        }
    }
    
    public void mostrarPalabrasNoDiccionario(ListaDiccionario diccionario) {
        NodoLinea aux = this.primero;
        if(aux == null){
            System.out.println("Texto Vacio");
        }
        else {        
            while (aux != null){
                System.out.print("Linea: " + aux.getDato()+" - ");
                NodoPalabra aux2 = aux.getListaPalabra().primero;
                if(aux2 == null){
                    System.out.println();
                }
                while(aux2 != null){                    
                    if(!diccionario.buscarElemento(aux2.getDato())){
                       System.out.print(aux2.getDato()+" ");
                    }
                    aux2 = (NodoPalabra)aux2.siguiente;
                }
                System.out.println();
                aux = (NodoLinea)aux.siguiente;
            }
        }
    }

    
    public void mostrarPorLinea(int posicionLinea) {
        NodoLinea aux = obtenerNodoPorNombre(posicionLinea);
        if(aux == null){
            System.out.println("Texto Vacio");
        }
        else {        
            System.out.print("Linea: " + aux.getDato()+" - ");
            NodoPalabra aux2 = aux.getListaPalabra().primero;
            if(aux2 == null){
                System.out.println();
            }
            while(aux2 != null){
                System.out.print(aux2.getDato()+" ");
                aux2 = (NodoPalabra)aux2.siguiente;
            }
            System.out.println();
        }
    }    
    
    public String reOrdenarPalabrasEnLineas(Object posicionLinea, Object palabraAIngresar, int posicionPalabra){
        String retorno = "";
        NodoLinea nodoLinea = this.obtenerNodoPorNombre(posicionLinea);
        if(nodoLinea != null){          
            ListaPalabra listaPalabras = nodoLinea.getListaPalabra();
            if(posicionPalabra >= 1 && posicionPalabra <= (listaPalabras.getCantidadElementos() + 1)){
            
                listaPalabras.agregarNodoPosicion(palabraAIngresar, posicionPalabra);

                if(listaPalabras.getMAX_CANT_PALABRAS_X_LINEA() < listaPalabras.getCantidadElementos()){
                    while(nodoLinea != null){
                        if(nodoLinea.getListaPalabra().getMAX_CANT_PALABRAS_X_LINEA() < nodoLinea.getListaPalabra().getCantidadElementos()){
                            if(nodoLinea.siguiente == null){ //si esta linea es la ultima agrego linea en blanco nueva 
                                //esto sucede en la ultima linena, solamente ahi se genera una linea nueva
                                int nroLinea = this.cantidadElementos + 1;               
                                this.agregarFinal(nroLinea);
                            }
                            //obtendo palabra final y la guardo en variable temporal
                            Object temporal = nodoLinea.getListaPalabra().getUltimo().dato;
                            //elimino nodo final de linea llena          
                            nodoLinea.getListaPalabra().borrarFinal();
                            //me muevo a la linea sifuiente 
                            nodoLinea = (NodoLinea)nodoLinea.siguiente;
                            //ingreso palabra al inicio
                            nodoLinea.getListaPalabra().agregarNodoPosicion(temporal, 1);
                            //luego de pasar a la linea de abajo se pregunta si esta llena
                        }
                        else {
                            //me muevo a la linea sifuiente 
                            nodoLinea = (NodoLinea)nodoLinea.siguiente;
                        }
                    }
                }                
            }
            else {
                retorno = "La posición de la palabra no es válida";
            }
        }
        else {
            retorno =  "La posición de la línea no es válida";
        }
        return retorno;
    }

    public void borrarOcurrenciaPalabraTexto(Object dato){
        NodoLinea aux = this.primero;
        while (aux != null){
            aux.getListaPalabra().borrarElemento(dato);
            aux = (NodoLinea)aux.siguiente;
        }
    }
    public void borrarOcurrenciaPalabraLineaPorPosicion(int posicionLinea, int posicionPalabra){
        NodoLinea aux = obtenerNodoPorNombre(posicionLinea);
        aux.getListaPalabra().borrarNodoPosicion(posicionPalabra);  
    }
    
    public void borrarOcurrenciaPalabraLineaPorNombre(int posicionLinea, String palabraABorrar){
        NodoLinea aux = obtenerNodoPorNombre(posicionLinea);
        aux.getListaPalabra().borrarElemento(palabraABorrar);
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

    public Nodo agregarInicio(Object dato) {
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
        return nuevo;
    }
    
    public NodoLinea agregarNodoPosicion(Object dato, int posicion){
        NodoLinea nuevo = new NodoLinea(dato);
        if (this.esVacia()){
            this.primero = nuevo;
            this.ultimo = nuevo;
            this.cantidadElementos = this.cantidadElementos + 1;
        }
        else {
            if(posicion == 1){
                Nodo nodoLinea = this.agregarInicio(dato);
                this.reOrdenarCreciente(nodoLinea.siguiente, posicion);
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
                this.reOrdenarCreciente(aux, posicion);
            }
        }
        return nuevo;
    }
    
    private void reOrdenarCreciente(Nodo aux, int posicion){
        while(aux != null){
            aux.setDato(posicion = posicion + 1);
            aux = aux.siguiente;
        }
    }
    
    private void reOrdenarDecreciente(Nodo aux, int posicion){
        while(aux != null){
            aux.setDato(posicion = (int)aux.getDato() - 1);
            aux = aux.siguiente;
        }
    }    
    
    public void borrarNodoPosicion(int posicion){
        if(posicion == 1){
            Nodo nodoLinea = this.borrarInicio();
            this.reOrdenarDecreciente(nodoLinea, posicion);
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
            this.cantidadElementos = this.cantidadElementos - 1;
            aux = aux.siguiente;
            this.reOrdenarDecreciente(aux, posicion);
        }
    }
    
    public Nodo borrarInicio() {     
        if (!this.esVacia()){
            if (this.primero == this.ultimo){
                this.vaciar();
                this.cantidadElementos = 0;
            }
            else{                     
                this.primero = (NodoLinea)this.primero.siguiente;
                this.cantidadElementos = this.cantidadElementos - 1;
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
                this.ultimo = (NodoLinea)aux;
                this.ultimo.setSiguiente(null);
                this.cantidadElementos = this.cantidadElementos - 1;
            }
        }
    }
    
    public NodoLinea obtenerNodoPorNombre(Object dato) {
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
