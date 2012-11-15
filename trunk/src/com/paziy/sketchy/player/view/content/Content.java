/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paziy.sketchy.player.view.content;

import java.util.LinkedList;
import java.util.List;

import com.paziy.sketchy.player.view.AlphaList;
import com.paziy.sketchy.player.view.ContentCategory;
import com.paziy.sketchy.player.view.Multimedia;
import com.paziy.sketchy.player.view.PlayingDirection;
import javafx.beans.property.ObjectProperty;
import javafx.scene.Node;

/**
 *
 * @author Slayer
 */
public abstract class Content {
    protected List<Multimedia> content;
    protected ObjectProperty<AlphaList<Multimedia>> leftList;
    protected ObjectProperty<AlphaList<Multimedia>> rightList;
    protected PlayingDirection direction;
    protected ObjectProperty<Node> view;
    protected ContentCategory contentCategory;

    protected Content() {
        content = new LinkedList<Multimedia>();
        view = createView();
        leftList = createLeftList();
        rightList = createRightList();
        contentCategory = initContentCategory();
    }

    protected abstract ObjectProperty<Node> createView();
    protected abstract ObjectProperty<AlphaList<Multimedia>> createLeftList();
    protected abstract ObjectProperty<AlphaList<Multimedia>> createRightList();
    protected abstract ContentCategory initContentCategory();

    public abstract List<ContentCategory> getContentCategories();

    public void setContentCategory(ContentCategory contentCategory) {
        //TODO may cause problems, when user selects friends on right list
        if (!contentCategory.getName().equals(contentCategory.getName())) {
            this.contentCategory = new ContentCategory(contentCategory);
        }
    }
    
    public abstract void play();
    public abstract void pause();
    public abstract void stop();
    public abstract void like();
    public abstract void next();
    public abstract void prev();
    
    public void setPlayingDirection(PlayingDirection direction) {
        this.direction = direction;
    }
    
    public PlayingDirection getPlayingDirection() {
        return direction;
    }

    public ObjectProperty<AlphaList<Multimedia>> leftListProperty() {
        return leftList;
    }

    public ObjectProperty<AlphaList<Multimedia>> rightListProperty() {
        return rightList;
    }

    public ObjectProperty<Node> viewProperty() {
        return view;
    }
}
