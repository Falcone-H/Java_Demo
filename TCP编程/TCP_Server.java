package Demo2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCP_Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        Socket socket = server.accept();
        InputStream inputstream = socket.getInputStream();
        int len = 0;
        byte[] bytes = new byte[1024];
        // 输出客户端请求信息
//        while((len = inputstream.read(bytes)) != -1) {
//            System.out.println(new String(bytes, 0, len));
//        }
        // 把网络字节输入流转换为字符缓冲输入流
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputstream));
        // 把客户端请求信息的第一行读取出来
        String line = bufferedReader.readLine();
        // 把读取到的信息切割，只要中间的文件位置
        String[] arr = line.split(" ");
        // 去掉文件位置前的斜杠
        String path = arr[1].substring(1);

        // 构造一个本地字节输入流，构造方法中绑定要读取的html路径
        FileInputStream fileInputStream = new FileInputStream(path);
        // 使用Socket的getOutputStream()获取网络字节输出流OutputStream
        OutputStream outputStream = socket.getOutputStream();

        // 写入HTTP协议响应头
        outputStream.write("HTTP/1.1 200 OK\r\n".getBytes());
        outputStream.write("Content-Type:text/html\r\n".getBytes());
        // 必须写入空行，否则浏览器不解析
        outputStream.write("\r\n".getBytes());

        // 将服务器读取的html文件回写到客户端
        while((len = fileInputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, len);
        }

        fileInputStream.close();
        server.close();
        socket.close();
    }
}
