package com.alopez.pooclasesabtractas.form.elementos;

public class InputForm extends ElementoForm {

    private String tipo = "text"; //En Html, Los elementos del formulario del tipo input tienen el atributo type, por defecto es del tipo text


    //Getter and Setter de tipo
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public InputForm(String nombre) { //Creamos un constructor que pasa el nombre
        super(nombre); //Atributo de la clase abstracta ElementoForm
    }

    public InputForm(String nombre, String tipo) { //Creamos un constructor que pasa nombre y tipo
        super(nombre);
        this.tipo = tipo; //Atributo propio de la clase
    }


    @Override
    public String dibujarHtml() { //Metodo para sobreescribir el metodo de la clase abstracta
        return "<input type= " + "\"" + this.tipo + "\"" +
                " name= " + "\"" + this.nombre + "\"" +
                " value= " + "\"" + this.valor + "\"" + ">"; //Etiqueta input, type esta en esta clase y name y value esta en la clase abstract
    }

}