package sistema.Nodos;

import sistema.Listas.ListaCarpeta;

public class NodoUnidad extends Nodo{
    
    ListaCarpeta listaCarpetas;

    public NodoUnidad(Object dato) {
        super(dato);
        this.listaCarpetas = new ListaCarpeta();
    }
    
    public ListaCarpeta getListaCarpetas() {
        return listaCarpetas;
    }
    
    public void setListaCarpetas(ListaCarpeta listaCarpeta) {
        this.listaCarpetas = listaCarpeta;
    }

}
