package com.alopez.pooclasesabtractas.form;

import com.alopez.pooclasesabtractas.form.elementos.*;
import com.alopez.pooclasesabtractas.form.elementos.select.Opcion;
import com.alopez.pooclasesabtractas.form.validador.*;

import java.util.Arrays;
import java.util.List;

public class EjemploForm {

    public static void main(String[] args) {

    /*    ElementoForm el = new ElementoForm(){//Elemento form es una clase asbtracta, por ello no se puede instanciar,
            //por ello debe quedar como una Clase anonima
            @Override
            public String dibujarHtml() { //Implementamos el método de la clase abstracta
                return null;
            }
        }; //Este tipo de clase con su metodo no son reutilizables
    */

        InputForm username = new InputForm("username"); //Creamos un inputform con un usuario y tipo text
        username.addValidador(new ValidadorRequerido()); //Agregamos un validador a username
        InputForm password = new InputForm("clave", "password"); //Creamos un inputform con clave y tipo password
        password.addValidador(new ValidadorRequerido()) //Agregamos un validador a password
                .addValidador(new ValidadorLargo(6,12)); //El minimo de caracteres es 6 y el maximo es 12
        InputForm email = new InputForm("email", "email"); //Creamos un inputform con email y tipo email
        email.addValidador(new ValidadorRequerido()) //Agregamos un validador a email
                .addValidador(new ValidadorEmail());
        InputForm edad = new InputForm("edad", "number"); //Creamos un inputform con edad y tipo number
        edad.addValidador(new ValidadorNumero());


        TextAreaForm experiencia = new TextAreaForm("exp", 5, 9); //Creamos un textArea, recibe un nombre, filas y columnas

        SelectForm lenguaje = new SelectForm("lenguaje"); //Creamos un selectform, y damos el nombre del campo
//        Opcion java = new Opcion("1", "Java"); //Pasamos la primera opcion y recibe el valor y el nombre //Esta es una forma de pasarla

        lenguaje.addValidador(new ValidadorNoNulo());//Agregamos un validador a username

        lenguaje.addOpcion(new Opcion("1", "Java")) //Agregamos el elemento a la lista con el metodo addOpcion
                .addOpcion(new Opcion("2", "Python")) //Esta es una forma de agregar la opcion de manera directa y pasamos la instancia
                .addOpcion(new Opcion("3", "Javascript"))
                .addOpcion(new Opcion("4", "Typescript").setSelected()) //El setSelected() puede ponerse en cualquiera de las opciones, para que quede marcada esa opcion
                .addOpcion(new Opcion("5", "Php"));


        ElementoForm saludar = new ElementoForm("saludo") { //Creamos una clase anonima, se puede usar solo una vez y no es reutilizable
            @Override
            public String dibujarHtml() {
                return "<input disabled name = '" + this.nombre + "' value = \"" + this.valor + "\">";
                //Esto será utilizado una sola vez
            }
        };


        //Asignamos los valores
        saludar.setValor("Hola, que tal, esto es un campo deshabilitado");
        username.setValor("alex");
        password.setValor("1234");
        email.setValor("alex@alex.com");
        edad.setValor("34");

        experiencia.setValor("... unos meses de experiencia ...");
        //java.setSelected(true); //Asignamos que java es el elemento seleccionado

    /* Esta es una forma de hacer la lista
        List<ElementoForm> elementos = new ArrayList<>(); //Creamos una lista para poder agregar los elementos de username, password, etc
        elementos.add(username); //Agregamos username con .add()
        elementos.add(password);
        elementos.add(email);
        elementos.add(edad);
        elementos.add(experiencia);
        elementos.add(lenguaje);
*/

        List<ElementoForm> elementos = Arrays.asList(username,  //Arrays.asList retorna una lista, solo colocamos los elementos en los parametros
                password,
                email,
                edad,
                experiencia,
                lenguaje,
                saludar);
/*
        for (ElementoForm e: elementos){
            System.out.println(e.dibujarHtml());
            System.out.println("<br>");
        }
*/
        elementos.forEach(e -> { //Esta es otra forma de iterar, con el api stream (o algo asi) de java
            System.out.println(e.dibujarHtml());
            System.out.println("<br>");
        });

        elementos.forEach(e -> { //Recorremos los elementos de la Lista con un foreach
            if(!e.esValido()){ //Validamos cada elemento, si es distinto de valido
                e.getErrores().forEach(err -> { //Si falla la validacion, recorremos la lista de errores //Mostramos la lista de errores
                    System.out.println(e.getNombre() + ": " + err); //e.getNombre() esto nos muestra que campo es el que da el error
//               e.getErrores().forEach(System.out::println); //Metodo referenciado en una expresión lambda System.out::println
                });
            }
        }) ;

    }

}