package hotel_managment.dal;

public class food_item_getset {

	String name;
	int id,prize,qyt,mesure_id,cat_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrize() {
		return prize;
	}
	public void setPrize(int prize) {
		this.prize = prize;
	}
	public int getQyt() {
		return qyt;
	}
	public void setQyt(int qyt) {
		this.qyt = qyt;
	}
	public int getMesure_id() {
		return mesure_id;
	}
	public void setMesure_id(int mesure_id) {
		this.mesure_id = mesure_id;
	}
	public int getCat_id() {
		return cat_id;
	}
	public void setCat_id(int cat_id) {
		this.cat_id = cat_id;
	}
	
}
