import Connection_for_ClientServer.Connection_ClientServer;

import java.io.*;
import java.net.ServerSocket;
import java.util.Scanner;

public class Server {

    public static void main(String args[]) {
        Scanner scanner =new Scanner(System.in);
        try (ServerSocket server = new ServerSocket(8081)) {
            System.out.println("Server started...");
            Connection_ClientServer con = new Connection_ClientServer(server);
            while (true) {
                String request = con.readLine();
                System.out.println(request);
                con.writeLine(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
    //    try (ServerSocket server = new ServerSocket(8081)) {
   //         System.out.println("Server stated...");
     //       while (true)
      //          try (Socket client = server.accept();
       //              BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
      //               BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()))) {
     //               String request = reader.readLine();
      //              System.out.println(request);
      //              writer.write("Answer for client " + request);
      //              writer.flush();
      //              writer.newLine();
      //          } catch (NullPointerException e) {
     //               e.printStackTrace();
     //       }
    //    } catch (IOException e) {
      //      e.printStackTrace();
      //  }
   // }
//}
