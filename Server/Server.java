package Home;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Server {
    private static final int SERVER_PORT = 8282;

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            System.out.println("Сервер запущен, ожидает подключения...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Соединение установлено, можете отправлять сообщения");

            Scanner inClient = new Scanner(clientSocket.getInputStream());
            PrintWriter outClient = new PrintWriter(clientSocket.getOutputStream(), true);
            Scanner scannerClient = new Scanner(System.in);

            Thread thread = new Thread(() -> {
                while (true) {
                    String messageServer = scannerClient.nextLine();
                    outClient.println(messageServer);
                }
            });
            thread.start();

            try {
                while (true) {
                    String messageClient = inClient.nextLine();
                    if (messageClient.equals("/end")) {
                        break;
                    }
                    System.out.println("Клиент: " + messageClient);
                }

                System.out.println("Сервер остановлен");
            } catch (Exception e) {
                clientSocket.close();
                System.out.println("Клиент отключился");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
