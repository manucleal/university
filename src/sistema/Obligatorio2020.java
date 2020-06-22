package sistema;

public class Obligatorio2020 {

    public static void main(String[] args) {
        Sistema sist = new Sistema();
        Prueba p1 = new Prueba();
        
        pruebaSinErrores(sist, p1);
        
        //pruebaErroresCrearCarpeta(sist, p1);

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
        p.ver(s.agregarMensaje("C", "Universidad", "Programacion2").resultado, Retorno.Resultado.OK, "Se agrego Mensaje/Documento Programacion2 a la carpeta Universidad de unidad C");
        p.ver(s.agregarMensaje("C", "Universidad", "Algoritmos y Estructuras de Datos").resultado, Retorno.Resultado.OK, "Se agrego Mensaje/Documento Algoritmos y Estructuras de Datos a la carpeta Universidad de unidad C");
        p.ver(s.agregarMensaje("C", "Personal", "Gastos").resultado, Retorno.Resultado.OK, "Se agrego Mensaje/Documento Gastos a la carpeta Personal de unidad C");
        p.ver(s.agregarMensaje("C", "Trabajo", "ADX").resultado, Retorno.Resultado.OK, "Se agrego Mensaje/Documento ADX a la carpeta Personal de unidad C");
        p.ver(s.agregarMensaje("C", "Trabajo", "AudioTrade").resultado, Retorno.Resultado.OK, "Se agrego Mensaje/Documento AudioTrade a la carpeta Personal de unidad C");
        
        //eliminando nodo carpeta del medio
        p.ver(s.eliminarMensaje("C", "Universidad", "Programacion2").resultado, Retorno.Resultado.OK, "Se elimino Mensaje/Documento Programacion2 de carpeta Universidad en unidad C");
        
        
        p.ver(s.listarEstructura("C", "Universidad").resultado, Retorno.Resultado.OK, "###### Estructura Carpeta: Universidad ######");
        p.ver(s.listarEstructura("C", "Personal").resultado, Retorno.Resultado.OK, "###### Estructura Carpeta: Personal ######");
        /***** INSERTAR LINEAS EN BLANCO AL FINAL *****/
        p.ver(s.insertarLinea().resultado, Retorno.Resultado.OK, "Insertar linea AL FINAL 1 en blanco, Documento Programacion de Carpeta Universidad");
        p.ver(s.insertarLinea().resultado, Retorno.Resultado.OK, "Insertar linea AL FINAL 2 en blanco, Documento Programacion de Carpeta Universidad");
        p.ver(s.insertarLinea().resultado, Retorno.Resultado.OK, "Insertar linea AL FINAL 3 en blanco, Documento Programacion de Carpeta Universidad");
        p.ver(s.insertarLinea().resultado, Retorno.Resultado.OK, "Insertar linea AL FINAL 4 en blanco, Documento Programacion de Carpeta Universidad");
        p.ver(s.insertarLinea().resultado, Retorno.Resultado.OK, "Insertar linea AL FINAL 5 en blanco, Documento Programacion de Carpeta Universidad"); 
        
        /***** INSERTAR LINEAS EN BLANCO POSICION ESPECIFICA *****/
        p.ver(s.insertarLineaEnPosicion(1).resultado, Retorno.Resultado.OK, "Insertar linea POS 1 en blanco, Documento Programacion de Carpeta Universidad");
        
        /***** INSERTAR PALABRAS EN UNA LINEA ESPECIFICA Y EN UNA POSICION ESPECIFICA *****/
        p.ver(s.insertarPalabraEnLinea(1, 1, "Emanuel").resultado, Retorno.Resultado.OK, "Insertar Palabra En Linea 1 en Posicion de linea 1");
        p.ver(s.insertarPalabraEnLinea(1, 2, "Coitino").resultado, Retorno.Resultado.OK, "Insertar Palabra En Linea 1 en Posicion de linea 1");
        
        /***** INSERTAR LINEAS EN BLANCO POSICION ESPECIFICA *****/
        p.ver(s.insertarLineaEnPosicion(1).resultado, Retorno.Resultado.OK, "Insertar linea 1 blanco, Documento Programacion de Carpeta Universidad");
        p.ver(s.insertarLineaEnPosicion(1).resultado, Retorno.Resultado.OK, "Insertar linea 1 blanco, Documento Programacion de Carpeta Universidad");

        p.ver(s.imprimirTexto().resultado, Retorno.Resultado.OK, "Imprimir texto de Documento Programación");
        /***** BORRAR LINEAS EN BLANCO POSICION ESPECIFICA *****/
        p.ver(s.borrarLinea(2).resultado,Retorno.Resultado.OK,"Borrar linea 2");
        p.ver(s.borrarLinea(7).resultado,Retorno.Resultado.OK,"Borrar linea 7");
        
        p.ver(s.imprimirTexto().resultado, Retorno.Resultado.OK, "Imprimir texto de Documento Programación");
        
        /***** BORRAR TODO DE DOC PROGRAMACION E IMPRIMIR PARA VERIFICAR QUE NO ESTEN LOS DATOS *****/
        //p.ver(s.borrarTodo().resultado, Retorno.Resultado.OK, "Documento Programacion vaciado !!");
        p.ver(s.imprimirTexto().resultado, Retorno.Resultado.OK, "Texto Vacio`");  
        
        /***** INSERTAR PALABRAS *****/
        p.ver(s.insertarPalabraEnLinea(1, 2, "Emanuel").resultado, Retorno.Resultado.OK, "Insertar Palabra En Linea");
        p.ver(s.insertarPalabraEnLinea(1, 1, "manu").resultado, Retorno.Resultado.OK, "Insertar Palabra En Linea");
        p.ver(s.insertarPalabraEnLinea(6, 3, "Emanuel").resultado, Retorno.Resultado.OK, "Insertar Palabra En Linea");
        
        /***** IMPRIMIR PARA VER PALABRAS INSERTADAS *****/
        p.ver(s.imprimirTexto().resultado, Retorno.Resultado.OK, "Imprimir texto de Documento Programación");
        
        /***** BORRAR OCURRENCIAS DE PALABRA "EMANUEL" EN DOCUMENTO PROGRAMACION *****/  
        p.ver(s.borrarOcurrenciasPalabraEnTexto("Emanuel").resultado, Retorno.Resultado.OK, "Borrar palabra Emanuel de documento Programacion");
        
        /***** IMPRIMIR PARA RESULTADO LUEGO DE BORRAR PALABRAS *****/
        p.ver(s.imprimirTexto().resultado, Retorno.Resultado.OK, "Imprimir texto de Documento Programación");

//        p.ver(s.imprimirTexto().resultado, Retorno.Resultado.OK, "Imprimir texto de Documento Programación");
    }
    
    public static void pruebaErroresCrearCarpeta(Sistema s, Prueba p){
        p.ver(s.crearSistemaMensajes().resultado, Retorno.Resultado.OK, "Se creo Sistema con una unidad C");
        p.ver(s.agregarCarpeta("C", "Personal").resultado, Retorno.Resultado.OK, "Se creo carpeta -> Personal en Unidad C");
        p.ver(s.agregarCarpeta("C", "Universidad").resultado, Retorno.Resultado.OK, "Se creo carpeta -> Universidad en Unidad C");
        p.ver(s.agregarMensaje("C", "Universidad", "Programacion").resultado, Retorno.Resultado.OK, "Se agrego Mensaje/Documento Programacion a la carpeta Universidad de unidad C");
        
        /***** CARPETA *****/
        
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
        
        /***** CARPETA *****/
        
        /***** MENSAJE *****/
        
        //intento agregar mesanje en carpeta no existente
        Retorno agregarMensajeEnCarpetaNoExiste = s.agregarMensaje("C", "pepito", "Programacion");
        p.ver(agregarMensajeEnCarpetaNoExiste.resultado, Retorno.Resultado.ERROR, agregarMensajeEnCarpetaNoExiste.valorString);
        
        //intento agregar mesanje en unidad que no existe
        Retorno agregarMensajeEnUnidadNoExiste = s.agregarMensaje("H", "Universidad", "Programacion");
        p.ver(agregarMensajeEnUnidadNoExiste.resultado, Retorno.Resultado.ERROR, agregarMensajeEnUnidadNoExiste.valorString);
        
        //intento agregar mesanje en carpeta que ya existe
        Retorno agregarMensajeQueExiste = s.agregarMensaje("C", "Universidad", "Programacion");
        p.ver(agregarMensajeQueExiste.resultado, Retorno.Resultado.ERROR, agregarMensajeQueExiste.valorString);
        
        //intento eliminar mesanje en carpeta no existente
        Retorno eliminarMensajeEnCarpetaNoExiste = s.eliminarMensaje("C", "pepito", "Programacion");
        p.ver(eliminarMensajeEnCarpetaNoExiste.resultado, Retorno.Resultado.ERROR, eliminarMensajeEnCarpetaNoExiste.valorString);
        
        //intento eliminar mesanje en unidad que no existe
        Retorno eliminarMensajeEnUnidadNoExiste = s.eliminarMensaje("H", "Universidad", "Programacion");
        p.ver(eliminarMensajeEnUnidadNoExiste.resultado, Retorno.Resultado.ERROR, eliminarMensajeEnUnidadNoExiste.valorString);
        
        //intento eliminar mesanje en archivo que no existe
        Retorno eliminarMensajeQueExiste = s.eliminarMensaje("C", "Universidad", "Programacion2");
        p.ver(eliminarMensajeQueExiste.resultado, Retorno.Resultado.ERROR, eliminarMensajeQueExiste.valorString);
        
        /***** MENSAJE *****/
        
        /***** ESTRUCTURA *****/
        
        Retorno noHayCarpetas = s.listarEstructura("H", "Personal");
        p.ver(noHayCarpetas.resultado, Retorno.Resultado.ERROR, noHayCarpetas.valorString);
        
        /***** ESTRUCTURA *****/
        
        /***** INSERTAR LINEAS *****/
        
        p.ver(s.insertarLinea().resultado, Retorno.Resultado.OK, "Insertar linea 1 en blanco, Documento Programacion de Carpeta Universidad");
        p.ver(s.insertarLinea().resultado, Retorno.Resultado.OK, "Insertar linea 2 en blanco, Documento Programacion de Carpeta Universidad");
        p.ver(s.insertarLinea().resultado, Retorno.Resultado.OK, "Insertar linea 3 en blanco, Documento Programacion de Carpeta Universidad");
        p.ver(s.insertarLinea().resultado, Retorno.Resultado.OK, "Insertar linea 4 en blanco, Documento Programacion de Carpeta Universidad");
        p.ver(s.insertarLinea().resultado, Retorno.Resultado.OK, "Insertar linea 5 en blanco, Documento Programacion de Carpeta Universidad");
        
        //intento insertar una linea en posicion invalida
        Retorno insertarLineaPosInvalida1 = s.insertarLineaEnPosicion(70); 
        Retorno insertarLineaPosInvalida2 = s.insertarLineaEnPosicion(25);
        
        p.ver(insertarLineaPosInvalida1.resultado, Retorno.Resultado.ERROR, insertarLineaPosInvalida1.valorString);
        p.ver(insertarLineaPosInvalida2.resultado, Retorno.Resultado.ERROR, insertarLineaPosInvalida2.valorString);        
        
        p.ver(s.imprimirTexto().resultado, Retorno.Resultado.OK, "Imprimir texto de Documento Programación");
        
        /***** INSERTAR LINEAS *****/
        
        /***** BORAR LINEAS EN POSICION ESPECIFICA *****/
        Retorno borrarLineaPosInvalida1 = s.insertarLineaEnPosicion(90);
        Retorno borrarLineaPosInvalida2 = s.insertarLineaEnPosicion(45);
        
        p.ver(borrarLineaPosInvalida1.resultado, Retorno.Resultado.ERROR, borrarLineaPosInvalida1.valorString);
        p.ver(borrarLineaPosInvalida2.resultado, Retorno.Resultado.ERROR, borrarLineaPosInvalida2.valorString);
        /***** BORAR LINEAS EN POSICION ESPECIFICA *****/
    }
    
}