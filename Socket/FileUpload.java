import java.io.*;
import java.net.Socket;

/*
文件上传案例的客户端：读取本地文件，上传到服务器，读取服务器回写的数据

数据源：C:\Users\Devour\Pictures\360截图\1.jpg
目的地：服务器

实现步骤：
客户端：
1、创建一个本地字节输入流FileInputStream对象，构造方法中绑定要读取的数据
2、创建一个客户端对象。构造方法中绑定服务器的地址和端口号
3、使用Socket中的getOutputStream，获取网络字节输出流OutputStream对象
4、使用本地字节输入流FileInputStream对象中的read()，读取本地文件
5、使用网络字节输出流OutputStream对象中的write()，上传文件到服务器

服务器端：
6、使用accept()，获取Socket对象和客户端
7、使用Socket中的方法getInputStream，获取网络字节输入流对象
8、使用InputStream对象中的read()，读取客户端发送的数据
9、使用Socket中的方法getOutputStream，获取网络字节输出流对象
10、使用OutputStream的write()，向客户端发送响应

客户端：
11、使用Socket的getInputStream，获取输入流对象
12、使用InputStream对象的read()，读取服务器返回的消息

13、释放资源
 */
public class FileUpload {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Devour\\Pictures\\360截图\\1.jpg");
        Socket socket = new Socket("127.0.0.1", 8080);
        OutputStream outputStream = socket.getOutputStream();
        byte[] bytes = new byte[1024];
        int len = 0;
        while((len = fileInputStream.read(bytes)) != -1){
            outputStream.write(bytes, 0, len);
        }
        // 客户端会读取到-1，然后停止，但不会把-1传到服务器端，因此，服务器端进入阻塞状态，不会停止
        // 解决方法：上传完文件，给服务器发送一个结束标志
        //  shutdownOutput() 禁用此套接字的输出流
        // 对于TCP套接字，任何以前写入的数据都将被发送，并且后跟TCP的正常连接终止序列
        socket.shutdownOutput();
        InputStream inputStream = socket.getInputStream();
        while((len = inputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }
        fileInputStream.close();
        inputStream.close();
        outputStream.close();
        socket.close();
    }
}
