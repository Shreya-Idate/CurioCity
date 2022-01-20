package home;

import javafx.application.Preloader;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MyPreloader extends Preloader{
    private Stage preloaderStage;
    private Scene scene;
    @FXML
    private Label progress=new Label("Loading ");
    public MyPreloader(){

    }
    public void init() throws Exception{
        Parent root1 = FXMLLoader.load(getClass().getResource("SplashScreen.fxml"));
        scene=new Scene(root1);
    }
    public void start(Stage primaryStage) throws Exception{
        this.preloaderStage=primaryStage;
        preloaderStage.setScene(scene);
        preloaderStage.initStyle(StageStyle.UNDECORATED);
        preloaderStage.show();
    }
    public void handleApplicationNotification(Preloader.PreloaderNotification info){
        if(info instanceof Preloader.ProgressNotification){
            PreloaderController.label.setText("Loading "+((Preloader.ProgressNotification) info).getProgress()+"%");
        }
    }
    public void handleStageChangeNotification(Preloader.StateChangeNotification info){
        Preloader.StateChangeNotification.Type type=info.getType();
        switch(type){
            case BEFORE_START :
                System.out.println("BEFORE_START");
                preloaderStage.hide();
                break;
        }
    }
}
