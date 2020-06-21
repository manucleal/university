package sistema.Interfaces;

import sistema.Retorno;

public interface ISistema {
    Retorno crearSistemaMensajes();
    Retorno destruirSistemaMensajes();
    Retorno agregarCarpeta(String unidad, String carpeta);
    Retorno eliminarCarpeta(String unidad, String carpeta);
    Retorno agregarMensaje(String unidad, String carpeta, String mensaje);
    Retorno eliminarMensaje(String unidad,String carpeta, String mensaje);
    Retorno listarEstructura(String unidad, String carpeta);
    Retorno insertarLinea();
    Retorno insertarLineaEnPosicion(int posicionLinea);
    Retorno borrarLinea(int posicionLinea);
    Retorno borrarTodo();
    Retorno borrarOcurrenciasPalabraEnTexto(String palabraABorrar);
    Retorno imprimirTexto();
    Retorno insertarPalabraEnLinea(int posicionLinea, int posicionPalabra, String palabraAIngresar);
    Retorno insertarPalabraYDesplazar(int posicionLinea, int posicionPalabra, String palabraAIngresar);
    Retorno borrarPalabra(int posicionLinea, int posicionPalabra);    
    Retorno borrarOcurrenciasPalabraEnLinea(int posicionLinea, String palabraABorrar);
    Retorno imprimirLinea(int posicionLinea);
    Retorno ingresarPalabraDiccionario(String palabraAIngresar);
    Retorno borrarPalabraDiccionario(String palabraABorrar);
    Retorno imprimirDiccionario();
    Retorno imprimirTextoIncorrecto();   
}
