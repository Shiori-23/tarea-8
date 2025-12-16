package com.ejemplo;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URI;
import java.nio.charset.StandardCharsets;

public class ClientePostUsuario {
    public static void main(String[] args) throws Exception {
        URL url = new URI("http://localhost:8000/usuario").toURL();
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json; utf-8");
        con.setRequestProperty("Accept", "text/plain"); 
        con.setDoOutput(true); 

        String jsonInputString = "{\"nombre\": \"Buffy\", \"edad\": 30}";

        try(OutputStream os = con.getOutputStream()) {
            byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        try(java.io.InputStream is = con.getInputStream();
            java.io.BufferedReader reader = new java.io.BufferedReader(
                new java.io.InputStreamReader(is, StandardCharsets.UTF_8))) {
            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = reader.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println("Respuesta del servidor: " + response.toString());
        }

        con.disconnect();
    }
}