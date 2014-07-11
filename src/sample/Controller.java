package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML ScrollPane scrollPane;
    @FXML ListView listView;
    @FXML TextField ipAddress;

    private Toolkit kit;
    private Clipboard clip;
    private ObservableList<String> listRecords;
    private Socket sock;




    @Override
    public void initialize(final URL location, final ResourceBundle resources ) {
        kit = Toolkit.getDefaultToolkit();
        clip = kit.getSystemClipboard();

        listRecords = FXCollections.observableArrayList();

        try {
            listRecords.add((String)clip.getData(DataFlavor.stringFlavor));
        } catch (Exception e) {
            e.printStackTrace();
        }

        listView.setItems(listRecords);

    }

    @FXML
    public void listReview() {
        try {
            listRecords.add((String)clip.getData(DataFlavor.stringFlavor));
        } catch (Exception e) {
            e.printStackTrace();
        }
        listView.setItems(listRecords);
    }

    @FXML
    public void startConnection() {
        int port; // ポート番号
        int timeout_msec = 10000; // accept() のタイムアウトは10秒にしてみる。

        port = 50000; // 例えばポート番号は 50000 番にする。

        try{
            // サーバソケットの作成
            ServerSocket svsock = new ServerSocket(port);
            svsock.setSoTimeout(timeout_msec);  // ※必要があるときのみ設定する。

            // クライアントからの接続を受け付ける。
            // ※クライアントからの接続がくるまでここでブロックする。

            Socket sock = svsock.accept();

            // クライアントと接続されたソケットを利用して処理を行う。

        } catch (Exception e) {
            // accept() タイムアウト時の処理をする。

        }
        ipAddress.getText();
    }


}
