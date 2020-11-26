package ru.job4j.chatbot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatBot {

    public static void main(String[] args) throws Exception {
        try (ServerSocket server = new ServerSocket(9000)) {
            boolean close = true;
            while (close) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    String answer = "";
                    String exit = "Exit";
                    String hello = "Hello";
                    str = in.readLine();
                    while (!(str.isEmpty())) {
                        str = in.readLine();
                        System.out.println(str);
                        if (str.indexOf("msg=") > 0) {
                            answer = str.split("msg=")[1];
                            answer = answer.split("HTTP/1.1")[0];
                            if (answer.contains(hello)) {
                                answer = hello;
                            } else {
                                if (answer.contains(exit)) {
                                    answer = exit;
                                    close = false;
                                }
                            }
                        }
                    }
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    out.write(answer.getBytes());

                }
            }
        }
    }
}
