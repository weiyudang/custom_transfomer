package com.examples;

import java.io.OutputStream;
import java.net.Socket;

public class SocketClient {


    public static void main(String[] args)  throws  Exception {


        String host="127.0.0.1";
        int port=55533;

        Socket socket=new Socket(host,port);

        OutputStream  outStream=socket.getOutputStream();

        String message="你好 服务器";


        socket.getOutputStream().write(message.getBytes("UTF-8"));

        outStream.close();
        socket.close();


    }
}
