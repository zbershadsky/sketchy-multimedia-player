package com.paziy.sketchy.player.view.content.audio;

import com.paziy.sketchy.player.view.AlphaList;
import com.paziy.sketchy.player.view.ContentCategory;
import com.paziy.sketchy.player.view.Multimedia;
import com.paziy.sketchy.player.view.content.Content;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Node;
import javafx.scene.control.Label;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Slayer
 * Date: 15.11.12
 * Time: 12:17
 * To change this template use File | Settings | File Templates.
 */
public class AudioContent extends Content {
    private static List<ContentCategory> categories = Arrays.asList(new ContentCategory("All"),
            new ContentCategory("Albums"),
            new ContentCategory("From page"),
            new ContentCategory("Favourites"));
    private Label wallPaper;

    @Override
    protected ObjectProperty<Node> createView() {
        //TODO add the way to set background image
        wallPaper = new Label("");
        return new SimpleObjectProperty<Node>(wallPaper);
    }

    @Override
    protected ObjectProperty<AlphaList<Multimedia>> createLeftList() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected ObjectProperty<AlphaList<Multimedia>> createRightList() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected ContentCategory initContentCategory() {
        return categories.get(0);
    }

    @Override
    public List<ContentCategory> getContentCategories() {
        return categories;
    }

    @Override
    public void play() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void pause() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void stop() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void like() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void next() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void prev() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
