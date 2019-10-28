package pt.iade.shoplist.models.daos;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pt.iade.shoplist.models.ImportedProduct;
import pt.iade.shoplist.models.Item;
import pt.iade.shoplist.models.Product;
import pt.iade.shoplist.models.Shoplist;

final public class ShoplistDAO {
	
	private ShoplistDAO() {}
	
	static private ObservableList<Shoplist> shoplists =
			FXCollections.observableArrayList();
	
	static {
		ObservableList<Item> items =FXCollections.observableArrayList();
		items.add(new Item(0.8,new Product("Batata",0.34)));
		items.add(new Item(1.2,new ImportedProduct("Cebolas",0.34,
				"França","F2P")));
		items.add(new Item(6,new Product("Pão",0.12)));
		
		shoplists.add(new Shoplist("Compras de Natal",
				items));
		items =FXCollections.observableArrayList();
		items.add(new Item(0.5,new Product("Pão",0.5)));
		items.add(new Item(0.4,new ImportedProduct("Presunto", 3.5,
				"Espanha","Espanholes")));
		
		shoplists.add(new Shoplist("Compras de Novembro",
				items));
	}
	
	static public ObservableList<Shoplist> getAllShoplists() {
		return shoplists;
	}

}
