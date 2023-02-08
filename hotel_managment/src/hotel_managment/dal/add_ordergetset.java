package hotel_managment.dal;

public class add_ordergetset {

	int waiter_id, captain_id, table_id, order_id;
	String date_sys, time_sys;

	int id;

	public int getOrder_Id() {
		return order_id;
	}

	public void setOrder_Id(int order_id) {
		this.order_id = order_id;
	}

	public String getDate_sys() {
		return date_sys;
	}

	public void setDate_sys(String date_sys) {
		this.date_sys = date_sys;
	}

	public String getTime_sys() {
		return time_sys;
	}

	public void setTime_sys(String time_sys) {
		this.time_sys = time_sys;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getWaiter_id() {
		return waiter_id;
	}

	public void setWaiter_id(int waiter_id) {
		this.waiter_id = waiter_id;
	}

	public int getCaptain_id() {
		return captain_id;
	}

	public void setCaptain_id(int captain_id) {
		this.captain_id = captain_id;
	}

	public int getTable_id() {
		return table_id;
	}

	public void setTable_id(int table_id) {
		this.table_id = table_id;
	}
}
