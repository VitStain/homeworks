package Home;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private static final String DEFAULT_SERVER_HOST = "localhost";
    private static final int DEFAULT_SERVER_SOCKET = 8282;


    public static void main(String[] args) {

        Socket socket = null;

        try {
            socket = new Socket(DEFAULT_SERVER_HOST, DEFAULT_SERVER_SOCKET);
            System.out.println("Клиент активирован, можете отправлять сообщения..");

            Scanner inServer = new Scanner(socket.getInputStream());
            PrintWriter outServer = new PrintWriter(socket.getOutputStream(), true);
            Scanner scannerServer = new Scanner(System.in);

            Thread thread = new Thread(() -> {
                try {
                    while (true) {
                        String messageServer = inServer.nextLine();
                        System.out.println("Сервер: " + messageServer);
                    }
                } catch (Exception e) {
                    System.out.println("Ошибка подключения");
                }
            });
            thread.start();

            while (true) {
                String messageClient = scannerServer.nextLine();
                outServer.println(messageClient);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}