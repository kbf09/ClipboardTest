package sample;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by kbf on 2014/07/11.
 */
public class ServerThread extends Thread{

    @Override
    public void run() {
        int port; // ポート番号

        Socket echoSocket = null;
        BufferedReader is = null;


        port = 12354;
            try {

                ServerSocket svsock = new ServerSocket(port);

                Socket sock = svsock.accept();
                OutputStream out = sock.getOutputStream();

                is = new BufferedReader(new InputStreamReader(sock.getInputStream()));

                System.out.println(is.readLine());
            } catch (Exception e) {
                e.printStackTrace();
            }


    }
}
