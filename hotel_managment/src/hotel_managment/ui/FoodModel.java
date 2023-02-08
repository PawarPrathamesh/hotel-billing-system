package hotel_managment.ui;

public class FoodModel {
	String name;
	int id, price;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public FoodModel( int id,String name ,int price) {
		super();
		this.name = name;
		this.id = id;
		this.price = price;
	}
	

}
