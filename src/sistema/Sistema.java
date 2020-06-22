package sistema;

import sistema.Interfaces.ISistema;
import sistema.Listas.ListaCarpeta;
import sistema.Listas.ListaDocumento;
import sistema.Listas.ListaLinea;
import sistema.Listas.ListaUnidad;
import sistema.Nodos.Nodo;
import sistema.Nodos.NodoCarpeta;
import sistema.Nodos.NodoDocumento;
import sistema.Nodos.NodoLinea;
import sistema.Nodos.NodoUnidad;

public class Sistema implements ISistema{
    public ListaUnidad unidades;
            
    //se inicia el sistema con una unidades C por defecto
    @Override
    public Retorno crearSistemaMensajes() {
        Retorno ret = new Retorno (Retorno.Resultado.OK);
        if(this.unidades == null){
            this.unidades = new ListaUnidad();
            this.unidades.agregarInicio("C");
        }
        return ret;
    }

    @Override
    public Retorno destruirSistemaMensajes() {
        Retorno ret = new Retorno (Retorno.Resultado.OK);    
        this.unidades.vaciar();
        return ret;
    }

    @Override
    public Retorno agregarCarpeta(String unidad, String carpeta) {
        Retorno ret = new Retorno (Retorno.Resultado.OK);
        NodoUnidad nodoUnidad = this.unidades.obtenerNodoPorNombre(unidad);
                
        if(nodoUnidad != null){//si unidad existe procedemos 
            ListaCarpeta listaCarpetas = nodoUnidad.getListaCarpetas();
            
            NodoCarpeta nodoCarpeta = listaCarpetas.obtenerNodoPorNombre(carpeta);
            
            if(nodoCarpeta == null){
                listaCarpetas.agregarFinal(carpeta);
            }
            else {
                ret.valorString = "La carpeta a crear ya existe";
            }
        }
        else {
             ret.valorString = "La ubicación donde se creará la carpeta no existe";
        }
       
        return ret;
    }

    @Override
    public Retorno eliminarCarpeta(String unidad, String carpeta) {
        Retorno ret = new Retorno (Retorno.Resultado.OK);
        NodoUnidad nodoUnidad = this.unidades.obtenerNodoPorNombre(unidad);
        
        if(nodoUnidad != null){//si unidad existe procedemos 
            ListaCarpeta listaCarpetas = nodoUnidad.getListaCarpetas();//obtenemos solamente una vez
            NodoCarpeta resultado = listaCarpetas.borrarElemento(carpeta);
            if(resultado == null){
                ret.valorString = "La carpeta a eliminar no existe"; 
            }
        }
        else {
            ret.valorString = "La ubicación no existe";
        }
        
        return ret;
    }

    @Override
    public Retorno agregarMensaje(String unidad, String carpeta, String mensaje) {
        Retorno ret = new Retorno (Retorno.Resultado.OK);
        NodoUnidad nodoUnidad = this.unidades.obtenerNodoPorNombre(unidad);
        if(nodoUnidad != null){//si unidad existe procedemos 
            ListaCarpeta listaCarpetas = nodoUnidad.getListaCarpetas();//obtenemos lista carpetas solamente una vez
            NodoCarpeta nodoCarpeta = listaCarpetas.obtenerNodoPorNombre(carpeta);
            if(nodoCarpeta != null){ //encontro carpeta
                ListaDocumento listaDocumentos = nodoCarpeta.getListaDocumento(); //obtenemos lista documentos solamente una vez
                NodoDocumento nodoDocumento = listaDocumentos.obtenerNodoPorNombre(mensaje);
                if(nodoDocumento == null){
                    listaDocumentos.agregarFinal(mensaje);
                }
                else {
                    ret.valorString = "El archivo ya existe";
                }
            }
            else{
                ret.valorString = "La carpeta no existe";    
            }
        }
        else {
            ret.valorString = "La ubicación no existe";
        }
        return ret;
    }

    @Override
    public Retorno eliminarMensaje(String unidad, String carpeta, String mensaje) {
        Retorno ret = new Retorno (Retorno.Resultado.OK);
        NodoUnidad nodoUnidad = this.unidades.obtenerNodoPorNombre(unidad);
        if(nodoUnidad != null){//si unidad existe procedemos 
            ListaCarpeta listaCarpetas = nodoUnidad.getListaCarpetas();//obtenemos lista carpetas solamente una vez
            NodoCarpeta nodoCarpeta = listaCarpetas.obtenerNodoPorNombre(carpeta);
            if(nodoCarpeta != null){ //encontro carpeta
                ListaDocumento listaDocumentos = nodoCarpeta.getListaDocumento();//obtenemos lista documentos solamente una vez
                NodoDocumento resultado = listaDocumentos.borrarElemento(mensaje);
                if(resultado == null){
                    ret.valorString = "El archivo no existe"; 
                }
            }
            else {
                ret.valorString = "La carpeta no existe";    
            }
        }
        else {
            ret.valorString = "La ubicación no existe";
        }
        return ret;
    }

    @Override
    public Retorno listarEstructura(String unidad, String carpeta) {
        Retorno ret = new Retorno (Retorno.Resultado.OK);
        NodoUnidad nodoUnidad = this.unidades.obtenerNodoPorNombre(unidad);
        if(nodoUnidad != null){//si unidad existe procedemos
            ListaCarpeta listaCarpetas = nodoUnidad.getListaCarpetas();//obtenemos lista carpetas solamente una vez
            NodoCarpeta nodoCarpeta = listaCarpetas.obtenerNodoPorNombre(carpeta);
            if(nodoCarpeta != null){ //encontro carpeta
                System.out.println("Carpeta: " + carpeta+ "\n");
                nodoCarpeta.getListaDocumento().mostrar();
            }
            else {
                ret.valorString = "No hay carpetas en la estructura";
            }
        }
        else {
            ret.valorString = "No hay carpetas en la estructura";
        }
        return ret;
    }

    @Override
    public Retorno insertarLinea() {
        Retorno ret = new Retorno (Retorno.Resultado.OK);
        NodoUnidad nodoUnidad = this.unidades.obtenerNodoPorNombre("C");
        if(nodoUnidad != null){//si unidad existe procedemos 
            ListaCarpeta listaCarpetas = nodoUnidad.getListaCarpetas();//nos posicionamos en lista carpetas solamente una vez
            NodoCarpeta nodoCarpeta = listaCarpetas.obtenerNodoPorNombre("Universidad");
            if(nodoCarpeta != null){ //encontro carpeta
                ListaDocumento listaDocumentos = nodoCarpeta.getListaDocumento(); //nos posicionamos en lista documentos solamente una vez
                NodoDocumento nodoDocumento = listaDocumentos.obtenerNodoPorNombre("Programacion");
                
                ListaLinea listaLineas = nodoDocumento.getListaLinea();//nos posicionamos en lista lieneas solamente una vez
                int nroLinea = listaLineas.getCantidadElementos() + 1;                
                listaLineas.agregarFinal(nroLinea);
            }
        }
        else {
            ret.valorString = "La ubicación no existe";
        }
        return ret;
    }

    @Override
    public Retorno insertarLineaEnPosicion(int posicionLinea) {
        //(posicionLinea >= 1) y (posicionLinea <= cantidad de líneas + 1
        Retorno ret = new Retorno (Retorno.Resultado.OK);
        NodoUnidad nodoUnidad = this.unidades.obtenerNodoPorNombre("C");
        if(nodoUnidad != null){//si unidad existe procedemos 
            ListaCarpeta listaCarpetas = nodoUnidad.getListaCarpetas();//obtenemos lista carpetas solamente una vez
            NodoCarpeta nodoCarpeta = listaCarpetas.obtenerNodoPorNombre("Universidad");
            if(nodoCarpeta != null){ //encontro carpeta
                ListaDocumento listaDocumentos = nodoCarpeta.getListaDocumento(); //obtenemos lista documentos solamente una vez
                NodoDocumento nodoDocumento = listaDocumentos.obtenerNodoPorNombre("Programacion");
                ListaLinea listaLineas =  nodoDocumento.getListaLinea();//obtenemos lista palabras solamente una vez 
                
                if(posicionLinea >= 1 && posicionLinea <= (listaLineas.getCantidadElementos() + 1)){
                    listaLineas.agregarNodoPosicion(posicionLinea, posicionLinea);    
                }
                else {
                    ret.valorString = "La posición no es valida";
                }
            }
        }
        else {
            ret.valorString = "La ubicación no existe";
        }
        return ret;
    }

    @Override
    public Retorno borrarLinea(int posicionLinea) {
        Retorno ret = new Retorno (Retorno.Resultado.OK);
        NodoUnidad nodoUnidad = this.unidades.obtenerNodoPorNombre("C");
        if(nodoUnidad != null){//si unidad existe procedemos 
            ListaCarpeta listaCarpetas = nodoUnidad.getListaCarpetas();//obtenemos lista carpetas solamente una vez
            NodoCarpeta nodoCarpeta = listaCarpetas.obtenerNodoPorNombre("Universidad");
            if(nodoCarpeta != null){ //encontro carpeta
                ListaDocumento listaDocumentos = nodoCarpeta.getListaDocumento(); //obtenemos lista documentos solamente una vez
                NodoDocumento nodoDocumento = listaDocumentos.obtenerNodoPorNombre("Programacion");
                ListaLinea listaLineas = nodoDocumento.getListaLinea();//ontenemos lista lineas solo una vez

                if(posicionLinea >= 1 && posicionLinea <= listaLineas.getCantidadElementos()){
                    listaLineas.borrarNodoPosicion(posicionLinea);
                }
                else {
                    ret.valorString = "La posición no es valida";
                }                
            }            
        }
        else {
            ret.valorString = "La ubicación no existe";
        }
        return ret;
    }

    @Override
    public Retorno borrarTodo() {
        Retorno ret = new Retorno (Retorno.Resultado.OK);
        NodoUnidad nodoUnidad = this.unidades.obtenerNodoPorNombre("C");
        if(nodoUnidad != null){//si unidad existe procedemos 
            ListaCarpeta listaCarpetas = nodoUnidad.getListaCarpetas();//obtenemos lista carpetas solamente una vez
            NodoCarpeta nodoCarpeta = listaCarpetas.obtenerNodoPorNombre("Universidad");
            if(nodoCarpeta != null){ //encontro carpeta
                ListaDocumento listaDocumentos = nodoCarpeta.getListaDocumento(); //obtenemos lista documentos solamente una vez
                NodoDocumento nodoDocumento = listaDocumentos.obtenerNodoPorNombre("Programacion");
                nodoDocumento.getListaLinea().vaciar();
            }
        }
        else {
            ret.valorString = "La ubicación no existe";
        }        
        return ret;
    }

    @Override
    public Retorno borrarOcurrenciasPalabraEnTexto(String palabraABorrar) {
        Retorno ret = new Retorno (Retorno.Resultado.OK);
        NodoUnidad nodoUnidad = this.unidades.obtenerNodoPorNombre("C");
        if(nodoUnidad != null){//si unidad existe procedemos 
            ListaCarpeta listaCarpetas = nodoUnidad.getListaCarpetas();//obtenemos lista carpetas solamente una vez
            NodoCarpeta nodoCarpeta = listaCarpetas.obtenerNodoPorNombre("Universidad");
            if(nodoCarpeta != null){ //encontro carpeta
                ListaDocumento listaDocumentos = nodoCarpeta.getListaDocumento(); //obtenemos lista documentos solamente una vez
                NodoDocumento nodoDocumento = listaDocumentos.obtenerNodoPorNombre("Programacion");
                nodoDocumento.getListaLinea().borrarOcurrenciaPalabra(palabraABorrar);
            }
        }
        else {
            ret.valorString = "La ubicación no existe";
        } 
        return ret;
    }

    @Override
    public Retorno imprimirTexto() {
        Retorno ret = new Retorno (Retorno.Resultado.OK);
        NodoUnidad nodoUnidad = this.unidades.obtenerNodoPorNombre("C");
        if(nodoUnidad != null){//si unidad existe procedemos
            ListaCarpeta listaCarpetas = nodoUnidad.getListaCarpetas();//obtenemos lista carpetas solamente una vez
            NodoCarpeta nodoCarpeta = listaCarpetas.obtenerNodoPorNombre("Universidad");
            if(nodoCarpeta != null){ //encontro carpeta
                ListaDocumento listaDocumentos = nodoCarpeta.getListaDocumento();
                NodoDocumento nodoDocumento = listaDocumentos.obtenerNodoPorNombre("Programacion");
                if(nodoDocumento != null){
                    nodoDocumento.getListaLinea().mostrar();
                }
                else {
                    ret.valorString = "No existe el documento";
                }
            }
            else {
                ret.valorString = "No hay carpetas en la estructura";
            }
        }
        else {
            ret.valorString = "La ubicación no existe";
        }
        return ret;
    }

    @Override
    public Retorno insertarPalabraEnLinea(int posicionLinea, int posicionPalabra, String palabraAIngresar) {
        Retorno ret = new Retorno (Retorno.Resultado.OK);
        NodoUnidad nodoUnidad = this.unidades.obtenerNodoPorNombre("C");
        if(nodoUnidad != null){//si unidad existe procedemos
            ListaCarpeta listaCarpetas = nodoUnidad.getListaCarpetas();//obtenemos lista carpetas solamente una vez
            NodoCarpeta nodoCarpeta = listaCarpetas.obtenerNodoPorNombre("Universidad");
            if(nodoCarpeta != null){ //encontro carpeta
                ListaDocumento listaDocumentos = nodoCarpeta.getListaDocumento();
                NodoDocumento nodoDocumento = listaDocumentos.obtenerNodoPorNombre("Programacion");
                NodoLinea nodoLinea = nodoDocumento.getListaLinea().obtenerNodoLineaPorNombre(posicionLinea);
                nodoLinea.getListaPalabra().agregarNodoPosicion(palabraAIngresar, posicionPalabra);
            }
            else {
                ret.valorString = "No hay carpetas en la estructura";
            }
        }
        else {
            ret.valorString = "La ubicación no existe";
        }        
        return ret;
    }

    @Override
    public Retorno insertarPalabraYDesplazar(int posicionLinea, int posicionPalabra, String palabraAIngresar) {
        Retorno ret = new Retorno (Retorno.Resultado.OK);
        return ret;
    }

    @Override
    public Retorno borrarPalabra(int posicionLinea, int posicionPalabra) {
        Retorno ret = new Retorno (Retorno.Resultado.OK);
        return ret;
    }

    @Override
    public Retorno borrarOcurrenciasPalabraEnLinea(int posicionLinea, String palabraABorrar) {
        Retorno ret = new Retorno (Retorno.Resultado.OK);
        return ret;
    }

    @Override
    public Retorno imprimirLinea(int posicionLinea) {
        Retorno ret = new Retorno (Retorno.Resultado.OK);
        return ret;
    }

    @Override
    public Retorno ingresarPalabraDiccionario(String palabraAIngresar) {
        Retorno ret = new Retorno (Retorno.Resultado.OK);
        return ret;
    }

    @Override
    public Retorno borrarPalabraDiccionario(String palabraABorrar) {
        Retorno ret = new Retorno (Retorno.Resultado.OK);
        return ret;
    }

    @Override
    public Retorno imprimirDiccionario() {
        Retorno ret = new Retorno (Retorno.Resultado.OK);
        return ret;
    }

    @Override
    public Retorno imprimirTextoIncorrecto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
