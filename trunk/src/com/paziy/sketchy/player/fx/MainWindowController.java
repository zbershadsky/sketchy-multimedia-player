/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paziy.sketchy.player.fx;

import com.paziy.sketchy.audio.controllers.AudioPlayerController;
import com.paziy.sketchy.audio.model.Audio;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author Slayer
 */
public class MainWindowController implements Initializable {
    
    @FXML private ListView center;
    @FXML private ImageView avatar;
    @FXML private Label album;
    @FXML private Label song;
    @FXML private Button menuButton;
    @FXML private Button musicButton;
    @FXML private Button videosButton;
    @FXML private Button photosButton;
    @FXML private ImageView albumLogo;
    @FXML private Button play;
    @FXML private Button previous;
    @FXML private Button next;
    @FXML  private Button volume;
    @FXML private Slider timeSlider;
    @FXML private AnchorPane bottom;
    @FXML private Label playTime;
    @FXML private Slider volumeSlider;

    private List<Audio> records;
    private AudioPlayerController controller;
    private MediaPlayer mediaPlayer;
    private MediaView mediaView;
    private Duration duration;
    private BooleanProperty seeking;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        seeking = new SimpleBooleanProperty();
        this.records = new LinkedList<Audio>();
        center.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        center.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number1) {
                Audio audio = records.get(number1.intValue());

                album.setText(audio.getArtist());
                song.setText(audio.getTitle());
            }
        });
        center.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                    if (mouseEvent.getClickCount() == 2) {
                        playSelected();
                    }
                }
            }
        });

        center.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode() == KeyCode.ENTER) {
                    playSelected();
                }
            }
        });

        play.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                playSelected();
            }
        });

        volumeSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number1) {
                if (mediaPlayer == null) {
                    return;
                }

                mediaPlayer.setVolume(number1.doubleValue() / volumeSlider.getMax());
            }
        });

        timeSlider.valueProperty().addListener(new InvalidationListener() {
            public void invalidated(Observable ov) {
                if (timeSlider.isValueChanging()) {
                    // multiply duration by percentage calculated by slider position
                    if(duration!=null) {
                        mediaPlayer.seek(duration.multiply(timeSlider.getValue() / 100.0));
                    }
                    updateValues();
                }
                if (seeking.get()) {
                    if(duration!=null) {
                        mediaPlayer.seek(duration.multiply(timeSlider.getValue() / 100.0));
                    }
                    updateValues();
                }
            }
        });

    }

    private void playSelected() {
        int index = center.getSelectionModel().getSelectedIndex();

        Audio audio = records.get(index);
        duration = Duration.seconds(Double.parseDouble(audio.getDuration()));

        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }

        mediaPlayer = new MediaPlayer(new Media(audio.getUrl()));
        mediaPlayer.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                int index = center.getSelectionModel().getSelectedIndex();

                center.getSelectionModel().select((index + 1) % records.size());
                playSelected();
            }
        });
        mediaPlayer.currentTimeProperty().addListener(new ChangeListener<Duration>() {
            @Override
            public void changed(ObservableValue<? extends Duration> observableValue, Duration duration, Duration duration1) {
                seeking.set(false);
                updateValues();
            }
        });
        mediaView = new MediaView(mediaPlayer);
        mediaPlayer.setVolume(volumeSlider.getValue());
        mediaPlayer.play();
    }

    private void updateValues() {
        if (playTime != null && timeSlider != null && volumeSlider != null && duration != null) {
            Platform.runLater(new Runnable() {
                public void run() {
                    Duration currentTime = mediaPlayer.getCurrentTime();

                    playTime.setText(formatTime(currentTime, duration));
                    timeSlider.setDisable(duration.isUnknown());

                    if (!timeSlider.isDisabled() && duration.greaterThan(Duration.ZERO)
                            && !timeSlider.isValueChanging() && !seeking.get()) {
                        timeSlider.setValue(currentTime.divide(duration).toMillis() * 100.0);
                        seeking.set(true);
                    }
                    /*if (!volumeSlider.isValueChanging()) {
                        volumeSlider.setValue((int) Math.round(mediaPlayer.getVolume() * 100));
                    } */
                }
            });
        }
    }

    private String formatTime(Duration elapsed, Duration duration) {
        int intElapsed = (int)Math.floor(elapsed.toSeconds());
        int elapsedHours = intElapsed / (60 * 60);
        if (elapsedHours > 0) {
            intElapsed -= elapsedHours * 60 * 60;
        }
        int elapsedMinutes = intElapsed / 60;
        int elapsedSeconds = intElapsed - elapsedHours * 60 * 60 - elapsedMinutes * 60;

        if (duration.greaterThan(Duration.ZERO)) {
            int intDuration = (int)Math.floor(duration.toSeconds());
            int durationHours = intDuration / (60 * 60);
            if (durationHours > 0) {
                intDuration -= durationHours * 60 * 60;
            }
            int durationMinutes = intDuration / 60;
            int durationSeconds = intDuration - durationHours * 60 * 60 - durationMinutes * 60;

            if (durationHours > 0) {
                return String.format("%d:%02d:%02d/%d:%02d:%02d",
                        elapsedHours, elapsedMinutes, elapsedSeconds,
                        durationHours, durationMinutes, durationSeconds);
            } else {
                return String.format("%02d:%02d/%02d:%02d",
                        elapsedMinutes, elapsedSeconds,
                        durationMinutes, durationSeconds);
            }
        } else {
            if (elapsedHours > 0) {
                return String.format("%d:%02d:%02d",
                        elapsedHours, elapsedMinutes, elapsedSeconds);
            } else {
                return String.format("%02d:%02d",
                        elapsedMinutes, elapsedSeconds);
            }
        }
    }

    @FXML
    private void handleSelectCell(ListView.EditEvent editEvent) {
        center.getSelectionModel();
    }

    private void setRecords(List<Audio> records) {
        this.records.clear();
        this.records.addAll(records);

        center.getItems().clear();
        center.setItems(FXCollections.observableArrayList(this.records));
    }

    public void setRecords() {
        setRecords(controller.getAudios());
    }

    public void setController(AudioPlayerController controller) {
        this.controller = controller;
    }
}
