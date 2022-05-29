package com.alopez.pooclasesabtractas.form.elementos;

import com.alopez.pooclasesabtractas.form.elementos.select.Opcion;

import java.util.ArrayList;
import java.util.List;

public class SelectForm extends ElementoForm{


    private List<Opcion> opciones; //Creamos una lista con opciones //List es una interfaz

    public SelectForm(String nombre) { //Constructor
        super(nombre); //Se pasa el nombre que es un atributo de la clase padre abstracta
        this.opciones = new ArrayList<Opcion>(); //Inicializamos el arreglo
    }

    public SelectForm(String nombre, List<Opcion> opciones) { //Constructor, en donde inicializamos la lista por argumento
        super(nombre); //Se pasa el nombre que es un atributo de la clase padre abstracta
        this.opciones = opciones;
    }

    public SelectForm addOpcion(Opcion opcion) { //Agregamos un elemento al arreglo lista //En vez de void se coloca el
        //nombre de la clase para no poner en todo momento objeto.addopcion; uno mas objeto.addopcion;, otro mas objeto.addopcion;
        this.opciones.add(opcion);
        return this;
    }

    @Override
    public String dibujarHtml() { //Metodo para sobreescribir el metodo
        StringBuilder sb = new StringBuilder("<select "); //Creamos un string builder para concatenar
        sb.append("name= '") //select es un elemento de html para listas, concatenamos con nombre
                .append(this.nombre)
                .append("'>"); //Cerramos la comilla y el elemento select
        for(Opcion opcion: this.opciones){ //Iteramos dentro del elemento select para mostrar las opciones
            //this.opciones hace referencia al arreglo //Por cada opcion se crea un elemento html
            sb.append("\n<option value = '") //
                    .append(opcion.getValor()) //Por cada opcion se le asigna un valor
                    .append("'");
            if (opcion.isSelected()){ //Si la opcion seleccionada es true
                sb.append(" selected"); //Si es true se coloca selected
                this.valor = opcion.getValor(); //Asignamos el valor de la opcion marcada
            }
            sb.append(">").append(opcion.getNombre()) //Cerramos la opcion  y colocamos el nombre
                    .append("</option>"); //Cerramos la etiqueta opcion
        }
        sb.append("</select>"); //Cerramos la etiqueta selected
        return sb.toString();
    }

}