package com.practica.java.util.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.stream.Stream;

/**
 * Entidad encargada del manejo de archivos de texto.
 * @author brian
 */
public class FileText implements I_File{
    
    private File archivo;

    /**
     * Se indica un archivo existente a tratar
     * @param archivo archivo de texto elegido para manipular
     */
    public FileText(File archivo) {
        this.archivo = archivo;
    }
    
    /**
     * Crea una nueva instancia de un archivo
     * de texto según un ruta definida
     * @param ruta donde se encuentra el archivo
     */
    public FileText(String ruta){
        this.archivo = new File(ruta);
    }

    /**
     * Guarda el texto enviado por párametro
     * en el archivo sobrescribiendolo
     * @param texto texto de tipo String a guardar en el archivo
     */
    @Override
    public void setText(String texto) {
        try (FileWriter in = new FileWriter(archivo)){            
            in.write(texto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Devuelve el contenido del archivo de texto
     * @return contenido de tipo String
     */
    @Override
    public String getText() {
        int car;
        StringBuilder sb= new StringBuilder();
        try (FileReader in=new FileReader(archivo)){
            while((car=in.read())!=-1){
                sb.append((char)car);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
    /**
    * Agrega una cadena de caracteres al final del archivo de texto
    * @param texto a agregar al final de tipo String
    */
    @Override
    public void append(String texto) {
        try (FileWriter in=new FileWriter(this.archivo,true)){
            in.write(texto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Devuelve un Stream de caracteres que contiene el texto
     * @return Stream de caracteres del texto
     */
    @Override
    public Stream<String> getStream() {
        try{
            return new BufferedReader(new FileReader(archivo)).lines();
        } catch (IOException e) {
            return null;
        }
    }
}
