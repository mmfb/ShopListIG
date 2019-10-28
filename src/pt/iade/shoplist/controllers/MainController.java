package pt.iade.shoplist.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import pt.iade.shoplist.WindowManager;
import pt.iade.shoplist.models.Shoplist;
import pt.iade.shoplist.models.daos.ShoplistDAO;

/**
 * 
 * This class controls the window that presents a shop list.
 * 
 * <p> Shows all items in a shop list
 * 
 * @author Miguel
 */
public class MainController {
    @FXML
    private ListView<Shoplist> shopListLV;
    
    
    /**
     * xdgsdg
     */
    @FXML
    private void initialize() {
    	shopListLV.setItems(ShoplistDAO.getAllShoplists());
    	
    	shopListLV.getSelectionModel().
		selectedItemProperty().addListener(
			(obs,oldVal,newVal)-> {
				WindowManager.openItemsWindow();
			});
    }
    
}
