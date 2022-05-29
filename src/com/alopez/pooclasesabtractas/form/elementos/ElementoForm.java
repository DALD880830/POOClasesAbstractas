package com.alopez.pooclasesabtractas.form.elementos;

import com.alopez.pooclasesabtractas.form.validador.Validador;
import com.alopez.pooclasesabtractas.form.validador.ValidadorLargo;
import com.alopez.pooclasesabtractas.form.validador.mensaje.MensajeFormateable;

import java.util.ArrayList;
import java.util.List;

abstract public class ElementoForm { //Definimos que la clase es abstracta, colocando abstract al inicio
//Una clase abstracta puede o no tener metodos abstractos, pero una clase que no sea abstracta no puede tener metodos abstractos

    //Atributos protected, para que las clases hijas puedan acceder a ellos sin la necesidad de metodo get
    protected String valor;
    protected String nombre;

    //Cada elemento del formulario va a obtener sus validadores
    private List<Validador> validadores;
    private List<String> errores;

    public ElementoForm() { //Generamos un constructor vacio
        this.validadores = new ArrayList<>(); //Inicializamos los list con new ArrayList
        this.errores = new ArrayList<>();
    }

    public ElementoForm(String nombre) {
        this(); //Esto hace que se llame al constructor de arriba, invocando a las listas
        this.nombre = nombre;
    }

    public ElementoForm addValidador(Validador validador){ //Retorna elementoform
        this.validadores.add(validador); //Adherimos elementos a la lista, Un arraylist maneja de manera dinamica el tamaño
        return this;
    }

    public List<String> getErrores() { //Con esto podemos leer lo errores desde fuera de la clase
        return errores;
    }

    public void setValor(String valor) { //Con este metodo se asigna valor
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean esValido(){ //Metodo para validar
        for(Validador v: validadores) //Recorremos con un for each los validadores
            if(!v.esValido(this.valor)){ //Si es distinto de valido, por argumento pasa valor de esta clase
                if (v instanceof MensajeFormateable){ //De esta forma, se pueden tener varias clases Validadoras que
                    //implementan la interfaz //Si es instancia de MensajeFormateable, se invoca el metodo de la interfaz
                    //independiente si lo implementa cualquier clase
                    this.errores.add(((MensajeFormateable) v).getMensajeFormateado(nombre));
//                  if (v instanceof ValidadorLargo){ //Si v es instancia de Validador Largo
//                    this.errores.add(((ValidadorLargo) v).getMensajeFormateado(nombre)); //Adhiere el error a la lista con el nombre del campo con mensajeFormateado
                }else{
                    this.errores.add(String.format(v.getMensaje(), nombre)); //Si no es valido, asignamos el mensaje de error, pasamos el mensaje
                    //Con String format, en los mensajes de error %s cambiará por el nombre del campo
                    // de error del validador, cada validador tiene su propio mensaje, Valor numero o requerido o no nulo, etc
                }

            }
        return this.errores.isEmpty(); //Si la lista no cuenta con elementos, retorna true, si cuenta con elementos, retorna false
    }

    abstract public String dibujarHtml(); //Al ser un metodo abstracto, no lleva llaves, el cuerpo e implementacion debe estar en las clases hijas


}