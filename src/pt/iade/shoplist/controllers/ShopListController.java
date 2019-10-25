package pt.iade.shoplist.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

/**
 * 
 * This class controls the window that presents a shop list.
 * 
 * <p> Shows all items in a shop list
 * 
 * @author Miguel
 */
public class ShopListController {
    @FXML
    private ListView<String> shopListLV;
    
    private ObservableList<String> shopList =
    		FXCollections.observableArrayList();
    
    /**
     * xdgsdg
     */
    @FXML
    private void initialize() {
    	shopListLV.setItems(shopList);
    	shopList.add("Batata");
    	shopList.add("Cebola");
    	shopList.add("Pão");
    	
    }
    
}
