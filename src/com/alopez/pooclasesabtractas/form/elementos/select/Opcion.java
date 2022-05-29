package com.alopez.pooclasesabtractas.form.elementos.select;

public class Opcion {

    private String valor;
    private String nombre;
    private boolean selected;

    //Getter and Setter de valor, nombre y selected
    public String getValor() {
        return valor;
    }
    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    //Sobrecargamos el metodo de arriba
    public Opcion setSelected() { //Se quita el void y se cambia a objeto del tipo Opcion
        this.selected = selected;
        return this; //Como ya es un objeto del tipo opcion y no un void, debe retornar algo
    }


    //Constructores, el primero vacío y el segundo con valor y nombre
    public Opcion() {
    }

    public Opcion(String valor, String nombre) {
        this.valor = valor;
        this.nombre = nombre;
    }
}