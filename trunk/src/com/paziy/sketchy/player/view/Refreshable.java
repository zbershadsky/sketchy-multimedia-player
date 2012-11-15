/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paziy.sketchy.player.view;

import javafx.beans.property.BooleanProperty;

/**
 * 
 * @author Slayer
 */
public interface Refreshable {
    BooleanProperty refreshProperty();  
    void refresh();
}
