package sistema;

public class Obligatorio2020 {

    public static void main(String[] args) {
        Sistema sist = new Sistema();
        Prueba p1 = new Prueba();
        
        //pruebaSinErrores(sist, p1);
        
        pruebaErroresCrearCarpeta(sist, p1);

    }
    
    public static void pruebaSinErrores(Sistema s, Prueba p){
        p.ver(s.crearSistemaMensajes().resultado, Retorno.Resultado.OK, "Se creo Sistema con una unidad C");
        p.ver(s.agregarCarpeta("C", "Personal").resultado, Retorno.Resultado.OK, "Se creo carpeta -> Personal en Unidad C");
        p.ver(s.agregarCarpeta("C", "Universidad").resultado, Retorno.Resultado.OK, "Se creo carpeta -> Universidad en Unidad C");
        p.ver(s.agregarCarpeta("C", "Trabajo").resultado, Retorno.Resultado.OK, "Se creo carpeta -> Trabajo en Unidad C");
        p.ver(s.agregarCarpeta("C", "Otros").resultado, Retorno.Resultado.OK, "Se creo carpeta -> Otros en Unidad C");
        //eliminando carpeta Otros
        p.ver(s.eliminarCarpeta("C", "Otros").resultado, Retorno.Resultado.OK, "Se eliminó carpeta Otros de unidad C");
        //agregando mensajes
        p.ver(s.agregarMensaje("C", "Universidad", "Programacion").resultado, Retorno.Resultado.OK, "Se agrego Mensaje/Documento Programacion a la carpeta Universidad de unidad C");
        p.ver(s.agregarMensaje("C", "Universidad", "Algoritmos y Estructuras de Datos").resultado, Retorno.Resultado.OK, "Se agrego Mensaje/Documento Algoritmos y Estructuras de Datos a la carpeta Universidad de unidad C");
        p.ver(s.agregarMensaje("C", "Personal", "Gastos").resultado, Retorno.Resultado.OK, "Se agrego Mensaje/Documento Gastos a la carpeta Personal de unidad C");
        p.ver(s.agregarMensaje("C", "Trabajo", "ADX").resultado, Retorno.Resultado.OK, "Se agrego Mensaje/Documento ADX a la carpeta Personal de unidad C");
        p.ver(s.agregarMensaje("C", "Trabajo", "AudioTrade").resultado, Retorno.Resultado.OK, "Se agrego Mensaje/Documento AudioTrade a la carpeta Personal de unidad C");
        
        
//        p.ver(s.listarEstructura("C", "Universidad").resultado, Retorno.Resultado.OK, "###### Estructura Carpeta: Universidad ######");
//        p.ver(s.listarEstructura("C", "Personal").resultado, Retorno.Resultado.OK, "###### Estructura Carpeta: Personal ######");
//        p.ver(s.listarEstructura("C", "Trabajo").resultado, Retorno.Resultado.OK, "###### Estructura Carpeta: Trabajo ######");
//        p.ver(s.listarEstructura("C", "Otros").resultado, Retorno.Resultado.OK, "###### Estructura Carpeta: Otros ######");
//        
//        p.ver(s.insertarLinea().resultado, Retorno.Resultado.OK, "Insertar linea 1 en blanco, Documento Programacion de Carpeta Universidad");
//        p.ver(s.insertarLinea().resultado, Retorno.Resultado.OK, "Insertar linea 2 en blanco, Documento Programacion de Carpeta Universidad");
//        p.ver(s.insertarLinea().resultado, Retorno.Resultado.OK, "Insertar linea 3 en blanco, Documento Programacion de Carpeta Universidad");
//        p.ver(s.insertarLinea().resultado, Retorno.Resultado.OK, "Insertar linea 4 en blanco, Documento Programacion de Carpeta Universidad");
//        p.ver(s.insertarLinea().resultado, Retorno.Resultado.OK, "Insertar linea 5 en blanco, Documento Programacion de Carpeta Universidad");
//        p.ver(s.insertarLineaEnPosicion(6).resultado, Retorno.Resultado.OK, "Insertar linea 6 blanco, Documento Programacion de Carpeta Universidad");
        
        
        
        
        //p.ver(s.imprimirTexto().resultado, Retorno.Resultado.OK, "Imprimir texto de Documento Programación");
        
        //p.ver(s.borrarLinea(2).resultado,Retorno.Resultado.ERROR,"Borrar linea 2");
//        
//        p.ver(s.imprimirTexto().resultado, Retorno.Resultado.OK, "Imprimir texto de Documento Programación"); 
//        
//        p.ver(s.borrarTodo().resultado, Retorno.Resultado.OK, "Documento Programacion vaciado !!");
//        
//        
//        p.ver(s.imprimirTexto().resultado, Retorno.Resultado.OK, "Imprimir texto de Documento Programación"); 
//        
//        p.ver(s.insertarPalabraEnLinea(4, 2, "hdp").resultado, Retorno.Resultado.OK, "Insertar Palabra En Linea");
//        p.ver(s.insertarPalabraEnLinea(4, 1, "manu").resultado, Retorno.Resultado.OK, "Insertar Palabra En Linea");
//        p.ver(s.insertarPalabraEnLinea(4, 2, "hdpppp").resultado, Retorno.Resultado.OK, "Insertar Palabra En Linea");
//        p.ver(s.insertarPalabraEnLinea(4, 2, "segundo").resultado, Retorno.Resultado.OK, "Insertar Palabra En Linea");
//        p.ver(s.insertarPalabraEnLinea(4, 1, "primero").resultado, Retorno.Resultado.OK, "Insertar Palabra En Linea");
//        p.ver(s.insertarPalabraEnLinea(4, 1, "jeje").resultado, Retorno.Resultado.OK, "Insertar Palabra En Linea");
//        
//        p.ver(s.imprimirTexto().resultado, Retorno.Resultado.OK, "Imprimir texto de Documento Programación");
//        
//        p.ver(s.borrarOcurrenciasPalabraEnTexto("hdp").resultado, Retorno.Resultado.OK, "Borrar palabra hdp de documento Programacion");
//        p.ver(s.borrarOcurrenciasPalabraEnTexto("jeje").resultado, Retorno.Resultado.OK, "Borrar palabra jeje de documento Programacion");
//        p.ver(s.borrarOcurrenciasPalabraEnTexto("manu").resultado, Retorno.Resultado.OK, "Borrar palabra manu de documento Programacion");
//        p.ver(s.borrarOcurrenciasPalabraEnTexto("segundo").resultado, Retorno.Resultado.OK, "Borrar palabra manu de documento Programacion");
//
//        p.ver(s.imprimirTexto().resultado, Retorno.Resultado.OK, "Imprimir texto de Documento Programación");
    }
    
    public static void pruebaErroresCrearCarpeta(Sistema s, Prueba p){
        p.ver(s.crearSistemaMensajes().resultado, Retorno.Resultado.OK, "Se creo Sistema con una unidad C");
        p.ver(s.agregarCarpeta("C", "Personal").resultado, Retorno.Resultado.OK, "Se creo carpeta -> Personal en Unidad C");
        p.ver(s.agregarCarpeta("C", "Universidad").resultado, Retorno.Resultado.OK, "Se creo carpeta -> Universidad en Unidad C");
        p.ver(s.agregarMensaje("C", "Universidad", "Programacion").resultado, Retorno.Resultado.OK, "Se agrego Mensaje/Documento Programacion a la carpeta Universidad de unidad C");
        
//intento crear carpeta duplicada
        Retorno crearCarpetaDuplicada = s.agregarCarpeta("C", "Universidad");
        p.ver(crearCarpetaDuplicada.resultado, Retorno.Resultado.ERROR, crearCarpetaDuplicada.valorString);
        
        //intento crear carpeta en ubicacion que no existe 
        Retorno crearCarpetaUnidadNoExiste = s.agregarCarpeta("H", "Universidad");
        p.ver(crearCarpetaUnidadNoExiste.resultado, Retorno.Resultado.ERROR, crearCarpetaUnidadNoExiste.valorString);
        
        //intento eliminar carpeta en unidad que no existe
        Retorno eliminarCarpetaNoExisteUnidad = s.eliminarCarpeta("H", "Universidad");
        p.ver(eliminarCarpetaNoExisteUnidad.resultado, Retorno.Resultado.ERROR, eliminarCarpetaNoExisteUnidad.valorString);
        
        //intento eliminar carpeta que no existe
        Retorno eliminarCarpetaNoExisteCarpeta = s.eliminarCarpeta("C", "pepe");
        p.ver(eliminarCarpetaNoExisteCarpeta.resultado, Retorno.Resultado.ERROR, eliminarCarpetaNoExisteCarpeta.valorString);
        
        //intento agregar mesanje en carpeta no existente
        Retorno agregarMensajeEnCarpetaNoExiste = s.agregarMensaje("C", "pepito", "Programacion");
        p.ver(agregarMensajeEnCarpetaNoExiste.resultado, Retorno.Resultado.ERROR, agregarMensajeEnCarpetaNoExiste.valorString);
        
        //intento agregar mesanje en unidad que no existe
        Retorno agregarMensajeEnUnidadNoExiste = s.agregarMensaje("H", "Universidad", "Programacion");
        p.ver(agregarMensajeEnUnidadNoExiste.resultado, Retorno.Resultado.ERROR, agregarMensajeEnUnidadNoExiste.valorString);
        
        //intento agregar mesanje en unidad que no existe
        Retorno agregarMensajeQueExiste = s.agregarMensaje("C", "Universidad", "Programacion");
        p.ver(agregarMensajeQueExiste.resultado, Retorno.Resultado.ERROR, agregarMensajeQueExiste.valorString);
        
//        p.ver(s.agregarMensaje("C", "Universidad", "Algoritmos y Estructuras de Datos").resultado, Retorno.Resultado.OK, "Se agrego Mensaje/Documento Algoritmos y Estructuras de Datos a la carpeta Universidad de unidad C");
//        p.ver(s.agregarMensaje("C", "Personal", "Gastos").resultado, Retorno.Resultado.OK, "Se agrego Mensaje/Documento Gastos a la carpeta Personal de unidad C");
//        p.ver(s.agregarMensaje("C", "Trabajo", "ADX").resultado, Retorno.Resultado.OK, "Se agrego Mensaje/Documento ADX a la carpeta Personal de unidad C");
//        p.ver(s.agregarMensaje("C", "Trabajo", "AudioTrade").resultado, Retorno.Resultado.OK, "Se agrego Mensaje/Documento AudioTrade a la carpeta Personal de unidad C");
    }
    
}