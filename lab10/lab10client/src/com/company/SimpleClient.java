package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SimpleClient {
    public static void main (String[] args) throws IOException {
        String serverAddress = "127.0.0.1"; // The server's IP address
        int PORT = 8100; // The server's port
        try (
                Socket socket = new Socket(serverAddress, PORT);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader (new InputStreamReader(socket.getInputStream())) ) {
            // Send a request to the server
            //String request = "World";
            //out.println(request);

            Scanner scanner = new Scanner(System.in);

            while(true){
            System.out.println("Choose from:\n \t-register name\n \t-login name\n \t-friend name1 name2 ...\n \t-send message\n \t-read\n \t-exit\n \t-stop\n");
            String request = scanner.nextLine();

            List<String> params = new ArrayList<>();

            StringTokenizer defaultTokenizer = new StringTokenizer(request);
            String command = defaultTokenizer.nextToken();

            while (defaultTokenizer.hasMoreTokens())
            {
                params.add(defaultTokenizer.nextToken());
            }

            if(command.equals("exit")){ //or request.equals("exit")
                System.out.println("Goodbyeee!");
                break;
            }
            if(command.equals("register") || command.equals("login") || command.equals("friend") || command.equals("send") || command.equals("read") || command.equals("stop")){
            out.println(command);
            // Wait the response from the server ("Hello World!")
            String response = in.readLine ();
            System.out.println(response);}else{
                System.out.println("Try again a different command!");
                }
            }
        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        }
    }
}