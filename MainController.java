package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    @FXML
    private TextField inputField;

    @FXML
    private TextArea textArea;

    @FXML
    public void initialize() {

    }

    @FXML
    public void addTextToChat() {
        String text = inputField.getText();

        if (!text.isEmpty()) {
            textArea.appendText(text + "\n");
        }
        inputField.setText("");
    }

    @FXML
    public void clearChat() {
        textArea.setText("");
    }

    @FXML
    public void exit() {
        System.exit(0);
    }

    @FXML
    public void openAboutWindow() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("About.fxml"));
        Stage stage = new Stage();
        stage.setTitle("About this web chat");
        stage.setScene(new Scene(root));
        stage.show();
    }

}
