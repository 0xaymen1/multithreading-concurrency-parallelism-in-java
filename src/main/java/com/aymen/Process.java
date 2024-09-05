package com.aymen;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class Process {

    private static final Logger LOGGER = Logger.getLogger(Process.class.getName());

    public static void main(String[] args) {
        //BY default the MAIN THREAD is running....

        System.out.println("Starting server ....");

        var t1 = new Thread(() -> {
            try (var tcpListener = new ServerSocket(
                    6556,
                    0,
                    InetAddress.getByName("127.0.0.1"))) {

                System.out.println("Server is listening ......");
                Socket client = tcpListener.accept();
                System.out.println("connected: " + client);

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        t1.start();

        var t2 = new Thread(() -> {
            for (int i = 0; i < 4; i++) {
                System.out.println("i am here on second thread .....");
            }
        });
        t2.start();
        
    }
}