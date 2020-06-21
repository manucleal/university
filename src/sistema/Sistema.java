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
        this.unidades = null;
        return ret;
    }

    @Override
    public Retorno agregarCarpeta(String unidad, String carpeta) {
        Retorno ret = new Retorno (Retorno.Resultado.OK);
        NodoUnidad nodoUnidad = this.unidades.obtenerNodoUnidadPorNombre(unidad);
                
        if(nodoUnidad != null){//si unidad existe procedemos 
            ListaCarpeta listaCarpetas = nodoUnidad.getListaCarpetas();
            
            NodoCarpeta nodoCarpeta = listaCarpetas.obtenerNodoCarpetaPorNombre(carpeta);
            
            if(nodoCarpeta == null){
                listaCarpetas.agregarFinal(carpeta);
            }
            else {
                ret.valorString = "Ya existe la carpeta: "+ carpeta + " en la ubicación";
            }
        }
        else {
             ret.valorString = "La ubicación no existe";
        }
       
        return ret;
    }

    @Override
    public Retorno eliminarCarpeta(String unidad, String carpeta) {
        Retorno ret = new Retorno (Retorno.Resultado.OK);
        NodoUnidad nodoUnidad = this.unidades.obtenerNodoUnidadPorNombre(unidad);
        
        if(nodoUnidad != null){//si unidad existe procedemos 
            ListaCarpeta listaCarpetas = nodoUnidad.getListaCarpetas();//obtenemos solamente una vez
            NodoCarpeta resultado = listaCarpetas.borrarElemento(carpeta);
            if(resultado != null){
                ret.valorString = "La carpeta eliminada fue "+ resultado.dato;
            }
            else {
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
        NodoUnidad nodoUnidad = this.unidades.obtenerNodoUnidadPorNombre(unidad);
        if(nodoUnidad != null){//si unidad existe procedemos 
            ListaCarpeta listaCarpetas = nodoUnidad.getListaCarpetas();//obtenemos lista carpetas solamente una vez
            NodoCarpeta nodoCarpeta = listaCarpetas.obtenerNodoCarpetaPorNombre(carpeta);
            if(nodoCarpeta != null){ //encontro carpeta
                ListaDocumento listaDocumentos = nodoCarpeta.getListaDocumento(); //obtenemos lista documentos solamente una vez
                NodoDocumento nodoDocumento = listaDocumentos.obtenerNodoDocumentoPorNombre(mensaje);
                if(nodoDocumento == null){
                    listaDocumentos.agregarFinal(mensaje);
                }
                else {
                    ret.valorString = "Ya existe el Documento: "+ mensaje + " en la ubicación";
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
        NodoUnidad nodoUnidad = this.unidades.obtenerNodoUnidadPorNombre(unidad);
        if(nodoUnidad != null){//si unidad existe procedemos 
            ListaCarpeta listaCarpetas = nodoUnidad.getListaCarpetas();//obtenemos lista carpetas solamente una vez
            NodoCarpeta nodoCarpeta = listaCarpetas.obtenerNodoCarpetaPorNombre(carpeta);
            if(nodoCarpeta != null){ //encontro carpeta
                ListaDocumento listaDocumentos = nodoCarpeta.getListaDocumento();//obtenemos lista documentos solamente una vez
                NodoDocumento resultado = listaDocumentos.borrarElemento(mensaje);
                if(resultado != null){
                    ret.valorString = "El Documento eliminado fue "+ resultado.dato;
                }
                else {
                    ret.valorString = "El Documento no existe";
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
        NodoUnidad nodoUnidad = this.unidades.obtenerNodoUnidadPorNombre(unidad);
        if(nodoUnidad != null){//si unidad existe procedemos
            ListaCarpeta listaCarpetas = nodoUnidad.getListaCarpetas();//obtenemos lista carpetas solamente una vez
            NodoCarpeta nodoCarpeta = listaCarpetas.obtenerNodoCarpetaPorNombre(carpeta);
            if(nodoCarpeta != null){ //encontro carpeta
                System.out.println(" Carpeta: " + carpeta+ "\n");
                nodoCarpeta.getListaDocumento().mostrar();
                //listaCarpetas.mostrar();
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
    public Retorno insertarLinea() {
        Retorno ret = new Retorno (Retorno.Resultado.OK);
        NodoUnidad nodoUnidad = this.unidades.obtenerNodoUnidadPorNombre("C");
        if(nodoUnidad != null){//si unidad existe procedemos 
            ListaCarpeta listaCarpetas = nodoUnidad.getListaCarpetas();//nos posicionamos en lista carpetas solamente una vez
            NodoCarpeta nodoCarpeta = listaCarpetas.obtenerNodoCarpetaPorNombre("Universidad");
            if(nodoCarpeta != null){ //encontro carpeta
                ListaDocumento listaDocumentos = nodoCarpeta.getListaDocumento(); //nos posicionamos en lista documentos solamente una vez
                NodoDocumento nodoDocumento = listaDocumentos.obtenerNodoDocumentoPorNombre("Programacion");
                
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
        Retorno ret = new Retorno (Retorno.Resultado.OK);
        NodoUnidad nodoUnidad = this.unidades.obtenerNodoUnidadPorNombre("C");
        if(nodoUnidad != null){//si unidad existe procedemos 
            ListaCarpeta listaCarpetas = nodoUnidad.getListaCarpetas();//obtenemos lista carpetas solamente una vez
            NodoCarpeta nodoCarpeta = listaCarpetas.obtenerNodoCarpetaPorNombre("Universidad");
            if(nodoCarpeta != null){ //encontro carpeta
                ListaDocumento listaDocumentos = nodoCarpeta.getListaDocumento(); //obtenemos lista documentos solamente una vez
                NodoDocumento nodoDocumento = listaDocumentos.obtenerNodoDocumentoPorNombre("Programacion");
                nodoDocumento.getListaLinea().agregarNodoPosicion(posicionLinea, posicionLinea);
            }
        }
        else {
            ret.valorString = "La ubicación no existe";
        }
        return ret;
    }

    @Override
    public Retorno borrarLinea(int posicionLinea) {
        Retorno ret = new Retorno (Retorno.Resultado.ERROR);
        NodoUnidad nodoUnidad = this.unidades.obtenerNodoUnidadPorNombre("C");
        if(nodoUnidad != null){//si unidad existe procedemos 
            ListaCarpeta listaCarpetas = nodoUnidad.getListaCarpetas();//obtenemos lista carpetas solamente una vez
            NodoCarpeta nodoCarpeta = listaCarpetas.obtenerNodoCarpetaPorNombre("Universidad");
            if(nodoCarpeta != null){ //encontro carpeta
                ListaDocumento listaDocumentos = nodoCarpeta.getListaDocumento(); //obtenemos lista documentos solamente una vez
                NodoDocumento nodoDocumento = listaDocumentos.obtenerNodoDocumentoPorNombre("Programacion");
                nodoDocumento.getListaLinea().borrarNodoPosicion(posicionLinea);
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
        NodoUnidad nodoUnidad = this.unidades.obtenerNodoUnidadPorNombre("C");
        if(nodoUnidad != null){//si unidad existe procedemos 
            ListaCarpeta listaCarpetas = nodoUnidad.getListaCarpetas();//obtenemos lista carpetas solamente una vez
            NodoCarpeta nodoCarpeta = listaCarpetas.obtenerNodoCarpetaPorNombre("Universidad");
            if(nodoCarpeta != null){ //encontro carpeta
                ListaDocumento listaDocumentos = nodoCarpeta.getListaDocumento(); //obtenemos lista documentos solamente una vez
                NodoDocumento nodoDocumento = listaDocumentos.obtenerNodoDocumentoPorNombre("Programacion");
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
        return ret;
    }

    @Override
    public Retorno imprimirTexto() {
        Retorno ret = new Retorno (Retorno.Resultado.OK);
        NodoUnidad nodoUnidad = this.unidades.obtenerNodoUnidadPorNombre("C");
        if(nodoUnidad != null){//si unidad existe procedemos
            ListaCarpeta listaCarpetas = nodoUnidad.getListaCarpetas();//obtenemos lista carpetas solamente una vez
            NodoCarpeta nodoCarpeta = listaCarpetas.obtenerNodoCarpetaPorNombre("Universidad");
            if(nodoCarpeta != null){ //encontro carpeta
                ListaDocumento listaDocumentos = nodoCarpeta.getListaDocumento();
                NodoDocumento nodoDocumento = listaDocumentos.obtenerNodoDocumentoPorNombre("Programacion");
                nodoDocumento.getListaLinea().mostrar();
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
        NodoUnidad nodoUnidad = this.unidades.obtenerNodoUnidadPorNombre("C");
        if(nodoUnidad != null){//si unidad existe procedemos
            ListaCarpeta listaCarpetas = nodoUnidad.getListaCarpetas();//obtenemos lista carpetas solamente una vez
            NodoCarpeta nodoCarpeta = listaCarpetas.obtenerNodoCarpetaPorNombre("Universidad");
            if(nodoCarpeta != null){ //encontro carpeta
                ListaDocumento listaDocumentos = nodoCarpeta.getListaDocumento();
                NodoDocumento nodoDocumento = listaDocumentos.obtenerNodoDocumentoPorNombre("Programacion");
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