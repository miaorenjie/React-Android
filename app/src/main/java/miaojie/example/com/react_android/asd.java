package miaojie.example.com.react_android;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
//import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class asd {

    private static List<Socket> serverlist = new ArrayList<>();

    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(30000);
            System.out.println("等待客户端连接...");
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            Socket socket = null;
            try {
                socket = server.accept();
                System.out.println("连接成功");
                serverlist.add(socket);
                new Thread(new receiveCilent(socket, serverlist)).start();
                //想用内部类实现也说有问题，说在封闭范围内套接字必须是最终或者有效的最终
//	            new Thread(){
//	            	public void run() {
//	            		try {
//							OutputStream os = socket.getOutputStream();
//						} catch (IOException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//	            	}
//	            }.start();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 得到该客户端的输出流数据，输出至集合中各个客户端的输入流
     */
    static class receiveCilent implements Runnable {
        private List<Socket> serverlist = null;
        private Socket s;
        private InputStream os;

        public receiveCilent(Socket s, List<Socket> serverlist) {
            this.serverlist = serverlist;
            this.s = s;
            try {
                os = s.getInputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void run() {
            byte[] bt = new byte[1024 * 1024];
            try {
                int l = os.read(bt);
                String str = new String(bt, 0, l);
                for (Socket socket : serverlist) {
                    OutputStream os = socket.getOutputStream();
                    os.write(str.getBytes());
                    os.flush();
                    //把数据写入到每个客户端的输入流
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                try {
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}