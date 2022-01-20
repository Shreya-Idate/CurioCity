package home;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Controller extends StackPane {
    private double x=0,y=0;
    @FXML
    private AnchorPane anchorPane;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button Loginbtn;

    @FXML
    private Button Registerbtn;


    @FXML
    void switchToRegister(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Register.fxml"));
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

    @FXML
    void switchToLogin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("temp.fxml"));
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

    @FXML
    private TextField AdhaarNo,Name,contact,dob;

    @FXML
    private TextField password;

    @FXML
    private Button registerButton;
    @FXML
    private Label validity=new Label("");

    @FXML
    private Label promptRegister=new Label("");
    private Label check=new Label("");

    @FXML
    void getData(ActionEvent event) {
        int flag=1;
        System.out.println((String) AdhaarNo.getText());
        System.out.println((String) Name.getText());
        System.out.println((String) contact.getText());
        System.out.println((String) dob.getText());
        System.out.println((String) password.getText());
        while(flag!=0){
            if(dob.getText().charAt(2)!='/' ||dob.getText().charAt(5)!='/'){
                check.setText("Invalid DOB format. Re-enter correct DOB.");
                flag++;
            }
            else if(password.getText().length()<4) {
                check.setText("Invalid password format. Should be at least 4 characters long. " +
                        "Re-enter correct DOB.");
                flag++;
            }
            else{
                JavaPgSql.writeToDatabase(AdhaarNo.getText(),Name.getText(),contact.getText(),
                        dob.getText(),password.getText());
                promptRegister.setText("Successfully Registered. Proceed to Login.");
                flag=0;
            }
        }
    }//writing data to pgsql


    public void Login(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("temp.fxml"));
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
        checkLogin(event);
    }
    @FXML
    void checkLogin(ActionEvent event) throws IOException {
        int flag = JavaPgSql.readLoginDatabase(AdhaarNo.getText(),password.getText());
        if(flag==1){
            switchToHome(event);
        }
        else{
            validity.setText("INVALID LOGIN!");
        }
    }//to check login info from pgsql

    @FXML
    private ScrollPane achievements;

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

    @FXML
    private Label TSAddress;

    @FXML
    private Label TSName;

    @FXML
    private Label TSdescription;



    @FXML
    void showCentralPark(ActionEvent event) {
        TSName.setText("Central Park");
        TSdescription.setText("This park beats all other parks in the vicinity of Navi Mumbai.Here, you can enjoy various swings and slides.");
        TSAddress.setText("Sectors 22, 23 & 24, Kharghar, Navi Mumbai");
    }

    @FXML
    void showJwelsNM(ActionEvent event) {
        TSName.setText("Jewel of Navi Mumbai");
        TSdescription.setText("The picture perfect place having a very impressive jogging trail");
        TSAddress.setText("Sector 26, Nerul, Navi Mumbai");
    }

    @FXML
    void showPandavkada(ActionEvent event) {
        TSName.setText("Pandavkada Falls");
        TSdescription.setText("This waterfall is the most alluring place to visit");
        TSAddress.setText("Kharghar, Navi Mumbai");
    }

    @FXML
    void showRockGarden(ActionEvent event) {
        TSName.setText("Rock Garden");
        TSdescription.setText("The toy train is the major attraction of this garden.It has two grounds with large statues.");
        TSAddress.setText("Sector 21, Nerul, Navi Mumbai");
    }

    @FXML
    void showWondersPark(ActionEvent event) {
        TSName.setText("Wonders Park");
        TSdescription.setText("One can spot mini replicas of seven wonders and, well-equipped playing arena for children.");
        TSAddress.setText("Sector 19A, Nerul, Navi Mumbai");
    }

    public void switchToSmallBusinesses(ActionEvent event) throws IOException,SQLException {
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
    public void backMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
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
    public void minimize(ActionEvent event){
        Stage stage; //= (Stage) anchorPane.getScene().getWindow();
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }
    public void maximize(ActionEvent event){
        //stage = (Stage)anchorPane.getScene().getWindow();
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        if(stage.isMaximized())
            stage.setMaximized(false);
        else
            stage.setMaximized(true);
    }

}