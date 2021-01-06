package Connection_for_ClientServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Connection_ClientServer implements Closeable {
    private  final Socket socket;
    private  final BufferedReader reader;
    private  final BufferedWriter writer;
    public Connection_ClientServer(String ip, int port) throws IOException {
        socket=new Socket(ip,port);
        this.writer=createBufferedWriter();
        this.reader=createBufferedReader();

    }
    public Connection_ClientServer(ServerSocket serverSocket) throws IOException {
        socket=serverSocket.accept();
        this.writer=createBufferedWriter();
        this.reader=createBufferedReader();
    }
private  BufferedWriter createBufferedWriter() throws IOException {

           return new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

}
    private  BufferedReader createBufferedReader() throws IOException {
            return new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }


    public void writeLine(String mes){
        try {
            writer.write(mes);
            writer.newLine();
            writer.flush();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public String readLine() throws IOException {
            return reader.readLine();

    }

    @Override
    public void close() throws IOException {
        reader.close();
        writer.close();
        socket.close();
    }
}


