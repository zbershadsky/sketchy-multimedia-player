package com.paziy.sketchy.controllers;

import com.paziy.sketchy.audio.controllers.AudioPlayerController;
import com.paziy.sketchy.authentication.model.Authenticator;
import com.paziy.sketchy.authentication.view.LoginWindow;
import com.paziy.sketchy.player.fx.MainWindowController;
import com.paziy.sketchy.player.fx.View;
import com.paziy.sketchy.request.controllers.VKUrlManager;
import com.paziy.sketchy.video.controllers.VideoPlayerController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class ApplicationController extends Application {
	private static ApplicationController instance;
    private AudioPlayerController audioController;
    private VideoPlayerController videoController;
	
	public ApplicationController() {
	}

    @Override
    public void start(Stage stage) throws Exception {
        ApplicationController.getInstance().run(stage);
    }

    public static ApplicationController getInstance() {
		if (instance == null) {
			instance = new ApplicationController();
		}
		
		return instance;
	}
	
	public void run(Stage stage) throws IOException {
		Authenticator auth = new LoginWindow();

        VKUrlManager manager = new VKUrlManager(auth.login());
        audioController = new AudioPlayerController(manager);
        videoController = new VideoPlayerController(manager);
        URL location = View.class.getResource("MainWindow.fxml");

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(location);
        Pane pane = (Pane) fxmlLoader.load();
        MainWindowController controller = (MainWindowController)fxmlLoader.getController();
        controller.setAudioPlayerController(audioController);
        controller.setVideoPlayerController(videoController);
        controller.setAudioRecords();
        Scene scene = new Scene(pane);

        stage.setScene(scene);
        stage.show();
    }
	
	public static void main(String[] args) {
		launch(args);
	}
}
