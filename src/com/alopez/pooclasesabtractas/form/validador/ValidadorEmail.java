package com.alopez.pooclasesabtractas.form.validador;

public class ValidadorEmail extends Validador{ //Clase que se extiende de la clase padre Validador

    protected String mensaje = "el campo %s tiene un formato de correo inválido";

    private final static String EMAIL_REGEX = "^(.+)@(.+)$"; //Para el caracter ^ se usa alt+94 //EMAIL_REGEX es una constante con el patron de expresion regular
    // ^ Valida el String desde el inicio de la cadena    () Indica que es un grupo  . Indica cualquier cararcter
    // + Indica que el caracter representado en . puede repetirse n cantidad de veces
    // @ Arroba, parte del correo   $ Revisa que el valor se encuentre al final de la expresion



    //Implementamos los metodos que vienen de la clase abstracta padre Validador
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
        return valor.matches(EMAIL_REGEX); //Para validar, colocamos el metodo matches, y se pasa por argumento la expresion regular
    }
}