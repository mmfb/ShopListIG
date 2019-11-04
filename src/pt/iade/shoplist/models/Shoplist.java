package pt.iade.shoplist.models;

import javafx.collections.ObservableList;

public class Shoplist {
	private String name;
	private ObservableList<Item> items;
	public Shoplist(String name, ObservableList<Item> items) {
		this.name = name;
		this.items = items;
	}
	@Override
	public String toString() {
		return  name;
	}
	public double getCost() {
		double sum =0;
		for (Item item : items) {
			sum += item.getCost();
		}
		return sum;
	}
	public ObservableList<Item> getItems() {
		return items;
	}
	public String getName() {
		return name;
	}
	
	
}
