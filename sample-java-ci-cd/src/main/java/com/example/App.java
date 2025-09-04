package com.example;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class App {
    public static void main(String[] args) throws IOException {
        int port = Integer.parseInt(System.getProperty("PORT", "8080"));
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/", exchange -> {
            String response = "{\"status\":\"ok\",\"app\":\"sample-java-ci-cd\"}";
            exchange.getResponseHeaders().add("Content-Type","application/json");
            exchange.sendResponseHeaders(200, response.getBytes().length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response.getBytes());
            }
        });
        server.start();
        System.out.println("Server started on port  " + port);
    }
}
