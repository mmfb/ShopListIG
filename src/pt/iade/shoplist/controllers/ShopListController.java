package pt.iade.shoplist.controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import pt.iade.shoplist.WindowManager;
import pt.iade.shoplist.models.Item;
import pt.iade.shoplist.models.Shoplist;

public class ShopListController {
    @FXML
    private Label titleL;

    @FXML
    private ListView<Item> itemsLV;

    private Shoplist shoplist;
    
    public ShopListController(Shoplist shoplist) {
    	this.shoplist = shoplist;
    }
    
    @FXML
    private void initialize() {
    	itemsLV.setItems(shoplist.getItems());
    	titleL.setText(shoplist.getName());
    }
    
    @FXML
    private void backToMain(ActionEvent event) {
    	WindowManager.backToMainWindow();
    }   
}
