/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paziy.sketchy.player.view;

/**
 *
 * @author Slayer
 */
public class ContentCategory {
    private String name;

    public ContentCategory(String name) {
        this.name = name;
    }

    public ContentCategory(ContentCategory category) {
        this.name = category.name;
    }

    public String getName() {
        return name;
    }
}
