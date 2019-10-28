package pt.iade.shoplist.controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import pt.iade.shoplist.models.Item;

public class ShopListController {


    @FXML
    private Label titleL;

    @FXML
    private ListView<Item> itemsLV;

    @FXML
    void backToMain(ActionEvent event) {
    	
    }
}
