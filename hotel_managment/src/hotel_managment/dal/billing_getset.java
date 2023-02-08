package hotel_managment.dal;

public class billing_getset {
int order_id,amount,customer_id,moblie,bill_id=0;
public int getBill_id() {
	return bill_id;
}
public void setBill_id(int bill_id) {
	this.bill_id = bill_id;
}
public int getMoblie() {
	return moblie;
}
public void setMoblie(int moblie) {
	this.moblie = moblie;
}
String date_time,payment_type,name;
String Credit_card = "none", Expiry_date = "none";

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getOrder_id() {
	return order_id;
}
public void setOrder_id(int order_id) {
	this.order_id = order_id;
}
public int getAmount() {
	return amount;
}
public void setAmount(int amount) {
	this.amount = amount;
}
public int getCustomer_id() {
	return customer_id;
}
public void setCustomer_id(int customer_id) {
	this.customer_id = customer_id;
}
public String getDate_time() {
	return date_time;
}
public void setDate_time(String date_time) {
	this.date_time = date_time;
}
public String getPayment_type() {
	return payment_type;
}
public void setPayment_type(String payment_type) {
	this.payment_type = payment_type;
}
public String getCredit_card() {
	return Credit_card;
}
public void setCredit_card(String credit_card) {
	Credit_card = credit_card;
}
public String getExpiry_date() {
	return Expiry_date;
}
public void setExpiry_date(String expiry_date) {
	Expiry_date = expiry_date;
}

}
