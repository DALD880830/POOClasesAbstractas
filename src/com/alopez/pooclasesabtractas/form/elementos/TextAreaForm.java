package com.alopez.pooclasesabtractas.form.elementos;

public class TextAreaForm extends ElementoForm {

    private int filas;
    private int columnas;


    public TextAreaForm(String nombre) { //Constructor para invocar al padre
        super(nombre);
    }

    public TextAreaForm(String nombre, int filas, int columnas) { //Constructor para que se pasen los atributos de esta clase
        super(nombre);
        this.filas = filas;
        this.columnas = columnas;
    }

    //Getter and setter de los atributos filas y columnas
    public int getFilas() {
        return filas;
    }
    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }
    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    @Override
    public String dibujarHtml() { //Metodo para sobreescribir el metodo de la clase abstracta
        return "<textarea name='" + this.nombre + "'" +
                " cols='" + this.columnas + "'" +
                " rows='" + this.filas + "' " +">"
                + this.valor + "</textarea>";

    }
}