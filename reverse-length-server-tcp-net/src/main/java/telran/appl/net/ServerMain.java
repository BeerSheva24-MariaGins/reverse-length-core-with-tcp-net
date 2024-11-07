package telran.appl.net;

import telran.net.TcpServer;
import telran.net.*;


public class ServerMain {
    public static void main(String[] args) {
        Protocol protocol = new ReverseLengthProtocol();
        TcpServer server = new TcpServer(protocol, 8080);
        new Thread(server).start();
    }
}
