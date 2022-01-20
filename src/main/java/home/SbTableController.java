package home;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SbTableController implements Initializable {

    @FXML
    private AnchorPane anchorPane;
    private Stage stage;
    private Scene scene;
    private Parent root;
    //////////
    @FXML
    private TableView<SbTable> sbTable;
    @FXML
    private TableColumn<SbTable, String > Sb_no;

    @FXML
    private TableColumn<SbTable, String > SBName;

    @FXML
    private TableColumn<SbTable, String > Name;

    @FXML
    private TableColumn<SbTable, String > Contact_no;

    @FXML
    private TableColumn<SbTable, String > description;

    @FXML
    private Hyperlink SBurl;
    private java.awt.Desktop Desktop;

//    @FXML
  //  void openLink(ActionEvent event) throws URISyntaxException,IOException {
    //    Desktop.getDesktop().browse(new URI("https://www.w3.org/Provider/Style/dummy.html"));
    //}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TableColumn Sb_no = new TableColumn("Sb_no");
        TableColumn SBName = new TableColumn("Business Name");
        TableColumn Name = new TableColumn("Owner Name");
        TableColumn Contact_no = new TableColumn("Contact_no");
        TableColumn description = new TableColumn("Description");
        sbTable.getColumns().addAll(Sb_no,SBName,Name,Contact_no,description);

        ObservableList<SbTable> data = null;
        try {
            data = JavaPgSql.readSb();
        } catch (SQLException e) {
            e.printStackTrace();
        }
                /*= FXCollections.observableArrayList(
                new ModelTable("1203051","Shreya","1213827113","Nerul","3"),
                new ModelTable("1203052","Shreya","1213827113","Nerul","3"),
                new ModelTable("1203053","Shreya","1213827113","Nerul","3"),
                new ModelTable("1203054","Shreya","1213827113","Nerul","3"));*/
        //Sb_no,SBName,Name,Contact_no,description
        Sb_no.setCellValueFactory(new PropertyValueFactory<SbTable,String>("Sb_no"));
        SBName.setCellValueFactory(new PropertyValueFactory<SbTable,String>("SBName"));
        Name.setCellValueFactory(new PropertyValueFactory<SbTable,String>("Name"));
        Contact_no.setCellValueFactory(new PropertyValueFactory<SbTable,String>("Contact_no"));
        description.setCellValueFactory(new PropertyValueFactory<SbTable,String>("description"));
        sbTable.setItems(data);
    }
    //////////
    public void switchToHome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToPartTimers(ActionEvent event) throws IOException, SQLException {
        Parent root = FXMLLoader.load(getClass().getResource("PartTimers.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToTouristSpots(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("TouristSpots.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToSmallBusinesses(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SmallBusinesses.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
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
