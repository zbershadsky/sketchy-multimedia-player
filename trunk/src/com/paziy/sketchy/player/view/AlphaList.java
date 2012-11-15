package com.paziy.sketchy.player.view;

import java.util.LinkedList;
import java.util.List;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

/**
 * 
 * @author Slayer
 */
public abstract class AlphaList<Item extends Searcheable & Refreshable> extends ListView<Item> {
    protected ObjectProperty<Item> selectedObject;
    protected ObservableList<Item> items;
    
    public AlphaList() {
        super();
        
        selectedObject = new SimpleObjectProperty<Item>();
        selectedObject.addListener(new ChangeListener<Item>() {

            @Override
            public void changed(ObservableValue<? extends Item> ov, Item unSelectedItem, Item selectedItem) {
                if (unSelectedItem != null) {
                    unSelectedItem.refresh();
                }
                if (selectedItem != null) {
                    selectedItem.refresh();
                }
            }
            
        });
        
        this.setCellFactory(new Callback<ListView<Item>, ListCell<Item>>() {

            @Override
            public ListCell<Item> call(ListView<Item> p) {
                return create();
            }
        });
    }
    
    public void setBaseItems(ObservableList<Item> items) {
        this.items = items;
    }

    public void selectItem(Item item) {
        if (item != null) {
            //TODO add check, if items contains item
            selectedObject.set(item);
        }
    }
    
    public void deselect() {
        selectedObject.set(null);
    }
    
    public void search(String text) {
        List<Item> resultList = new LinkedList<Item>();
        
        //TODO add items dynamicaly
        if (items == null) {
            return;
        }
        
        for (Item item : items) {
            if (item.has(text)) {
                resultList.add(item);
            }
        }
        
        setItems(FXCollections.observableList(resultList));
    }
    
    public void cancelSearch() {
        setItems(items);
    }
    
    protected abstract ListCell<Item> create();
}
