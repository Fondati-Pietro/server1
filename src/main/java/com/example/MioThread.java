package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MioThread extends Thread{
    Socket s;
    MioThread(Socket s){
        this.s = s;
    }

    try {

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());          

        String stringaMaiuscola;
        do {
            
            String stringaRicevuta = in.readLine();
            System.out.println("Stringa ricevuta: " + stringaRicevuta);

            if(stringaRicevuta.equals("!")){
                    stringaMaiuscola = "STOP";
                    break;
                }
                System.out.println(stringaRicevuta);
                stringaMaiuscola = stringaRicevuta.toUpperCase();
                out.writeBytes(stringaMaiuscola + '\n'); 
                
            } while (stringaMaiuscola.equals("!"));

            s.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
}
