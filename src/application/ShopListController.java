package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class ShopListController {
    @FXML
    private ListView<String> shopListLV;
    
    private ObservableList<String> shopList =
    		FXCollections.observableArrayList();
    
    @FXML
    private void initialize() {
    	shopListLV.setItems(shopList);
    	shopList.add("Batata");
    	shopList.add("Cebola");
    	shopList.add("Pão");
    	
    }
    
}
