package telran.appl.net;
import java.net.*;

public class TcpServer implements Runnable {
    Protocol protocol;
    int port;

    public TcpServer(Protocol protocol, int port) {
         this.protocol = protocol; this.port = port; 
        }

@Override 
public void run() {
     try (ServerSocket serverSocket = new ServerSocket(port)) {
         System.out.println("Server is listening on the port " + port); 
         while (true) { Socket socket = serverSocket.accept(); 
            var session = new TcpClientServerSession(protocol, socket); 
            new Thread(session).start(); // Запуск сессии в новом потоке 
            } 
        } catch (Exception e) {
             System.out.println(e);
     }
     }
    }
