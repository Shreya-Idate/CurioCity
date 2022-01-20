package home;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PrtTableController implements Initializable {
    private double x=0,y=0;

    @FXML
    private AnchorPane anchorPane;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TableView myTable;
    @FXML
    private TableColumn<PrtTable, String > add;

    @FXML
    private TableColumn<PrtTable, String > an;

    @FXML
    private TableColumn<PrtTable, String > contact;

    @FXML
    private TableColumn<PrtTable, String > name;

    @FXML
    private TableColumn<PrtTable, String > sb;
    @FXML
    private TableColumn<PrtTable, String> sk;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TableColumn an = new TableColumn("AN");
        TableColumn name = new TableColumn("Name");
        TableColumn contact = new TableColumn("Contact");
        TableColumn add = new TableColumn("Address");
        TableColumn sb = new TableColumn("SbNo");
        TableColumn sk = new TableColumn("Skills");
        myTable.getColumns().addAll(an,name,contact,add,sb,sk);

        ObservableList<PrtTable> data = null;
        try {
            data = JavaPgSql.readPrt();
        } catch (SQLException e) {
            e.printStackTrace();
        }
                /*= FXCollections.observableArrayList(
                new ModelTable("1203051","Shreya","1213827113","Nerul","3"),
                new ModelTable("1203052","Shreya","1213827113","Nerul","3"),
                new ModelTable("1203053","Shreya","1213827113","Nerul","3"),
                new ModelTable("1203054","Shreya","1213827113","Nerul","3"));*/

        an.setCellValueFactory(new PropertyValueFactory<PrtTable,String>("AN"));
        name.setCellValueFactory(new PropertyValueFactory<PrtTable,String>("Name"));
        contact.setCellValueFactory(new PropertyValueFactory<PrtTable,String>("Contact_no"));
        add.setCellValueFactory(new PropertyValueFactory<PrtTable,String>("address"));
        sb.setCellValueFactory(new PropertyValueFactory<PrtTable,String>("sbNo"));
        sk.setCellValueFactory(new PropertyValueFactory<PrtTable,String>("skills"));
        myTable.setItems(data);
    }

    @FXML
    private TextField AN,Name,Contact_no,address,sbNo,skills;
    @FXML
    private Label check = new Label("");

    public void switchToPartTimers(ActionEvent event) throws IOException, SQLException {
        Parent root = FXMLLoader.load(getClass().getResource("PartTimers.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                x = event.getSceneX();
                y = event.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() - x);
                stage.setY(event.getScreenY() - y);
            }
        });
        stage.show();
    }

    public void switchToHome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                x = event.getSceneX();
                y = event.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() - x);
                stage.setY(event.getScreenY() - y);
            }
        });
        stage.show();
    }
    public void switchToTouristSpots(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("TouristSpots.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                x = event.getSceneX();
                y = event.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() - x);
                stage.setY(event.getScreenY() - y);
            }
        });
        stage.show();
    }
    public void switchToSmallBusinesses(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SmallBusinesses.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                x = event.getSceneX();
                y = event.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() - x);
                stage.setY(event.getScreenY() - y);
            }
        });
        stage.show();
    }
    public void close(ActionEvent event) {
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        stage.close();
    }
    public void maximize(ActionEvent event){
        //stage = (Stage)anchorPane.getScene().getWindow();
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        if(stage.isMaximized())
            stage.setMaximized(false);
        else
            stage.setMaximized(true);
    }
    public void minimize(ActionEvent event){
        Stage stage; //= (Stage) anchorPane.getScene().getWindow();
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

}
