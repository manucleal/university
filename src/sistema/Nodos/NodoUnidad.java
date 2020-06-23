package sistema.Nodos;

import sistema.Listas.ListaCarpeta;
import sistema.Listas.ListaDiccionario;

public class NodoUnidad extends Nodo{
    
    ListaCarpeta listaCarpetas;
    ListaDiccionario listaDiccionario;

    public NodoUnidad(Object dato) {
        super(dato);
        this.listaCarpetas = new ListaCarpeta();
        this.listaDiccionario = new ListaDiccionario();
    }
    
    public ListaCarpeta getListaCarpetas() {
        return listaCarpetas;
    }
    
    public ListaDiccionario getListaDiccionario() {
        return listaDiccionario;
    }
    
    public void setListaCarpetas(ListaCarpeta listaCarpeta) {
        this.listaCarpetas = listaCarpeta;
    }

}
