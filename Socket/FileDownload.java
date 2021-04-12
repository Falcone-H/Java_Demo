import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FileDownload {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        Socket socket = server.accept();
        InputStream inputStream = socket.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Devour\\Desktop\\upload\\1.jpg");
        byte[] bytes = new byte[1024];
        int len = 0;
        while((len = inputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
            fileOutputStream.write(bytes, 0, len);
        }
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("Upload successfully!".getBytes());
        server.close();
        inputStream.close();
        outputStream.close();
    }
}
