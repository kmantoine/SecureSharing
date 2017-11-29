/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SecureShareServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

//import java.util.concurrent.atomic.AtomicInteger;
/**
 *
 * @author Akane D. Simpson
 */
public class ServerThread extends Thread {

    Socket client = new Socket();
    PrintWriter output;
    BufferedReader input;

    public ServerThread(Socket client) {
        this.client = client;
    }

    public void StartStream() {
        System.out.println("Starting stream.....");

        try {
            output = new PrintWriter(client.getOutputStream(), true);
            input = new BufferedReader(new InputStreamReader(client.getInputStream()));
            System.out.print("Reader and writer created. ");

//            String inString;
//
//            while ((inString = input.readLine()) == null) {
//                System.out.println();
//            }

        } catch (IOException ex) {
            Logger.getLogger (ServerThread.class.getName()).log (Level.SEVERE, "Server thread error", ex);
        } finally {
            try {
                client.close();
            } catch (IOException ex) {
                Logger.getLogger (ServerThread.class.getName()).log (Level.SEVERE, "null", ex);
            }
        }
    }
}
