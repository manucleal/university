package sistema;

public class Obligatorio2020 {
    
    //ImprimirTexto() es un metodo duro, siempre le pega a documento programacion
    //InsertarLinea() es un metodo duro, siempre le pega a documento programacion
    //insertarLineaEnPosicion(1) es un metodo duro, siempre le pega a documento programacion
    
    public static void main(String[] args) {
        Sistema sist = new Sistema();
        Prueba p1 = new Prueba();
        
        //PRUEBAS GENERALES SIN ERRORES
        //pruebaSinErrores(sist, p1);
        
        //PRUEBAS GENERALES CON ERRORES
        //pruebaErroresCrearCarpeta(sist, p1);
        
        //PRUEBAS DE OPERACIONES RELATIVAS A LAS PALABRAS
        //pruebaOperacionesPalabras(sist, p1);
        
        //PRUEBAS CON DICCIONARIO
        pruebaDiccionario(sist, p1);
    }
    public static void pruebaDiccionario(Sistema s, Prueba p){
        p.ver(s.CrearSistemaMensajes().resultado, Retorno.Resultado.OK, "Se creo Sistema con una unidad C");
        p.ver(s.AgregarCarpeta("C", "Universidad").resultado, Retorno.Resultado.OK, "Se creo carpeta -> Universidad en Unidad C");
        p.ver(s.AgregarMensaje("C", "Universidad", "Programacion").resultado, Retorno.Resultado.OK, "Se agrego Mensaje/Documento Programacion a la carpeta Universidad de unidad C");
        
        p.ver(s.InsertarLinea().resultado, Retorno.Resultado.OK, "Insertar linea AL FINAL 1 en blanco, Documento Programacion de Carpeta Universidad");
        p.ver(s.InsertarLinea().resultado, Retorno.Resultado.OK, "Insertar linea AL FINAL 2 en blanco, Documento Programacion de Carpeta Universidad");
        p.ver(s.InsertarLinea().resultado, Retorno.Resultado.OK, "Insertar linea AL FINAL 3 en blanco, Documento Programacion de Carpeta Universidad");
        p.ver(s.InsertarLinea().resultado, Retorno.Resultado.OK, "Insertar linea AL FINAL 4 en blanco, Documento Programacion de Carpeta Universidad");
        p.ver(s.InsertarLinea().resultado, Retorno.Resultado.OK, "Insertar linea AL FINAL 5 en blanco, Documento Programacion de Carpeta Universidad"); 
        
        p.ver(s.InsertarPalabraEnLinea(1, 1, "Hace").resultado, Retorno.Resultado.OK, "Insertar Palabra En Linea");
        p.ver(s.InsertarPalabraEnLinea(1, 2, "un").resultado, Retorno.Resultado.OK, "Insertar Palabra En Linea");
        p.ver(s.InsertarPalabraEnLinea(1, 3, "Deploy").resultado, Retorno.Resultado.OK, "Insertar Palabra En Linea");
        p.ver(s.InsertarPalabraEnLinea(2, 1, "Emanuel").resultado, Retorno.Resultado.OK, "Insertar Palabra En Linea");
        
        
        p.ver(s.IngresarPalabraDiccionario("Deploy").resultado, Retorno.Resultado.OK, "Ingresando palabra Deploy a diccionario");
        p.ver(s.IngresarPalabraDiccionario("Frontend").resultado, Retorno.Resultado.OK, "Ingresando palabra Frontend a diccionario");
        p.ver(s.IngresarPalabraDiccionario("Backend").resultado, Retorno.Resultado.OK, "Ingresando palabra Backend a diccionario");
        p.ver(s.IngresarPalabraDiccionario("Emanuel").resultado, Retorno.Resultado.OK, "Ingresando palabra Backend a diccionario");
        p.ver(s.BorrarPalabraDiccionario("Frontend").resultado, Retorno.Resultado.OK, "Ingresando palabra Backend a diccionario");
        
        p.ver(s.ImprimirTexto().resultado, Retorno.Resultado.OK, "Imprimir texto de Documento Programación");
        
        p.ver(s.ImprimirDiccionario().resultado, Retorno.Resultado.OK, "Imprimir palabras del diccionario");
        
        p.ver(s.ImprimirTextoIncorrecto().resultado, Retorno.Resultado.OK, "Imprimir texto que no se encunetra en el diccionario");
        
    }
    
    public static void pruebaOperacionesPalabras(Sistema s, Prueba p){
        p.ver(s.CrearSistemaMensajes().resultado, Retorno.Resultado.OK, "Se creo Sistema con una unidad C");
        p.ver(s.AgregarCarpeta("C", "Personal").resultado, Retorno.Resultado.OK, "Se creo carpeta -> Personal en Unidad C");
        p.ver(s.AgregarCarpeta("C", "Universidad").resultado, Retorno.Resultado.OK, "Se creo carpeta -> Universidad en Unidad C");
        p.ver(s.AgregarCarpeta("C", "Trabajo").resultado, Retorno.Resultado.OK, "Se creo carpeta -> Trabajo en Unidad C");
        p.ver(s.AgregarCarpeta("C", "Otros").resultado, Retorno.Resultado.OK, "Se creo carpeta -> Otros en Unidad C");
        //eliminando carpeta Otros
        p.ver(s.EliminarCarpeta("C", "Otros").resultado, Retorno.Resultado.OK, "Se eliminó carpeta Otros de unidad C");
        //agregando mensajes
        p.ver(s.AgregarMensaje("C", "Universidad", "Programacion").resultado, Retorno.Resultado.OK, "Se agrego Mensaje/Documento Programacion a la carpeta Universidad de unidad C");
        p.ver(s.AgregarMensaje("C", "Universidad", "Programacion2").resultado, Retorno.Resultado.OK, "Se agrego Mensaje/Documento Programacion2 a la carpeta Universidad de unidad C");
        p.ver(s.AgregarMensaje("C", "Universidad", "Algoritmos y Estructuras de Datos").resultado, Retorno.Resultado.OK, "Se agrego Mensaje/Documento Algoritmos y Estructuras de Datos a la carpeta Universidad de unidad C");
        p.ver(s.AgregarMensaje("C", "Personal", "Gastos").resultado, Retorno.Resultado.OK, "Se agrego Mensaje/Documento Gastos a la carpeta Personal de unidad C");
        p.ver(s.AgregarMensaje("C", "Trabajo", "ADX").resultado, Retorno.Resultado.OK, "Se agrego Mensaje/Documento ADX a la carpeta Personal de unidad C");
        p.ver(s.AgregarMensaje("C", "Trabajo", "AudioTrade").resultado, Retorno.Resultado.OK, "Se agrego Mensaje/Documento AudioTrade a la carpeta Personal de unidad C");
        
        //eliminando nodo carpeta del medio
        p.ver(s.EliminarMensaje("C", "Universidad", "Programacion2").resultado, Retorno.Resultado.OK, "Se elimino Mensaje/Documento Programacion2 de carpeta Universidad en unidad C");
        
        
        p.ver(s.ListarEstructura("C", "Universidad").resultado, Retorno.Resultado.OK, "###### Estructura Carpeta: Universidad ######");
        p.ver(s.ListarEstructura("C", "Personal").resultado, Retorno.Resultado.OK, "###### Estructura Carpeta: Personal ######");
        
        /***** INSERTAR LINEAS EN BLANCO AL FINAL *****/
        p.ver(s.InsertarLinea().resultado, Retorno.Resultado.OK, "Insertar linea AL FINAL 1 en blanco, Documento Programacion de Carpeta Universidad");
        p.ver(s.InsertarLinea().resultado, Retorno.Resultado.OK, "Insertar linea AL FINAL 2 en blanco, Documento Programacion de Carpeta Universidad");
        p.ver(s.InsertarLinea().resultado, Retorno.Resultado.OK, "Insertar linea AL FINAL 3 en blanco, Documento Programacion de Carpeta Universidad");
        p.ver(s.InsertarLinea().resultado, Retorno.Resultado.OK, "Insertar linea AL FINAL 4 en blanco, Documento Programacion de Carpeta Universidad");
        p.ver(s.InsertarLinea().resultado, Retorno.Resultado.OK, "Insertar linea AL FINAL 5 en blanco, Documento Programacion de Carpeta Universidad"); 
        
        /***** INSERTAR LINEAS EN BLANCO POSICION ESPECIFICA *****/
        p.ver(s.InsertarLineaEnPosicion(1).resultado, Retorno.Resultado.OK, "Insertar linea POS 1 en blanco, Documento Programacion de Carpeta Universidad");
        
        p.ver(s.ImprimirTexto().resultado, Retorno.Resultado.OK, "Imprimir texto de Documento Programación");
        
        /***** INSERTAR PALABRAS *****/
        p.ver(s.InsertarPalabraEnLinea(1, 1, "Bienvenido").resultado, Retorno.Resultado.OK, "Insertar Palabra En Linea");
        p.ver(s.InsertarPalabraEnLinea(1, 2, "Emanuel").resultado, Retorno.Resultado.OK, "Insertar Palabra En Linea");
        p.ver(s.InsertarPalabraEnLinea(1, 2, "Coitino").resultado, Retorno.Resultado.OK, "Insertar Palabra En Linea");
               
        //palabra que excede el numero maximo de palabras por linea
        p.ver(s.InsertarPalabraEnLinea(1, 1, "excedente").resultado, Retorno.Resultado.OK, "Insertar Palabra En Linea");
        
        p.ver(s.InsertarPalabraEnLinea(6, 1, "Emanuel").resultado, Retorno.Resultado.OK, "Insertar Palabra En Linea");  
        p.ver(s.InsertarPalabraEnLinea(6, 2, "Coitino").resultado, Retorno.Resultado.OK, "Insertar Palabra En Linea"); 
        p.ver(s.InsertarPalabraEnLinea(6, 3, "aaaaa").resultado, Retorno.Resultado.OK, "Insertar Palabra En Linea"); 
        
        p.ver(s.InsertarPalabraEnLinea(6, 2, "excedente2").resultado, Retorno.Resultado.OK, "Insertar Palabra En Linea"); 
        p.ver(s.ImprimirTexto().resultado, Retorno.Resultado.OK, "Imprimir texto de Documento Programación");
        
        /***** INSERTAR Y DESPLAZAR *****/
        
//        p.ver(s.insertarPalabraYDesplazar(1, 1, "pepito").resultado,Retorno.Resultado.OK,"Insertar y desplazar");
//        p.ver(s.insertarPalabraYDesplazar(1, 1, "audioad").resultado,Retorno.Resultado.OK,"Insertar y desplazar");
//        p.ver(s.insertarPalabraYDesplazar(1, 1, "jp").resultado,Retorno.Resultado.OK,"Insertar y desplazar");
//        p.ver(s.insertarPalabraYDesplazar(1, 1, "fer").resultado,Retorno.Resultado.OK,"Insertar y desplazar");
//        p.ver(s.insertarPalabraYDesplazar(1, 1, "manu").resultado,Retorno.Resultado.OK,"Insertar y desplazar");
//        p.ver(s.insertarPalabraYDesplazar(1, 1, "otra").resultado,Retorno.Resultado.OK,"Insertar y desplazar");
//        p.ver(s.insertarPalabraYDesplazar(3, 3, "hola").resultado,Retorno.Resultado.OK,"Insertar y desplazar");
//        p.ver(s.insertarPalabraYDesplazar(6, 1, "nueva").resultado,Retorno.Resultado.OK,"Insertar y desplazar");
//        p.ver(s.insertarPalabraYDesplazar(6, 1, "nueva2").resultado,Retorno.Resultado.OK,"Insertar y desplazar");
//        p.ver(s.insertarPalabraYDesplazar(6, 1, "nueva3").resultado,Retorno.Resultado.OK,"Insertar y desplazar");
//        p.ver(s.insertarPalabraYDesplazar(6, 1, "nueva8").resultado,Retorno.Resultado.OK,"Insertar y desplazar");
//        p.ver(s.insertarPalabraYDesplazar(5, 1, "ultimotest3").resultado,Retorno.Resultado.OK,"Insertar y desplazar");
//        p.ver(s.insertarPalabraYDesplazar(5, 1, "ultimotest2").resultado,Retorno.Resultado.OK,"Insertar y desplazar");
//        p.ver(s.insertarPalabraYDesplazar(5, 1, "ultimotest1").resultado,Retorno.Resultado.OK,"Insertar y desplazar");
//        p.ver(s.insertarPalabraYDesplazar(5, 3, "ultimotest3/2").resultado,Retorno.Resultado.OK,"Insertar y desplazar");
//        p.ver(s.insertarPalabraYDesplazar(5, 3, "ultimotest3/2").resultado,Retorno.Resultado.OK,"Insertar y desplazar");
//        p.ver(s.insertarPalabraYDesplazar(5, 3, "ultimotest3/2").resultado,Retorno.Resultado.OK,"Insertar y desplazar");
//        p.ver(s.ImprimirTexto().resultado, Retorno.Resultado.OK, "Imprimir texto de Documento Programación");
        
        /***** INSERTAR Y DESPLAZAR *****/
        
        /***** BORRAR PALABRA *****/
        //p.ver(s.borrarPalabra(1, 1).resultado, Retorno.Resultado.OK, "Borrar Palabra en posicion linea posicion palabra");
        //p.ver(s.borrarPalabra(1, 1).resultado, Retorno.Resultado.OK, "Borrar Palabra en posicion linea posicion palabra");
        p.ver(s.ImprimirTexto().resultado, Retorno.Resultado.OK, "Imprimir texto de Documento Programación");
        
        //p.ver(s.borrarOcurrenciasPalabraEnLinea(6, "Emanuel").resultado,Retorno.Resultado.OK, "Borrar Palabra en linea especifica");
        //p.ver(s.borrarOcurrenciasPalabraEnLinea(6, "aaaaa").resultado,Retorno.Resultado.OK, "Borrar Palabra en linea especifica");
        p.ver(s.ImprimirLinea(1).resultado, Retorno.Resultado.OK, "Imprimir texto linea uno ");
        //p.ver(s.ImprimirTexto().resultado, Retorno.Resultado.OK, "Imprimir texto de Documento Programación");
    }
    
    public static void pruebaSinErrores(Sistema s, Prueba p){
        p.ver(s.CrearSistemaMensajes().resultado, Retorno.Resultado.OK, "Se creo Sistema con una unidad C");
        p.ver(s.AgregarCarpeta("C", "Personal").resultado, Retorno.Resultado.OK, "Se creo carpeta -> Personal en Unidad C");
        p.ver(s.AgregarCarpeta("C", "Universidad").resultado, Retorno.Resultado.OK, "Se creo carpeta -> Universidad en Unidad C");
        p.ver(s.AgregarCarpeta("C", "Trabajo").resultado, Retorno.Resultado.OK, "Se creo carpeta -> Trabajo en Unidad C");
        p.ver(s.AgregarCarpeta("C", "Otros").resultado, Retorno.Resultado.OK, "Se creo carpeta -> Otros en Unidad C");
        //eliminando carpeta Otros
        p.ver(s.EliminarCarpeta("C", "Otros").resultado, Retorno.Resultado.OK, "Se eliminó carpeta Otros de unidad C");
        //agregando mensajes
        p.ver(s.AgregarMensaje("C", "Universidad", "Programacion").resultado, Retorno.Resultado.OK, "Se agrego Mensaje/Documento Programacion a la carpeta Universidad de unidad C");
        p.ver(s.AgregarMensaje("C", "Universidad", "Programacion2").resultado, Retorno.Resultado.OK, "Se agrego Mensaje/Documento Programacion2 a la carpeta Universidad de unidad C");
        p.ver(s.AgregarMensaje("C", "Universidad", "Algoritmos y Estructuras de Datos").resultado, Retorno.Resultado.OK, "Se agrego Mensaje/Documento Algoritmos y Estructuras de Datos a la carpeta Universidad de unidad C");
        p.ver(s.AgregarMensaje("C", "Personal", "Gastos").resultado, Retorno.Resultado.OK, "Se agrego Mensaje/Documento Gastos a la carpeta Personal de unidad C");
        p.ver(s.AgregarMensaje("C", "Trabajo", "ADX").resultado, Retorno.Resultado.OK, "Se agrego Mensaje/Documento ADX a la carpeta Personal de unidad C");
        p.ver(s.AgregarMensaje("C", "Trabajo", "AudioTrade").resultado, Retorno.Resultado.OK, "Se agrego Mensaje/Documento AudioTrade a la carpeta Personal de unidad C");
        
        //eliminando nodo carpeta del medio
        p.ver(s.EliminarMensaje("C", "Universidad", "Programacion2").resultado, Retorno.Resultado.OK, "Se elimino Mensaje/Documento Programacion2 de carpeta Universidad en unidad C");
        
        
        p.ver(s.ListarEstructura("C", "Universidad").resultado, Retorno.Resultado.OK, "###### Estructura Carpeta: Universidad ######");
        p.ver(s.ListarEstructura("C", "Personal").resultado, Retorno.Resultado.OK, "###### Estructura Carpeta: Personal ######");
        
        /***** INSERTAR LINEAS EN BLANCO AL FINAL *****/
        p.ver(s.InsertarLinea().resultado, Retorno.Resultado.OK, "Insertar linea AL FINAL 1 en blanco, Documento Programacion de Carpeta Universidad");
        p.ver(s.InsertarLinea().resultado, Retorno.Resultado.OK, "Insertar linea AL FINAL 2 en blanco, Documento Programacion de Carpeta Universidad");
        p.ver(s.InsertarLinea().resultado, Retorno.Resultado.OK, "Insertar linea AL FINAL 3 en blanco, Documento Programacion de Carpeta Universidad");
        p.ver(s.InsertarLinea().resultado, Retorno.Resultado.OK, "Insertar linea AL FINAL 4 en blanco, Documento Programacion de Carpeta Universidad");
        p.ver(s.InsertarLinea().resultado, Retorno.Resultado.OK, "Insertar linea AL FINAL 5 en blanco, Documento Programacion de Carpeta Universidad"); 
        
        /***** INSERTAR LINEAS EN BLANCO POSICION ESPECIFICA *****/
        p.ver(s.InsertarLineaEnPosicion(1).resultado, Retorno.Resultado.OK, "Insertar linea POS 1 en blanco, Documento Programacion de Carpeta Universidad");
        
        /***** INSERTAR PALABRAS EN UNA LINEA ESPECIFICA Y EN UNA POSICION ESPECIFICA *****/
        p.ver(s.InsertarPalabraEnLinea(1, 1, "Emanuel").resultado, Retorno.Resultado.OK, "Insertar Palabra En Linea 1 en Posicion de linea 1");
        p.ver(s.InsertarPalabraEnLinea(1, 2, "Coitino").resultado, Retorno.Resultado.OK, "Insertar Palabra En Linea 1 en Posicion de linea 1");
        
        /***** INSERTAR LINEAS EN BLANCO POSICION ESPECIFICA *****/
        p.ver(s.InsertarLineaEnPosicion(1).resultado, Retorno.Resultado.OK, "Insertar linea 1 blanco, Documento Programacion de Carpeta Universidad");
        p.ver(s.InsertarLineaEnPosicion(1).resultado, Retorno.Resultado.OK, "Insertar linea 1 blanco, Documento Programacion de Carpeta Universidad");
        
        p.ver(s.ImprimirTexto().resultado, Retorno.Resultado.OK, "Imprimir texto de Documento Programación");
        /***** BORRAR LINEAS EN BLANCO POSICION ESPECIFICA *****/
        p.ver(s.BorrarLinea(2).resultado,Retorno.Resultado.OK,"Borrar linea 2");
        p.ver(s.BorrarLinea(7).resultado,Retorno.Resultado.OK,"Borrar linea 7");
        
        p.ver(s.ImprimirTexto().resultado, Retorno.Resultado.OK, "Imprimir texto de Documento Programación");
        
        /***** BORRAR TODO DE DOC PROGRAMACION E IMPRIMIR PARA VERIFICAR QUE NO ESTEN LOS DATOS *****/
        //p.ver(s.borrarTodo().resultado, Retorno.Resultado.OK, "Documento Programacion vaciado !!");
        p.ver(s.ImprimirTexto().resultado, Retorno.Resultado.OK, "Texto Vacio`");  
        
        /***** INSERTAR PALABRAS *****/
        p.ver(s.InsertarPalabraEnLinea(1, 2, "Emanuel").resultado, Retorno.Resultado.OK, "Insertar Palabra En Linea");
        p.ver(s.InsertarPalabraEnLinea(1, 1, "manu").resultado, Retorno.Resultado.OK, "Insertar Palabra En Linea");
        p.ver(s.InsertarPalabraEnLinea(6, 3, "Emanuel").resultado, Retorno.Resultado.OK, "Insertar Palabra En Linea");
        
        /***** IMPRIMIR PARA VER PALABRAS INSERTADAS *****/
        p.ver(s.ImprimirTexto().resultado, Retorno.Resultado.OK, "Imprimir texto de Documento Programación");
        
        /***** BORRAR OCURRENCIAS DE PALABRA "EMANUEL" EN DOCUMENTO PROGRAMACION *****/  
        p.ver(s.BorrarOcurrenciasPalabraEnTexto("Emanuel").resultado, Retorno.Resultado.OK, "Borrar palabra Emanuel de documento Programacion");
        
        /***** IMPRIMIR PARA RESULTADO LUEGO DE BORRAR PALABRAS *****/
        p.ver(s.ImprimirTexto().resultado, Retorno.Resultado.OK, "Imprimir texto de Documento Programación");

    }
    
    public static void pruebaErroresCrearCarpeta(Sistema s, Prueba p){
        p.ver(s.CrearSistemaMensajes().resultado, Retorno.Resultado.OK, "Se creo Sistema con una unidad C");
        p.ver(s.AgregarCarpeta("C", "Personal").resultado, Retorno.Resultado.OK, "Se creo carpeta -> Personal en Unidad C");
        p.ver(s.AgregarCarpeta("C", "Universidad").resultado, Retorno.Resultado.OK, "Se creo carpeta -> Universidad en Unidad C");
        p.ver(s.AgregarMensaje("C", "Universidad", "Programacion").resultado, Retorno.Resultado.OK, "Se agrego Mensaje/Documento Programacion a la carpeta Universidad de unidad C");
        
        /***** CARPETA *****/
        
        //intento crear carpeta duplicada
        Retorno crearCarpetaDuplicada = s.AgregarCarpeta("C", "Universidad");
        p.ver(crearCarpetaDuplicada.resultado, Retorno.Resultado.ERROR, crearCarpetaDuplicada.valorString);
        
        //intento crear carpeta en ubicacion que no existe 
        Retorno crearCarpetaUnidadNoExiste = s.AgregarCarpeta("H", "Universidad");
        p.ver(crearCarpetaUnidadNoExiste.resultado, Retorno.Resultado.ERROR, crearCarpetaUnidadNoExiste.valorString);
        
        //intento eliminar carpeta en unidad que no existe
        Retorno eliminarCarpetaNoExisteUnidad = s.EliminarCarpeta("H", "Universidad");
        p.ver(eliminarCarpetaNoExisteUnidad.resultado, Retorno.Resultado.ERROR, eliminarCarpetaNoExisteUnidad.valorString);
        
        //intento eliminar carpeta que no existe
        Retorno eliminarCarpetaNoExisteCarpeta = s.EliminarCarpeta("C", "pepe");
        p.ver(eliminarCarpetaNoExisteCarpeta.resultado, Retorno.Resultado.ERROR, eliminarCarpetaNoExisteCarpeta.valorString);
        
        /***** CARPETA *****/
        
        /***** MENSAJE *****/
        
        //intento agregar mesanje en carpeta no existente
        Retorno AgregarMensajeEnCarpetaNoExiste = s.AgregarMensaje("C", "pepito", "Programacion");
        p.ver(AgregarMensajeEnCarpetaNoExiste.resultado, Retorno.Resultado.ERROR, AgregarMensajeEnCarpetaNoExiste.valorString);
        
        //intento agregar mesanje en unidad que no existe
        Retorno AgregarMensajeEnUnidadNoExiste = s.AgregarMensaje("H", "Universidad", "Programacion");
        p.ver(AgregarMensajeEnUnidadNoExiste.resultado, Retorno.Resultado.ERROR, AgregarMensajeEnUnidadNoExiste.valorString);
        
        //intento agregar mesanje en carpeta que ya existe
        Retorno AgregarMensajeQueExiste = s.AgregarMensaje("C", "Universidad", "Programacion");
        p.ver(AgregarMensajeQueExiste.resultado, Retorno.Resultado.ERROR, AgregarMensajeQueExiste.valorString);
        
        //intento eliminar mesanje en carpeta no existente
        Retorno eliminarMensajeEnCarpetaNoExiste = s.EliminarMensaje("C", "pepito", "Programacion");
        p.ver(eliminarMensajeEnCarpetaNoExiste.resultado, Retorno.Resultado.ERROR, eliminarMensajeEnCarpetaNoExiste.valorString);
        
        //intento eliminar mesanje en unidad que no existe
        Retorno eliminarMensajeEnUnidadNoExiste = s.EliminarMensaje("H", "Universidad", "Programacion");
        p.ver(eliminarMensajeEnUnidadNoExiste.resultado, Retorno.Resultado.ERROR, eliminarMensajeEnUnidadNoExiste.valorString);
        
        //intento eliminar mesanje en archivo que no existe
        Retorno eliminarMensajeQueExiste = s.EliminarMensaje("C", "Universidad", "Programacion2");
        p.ver(eliminarMensajeQueExiste.resultado, Retorno.Resultado.ERROR, eliminarMensajeQueExiste.valorString);
        
        /***** MENSAJE *****/
        
        /***** ESTRUCTURA *****/
        
        Retorno noHayCarpetas = s.ListarEstructura("H", "Personal");
        p.ver(noHayCarpetas.resultado, Retorno.Resultado.ERROR, noHayCarpetas.valorString);
        
        /***** ESTRUCTURA *****/
        
        /***** INSERTAR LINEAS *****/
        
        p.ver(s.InsertarLinea().resultado, Retorno.Resultado.OK, "Insertar linea 1 en blanco, Documento Programacion de Carpeta Universidad");
        p.ver(s.InsertarLinea().resultado, Retorno.Resultado.OK, "Insertar linea 2 en blanco, Documento Programacion de Carpeta Universidad");
        p.ver(s.InsertarLinea().resultado, Retorno.Resultado.OK, "Insertar linea 3 en blanco, Documento Programacion de Carpeta Universidad");
        p.ver(s.InsertarLinea().resultado, Retorno.Resultado.OK, "Insertar linea 4 en blanco, Documento Programacion de Carpeta Universidad");
        p.ver(s.InsertarLinea().resultado, Retorno.Resultado.OK, "Insertar linea 5 en blanco, Documento Programacion de Carpeta Universidad");
        
        //intento insertar una linea en posicion invalida
        Retorno insertarLineaPosInvalida1 = s.InsertarLineaEnPosicion(70); 
        Retorno insertarLineaPosInvalida2 = s.InsertarLineaEnPosicion(25);
        
        p.ver(insertarLineaPosInvalida1.resultado, Retorno.Resultado.ERROR, insertarLineaPosInvalida1.valorString);
        p.ver(insertarLineaPosInvalida2.resultado, Retorno.Resultado.ERROR, insertarLineaPosInvalida2.valorString);        
        
        p.ver(s.ImprimirTexto().resultado, Retorno.Resultado.OK, "Imprimir texto de Documento Programación");
        
        /***** INSERTAR LINEAS *****/
        
        /***** BORAR LINEAS EN POSICION ESPECIFICA *****/
        Retorno borrarLineaPosInvalida1 = s.InsertarLineaEnPosicion(90);
        Retorno borrarLineaPosInvalida2 = s.InsertarLineaEnPosicion(45);
        
        p.ver(borrarLineaPosInvalida1.resultado, Retorno.Resultado.ERROR, borrarLineaPosInvalida1.valorString);
        p.ver(borrarLineaPosInvalida2.resultado, Retorno.Resultado.ERROR, borrarLineaPosInvalida2.valorString);
        /***** BORAR LINEAS EN POSICION ESPECIFICA *****/
    }
    
}