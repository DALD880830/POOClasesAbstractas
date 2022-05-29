package com.alopez.pooclasesabtractas.form.validador;

public class ValidadorNoNulo extends Validador{ //Clase hija que se extiende de la clase padre abstracta Validador


    protected String mensaje = "el campo %s no puede ser nulo"; //Atributo mensaje igual que el padre, con la diferencia de que tiene un valor
    //%s es un comodin, para que cambie con un String especifico


    //Implementamos los metodos de la clase padre
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
        return (valor != null); //Si el valor pasado por argumento es diferente de null es valido, si no, retorna false
    }
}