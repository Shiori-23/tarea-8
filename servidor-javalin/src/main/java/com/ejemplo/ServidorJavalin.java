package com.ejemplo;

import io.javalin.Javalin;

public class ServidorJavalin {
    public static void main(String[] args) {
        Javalin app = Javalin.create().start(8000);

        app.get("/saludo/{nombre}", ctx -> {
            String nombre = ctx.pathParam("nombre");
            ctx.result("¡Hola, " + nombre + "!");
        });

        app.post("/usuario", ctx -> {
            String nombre = ctx.bodyAsClass(Usuario.class).getNombre();
            int edad = ctx.bodyAsClass(Usuario.class).getEdad();
            ctx.result("¡Hola, " + nombre + "! Tienes " + edad + " años.");
        });
    }

    public static class Usuario {
        private String nombre;
        private int edad;

        public String getNombre() { return nombre; }
        public int getEdad() { return edad; }
        
    }
}