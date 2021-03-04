/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientbase;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pogliani.mattia
 */
public class ClientBase {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Apertua connessione");
        try {
            Socket server = new Socket("127.0.0.1", 5500);

            PrintWriter out = new PrintWriter(server.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
            Scanner tastiera = new Scanner(System.in);
            String s = "";
                
                System.out.println("Inserire il numero da inviare al server:");
                s = tastiera.nextLine();
                System.out.println("numero inserito: " + s);
                out.println(s);
                
                in.close();
                server.close();
                System.out.println("chiusura connessione");
                
        } catch (IOException ex) {
            Logger.getLogger(ClientBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}