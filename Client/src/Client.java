import Connection_for_ClientServer.Connection_ClientServer;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String args[]) {
        Scanner scanner =new Scanner(System.in);
            try (Connection_ClientServer con = new Connection_ClientServer("127.0.0.1", 8081)) {
                while (true) {
                    con.writeLine(scanner.nextLine());
                    String answer = con.readLine();
                    System.out.println(answer);
                }
            } catch (IOException e) {
            }

    }
}
     //   try(
       // Socket client = new Socket("127.0.0.1",8081);
       // BufferedWriter writer =new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
       // BufferedReader reader =new BufferedReader((new InputStreamReader(client.getInputStream()))))
       // {
         //   System.out.println("Connected");
          //  Scanner scanner=new Scanner(System.in);
           // String request=scanner.nextLine();
            //writer.write(request);
           // writer.newLine();
          //  writer.flush();

          //  String answer_server= reader.readLine();
          //  System.out.println(answer_server);
         //   }

       // catch (IOException e ){
        //    e.printStackTrace();
       // }



  //  }
//}
