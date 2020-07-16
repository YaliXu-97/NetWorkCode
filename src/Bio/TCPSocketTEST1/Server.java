package Bio.TCPSocketTEST1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        final int DEFALUT_PORT=8888;
        ServerSocket serverSocket=null;
        try {
            serverSocket=new ServerSocket(DEFALUT_PORT);
            System.out.println("启动服务器端口["+DEFALUT_PORT+"]");
           // while (true){
                //服务器等待客户端连接
                Socket socket=serverSocket.accept();
                InputStream inputStream=socket.getInputStream();
                byte bytes[]=new byte[1024];
               int len=inputStream.read(bytes);
                System.out.println("客户端["+socket.getPort()+"]发来的数据"+(new String(bytes,0,len)));
                OutputStream outputStream=socket.getOutputStream();
                outputStream.write("收到谢谢".getBytes());
          //  }
            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
