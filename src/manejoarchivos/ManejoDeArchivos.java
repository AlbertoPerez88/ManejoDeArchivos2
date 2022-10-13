/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejoarchivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alumno Mañana
 */
public class ManejoDeArchivos {
    public static void crearArchivo(String nombre){
        File archivo = new File(nombre);
        try{
            PrintWriter salida = new PrintWriter(archivo);
            salida.close();
        } catch(FileNotFoundException ex){
            ex.printStackTrace(System.out);
        }
    }
    public static void escribirArchivo(String nombre, String contenido){
        PrintWriter salida = null;
        File archivo = new File(nombre);
        try {   //se que el fichero existe
            salida = new PrintWriter(archivo);
            salida.println(contenido);
            System.out.println("Se ha creado el archivo");
        } catch (FileNotFoundException ex) {    //el fichero no existe
            ex.printStackTrace(System.out);
        } finally { //este bloque siempre se ejecuta
            salida.close();
        }
    }
    
    //Este metodo agraga texto en el archivo, no sobreescribe
    public static void agregarArchivo(String nombre, String contenido){
        PrintWriter salida = null;
        File archivo = new File(nombre);
        
        try {
            salida = new PrintWriter(new FileWriter(nombre, true));
            salida.println(contenido);
        } catch (IOException ex) {
            
        }finally { 
            salida.close();
        }
        
    }
    
    public static void leerArchivo(String nombre){
        BufferedReader entrada = null;
        //1º Declaramos el File
        File archivo = new File(nombre);
        try {
            //2º Creamos el descriptor de lectura del fichero
            entrada = new BufferedReader(new FileReader(archivo));
            String lectura = entrada.readLine();
            //3º Ahora recorremos lectura hasta fin de fichero
            while(lectura != null){
                System.out.println("lectura -> " + lectura);
                lectura = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex){
            ex.printStackTrace(System.out);
        }
    }
    
    public static void leerArchivoPorPalabra(String nombre){
        
        File archivo = new File(nombre);
        try {
            Scanner entrada = new Scanner(archivo);
            int cont = 0;
            
            //Recorro el fichero hasta fin
            while(entrada.hasNext()){
                String palabra = entrada.next();
                System.out.println(palabra);
                cont = cont + 1;
            }
            System.out.println("Numero de palabras de mi fichero = "+ cont);
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
