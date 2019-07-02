package com.examples;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketDemo {


    public static void main(String[] args)  throws  Exception {


        int port=55533;
        ServerSocket server = new ServerSocket(port);

        System.out.println("Server 将一致等待连接的到来");

        Socket socket=server.accept();


        InputStream   inStream=socket.getInputStream();

        byte[]  bytes=new byte[1024];

        int len;
        StringBuilder sb=new StringBuilder();

        while ((len=inStream.read(bytes))!=-1){
            sb.append(new String(bytes,0,len,"UTF-8"));
        }

        System.out.println("get message from client:"+sb);

        inStream.close();
        socket.close();
        server.close();

    }
}
