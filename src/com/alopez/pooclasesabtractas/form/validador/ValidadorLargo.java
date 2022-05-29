package com.alopez.pooclasesabtractas.form.validador;

import com.alopez.pooclasesabtractas.form.validador.mensaje.MensajeFormateable;

public class ValidadorLargo extends  Validador implements MensajeFormateable {
    //Clase que se extiende de la clase padre Validador e Implementa la Interfaz de MensajeFormateable


    protected String mensaje = "el campo %s debe tener minimo %d caracteres y maximo %d caracteres";
    //%s es un comodin, para que cambie con un String especifico

    private int min; //Inicializamos la variable de valor minimo, por defecto esta en 0
    private int max = Integer.MAX_VALUE; //Inicializamos la variable de valor maximo, esta asociada al maximo valor de int


    public ValidadorLargo() { //Generamos un constructor vacio //Generamos el new con este constructor
    }

    //Generamos el constructor para minimo y maximo
    public ValidadorLargo(int min, int max) { //Si pasamos ambos, se utiliza este constructor
        this.min = min;
        this.max = max;
    }


    //Generamos los setter tanto de minimo como maximo //Pasamos el minimo o el maximo via set
    public void setMin(int min) {
        this.min = min;
    }
    public void setMax(int max) {
        this.max = max;
    }


    //Implementamos los metodos que vienen de la clase abstracta padre Validador
    @Override
    public void setMensaje(String mensaje) {
        this.mensaje=mensaje;
    }

    @Override
    public String getMensaje() {
        return mensaje;
    }

    @Override
    public boolean esValido(String valor) {
//        this.mensaje = String.format(this.mensaje, this.min, this.max);
        if(valor == null){ //Validamos, si es null entonces es valido y retorna true
            return true; //Retorna true porque asi evitamos el NullPointerExcepcion
        }
        int largo = valor.length(); //Invocamos el metodo lenght
        return largo >= min && largo <= max; //Retornara true si el largo es mayor o igual a minimo y ademas sea menor o igual a maximo
    }

    @Override
    public String getMensajeFormateado(String campo){ //Este metodo viene de la interfaz
        return String.format(this.mensaje, campo, this.min, this.max);
    }
}