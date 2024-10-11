package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            System.out.println("Server avviato");

        ServerSocket server = new ServerSocket(3000);
        Socket s = server.accept();

        System.out.println("Client collegato");

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());

        String stringaRicevuta = in.readLine();
        System.out.println("Stringa ricevuta: " + stringaRicevuta);

        String stringaMaiuscola = stringaRicevuta.toUpperCase();
        out.writeBytes(stringaMaiuscola + '\n');    

        s.close();
        server.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}