package sistema.Interfaces;

import sistema.Nodos.NodoUnidad;

public interface ILista {
    public boolean esVacia();
    public void vaciar();
    public NodoUnidad obtenerNodoPorNombre(String dato);

}
