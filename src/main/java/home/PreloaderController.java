package home;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class PreloaderController implements Initializable {
    @FXML
    private Label progress;

    public static Label label;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        label=progress;
    }
}
