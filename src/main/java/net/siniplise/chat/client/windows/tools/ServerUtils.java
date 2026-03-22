package net.siniplise.chat.client.windows.tools;

import org.tinylog.Logger;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ServerUtils {
    private static String SERVER_IP;
    private static int SERVER_PORT;
    private static String USER;

    public ServerUtils(String user, String ip, int port) {
        SERVER_IP = ip;
        SERVER_PORT = port;
        USER = user;
    }

    public String getServerIP() {
        return SERVER_IP;
    }
    public int getServerPort() {
        return SERVER_PORT;
    }
    public String getUser() {
        return USER;
    }

    public void start_lisen() {
        try (
                Socket socket = new Socket(SERVER_IP, SERVER_PORT);
                DataInputStream inputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                DataOutputStream outputStream = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                Scanner scanner = new Scanner(System.in))
        {
            Logger.info("Connecting to " + SERVER_IP + ":" + SERVER_PORT);
            Thread receive_thread = new Thread(() -> {
                try {

                }
            })

        } catch (Exception e) {
            Logger.error("ps" );
        }
    }
}
