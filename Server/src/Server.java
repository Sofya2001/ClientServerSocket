import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String args[]) {
        try (ServerSocket server = new ServerSocket(8081)) {
            System.out.println("Server stated...");
            while (true)
                try (Socket client = server.accept();
                     BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
                     BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()))) {
                    String request = reader.readLine();
                    System.out.println(request);
                    writer.write("Answer for client " + request);
                    writer.flush();
                    writer.newLine();
                } catch (NullPointerException e) {
                    e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
