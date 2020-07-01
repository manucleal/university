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
        //pruebaDiccionarioYMatriz(sist, p1);
        
        
        /***** PRUEBAS DEFENSA *****/
        //pruebaEstructura(sist, p1);
        //pruebatopes(sist, p1);
        pruebaDiccionario(sist, p1);
        
    }
    public static void pruebaEstructura(Sistema s, Prueba p){

    // casos Ok
    p.ver(s.CrearSistemaMensajes().resultado,Retorno.Resultado.OK,"Se crea sistema de mensajes");       
    // agregar carpetas 
    p.ver(s.AgregarCarpeta("C", "Archivos").resultado, Retorno.Resultado.OK, "Se creo la carpeta Archivos en unidad C"); 
    p.ver(s.AgregarCarpeta("C", "Documentos").resultado, Retorno.Resultado.OK, "Se creo la carpeta documentos en unidad C");   
    p.ver(s.AgregarCarpeta("C", "Mensajes").resultado, Retorno.Resultado.OK, "Se creo la carpeta mensajes en unidad C");
    p.ver(s.AgregarCarpeta("C", "Otros Archivos").resultado, Retorno.Resultado.OK, "Se creo la carpeta otros Archivos en unidad C");
    // listamos par ver si la estructura es correcta
    p.ver(s.ListarEstructura("C","Archivos").resultado,Retorno.Resultado.OK,"Se listan los documentos de la carpeta Archivos");    
    // agregamos mensajes a una carpeta
    p.ver(s.AgregarMensaje("C", "Archivos", "mensaje1").resultado, Retorno.Resultado.OK, "Se agrega mensaje 1 en carpeta Archivos");
    p.ver(s.AgregarMensaje("C", "Archivos", "mensaje2").resultado, Retorno.Resultado.OK, "Se agrega mensaje 2 en carpeta Archivos");
    p.ver(s.AgregarMensaje("C", "Archivos", "mensaje3").resultado, Retorno.Resultado.OK, "Se agrega mensaje 3 en carpeta Archivos");
    // listamos la carpeta Archivos para ver si estan los mensajes agregados.
    p.ver(s.ListarEstructura("C","Archivos").resultado,Retorno.Resultado.OK,"Se listan los documentos de la carpeta Archivos");   
    // agregamos un nuevo mensaje y posteriormente lo elimino 
    p.ver(s.AgregarMensaje("C", "Archivos", "mensajex").resultado, Retorno.Resultado.OK, "Se agrega mensaje x en carpeta Archivos");
    p.ver(s.EliminarMensaje("C","Archivos","mensajex").resultado, Retorno.Resultado.OK, "Se  elimina mensaje x en carpeta Archivos ");

    // casos de error
    p.ver(s.AgregarCarpeta("C", "Archivos").resultado, Retorno.Resultado.ERROR, "Error Se intento crear la carpeta Archivos en unidad C que ya existe RESULTADO: "+ s.AgregarCarpeta("C", "Archivos").valorString);   
    
    
    p.ver(s.EliminarCarpeta("C", "Carpeta X").resultado, Retorno.Resultado.ERROR, "Se intento borrar carpeta X que no existe RESULTADO: "+s.EliminarCarpeta("C", "Carpeta X").valorString);
    p.ver(s.AgregarMensaje("C", "Archivos", "mensaje1").resultado, Retorno.Resultado.ERROR, "Se intento agregar mensaje 1 en carpeta Archivos ya existente RESULTADO: "+s.AgregarMensaje("C", "Archivos", "mensaje1").valorString);
    p.ver(s.EliminarMensaje("C","Archivos","mensaje4").resultado, Retorno.Resultado.ERROR, "Se intenta eliminar mensaje 4 en carpeta Archivos que no existe RESULTADO: "+s.EliminarMensaje("C","Archivos","mensaje4").valorString);
    
    /**** Método que agregue INICO ****/
    p.ver(s.CargarDistancias(s.getMatriz()).resultado, Retorno.Resultado.OK, "Cargar distancias");
    /**** Método que agregue FIN ****/
    
    p.ver(s.BuscarCamino(s.getMatriz(), "MVD", "MIA").resultado, Retorno.Resultado.OK,s.BuscarCamino(s.getMatriz(), "MVD", "MIA").valorString);    
    
    p.ver(s.DestruirSistemaMensajes().resultado, Retorno.Resultado.OK, "Se destruye sistma" );
    p.imprimirResultadosPrueba();

}    



    public static void pruebatopes(Sistema s, Prueba p) {

        p.tituloPrueba("pruebatopes");
        p.ver(s.CrearSistemaMensajes().resultado, Retorno.Resultado.OK, "Vacio");
        
        /**** Métodos que agregue INICIO ****/
        p.ver(s.AgregarCarpeta("C", "Universidad").resultado, Retorno.Resultado.OK, "Se creo carpeta -> Universidad en Unidad C");
        p.ver(s.AgregarMensaje("C", "Universidad", "Programacion").resultado, Retorno.Resultado.OK, "Se agrego Mensaje/Documento Programacion a la carpeta Universidad de unidad C");        
        /**** Métodos que agregue FIN ****/
        
        p.ver(s.InsertarLinea().resultado, Retorno.Resultado.OK, "Vacio"); //no hay errores posibles 
        p.ver(s.InsertarPalabraEnLinea(1, 1, "Palabra1").resultado, Retorno.Resultado.OK, "Palabra Ingresada");
        p.ver(s.InsertarPalabraEnLinea(1, 2, "Palabra2").resultado, Retorno.Resultado.OK, "Palabra Ingresada");
        p.ver(s.InsertarPalabraEnLinea(1, 3, "Palabra3").resultado, Retorno.Resultado.OK, "Palabra Ingresada");
        p.ver(s.InsertarPalabraYDesplazar(1, 2, "PalabraX").resultado, Retorno.Resultado.OK, "Insertada y desplazada");
        p.ver(s.ImprimirTexto().resultado, Retorno.Resultado.OK, "Texto impreso correctamente");
        p.ver(s.InsertarPalabraEnLinea(2, 2, "Palabra4").resultado, Retorno.Resultado.OK, "Palabra Ingresada");
        p.ver(s.InsertarPalabraEnLinea(2, 3, "Palabra5").resultado, Retorno.Resultado.OK, "Palabra Ingresada");
        p.ver(s.ImprimirTexto().resultado, Retorno.Resultado.OK, "Texto impreso correctamente");
        p.ver(s.InsertarPalabraYDesplazar(1, 1, "PalabraY").resultado, Retorno.Resultado.OK, "Insertada y desplazada");
        p.ver(s.InsertarPalabraYDesplazar(1, 2, "XXXXX").resultado, Retorno.Resultado.OK, "Insertada y desplazada");
        p.ver(s.ImprimirTexto().resultado, Retorno.Resultado.OK, "Texto impreso correctamente");

        p.ver(s.IngresarPalabraDiccionario("XXXXX").resultado, Retorno.Resultado.OK, "Palabra agregada al diccionario");
        p.ver(s.IngresarPalabraDiccionario("PalabraX").resultado, Retorno.Resultado.OK, "Palabra agregada al diccionario");
        p.ver(s.IngresarPalabraDiccionario("PalabraY").resultado, Retorno.Resultado.OK, "Palabra agregada al diccionario");
        p.ver(s.IngresarPalabraDiccionario("XXXXX").resultado, Retorno.Resultado.ERROR, "Se intenta agregar Palabra repetida al diccionario RESULTADO: "+ s.IngresarPalabraDiccionario("XXXXX").valorString);
              
        p.ver(s.ImprimirTextoIncorrecto().resultado, Retorno.Resultado.OK, "Palabras no ingresadas al diccionario impresas");               

        p.ver(s.DestruirSistemaMensajes().resultado, Retorno.Resultado.OK, "Sistema Borrado");       
        p.imprimirResultadosPrueba();


     }



    public static void pruebaDiccionario(Sistema s, Prueba p){

        p.ver(s.CrearSistemaMensajes().resultado, Retorno.Resultado.OK, "Se creo Sistema con una unidad C");
         /**** Métodos que agregue INICIO ****/
        p.ver(s.AgregarCarpeta("C", "Universidad").resultado, Retorno.Resultado.OK, "Se creo carpeta -> Universidad en Unidad C");
        p.ver(s.AgregarMensaje("C", "Universidad", "Programacion").resultado, Retorno.Resultado.OK, "Se agrego Mensaje/Documento Programacion a la carpeta Universidad de unidad C");
         /**** Métodos que agregue FIN ****/
        p.ver(s.InsertarLinea().resultado, Retorno.Resultado.OK, "Insertar linea AL FINAL 1 en blanco, Documento Programacion de Carpeta Universidad");
        p.ver(s.InsertarLinea().resultado, Retorno.Resultado.OK, "Insertar linea AL FINAL 2 en blanco, Documento Programacion de Carpeta Universidad");
        p.ver(s.InsertarLinea().resultado, Retorno.Resultado.OK, "Insertar linea AL FINAL 3 en blanco, Documento Programacion de Carpeta Universidad");
        p.ver(s.InsertarLinea().resultado, Retorno.Resultado.OK, "Insertar linea AL FINAL 4 en blanco, Documento Programacion de Carpeta Universidad");
        p.ver(s.InsertarLinea().resultado, Retorno.Resultado.OK, "Insertar linea AL FINAL 5 en blanco, Documento Programacion de Carpeta Universidad"); 
        
        p.ver(s.InsertarPalabraEnLinea(1, 1, "Este").resultado, Retorno.Resultado.OK, "Se Inserta Palabra 1 En Linea 1");
        p.ver(s.InsertarPalabraEnLinea(1, 2, "es").resultado, Retorno.Resultado.OK, "Se inseta palabra 2 en linea 1 ");
        p.ver(s.InsertarPalabraEnLinea(1, 3, "un").resultado, Retorno.Resultado.OK, "Se inseta palabra 3 en linea 1 ");
        p.ver(s.InsertarPalabraEnLinea(2, 1, "ejemplo").resultado, Retorno.Resultado.OK, "Se inseta palabra 1 en linea 2 ");
        p.ver(s.InsertarPalabraEnLinea(2, 1, "Frontend").resultado, Retorno.Resultado.OK, "Se inseta palabra Frontend en linea 2 ");
        
        p.ver(s.IngresarPalabraDiccionario("Deploy").resultado, Retorno.Resultado.OK, "Ingresando palabra Deploy a diccionario");
        p.ver(s.IngresarPalabraDiccionario("Frontend").resultado, Retorno.Resultado.OK, "Ingresando palabra Frontend a diccionario");
        p.ver(s.IngresarPalabraDiccionario("Backend").resultado, Retorno.Resultado.OK, "Ingresando palabra Backend a diccionario");
        p.ver(s.IngresarPalabraDiccionario("Ejemplo").resultado, Retorno.Resultado.OK, "Ingresando palabra Ejemplo a diccionario");
        
        
        p.ver(s.ImprimirTexto().resultado, Retorno.Resultado.OK, "Imprimir texto de Documento Programación");        
        p.ver(s.ImprimirDiccionario().resultado, Retorno.Resultado.OK, "Imprimir palabras del diccionario");        
        p.ver(s.ImprimirTextoIncorrecto().resultado, Retorno.Resultado.OK, "Imprimir texto que no se encunetra en el diccionario");
        p.imprimirResultadosPrueba();


    }    
//    public static void pruebaDiccionarioYMatriz(Sistema s, Prueba p){
//        p.ver(s.CrearSistemaMensajes().resultado, Retorno.Resultado.OK, "Se creo Sistema con una unidad C");
//        p.ver(s.AgregarCarpeta("C", "Universidad").resultado, Retorno.Resultado.OK, "Se creo carpeta -> Universidad en Unidad C");
//        p.ver(s.AgregarMensaje("C", "Universidad", "Programacion").resultado, Retorno.Resultado.OK, "Se agrego Mensaje/Documento Programacion a la carpeta Universidad de unidad C");
//        
//        p.ver(s.InsertarLinea().resultado, Retorno.Resultado.OK, "Insertar linea AL FINAL 1 en blanco, Documento Programacion de Carpeta Universidad");
//        p.ver(s.InsertarLinea().resultado, Retorno.Resultado.OK, "Insertar linea AL FINAL 2 en blanco, Documento Programacion de Carpeta Universidad");
//        p.ver(s.InsertarLinea().resultado, Retorno.Resultado.OK, "Insertar linea AL FINAL 3 en blanco, Documento Programacion de Carpeta Universidad");
//        p.ver(s.InsertarLinea().resultado, Retorno.Resultado.OK, "Insertar linea AL FINAL 4 en blanco, Documento Programacion de Carpeta Universidad");
//        p.ver(s.InsertarLinea().resultado, Retorno.Resultado.OK, "Insertar linea AL FINAL 5 en blanco, Documento Programacion de Carpeta Universidad"); 
//        
//        p.ver(s.InsertarPalabraEnLinea(1, 1, "Hace").resultado, Retorno.Resultado.OK, "Insertar Palabra En Linea");
//        p.ver(s.InsertarPalabraEnLinea(1, 2, "un").resultado, Retorno.Resultado.OK, "Insertar Palabra En Linea");
//        p.ver(s.InsertarPalabraEnLinea(1, 3, "Deploy").resultado, Retorno.Resultado.OK, "Insertar Palabra En Linea");
//        p.ver(s.InsertarPalabraEnLinea(2, 1, "Emanuel").resultado, Retorno.Resultado.OK, "Insertar Palabra En Linea");
//        
//        
//        p.ver(s.IngresarPalabraDiccionario("Deploy").resultado, Retorno.Resultado.OK, "Ingresando palabra Deploy a diccionario");
//        p.ver(s.IngresarPalabraDiccionario("Frontend").resultado, Retorno.Resultado.OK, "Ingresando palabra Frontend a diccionario");
//        p.ver(s.IngresarPalabraDiccionario("Backend").resultado, Retorno.Resultado.OK, "Ingresando palabra Backend a diccionario");
//        p.ver(s.IngresarPalabraDiccionario("Emanuel").resultado, Retorno.Resultado.OK, "Ingresando palabra Backend a diccionario");
//        p.ver(s.IngresarPalabraDiccionario("Alfredo").resultado, Retorno.Resultado.OK, "Ingresando palabra Backend a diccionario");
//        p.ver(s.IngresarPalabraDiccionario("Cecilia").resultado, Retorno.Resultado.OK, "Ingresando palabra Backend a diccionario");
//        p.ver(s.IngresarPalabraDiccionario("Fernanda").resultado, Retorno.Resultado.OK, "Ingresando palabra Backend a diccionario");
//        p.ver(s.IngresarPalabraDiccionario("Gonzalo").resultado, Retorno.Resultado.OK, "Ingresando palabra Backend a diccionario");
//        p.ver(s.BorrarPalabraDiccionario("frontend").resultado, Retorno.Resultado.OK, "Ingresando palabra Backend a diccionario");
//        
//        p.ver(s.ImprimirTexto().resultado, Retorno.Resultado.OK, "Imprimir texto de Documento Programación");
//        
//        p.ver(s.ImprimirDiccionario().resultado, Retorno.Resultado.OK, "Imprimir palabras del diccionario alfabeticamente");
//        
//        p.ver(s.ImprimirTextoIncorrecto().resultado, Retorno.Resultado.OK, "Imprimir texto que no se encunetra en el diccionario");
//        
//        p.ver(s.CargarDistancias(s.getMatriz()).resultado, Retorno.Resultado.OK, "Cargar distancias");
//        
//        Retorno mostrarCamino = s.BuscarCamino(s.getMatriz(), "MVD", "BA");
//        
//        p.ver(mostrarCamino.resultado, Retorno.Resultado.OK, mostrarCamino.valorString);
//        
//        Retorno mostrarCamino2 = s.BuscarCamino(s.getMatriz(), "MVD", "NYC");
//        
//        p.ver(mostrarCamino2.resultado, Retorno.Resultado.OK, mostrarCamino2.valorString);
//        
//        Retorno mostrarCamino3 = s.BuscarCamino(s.getMatriz(), "POA", "NYC");
//        
//        p.ver(mostrarCamino3.resultado, Retorno.Resultado.OK, mostrarCamino3.valorString);
//        
//        Retorno mostrarCamino4 = s.BuscarCamino(s.getMatriz(), "NYC", "SP");
//        
//        p.ver(mostrarCamino4.resultado, Retorno.Resultado.OK, mostrarCamino4.valorString);
//        
//    }
//    
//    public static void pruebaOperacionesPalabras(Sistema s, Prueba p){
//        p.ver(s.CrearSistemaMensajes().resultado, Retorno.Resultado.OK, "Se creo Sistema con una unidad C");
//        p.ver(s.AgregarCarpeta("C", "Personal").resultado, Retorno.Resultado.OK, "Se creo carpeta -> Personal en Unidad C");
//        p.ver(s.AgregarCarpeta("C", "Universidad").resultado, Retorno.Resultado.OK, "Se creo carpeta -> Universidad en Unidad C");
//        p.ver(s.AgregarCarpeta("C", "Trabajo").resultado, Retorno.Resultado.OK, "Se creo carpeta -> Trabajo en Unidad C");
//        p.ver(s.AgregarCarpeta("C", "Otros").resultado, Retorno.Resultado.OK, "Se creo carpeta -> Otros en Unidad C");
//        //eliminando carpeta Otros
//        p.ver(s.EliminarCarpeta("C", "Otros").resultado, Retorno.Resultado.OK, "Se eliminó carpeta Otros de unidad C");
//        //agregando mensajes
//        p.ver(s.AgregarMensaje("C", "Universidad", "Programacion").resultado, Retorno.Resultado.OK, "Se agrego Mensaje/Documento Programacion a la carpeta Universidad de unidad C");
//        p.ver(s.AgregarMensaje("C", "Universidad", "Programacion2").resultado, Retorno.Resultado.OK, "Se agrego Mensaje/Documento Programacion2 a la carpeta Universidad de unidad C");
//        p.ver(s.AgregarMensaje("C", "Universidad", "Algoritmos y Estructuras de Datos").resultado, Retorno.Resultado.OK, "Se agrego Mensaje/Documento Algoritmos y Estructuras de Datos a la carpeta Universidad de unidad C");
//        p.ver(s.AgregarMensaje("C", "Personal", "Gastos").resultado, Retorno.Resultado.OK, "Se agrego Mensaje/Documento Gastos a la carpeta Personal de unidad C");
//        p.ver(s.AgregarMensaje("C", "Trabajo", "ADX").resultado, Retorno.Resultado.OK, "Se agrego Mensaje/Documento ADX a la carpeta Personal de unidad C");
//        p.ver(s.AgregarMensaje("C", "Trabajo", "AudioTrade").resultado, Retorno.Resultado.OK, "Se agrego Mensaje/Documento AudioTrade a la carpeta Personal de unidad C");
//        
//        //eliminando nodo carpeta del medio
//        p.ver(s.EliminarMensaje("C", "Universidad", "Programacion2").resultado, Retorno.Resultado.OK, "Se elimino Mensaje/Documento Programacion2 de carpeta Universidad en unidad C");
//        
//        
//        p.ver(s.ListarEstructura("C", "Universidad").resultado, Retorno.Resultado.OK, "###### Estructura Carpeta: Universidad ######");
//        p.ver(s.ListarEstructura("C", "Personal").resultado, Retorno.Resultado.OK, "###### Estructura Carpeta: Personal ######");
//        
//        /***** INSERTAR LINEAS EN BLANCO AL FINAL *****/
//        p.ver(s.InsertarLinea().resultado, Retorno.Resultado.OK, "Insertar linea AL FINAL 1 en blanco, Documento Programacion de Carpeta Universidad");
//        p.ver(s.InsertarLinea().resultado, Retorno.Resultado.OK, "Insertar linea AL FINAL 2 en blanco, Documento Programacion de Carpeta Universidad");
//        p.ver(s.InsertarLinea().resultado, Retorno.Resultado.OK, "Insertar linea AL FINAL 3 en blanco, Documento Programacion de Carpeta Universidad");
//        p.ver(s.InsertarLinea().resultado, Retorno.Resultado.OK, "Insertar linea AL FINAL 4 en blanco, Documento Programacion de Carpeta Universidad");
//        p.ver(s.InsertarLinea().resultado, Retorno.Resultado.OK, "Insertar linea AL FINAL 5 en blanco, Documento Programacion de Carpeta Universidad"); 
//        
//        /***** INSERTAR LINEAS EN BLANCO POSICION ESPECIFICA *****/
//        p.ver(s.InsertarLineaEnPosicion(1).resultado, Retorno.Resultado.OK, "Insertar linea POS 1 en blanco, Documento Programacion de Carpeta Universidad");
//        
//        p.ver(s.ImprimirTexto().resultado, Retorno.Resultado.OK, "Imprimir texto de Documento Programación");
//        
//        /***** INSERTAR PALABRAS *****/
//        p.ver(s.InsertarPalabraEnLinea(1, 1, "Bienvenido").resultado, Retorno.Resultado.OK, "Insertar Palabra En Linea");
//        p.ver(s.InsertarPalabraEnLinea(1, 2, "Emanuel").resultado, Retorno.Resultado.OK, "Insertar Palabra En Linea");
//        p.ver(s.InsertarPalabraEnLinea(1, 2, "Coitino").resultado, Retorno.Resultado.OK, "Insertar Palabra En Linea");
//               
//        //palabra que excede el numero maximo de palabras por linea
//        p.ver(s.InsertarPalabraEnLinea(1, 1, "excedente").resultado, Retorno.Resultado.OK, "Insertar Palabra En Linea");
//        
//        p.ver(s.InsertarPalabraEnLinea(6, 1, "Emanuel").resultado, Retorno.Resultado.OK, "Insertar Palabra En Linea");  
//        p.ver(s.InsertarPalabraEnLinea(6, 2, "Coitino").resultado, Retorno.Resultado.OK, "Insertar Palabra En Linea"); 
//        p.ver(s.InsertarPalabraEnLinea(6, 3, "aaaaa").resultado, Retorno.Resultado.OK, "Insertar Palabra En Linea"); 
//        
//        p.ver(s.InsertarPalabraEnLinea(6, 2, "excedente2").resultado, Retorno.Resultado.OK, "Insertar Palabra En Linea"); 
//        p.ver(s.ImprimirTexto().resultado, Retorno.Resultado.OK, "Imprimir texto de Documento Programación");
//        
//        /***** INSERTAR Y DESPLAZAR *****/
//        
//        p.ver(s.InsertarPalabraYDesplazar(1, 1, "pepito").resultado,Retorno.Resultado.OK,"Insertar y desplazar");
//        p.ver(s.InsertarPalabraYDesplazar(1, 1, "audioad").resultado,Retorno.Resultado.OK,"Insertar y desplazar");
//        p.ver(s.InsertarPalabraYDesplazar(1, 1, "jp").resultado,Retorno.Resultado.OK,"Insertar y desplazar");
//        p.ver(s.InsertarPalabraYDesplazar(1, 1, "fer").resultado,Retorno.Resultado.OK,"Insertar y desplazar");
//        p.ver(s.InsertarPalabraYDesplazar(1, 1, "manu").resultado,Retorno.Resultado.OK,"Insertar y desplazar");
//        p.ver(s.InsertarPalabraYDesplazar(1, 1, "otra").resultado,Retorno.Resultado.OK,"Insertar y desplazar");
//        p.ver(s.InsertarPalabraYDesplazar(3, 3, "hola").resultado,Retorno.Resultado.OK,"Insertar y desplazar");
//        p.ver(s.InsertarPalabraYDesplazar(6, 1, "nueva").resultado,Retorno.Resultado.OK,"Insertar y desplazar");
//        p.ver(s.InsertarPalabraYDesplazar(6, 1, "nueva2").resultado,Retorno.Resultado.OK,"Insertar y desplazar");
//        p.ver(s.InsertarPalabraYDesplazar(6, 1, "nueva3").resultado,Retorno.Resultado.OK,"Insertar y desplazar");
//        p.ver(s.InsertarPalabraYDesplazar(6, 1, "nueva8").resultado,Retorno.Resultado.OK,"Insertar y desplazar");
//        p.ver(s.InsertarPalabraYDesplazar(5, 1, "ultimotest3").resultado,Retorno.Resultado.OK,"Insertar y desplazar");
//        p.ver(s.InsertarPalabraYDesplazar(5, 1, "ultimotest2").resultado,Retorno.Resultado.OK,"Insertar y desplazar");
//        p.ver(s.InsertarPalabraYDesplazar(5, 1, "ultimotest1").resultado,Retorno.Resultado.OK,"Insertar y desplazar");
//        p.ver(s.InsertarPalabraYDesplazar(5, 3, "ultimotest3/2").resultado,Retorno.Resultado.OK,"Insertar y desplazar");
//        p.ver(s.InsertarPalabraYDesplazar(5, 3, "ultimotest3/2").resultado,Retorno.Resultado.OK,"Insertar y desplazar");
//        p.ver(s.InsertarPalabraYDesplazar(5, 3, "ultimotest3/2").resultado,Retorno.Resultado.OK,"Insertar y desplazar");
//        p.ver(s.ImprimirTexto().resultado, Retorno.Resultado.OK, "Imprimir texto de Documento Programación");
//        
//        /***** INSERTAR Y DESPLAZAR *****/
//        
//        /***** BORRAR PALABRA *****/
//        //p.ver(s.borrarPalabra(1, 1).resultado, Retorno.Resultado.OK, "Borrar Palabra en posicion linea posicion palabra");
//        //p.ver(s.borrarPalabra(1, 1).resultado, Retorno.Resultado.OK, "Borrar Palabra en posicion linea posicion palabra");
//        p.ver(s.ImprimirTexto().resultado, Retorno.Resultado.OK, "Imprimir texto de Documento Programación");
//        
//        //p.ver(s.borrarOcurrenciasPalabraEnLinea(6, "Emanuel").resultado,Retorno.Resultado.OK, "Borrar Palabra en linea especifica");
//        //p.ver(s.borrarOcurrenciasPalabraEnLinea(6, "aaaaa").resultado,Retorno.Resultado.OK, "Borrar Palabra en linea especifica");
//        p.ver(s.ImprimirLinea(1).resultado, Retorno.Resultado.OK, "Imprimir texto linea uno ");
//        //p.ver(s.ImprimirTexto().resultado, Retorno.Resultado.OK, "Imprimir texto de Documento Programación");
//    }
//    
//    public static void pruebaSinErrores(Sistema s, Prueba p){
//        p.ver(s.CrearSistemaMensajes().resultado, Retorno.Resultado.OK, "Se creo Sistema con una unidad C");
//        p.ver(s.AgregarCarpeta("C", "Personal").resultado, Retorno.Resultado.OK, "Se creo carpeta -> Personal en Unidad C");
//        p.ver(s.AgregarCarpeta("C", "Universidad").resultado, Retorno.Resultado.OK, "Se creo carpeta -> Universidad en Unidad C");
//        p.ver(s.AgregarCarpeta("C", "Trabajo").resultado, Retorno.Resultado.OK, "Se creo carpeta -> Trabajo en Unidad C");
//        p.ver(s.AgregarCarpeta("C", "Otros").resultado, Retorno.Resultado.OK, "Se creo carpeta -> Otros en Unidad C");
//        //eliminando carpeta Otros
//        p.ver(s.EliminarCarpeta("C", "Otros").resultado, Retorno.Resultado.OK, "Se eliminó carpeta Otros de unidad C");
//        //agregando mensajes
//        p.ver(s.AgregarMensaje("C", "Universidad", "Programacion").resultado, Retorno.Resultado.OK, "Se agrego Mensaje/Documento Programacion a la carpeta Universidad de unidad C");
//        p.ver(s.AgregarMensaje("C", "Universidad", "Programacion2").resultado, Retorno.Resultado.OK, "Se agrego Mensaje/Documento Programacion2 a la carpeta Universidad de unidad C");
//        p.ver(s.AgregarMensaje("C", "Universidad", "Algoritmos y Estructuras de Datos").resultado, Retorno.Resultado.OK, "Se agrego Mensaje/Documento Algoritmos y Estructuras de Datos a la carpeta Universidad de unidad C");
//        p.ver(s.AgregarMensaje("C", "Personal", "Gastos").resultado, Retorno.Resultado.OK, "Se agrego Mensaje/Documento Gastos a la carpeta Personal de unidad C");
//        p.ver(s.AgregarMensaje("C", "Trabajo", "ADX").resultado, Retorno.Resultado.OK, "Se agrego Mensaje/Documento ADX a la carpeta Personal de unidad C");
//        p.ver(s.AgregarMensaje("C", "Trabajo", "AudioTrade").resultado, Retorno.Resultado.OK, "Se agrego Mensaje/Documento AudioTrade a la carpeta Personal de unidad C");
//        
//        //eliminando nodo carpeta del medio
//        p.ver(s.EliminarMensaje("C", "Universidad", "Programacion2").resultado, Retorno.Resultado.OK, "Se elimino Mensaje/Documento Programacion2 de carpeta Universidad en unidad C");
//        
//        
//        p.ver(s.ListarEstructura("C", "Universidad").resultado, Retorno.Resultado.OK, "###### Estructura Carpeta: Universidad ######");
//        p.ver(s.ListarEstructura("C", "Personal").resultado, Retorno.Resultado.OK, "###### Estructura Carpeta: Personal ######");
//        
//        /***** INSERTAR LINEAS EN BLANCO AL FINAL *****/
//        p.ver(s.InsertarLinea().resultado, Retorno.Resultado.OK, "Insertar linea AL FINAL 1 en blanco, Documento Programacion de Carpeta Universidad");
//        p.ver(s.InsertarLinea().resultado, Retorno.Resultado.OK, "Insertar linea AL FINAL 2 en blanco, Documento Programacion de Carpeta Universidad");
//        p.ver(s.InsertarLinea().resultado, Retorno.Resultado.OK, "Insertar linea AL FINAL 3 en blanco, Documento Programacion de Carpeta Universidad");
//        p.ver(s.InsertarLinea().resultado, Retorno.Resultado.OK, "Insertar linea AL FINAL 4 en blanco, Documento Programacion de Carpeta Universidad");
//        p.ver(s.InsertarLinea().resultado, Retorno.Resultado.OK, "Insertar linea AL FINAL 5 en blanco, Documento Programacion de Carpeta Universidad"); 
//        
//        /***** INSERTAR LINEAS EN BLANCO POSICION ESPECIFICA *****/
//        p.ver(s.InsertarLineaEnPosicion(1).resultado, Retorno.Resultado.OK, "Insertar linea POS 1 en blanco, Documento Programacion de Carpeta Universidad");
//        
//        /***** INSERTAR PALABRAS EN UNA LINEA ESPECIFICA Y EN UNA POSICION ESPECIFICA *****/
//        p.ver(s.InsertarPalabraEnLinea(1, 1, "Emanuel").resultado, Retorno.Resultado.OK, "Insertar Palabra En Linea 1 en Posicion de linea 1");
//        p.ver(s.InsertarPalabraEnLinea(1, 2, "Coitino").resultado, Retorno.Resultado.OK, "Insertar Palabra En Linea 1 en Posicion de linea 1");
//        
//        /***** INSERTAR LINEAS EN BLANCO POSICION ESPECIFICA *****/
//        p.ver(s.InsertarLineaEnPosicion(1).resultado, Retorno.Resultado.OK, "Insertar linea 1 blanco, Documento Programacion de Carpeta Universidad");
//        p.ver(s.InsertarLineaEnPosicion(1).resultado, Retorno.Resultado.OK, "Insertar linea 1 blanco, Documento Programacion de Carpeta Universidad");
//        
//        p.ver(s.ImprimirTexto().resultado, Retorno.Resultado.OK, "Imprimir texto de Documento Programación");
//        /***** BORRAR LINEAS EN BLANCO POSICION ESPECIFICA *****/
//        p.ver(s.BorrarLinea(2).resultado,Retorno.Resultado.OK,"Borrar linea 2");
//        p.ver(s.BorrarLinea(7).resultado,Retorno.Resultado.OK,"Borrar linea 7");
//        
//        p.ver(s.ImprimirTexto().resultado, Retorno.Resultado.OK, "Imprimir texto de Documento Programación");
//        
//        /***** BORRAR TODO DE DOC PROGRAMACION E IMPRIMIR PARA VERIFICAR QUE NO ESTEN LOS DATOS *****/
//        //p.ver(s.borrarTodo().resultado, Retorno.Resultado.OK, "Documento Programacion vaciado !!");
//        p.ver(s.ImprimirTexto().resultado, Retorno.Resultado.OK, "Texto Vacio`");  
//        
//        /***** INSERTAR PALABRAS *****/
//        p.ver(s.InsertarPalabraEnLinea(1, 2, "Emanuel").resultado, Retorno.Resultado.OK, "Insertar Palabra En Linea");
//        p.ver(s.InsertarPalabraEnLinea(1, 1, "manu").resultado, Retorno.Resultado.OK, "Insertar Palabra En Linea");
//        p.ver(s.InsertarPalabraEnLinea(6, 3, "Emanuel").resultado, Retorno.Resultado.OK, "Insertar Palabra En Linea");
//        
//        /***** IMPRIMIR PARA VER PALABRAS INSERTADAS *****/
//        p.ver(s.ImprimirTexto().resultado, Retorno.Resultado.OK, "Imprimir texto de Documento Programación");
//        
//        /***** BORRAR OCURRENCIAS DE PALABRA "EMANUEL" EN DOCUMENTO PROGRAMACION *****/  
//        p.ver(s.BorrarOcurrenciasPalabraEnTexto("Emanuel").resultado, Retorno.Resultado.OK, "Borrar palabra Emanuel de documento Programacion");
//        
//        /***** IMPRIMIR PARA RESULTADO LUEGO DE BORRAR PALABRAS *****/
//        p.ver(s.ImprimirTexto().resultado, Retorno.Resultado.OK, "Imprimir texto de Documento Programación");
//
//    }
//    
//    public static void pruebaErroresCrearCarpeta(Sistema s, Prueba p){
//        p.ver(s.CrearSistemaMensajes().resultado, Retorno.Resultado.OK, "Se creo Sistema con una unidad C");
//        p.ver(s.AgregarCarpeta("C", "Personal").resultado, Retorno.Resultado.OK, "Se creo carpeta -> Personal en Unidad C");
//        p.ver(s.AgregarCarpeta("C", "Universidad").resultado, Retorno.Resultado.OK, "Se creo carpeta -> Universidad en Unidad C");
//        p.ver(s.AgregarMensaje("C", "Universidad", "Programacion").resultado, Retorno.Resultado.OK, "Se agrego Mensaje/Documento Programacion a la carpeta Universidad de unidad C");
//        
//        /***** CARPETA *****/
//        
//        //intento crear carpeta duplicada
//        Retorno crearCarpetaDuplicada = s.AgregarCarpeta("C", "Universidad");
//        p.ver(crearCarpetaDuplicada.resultado, Retorno.Resultado.ERROR, crearCarpetaDuplicada.valorString);
//        
//        //intento crear carpeta en ubicacion que no existe 
//        Retorno crearCarpetaUnidadNoExiste = s.AgregarCarpeta("H", "Universidad");
//        p.ver(crearCarpetaUnidadNoExiste.resultado, Retorno.Resultado.ERROR, crearCarpetaUnidadNoExiste.valorString);
//        
//        //intento eliminar carpeta en unidad que no existe
//        Retorno eliminarCarpetaNoExisteUnidad = s.EliminarCarpeta("H", "Universidad");
//        p.ver(eliminarCarpetaNoExisteUnidad.resultado, Retorno.Resultado.ERROR, eliminarCarpetaNoExisteUnidad.valorString);
//        
//        //intento eliminar carpeta que no existe
//        Retorno eliminarCarpetaNoExisteCarpeta = s.EliminarCarpeta("C", "pepe");
//        p.ver(eliminarCarpetaNoExisteCarpeta.resultado, Retorno.Resultado.ERROR, eliminarCarpetaNoExisteCarpeta.valorString);
//        
//        /***** CARPETA *****/
//        
//        /***** MENSAJE *****/
//        
//        //intento agregar mesanje en carpeta no existente
//        Retorno AgregarMensajeEnCarpetaNoExiste = s.AgregarMensaje("C", "pepito", "Programacion");
//        p.ver(AgregarMensajeEnCarpetaNoExiste.resultado, Retorno.Resultado.ERROR, AgregarMensajeEnCarpetaNoExiste.valorString);
//        
//        //intento agregar mesanje en unidad que no existe
//        Retorno AgregarMensajeEnUnidadNoExiste = s.AgregarMensaje("H", "Universidad", "Programacion");
//        p.ver(AgregarMensajeEnUnidadNoExiste.resultado, Retorno.Resultado.ERROR, AgregarMensajeEnUnidadNoExiste.valorString);
//        
//        //intento agregar mesanje en carpeta que ya existe
//        Retorno AgregarMensajeQueExiste = s.AgregarMensaje("C", "Universidad", "Programacion");
//        p.ver(AgregarMensajeQueExiste.resultado, Retorno.Resultado.ERROR, AgregarMensajeQueExiste.valorString);
//        
//        //intento eliminar mesanje en carpeta no existente
//        Retorno eliminarMensajeEnCarpetaNoExiste = s.EliminarMensaje("C", "pepito", "Programacion");
//        p.ver(eliminarMensajeEnCarpetaNoExiste.resultado, Retorno.Resultado.ERROR, eliminarMensajeEnCarpetaNoExiste.valorString);
//        
//        //intento eliminar mesanje en unidad que no existe
//        Retorno eliminarMensajeEnUnidadNoExiste = s.EliminarMensaje("H", "Universidad", "Programacion");
//        p.ver(eliminarMensajeEnUnidadNoExiste.resultado, Retorno.Resultado.ERROR, eliminarMensajeEnUnidadNoExiste.valorString);
//        
//        //intento eliminar mesanje en archivo que no existe
//        Retorno eliminarMensajeQueExiste = s.EliminarMensaje("C", "Universidad", "Programacion2");
//        p.ver(eliminarMensajeQueExiste.resultado, Retorno.Resultado.ERROR, eliminarMensajeQueExiste.valorString);
//        
//        /***** MENSAJE *****/
//        
//        /***** ESTRUCTURA *****/
//        
//        Retorno noHayCarpetas = s.ListarEstructura("H", "Personal");
//        p.ver(noHayCarpetas.resultado, Retorno.Resultado.ERROR, noHayCarpetas.valorString);
//        
//        /***** ESTRUCTURA *****/
//        
//        /***** INSERTAR LINEAS *****/
//        
//        p.ver(s.InsertarLinea().resultado, Retorno.Resultado.OK, "Insertar linea 1 en blanco, Documento Programacion de Carpeta Universidad");
//        p.ver(s.InsertarLinea().resultado, Retorno.Resultado.OK, "Insertar linea 2 en blanco, Documento Programacion de Carpeta Universidad");
//        p.ver(s.InsertarLinea().resultado, Retorno.Resultado.OK, "Insertar linea 3 en blanco, Documento Programacion de Carpeta Universidad");
//        p.ver(s.InsertarLinea().resultado, Retorno.Resultado.OK, "Insertar linea 4 en blanco, Documento Programacion de Carpeta Universidad");
//        p.ver(s.InsertarLinea().resultado, Retorno.Resultado.OK, "Insertar linea 5 en blanco, Documento Programacion de Carpeta Universidad");
//        
//        //intento insertar una linea en posicion invalida
//        Retorno insertarLineaPosInvalida1 = s.InsertarLineaEnPosicion(70); 
//        Retorno insertarLineaPosInvalida2 = s.InsertarLineaEnPosicion(25);
//        
//        p.ver(insertarLineaPosInvalida1.resultado, Retorno.Resultado.ERROR, insertarLineaPosInvalida1.valorString);
//        p.ver(insertarLineaPosInvalida2.resultado, Retorno.Resultado.ERROR, insertarLineaPosInvalida2.valorString);        
//        
//        p.ver(s.ImprimirTexto().resultado, Retorno.Resultado.OK, "Imprimir texto de Documento Programación");
//        
//        /***** INSERTAR LINEAS *****/
//        
//        /***** BORAR LINEAS EN POSICION ESPECIFICA *****/
//        Retorno borrarLineaPosInvalida1 = s.InsertarLineaEnPosicion(90);
//        Retorno borrarLineaPosInvalida2 = s.InsertarLineaEnPosicion(45);
//        
//        p.ver(borrarLineaPosInvalida1.resultado, Retorno.Resultado.ERROR, borrarLineaPosInvalida1.valorString);
//        p.ver(borrarLineaPosInvalida2.resultado, Retorno.Resultado.ERROR, borrarLineaPosInvalida2.valorString);
//        /***** BORAR LINEAS EN POSICION ESPECIFICA *****/
//    }
    
}