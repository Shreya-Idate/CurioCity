package home;


import com.sun.javafx.application.LauncherImpl;
import javafx.application.Application;
import javafx.application.Preloader;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {
    private double x=0,y=0;
   // private static final int COUNT_LIMIT=500000;
   // private static LauncherImpl LI;

    @Override
    public void start(Stage stage) throws IOException {

       // stage.setFullScreen(true);
        stage.setMaxWidth(1280);
        stage.setMaxHeight(720);
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        stage.setScene(new Scene(root));
        //set stage borderless
        stage.initStyle(StageStyle.UNDECORATED);

        //drag it here
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

    /*@Override
    public void init() throws Exception {
        for(int i=0; i<COUNT_LIMIT; i++){
            double progress = (100*i)/COUNT_LIMIT;
            LauncherImpl.notifyPreloader(this, new Preloader.ProgressNotification(progress));
        }
    }*/

    public static void main(String[] args) {
        //LI.launchApplication(Main.class,MyPreloader.class, args);
        //com.sun.javafx.application.LauncherImpl.launchApplication(Main.class,MyPreloader.class, args);
        launch();
    }
}