package com.alopez.pooclasesabtractas.form.validador;

public class ValidadorRequerido extends Validador { //Clase que se extiende de la clase padre Validador

    protected String mensaje = "El campo %s es requerido";
    //%s es un comodin, para que cambie con un String especifico


    //Implementación de los métodos de la clase abstracta padre Validador
    @Override
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje; //Asignamos el mensaje
    }

    @Override
    public String getMensaje() {
        return mensaje; //Retornamos el mensaje asignado
    }

    @Override
    public boolean esValido(String valor) {
        return (valor != null && valor.length() > 0); //Valida si es diferente de nulo y además tenga contenido
    }
}