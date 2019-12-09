package pt.iade.shoplist.models;

public class Shoplist {
	private int id;
	private String name;
	public Shoplist(int id,String name) {
		this.name = name;
		this.id = id;
	}
	
	@Override
	public String toString() {
		return  name;
	}
	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}
	
	
}
