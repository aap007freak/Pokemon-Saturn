package com.antonleagre.pokemonsaturn.dataviewer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/main.fxml")); // YOU HAVE TO HAVE THIS BACKSLASH OR ELSE IT DOESNT WORK WHO IS THE DEVIL THAT MADE THIS WHOAAAAA


        Scene scene = new Scene(root, 1000, 980);

        stage.setTitle("FXML Welcome");
        stage.setScene(scene);
        stage.show();
    }

}
