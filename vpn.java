
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

class VPNClient {
    public static void main(String[] args) {
        String serverHost = "127.0.0.1"; 
        int serverPort = 8080; 

        try {
           
            Socket socket = new Socket(serverHost, serverPort);
            System.out.println("Connected to VPN server.");

           
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            socket.close();
            System.out.println("Disconnected from VPN server.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class VPNServer {
    public static void main(String[] args) {
        int serverPort = 8080; 

        try {
          
            ServerSocket serverSocket = new ServerSocket(serverPort);
            System.out.println("VPN server started. Waiting for connections...");

            while (true) {
                
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                
                InputStream inputStream = clientSocket.getInputStream();
                OutputStream outputStream = clientSocket.getOutputStream();

                
                clientSocket.close();
                System.out.println("Client disconnected: " + clientSocket.getInetAddress());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
