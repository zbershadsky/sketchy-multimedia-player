/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paziy.sketchy.player.fx;

import java.io.IOException;
import java.net.URL;

import com.paziy.sketchy.audio.controllers.AudioPlayerController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Slayer
 */
public class View extends Application {

    private AudioPlayerController audioPlayerController;

    public View(AudioPlayerController audioPlayerController) {
        this.audioPlayerController = audioPlayerController;
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        URL location = View.class.getResource("MainWindow.fxml");

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(location);
        Pane pane = (Pane) fxmlLoader.load();
        MainWindowController controller = (MainWindowController)fxmlLoader.getController();
        controller.setController(audioPlayerController);

        Scene scene = new Scene(pane);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
