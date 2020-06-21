package sistema.Interfaces;

import sistema.Nodos.Nodo;

public interface ILista {
    //metodos de la interfaz
    public boolean esVacia();
    public void agregarInicio(Object dato);
    public void agregarFinal(Object dato);
    public void borrarInicio(); 
    public boolean buscarelemento(Object dato);    
    public void vaciar();
    public void mostrar();  
    public Nodo obtenercarpeta(Object dato);
    public Nodo obtenercarpetapororden(Object dato);
    //public void mostrarREC(Nodo l); // implementar el mostrar recursivo    
    //public void borrarFin();
    //otros metodos para analizar
    //public void agregarOrd(int n);
    //public void borrarElemento(int n);
    //public NodoLista obtenerElemento(int n);
    //public int cantElementos();
    public boolean buscarCarpetaPorNombre(Object nombre);
}
