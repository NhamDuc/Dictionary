package DictionaryApp.Controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StartController implements Initializable {
    private Button searchBtn, addBtn, transBtn, gameBtn, closeBtn;
    private AnchorPane container;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        searchBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showComponent("/UI/SearchUI.fxml");
            }
        });

        closeBtn.setOnMouseClicked(e -> {
            e.consume();
            System.exit(0);
        });
    }

    private void setNode(Node node) {
        container.getChildren().clear();
        container.getChildren().add(node);
    }

    private void showComponent(String path) {
        try {
            AnchorPane component = FXMLLoader.load(getClass().getResource(path));
            setNode(component);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
