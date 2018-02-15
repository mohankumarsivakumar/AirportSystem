package global.coda.airport.bean;

public class History {
	 int pnr;
	 String customer_id ;
	 int flight_schedule_no ;
	 String flight_class ;
	 int no_of_seats ;
	 String status;
	 Double price;
	public int getPnr() {
		return pnr;
	}
	public void setPnr(int pnr) {
		this.pnr = pnr;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public int getFlight_schedule_no() {
		return flight_schedule_no;
	}
	public void setFlight_schedule_no(int flight_schedule_no) {
		this.flight_schedule_no = flight_schedule_no;
	}
	public String getFlight_class() {
		return flight_class;
	}
	public void setFlight_class(String flight_class) {
		this.flight_class = flight_class;
	}
	public int getNo_of_seats() {
		return no_of_seats;
	}
	public void setNo_of_seats(int no_of_seats) {
		this.no_of_seats = no_of_seats;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
}
