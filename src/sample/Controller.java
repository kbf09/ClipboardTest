package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Proxy;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML ScrollPane scrollPane;
    @FXML ListView listView;
    @FXML TextField ipAddress;
    @FXML
    javafx.scene.control.Label ipLabel;

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

        ServerThread st = new ServerThread();
        st.start();

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

        BufferedReader br;
        try {

            sock = new Socket(ipAddress.getText(), 12354);
            OutputStream out = sock.getOutputStream();

            br = new BufferedReader(new InputStreamReader(sock.getInputStream()));

            System.out.println(br.readLine());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
