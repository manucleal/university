package sistema.Interfaces;

import sistema.Retorno;

public interface ISistema {
    Retorno CrearSistemaMensajes();
    Retorno DestruirSistemaMensajes();
    Retorno AgregarCarpeta(String unidad, String carpeta);
    Retorno EliminarCarpeta(String unidad, String carpeta);
    Retorno AgregarMensaje(String unidad, String carpeta, String mensaje);
    Retorno EliminarMensaje(String unidad,String carpeta, String mensaje);
    Retorno ListarEstructura(String unidad, String carpeta);
    Retorno InsertarLinea();
    Retorno InsertarLineaEnPosicion(int posicionLinea);
    Retorno BorrarLinea(int posicionLinea);
    Retorno BorrarTodo();
    Retorno BorrarOcurrenciasPalabraEnTexto(String palabraABorrar);
    Retorno ImprimirTexto();
    Retorno InsertarPalabraEnLinea(int posicionLinea, int posicionPalabra, String palabraAIngresar);
    Retorno InsertarPalabraYDesplazar(int posicionLinea, int posicionPalabra, String palabraAIngresar);
    Retorno BorrarPalabra(int posicionLinea, int posicionPalabra);    
    Retorno BorrarOcurrenciasPalabraEnLinea(int posicionLinea, String palabraABorrar);
    Retorno ImprimirLinea(int posicionLinea);
    Retorno IngresarPalabraDiccionario(String palabraAIngresar);
    Retorno BorrarPalabraDiccionario(String palabraABorrar);
    Retorno ImprimirDiccionario();
    Retorno ImprimirTextoIncorrecto();   
}
