package com.paziy.sketchy.player.view;

import com.paziy.sketchy.player.view.content.Content;
import javafx.beans.property.ObjectProperty;
import javafx.collections.ObservableList;
import javafx.scene.layout.StackPane;

/**
 * Created with IntelliJ IDEA.
 * User: Slayer
 * Date: 15.11.12
 * Time: 11:01
 * To change this template use File | Settings | File Templates.
 */
public class Screen extends StackPane {
    private ObservableList<Content> contents;
    private ObjectProperty<Content> currentContent;
    private AlphaList<Multimedia> leftList;
    private AlphaList<Multimedia> rightList;
    private PlayPane playPane;

    public ObservableList<Content> getContents() {
        return contents;
    }

    public void setCurrentContent(Content content) {
        currentContent.set(content);
    }
}
