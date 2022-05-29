package com.alopez.pooclasesabtractas.form.validador;

public class ValidadorNumero extends Validador{//Clase que se extiende de la clase padre Validador


    protected String mensaje = "el campo %s debe ser numero"; //mensaje debe tener el mismo nombre que en la clase padre abstracta Validador
    //%s es un comodin, para que cambie con un String especifico


    //Implementación de los métodos de la clase abstracta padre Validador
    @Override
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String getMensaje() {
        return mensaje;
    }

    @Override
    public boolean esValido(String valor) {
        try { //Validamos que el valor sea un numero, si es un numero retorna true
            Integer.parseInt(valor);
            return true;
        }catch (NumberFormatException e){ //si no es un numero se retorna un false
            return false;
        }
    }
}