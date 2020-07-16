package Bio.TCPSocketTEST1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        final  int DEFALUT_PORT=8888;
        Socket socket=new Socket("127.0.0.1",DEFALUT_PORT);
        OutputStream outputStream=socket.getOutputStream();
        outputStream.write("你好，服务器".getBytes());

        InputStream inputStream=socket.getInputStream();
        byte bytes[]=new byte[1024];
        int len=inputStream.read(bytes);
        System.out.println("客户端["+socket.getPort()+"]收到服务器回信"+(new String(bytes,0,len)));
        socket.close();
    }
}
