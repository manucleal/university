package sistema.Nodos;

import sistema.Listas.ListaLinea;

public class NodoDocumento extends Nodo{
    
    ListaLinea listaLinea;
            
    public NodoDocumento(Object dato) {
        super(dato);
        this.listaLinea = new ListaLinea();
    }

    public ListaLinea getListaLinea() {
        return listaLinea;
    }

    public void setListaLinea(ListaLinea listaLinea) {
        this.listaLinea = listaLinea;
    }
    
}
