package sistema.Nodos;

import sistema.Listas.ListaDocumento;

public class NodoCarpeta extends Nodo {
    
    ListaDocumento listaDocumento;
    
    public NodoCarpeta(Object dato) {
        super(dato);
        this.listaDocumento = new ListaDocumento();
    }

    public ListaDocumento getListaDocumento() {
        return listaDocumento;
    }

    public void setListaDocumento(ListaDocumento listaDocumento) {
        this.listaDocumento = listaDocumento;
    }
    
}
