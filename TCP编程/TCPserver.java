import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
TCP服务器端：接收客户端的请求，读取客户端发送的数据，给客户端回写数据
表示服务器的类：
    java.net.ServerSocket：此类表示服务器套接字
构造方法：
    ServerSocket(int port) 绑定到特定端口的服务器套接字
成员方法：
    服务器端必须知道是哪个客户端的请求，可以用accept()方法，获取到请求客户端的Socket对象
实现步骤：
    1、创建服务器ServerSocket对象和系统要指定的端口号
    2、使用accept()，获取到请求客户端的Socket对象
    3、使用getInputStream()获取网络字节输入流InputStream对象
    4、使用read()方法读取客户端发送的数据
    5、使用getOutputStream()获取网络字节输出流OutputStream对象
    6、使用write()方法，给客户端回写信息
    7、释放资源
 */
public class TCPserver {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        Socket socket = server.accept();
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = inputStream.read(bytes);
        System.out.println(new String(bytes, 0, len));
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("has received".getBytes());
        socket.close();
        server.close();
    }
}
