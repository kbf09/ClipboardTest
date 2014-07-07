package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML ScrollPane scrollPane;
    @FXML ListView listView;

    private Toolkit kit;
    private Clipboard clip;
    private ObservableList<String> listRecords;
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


}
