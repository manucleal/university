package sistema.Nodos;

import sistema.Listas.ListaPalabra;

public class NodoLinea extends Nodo {

    ListaPalabra listaPalabra;
    
    public NodoLinea(Object dato) {
        super(dato);
        this.listaPalabra = new ListaPalabra();
    }

    public ListaPalabra getListaPalabra() {
        return listaPalabra;
    }

    public void setListaPalabra(ListaPalabra listaPalabra) {
        this.listaPalabra = listaPalabra;
    }
}
