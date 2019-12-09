package pt.iade.shoplist.models.daos;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pt.iade.shoplist.models.ImportedProduct;
import pt.iade.shoplist.models.Item;
import pt.iade.shoplist.models.Product;
import pt.iade.shoplist.models.Shoplist;

final public class ShoplistDAO {
	
	private ShoplistDAO() {}
	
	static public ObservableList<Shoplist> getAllShoplists() {
		Connection conn = DBConnector.getConnection();
		String sql = "Select * from shoplists";
		 ObservableList<Shoplist> shoplists = 
				 FXCollections.observableArrayList();
		 try(Statement stat=conn.createStatement();
		     ResultSet rs = stat.executeQuery(sql)) {
			 while(rs.next()) {
				 int id = rs.getInt("id");
				 String name = rs.getString("name");
				 shoplists.add(new Shoplist(id,name));
			 }
		 } catch(SQLException err) {
			 err.printStackTrace();
		 }
		 
		return shoplists;
	}

	public static ObservableList<Item> getShoplistItems(int id) {
		Connection conn = DBConnector.getConnection();
		String sql = "Select quantity,name,price,country "+
		"from items, products "+
		"where product_id = id AND shoplist_id = ?";
		ObservableList<Item> items = FXCollections.observableArrayList();
		
		try(PreparedStatement stat = conn.prepareStatement(sql)) {
			stat.setInt(1, id);
			try(ResultSet rs = stat.executeQuery()) {
				while (rs.next()) {
					double quant = rs.getDouble("quantity");
					String nome = rs.getString("name");
					double preco = rs.getDouble("price");
					String pais = rs.getString("country");
					Product produto;
					if (pais == null) {
						produto = new Product(nome,preco);
					} else {
						produto = new ImportedProduct(nome,preco,pais,"");
					}
					Item item = new Item(quant,produto);
					items.add(item);
				}
			}
		} catch(SQLException err) {
			 err.printStackTrace();
		}
		
		return items;
	}
	
	/*
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
	*/

}
