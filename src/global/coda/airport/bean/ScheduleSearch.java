package global.coda.airport.bean;

import java.sql.Time;
import java.util.Date;

public class ScheduleSearch {
	int flight_schedule_no;
	String airline,boarding_place,destination;
	Date date;
	Time departure;
	Float fare;
	int seats;
	public int getFlight_schedule_no() {
		return flight_schedule_no;
	}
	public void setFlight_schedule_no(int flight_schedule_no) {
		this.flight_schedule_no = flight_schedule_no;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public String getBoarding_place() {
		return boarding_place;
	}
	public void setBoarding_place(String boarding_place) {
		this.boarding_place = boarding_place;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Time getDeparture() {
		return departure;
	}
	public void setDeparture(Time departure) {
		this.departure = departure;
	}
	public Float getFare() {
		return fare;
	}
	public void setFare(Float fare) {
		this.fare = fare;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
}
