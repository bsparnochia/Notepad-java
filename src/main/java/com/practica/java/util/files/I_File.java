package com.practica.java.util.files;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 * Interfaz para el tratamiento 
 * de información de una fuente
 * @author brian
 */
public interface I_File {
    /**
     * Imprime en pantalla el contenido de la fuente
     */
   default void print(){
       System.out.println(this.getText());
   }
   /**
    * Establece el contenido dentro de la fuente
    * @param texto nuevo texto a guardar
    */
   void setText(String texto);
   /**
    * Limpia el contenido de la fuente dejandolá vacía
    */
   default void clear(){
       this.setText("");
   }
   /**
    * Devuelve el texto de la fuente
    * @return texto en formato String de la fuente
    */
   String getText();
   /**
    * Agrega contenido a la fuente
    * @param texto contenido de formato String
    */
   void append(String texto);
   /**
    * Agrega una linea de texto a la fuente
    * @param linea línea de caracteres en formato String a agregar
    */
   default void addLine(String linea){
       this.append(linea+"\n");
   }
   /**
    * Agrega varias líneas de caracteres a la fuente
    * @param lineas lista de lineas de texto a agregar
    */
   default void addlines(List<String> lineas){
       lineas.forEach(this::addLine);
   }
   /**
    * Devuelve un Stream de Strings que contiene el texto de al fuente
    * @return un Stream de Strings del contenido
    */
   Stream<String> getStream();
   /**
    * Retorna un listado de caracteres del contenido del texto
    * @return Lista de caracteres
    */
   default List<String> getAll(){
       return this.getStream().collect(Collectors.toList());
   }
   /**
    * Devuelve un listado de caracteres 
    * basandose en un filtro de búsqueda
    * @param filter filtro de tipo String
    * @return Devuelve un listado de caracteres
    */
   default List<String> getByFilter(String filter){
       return this
               .getStream()
               .filter(s->s.toLowerCase().contains(filter.toLowerCase()))
               .collect(Collectors.toList());
   }
   /**
    * Devuelve las líneas de texto de la fuente ordenadas
    * en orden alfabético(A-Z)
    * @return Listado de caracteres ordenado
    */
   default List<String> getSortedLines(){
       return this.getStream().sorted().collect(Collectors.toList());
   }
   /**
    * Devuelve las líneas de texto de la fuente ordenadas
    * en orden contrario (Z-A)
    * @return Listado de caracteres ordenado
    */
   default List<String> getReversedSortedLines(){
       return this.getStream()
               .sorted(Comparator
                       .reverseOrder())
               .collect(Collectors.toList());
   }
   /**
    * Devuelve un LinkedHashSet del contenido
    * de la fuente
    * @return un LinkedHashSet con elementos String
    */
   default LinkedHashSet<String> getLinkedHashSet(){
       LinkedHashSet<String> set = new LinkedHashSet();
       set.addAll(this.getAll());
       return set;
   }
   /**
    * Devuelve un TreeSet del contenido
    * de la fuente
    * @return TreeSet con elementos String
    */
   default TreeSet<String> getTreeSet(){
       TreeSet set= new TreeSet();
       set.addAll(getAll());
       return set;
   }
   /**
    * Remueve una línea del contenido de la fuente
    * @param line línea a remover en formato String
    */
   default void remove(String line){
       List<String> list= this.getAll();
       list.remove(line);
       clear();
       addlines(list);
   }
}
