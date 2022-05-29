package com.alopez.pooclasesabtractas.form.validador;

abstract public class Validador { //Creamos la clase abstracta

    protected String mensaje; //Cada clase validadora implementará este mensaje, cada clase hija tendrá este atributo

    //Getter and Setter abstractos
    abstract public void setMensaje(String mensaje);
    abstract public String getMensaje();

    abstract public boolean esValido(String valor); //Metodo abstracto //Validamos que cada campo tenga un valor

}