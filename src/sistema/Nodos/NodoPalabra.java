package sistema.Nodos;

public class NodoPalabra extends Nodo {
    
    public NodoPalabra(Object dato) {
        super(dato);
    }

    public NodoPalabra() {
        
    }

    @Override
    public void setSiguiente(Nodo siguiente) {
        super.setSiguiente(siguiente); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Nodo getSiguiente() {
        return super.getSiguiente(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setDato(Object dato) {
        super.setDato(dato); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getDato() {
        return super.getDato(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
