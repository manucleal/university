package sistema;

import sistema.Interfaces.ISistema;
import sistema.Listas.ListaCarpeta;
import sistema.Listas.ListaDiccionario;
import sistema.Listas.ListaDocumento;
import sistema.Listas.ListaLinea;
import sistema.Listas.ListaPalabra;
import sistema.Listas.ListaUnidad;
import sistema.Nodos.*;

public class Sistema implements ISistema{
    public ListaUnidad unidades;
    public ListaDiccionario diccionario;
    public int cantidadCiudades;
    public int matriz[][];
    
    public int[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }    
            
    @Override
    public Retorno CrearSistemaMensajes() {
        Retorno ret = new Retorno (Retorno.Resultado.OK);
        if(this.unidades == null){
            this.unidades = new ListaUnidad();
            this.unidades.agregarInicio("C");
            this.diccionario = new ListaDiccionario();
            this.cantidadCiudades = 7;
            this.matriz = new int[this.cantidadCiudades][this.cantidadCiudades];
        }
        return ret;
    }

    @Override
    public Retorno DestruirSistemaMensajes() {
        Retorno ret = new Retorno (Retorno.Resultado.OK);    
        this.unidades.vaciar();
        return ret;
    }

    @Override
    public Retorno AgregarCarpeta(String unidad, String carpeta) {
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
    public Retorno EliminarCarpeta(String unidad, String carpeta) {
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
    public Retorno AgregarMensaje(String unidad, String carpeta, String mensaje) {
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
    public Retorno EliminarMensaje(String unidad, String carpeta, String mensaje) {
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
    public Retorno ListarEstructura(String unidad, String carpeta) {
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
    public Retorno InsertarLinea() {
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
    public Retorno InsertarLineaEnPosicion(int posicionLinea) {
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
    public Retorno BorrarLinea(int posicionLinea) {
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
    public Retorno BorrarTodo() {
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
    public Retorno ImprimirTexto() {
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
    public Retorno InsertarPalabraEnLinea(int posicionLinea, int posicionPalabra, String palabraAIngresar) {
        Retorno ret = new Retorno (Retorno.Resultado.OK);
        NodoUnidad nodoUnidad = this.unidades.obtenerNodoPorNombre("C");
        if(nodoUnidad != null){//si unidad existe procedemos
            ListaCarpeta listaCarpetas = nodoUnidad.getListaCarpetas();//obtenemos lista carpetas solamente una vez
            NodoCarpeta nodoCarpeta = listaCarpetas.obtenerNodoPorNombre("Universidad");
            if(nodoCarpeta != null){ //encontro carpeta
                ListaDocumento listaDocumentos = nodoCarpeta.getListaDocumento();
                NodoDocumento nodoDocumento = listaDocumentos.obtenerNodoPorNombre("Programacion");
                NodoLinea nodoLinea = nodoDocumento.getListaLinea().obtenerNodoPorNombre(posicionLinea);
                if(nodoLinea != null){
                    ListaPalabra listaPalabras = nodoLinea.getListaPalabra();
                    if(listaPalabras.getMAX_CANT_PALABRAS_X_LINEA() > listaPalabras.getCantidadElementos()){
                        if(posicionPalabra >= 1 && posicionPalabra <= (listaPalabras.getCantidadElementos() + 1)){
                            listaPalabras.agregarNodoPosicion(palabraAIngresar, posicionPalabra);
                        }
                        else {
                            ret.valorString = "la posición de la palabra no es válida";
                        }
                    }
                    else {
                        ret.valorString = "Superara la cantidad máxima de palabras por línea -> Cantidad permitida: " + listaPalabras.getMAX_CANT_PALABRAS_X_LINEA();
                    }
                }
                else {
                    ret.valorString = "La posición de la línea no es válida";
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
    public Retorno InsertarPalabraYDesplazar(int posicionLinea, int posicionPalabra, String palabraAIngresar) {
        Retorno ret = new Retorno (Retorno.Resultado.OK);
        NodoUnidad nodoUnidad = this.unidades.obtenerNodoPorNombre("C");
        if(nodoUnidad != null){//si unidad existe procedemos
            ListaCarpeta listaCarpetas = nodoUnidad.getListaCarpetas();//obtenemos lista carpetas solamente una vez
            NodoCarpeta nodoCarpeta = listaCarpetas.obtenerNodoPorNombre("Universidad");
            if(nodoCarpeta != null){ //encontro carpeta
                ListaDocumento listaDocumentos = nodoCarpeta.getListaDocumento();
                NodoDocumento nodoDocumento = listaDocumentos.obtenerNodoPorNombre("Programacion");
                ListaLinea listaLineas = nodoDocumento.getListaLinea();//nos posicionamos en lista lineas solamente una vez

                ret.valorString = listaLineas.reOrdenarPalabrasEnLineas(posicionLinea, palabraAIngresar, posicionPalabra);
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
    public Retorno BorrarOcurrenciasPalabraEnTexto(String palabraABorrar) {
        Retorno ret = new Retorno (Retorno.Resultado.OK);
        NodoUnidad nodoUnidad = this.unidades.obtenerNodoPorNombre("C");
        if(nodoUnidad != null){//si unidad existe procedemos 
            ListaCarpeta listaCarpetas = nodoUnidad.getListaCarpetas();//obtenemos lista carpetas solamente una vez
            NodoCarpeta nodoCarpeta = listaCarpetas.obtenerNodoPorNombre("Universidad");
            if(nodoCarpeta != null){ //encontro carpeta
                ListaDocumento listaDocumentos = nodoCarpeta.getListaDocumento(); //obtenemos lista documentos solamente una vez
                NodoDocumento nodoDocumento = listaDocumentos.obtenerNodoPorNombre("Programacion");
                nodoDocumento.getListaLinea().borrarOcurrenciaPalabraTexto(palabraABorrar);
            }
        }
        else {
            ret.valorString = "La ubicación no existe";
        } 
        return ret;
    }
    
    @Override
    public Retorno BorrarPalabra(int posicionLinea, int posicionPalabra) {
        Retorno ret = new Retorno (Retorno.Resultado.OK);
        NodoUnidad nodoUnidad = this.unidades.obtenerNodoPorNombre("C");
        if(nodoUnidad != null){//si unidad existe procedemos 
            ListaCarpeta listaCarpetas = nodoUnidad.getListaCarpetas(); //obtenemos lista carpetas solamente una vez
            NodoCarpeta nodoCarpeta = listaCarpetas.obtenerNodoPorNombre("Universidad");
            if(nodoCarpeta != null){ //encontro carpeta
                ListaDocumento listaDocumentos = nodoCarpeta.getListaDocumento(); //obtenemos lista documentos solamente una vez
                NodoDocumento nodoDocumento = listaDocumentos.obtenerNodoPorNombre("Programacion");
                nodoDocumento.getListaLinea().borrarOcurrenciaPalabraLineaPorPosicion(posicionLinea, posicionPalabra);
            }
        }
        else {
            ret.valorString = "La ubicación no existe";
        }         
        return ret;
    }

    @Override
    public Retorno BorrarOcurrenciasPalabraEnLinea(int posicionLinea, String palabraABorrar) {
        Retorno ret = new Retorno (Retorno.Resultado.OK);
        NodoUnidad nodoUnidad = this.unidades.obtenerNodoPorNombre("C");
        if(nodoUnidad != null){//si unidad existe procedemos 
            ListaCarpeta listaCarpetas = nodoUnidad.getListaCarpetas(); //obtenemos lista carpetas solamente una vez
            NodoCarpeta nodoCarpeta = listaCarpetas.obtenerNodoPorNombre("Universidad");
            if(nodoCarpeta != null){ //encontro carpeta
                ListaDocumento listaDocumentos = nodoCarpeta.getListaDocumento(); //obtenemos lista documentos solamente una vez
                NodoDocumento nodoDocumento = listaDocumentos.obtenerNodoPorNombre("Programacion");
                nodoDocumento.getListaLinea().borrarOcurrenciaPalabraLineaPorNombre(posicionLinea, palabraABorrar);
            }
        }
        else {
            ret.valorString = "La ubicación no existe";
        }         
        return ret;
    }

    @Override
    public Retorno ImprimirLinea(int posicionLinea) {
        Retorno ret = new Retorno (Retorno.Resultado.OK);
        NodoUnidad nodoUnidad = this.unidades.obtenerNodoPorNombre("C");
        if(nodoUnidad != null){//si unidad existe procedemos
            ListaCarpeta listaCarpetas = nodoUnidad.getListaCarpetas();//obtenemos lista carpetas solamente una vez
            NodoCarpeta nodoCarpeta = listaCarpetas.obtenerNodoPorNombre("Universidad");
            if(nodoCarpeta != null){ //encontro carpeta
                ListaDocumento listaDocumentos = nodoCarpeta.getListaDocumento();
                NodoDocumento nodoDocumento = listaDocumentos.obtenerNodoPorNombre("Programacion");
                if(nodoDocumento != null){
                    NodoLinea nodolinea = nodoDocumento.getListaLinea().obtenerNodoPorNombre(posicionLinea);
                    if(nodolinea != null){
                        nodoDocumento.getListaLinea().mostrarPorLinea(posicionLinea);
                    }
                    else {
                        ret.valorString = "No existe el Linea";
                    }
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
    public Retorno IngresarPalabraDiccionario(String palabraAIngresar) {
        Retorno ret = new Retorno (Retorno.Resultado.OK);

        NodoPalabra palabra = this.diccionario.obtenerNodoPalabraPorNombre(palabraAIngresar);
        if(palabra == null){
            this.diccionario.insertarOrdenado(palabraAIngresar);
        }
        else {
            ret.valorString = "Palabra ya existe";
        }
        return ret;
    }

    @Override
    public Retorno BorrarPalabraDiccionario(String palabraABorrar) {
        Retorno ret = new Retorno (Retorno.Resultado.OK);
        this.diccionario.borrarOcurrenciaPalabraTexto(palabraABorrar);
        return ret;
    }

    @Override
    public Retorno ImprimirDiccionario() {
        Retorno ret = new Retorno (Retorno.Resultado.OK);
        this.diccionario.mostrar();
        return ret;
    }

    @Override
    public Retorno ImprimirTextoIncorrecto() {
        Retorno ret = new Retorno (Retorno.Resultado.OK);
        NodoUnidad nodoUnidad = this.unidades.obtenerNodoPorNombre("C");
        if(nodoUnidad != null){//si unidad existe procedemos
            ListaCarpeta listaCarpetas = nodoUnidad.getListaCarpetas();//obtenemos lista carpetas solamente una vez
            NodoCarpeta nodoCarpeta = listaCarpetas.obtenerNodoPorNombre("Universidad");
            if(nodoCarpeta != null){ //encontro carpeta
                ListaDocumento listaDocumentos = nodoCarpeta.getListaDocumento();
                NodoDocumento nodoDocumento = listaDocumentos.obtenerNodoPorNombre("Programacion");
                if(nodoDocumento != null){
                    nodoDocumento.getListaLinea().mostrarPalabrasNoDiccionario(this.diccionario);
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
    public Retorno CargarDistancias(int[][] Ciudades) {
        Retorno ret = new Retorno (Retorno.Resultado.OK); 
        
        Ciudades[1][3] = 9;
        Ciudades[3][1] = 9;
        
        Ciudades[5][6] = 9;
        Ciudades[6][5] = 9;  

        Ciudades[2][5] = 14;
        Ciudades[5][2] = 14;
        
        Ciudades[1][6] = 14;
        Ciudades[6][1] = 14;        
        
        Ciudades[1][2] = 1;
        Ciudades[2][1] = 1;
        
        Ciudades[2][3] = 10;
        Ciudades[3][2] = 10;
              
        Ciudades[3][6] = 2;
        Ciudades[3][3] = 2;
        
        Ciudades[3][5] = 3;
        Ciudades[5][3] = 3; 
        
        Ciudades[3][4] = 11;
        Ciudades[4][3] = 11;

        Ciudades[5][4] = 6;
        Ciudades[4][5] = 6;
        
        Ciudades[2][4] = 15;
        Ciudades[4][2] = 15;        
        
   

       
        
//        Ciudades[0][1] = 5;
//        Ciudades[1][0] = 5;
//    
//        Ciudades[0][2] = 2;
//        Ciudades[2][0] = 2;
//        
//        Ciudades[1][2] = 2;
//        Ciudades[2][1] = 2;
//        
//        Ciudades[1][3] = 3;
//        Ciudades[3][1] = 3;
//        
//        Ciudades[2][4] = 4;
//        Ciudades[4][2] = 4;
//        
//        Ciudades[3][4] = 1;
//        Ciudades[4][3] = 1;
//        
//        Ciudades[1][4] = 3;                                                                   
//        Ciudades[4][1] = 3;
//        
//        Ciudades[0][3] = 4;
//        Ciudades[3][0] = 4;
//        
//        Ciudades[2][3] = 4;
//        Ciudades[3][2] = 4;
        
        return ret;
    }


    @Override
    public Retorno BuscarCamino(int[][] M, String origen, String destino) {
        Retorno ret = new Retorno (Retorno.Resultado.OK);
        
        int miorigen = this.ciudadAnumero(origen);
        int midestino = this.ciudadAnumero(destino);
       
        ret.valorString = "";
        int suma = 6999999;
        String escala="";
        int columnas = M[0].length;
        
        for(int i = 0; i < columnas; i++){
            if(M[miorigen][i] != 0 && M[midestino][i] != 0){
                if(M[miorigen][i] + M[midestino][i] < suma){
                    suma = M[miorigen][i] + M[midestino][i];
                    escala = this.numeroAciudad(i);
                    
                    ret.valorString = "El camino mas corto es : Origen: " + origen + " escala: " + escala + " destino: " + destino + " cantidad horas: " + suma;
                    //ret.valorString = "El camino mas corto es : " + origen +" - " +escala +" - " + destino;
                }
            }
        }
       
        return ret;
    }
    
    // metodos auxiliares    
    private int ciudadAnumero(String Ciudad){
//        if (Ciudad.equals("MVD")) return 0;
//        if (Ciudad.equals("POA")) return 1;
//        if (Ciudad.equals("BA")) return 2;
//        if (Ciudad.equals("SP")) return 3;
//        if (Ciudad.equals("NYC")) return 4;
//        if (Ciudad.equals("MIA")) return 5;
//        if (Ciudad.equals("MAD")) return 6; 

        if (Ciudad.equals("MVD")) return 1;
        if (Ciudad.equals("BAs")) return 2;
        if (Ciudad.equals("POA")) return 3;
        if (Ciudad.equals("RIO")) return 4;
        if (Ciudad.equals("MIA")) return 5;
        if (Ciudad.equals("SP")) return 6;
        //if (Ciudad.equals("MAD")) return 6;
        return -1;    
    }    

    private String numeroAciudad(int numeroCiudad){
        if (numeroCiudad == 1) return "MVD";
        if (numeroCiudad == 2) return "BAs";
        if (numeroCiudad == 3) return "POA";
        if (numeroCiudad == 4) return "RIO";
        if (numeroCiudad == 5) return "MIA";
        if (numeroCiudad == 6) return "SP";
        //if (numeroCiudad == 6) return "MAD";    
        return "";
    }

    @Override
    public Retorno mostrarestructuracompleta(String unidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
