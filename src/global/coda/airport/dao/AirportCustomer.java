package global.coda.airport.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import com.mysql.jdbc.Connection;

import global.coda.airport.bean.Customer;
import global.coda.airport.bean.History;
import global.coda.airport.bean.Passenger;
import global.coda.airport.bean.ScheduleSearch;
import global.coda.airport.bean.Transaction;
import global.coda.airport.connection.ConnectionClass;

public class AirportCustomer {
	/**
	 * it is used to authenticate the given customer
	 */
	public int verifyLogin(String phoneNo, String password) throws SQLException {
		Connection con = (Connection) ConnectionClass.establish();
		String query = "select * from customer where contact_number=(?) and password=(?)";
		PreparedStatement preparedStmt = con.prepareStatement(query);
		preparedStmt.setString(1, phoneNo);
		preparedStmt.setString(2, password);
		ResultSet rs = preparedStmt.executeQuery();
		int rowCount = 0;
		while (rs.next())
			rowCount++;
		ConnectionClass.closeConnection(con);
		return rowCount;
	}

	// it is used to create login id and password for the new customer
	public int createLogin(int phoneNo, String name, String gender, String password) throws SQLException {
		Connection con = (Connection) ConnectionClass.establish();
		String query = "insert into customer values (?,?,?,?)";
		int registervalid = 0;
		PreparedStatement preparedStmt;

		preparedStmt = con.prepareStatement(query);

		preparedStmt.setInt(3, phoneNo);
		preparedStmt.setString(1, name);
		preparedStmt.setString(2, gender);
		preparedStmt.setString(4, password);
		int rs = preparedStmt.executeUpdate();

		if (rs == 1) {
			registervalid = 1;
			Customer c = new Customer();
			c.createCustomer(phoneNo, name, gender, password);
		} else
			registervalid = 0;
		ConnectionClass.closeConnection(con);
		return registervalid;
	}

	// it is used to display the result set that matches with our given requirements
	public ArrayList<ScheduleSearch> search(String source, String destination, Date date, String type, int number,
			String filter) throws SQLException {
		Connection con = (Connection) ConnectionClass.establish();
		String query = null;
		if (type.equalsIgnoreCase("e"))
			query = "select flight_schedule.flight_schedule_no,flight.airline,flight.boarding_place,flight.destination,flight_schedule.date,flight_schedule.departure,flight_schedule.economy_fare,flight_schedule.economy_seats"
					+ " from flight inner join flight_schedule on flight.id = flight_schedule.flight_id and flight.boarding_place=(?) "
					+ "and flight.destination=(?) and flight_schedule.date=(?)and flight_schedule.economy_seats>="
					+ number + " order by " + filter;
		else if (type.equalsIgnoreCase("b")) {
			query = "select flight_schedule.flight_schedule_no,flight.airline,flight.boarding_place,flight.destination,flight_schedule.date,flight_schedule.departure,flight_schedule.business_fare,flight_schedule.business_seats"
					+ " from flight inner join flight_schedule on flight.id = flight_schedule.flight_id and flight.boarding_place=(?) "
					+ "and flight.destination=(?) and flight_schedule.date=(?)and flight_schedule.business_seats>="
					+ number + " order by " + filter;
		}
		PreparedStatement preparedStmt = con.prepareStatement(query);
		preparedStmt.setString(1, source);
		preparedStmt.setString(2, destination);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		preparedStmt.setString(3, df.format(date));
		ResultSet rs = preparedStmt.executeQuery();
		ArrayList<ScheduleSearch> search = new ArrayList<ScheduleSearch>();
		while (rs.next()) {
			ScheduleSearch s = new ScheduleSearch();
			s.setFlight_schedule_no(rs.getInt(1));
			System.out.println(rs.getInt(1));
			s.setAirline(rs.getString(2));
			s.setBoarding_place(rs.getString(3));
			s.setDestination(rs.getString(4));
			s.setDate(rs.getDate(5));
			s.setDeparture(rs.getTime(6));
			s.setFare(rs.getFloat(7));
			s.setSeats(rs.getInt(8));
			search.add(s);
		}
		ConnectionClass.closeConnection(con);

		return search;

	}
	// it is used to book a flight by giving the names of the passengers

	public float[] book(String cid, int scheduleNo, String types, int noofSeat, String name[]) throws SQLException {
		Random rand = new Random();
		int pnr = rand.nextInt(100000);
		Connection con = (Connection) ConnectionClass.establish();
		String query1 = null;
		if (types.equals("e")) {
			query1 = " select (?)*economy_fare from flight_schedule where flight_schedule_no=(?) and economy_seats > 0";
		} else if (types.equals("b")) {
			query1 = " select (?)*business_fare from flight_schedule where flight_schedule_no=(?) and business_Seats > 0";
		}
		PreparedStatement smt = con.prepareStatement(query1);
		smt.setInt(1, noofSeat);
		smt.setInt(2, scheduleNo);
		ResultSet rs = smt.executeQuery();
		float amnt = 0;
		while (rs.next()) {
			amnt = rs.getInt(1);
		}
		String query = "insert into transaction values (?,?,?,?,?,?,?)";
		PreparedStatement preparedStmt = con.prepareStatement(query);
		preparedStmt.setInt(1, pnr);
		preparedStmt.setString(2, cid);
		preparedStmt.setInt(3, scheduleNo);
		preparedStmt.setString(4, types);
		preparedStmt.setInt(5, noofSeat);
		preparedStmt.setString(6, "booked");
		preparedStmt.setFloat(7, amnt);
		int value = preparedStmt.executeUpdate();
		float flag[] = new float[3];
		if (value == 1) {

			Transaction t = new Transaction();
			t.setTransaction(pnr, cid, scheduleNo, types, noofSeat, amnt);
			Passenger p = new Passenger();
			for (int j = 1; j <= noofSeat; j++) {
				String query2 = "insert into passenger(pnr_no,passenger_name) values(?,?)";
				PreparedStatement Stmt = con.prepareStatement(query2);
				Stmt.setInt(1, pnr);
				Stmt.setString(2, name[j]);
				Stmt.execute();
				p.setPassenger(pnr, name[j]);

			}
			if (types.equalsIgnoreCase("e")) {
				query = "update flight_schedule set economy_seats=economy_seats-(?) where flight_schedule_no=(?)";
				preparedStmt = con.prepareStatement(query);
				preparedStmt.setInt(1, noofSeat);
				preparedStmt.setInt(2, scheduleNo);
				preparedStmt.executeUpdate();
			} else if (types.equalsIgnoreCase("b")) {
				query = "update flight_schedule set business_seats=business_seats-(?) where flight_schedule_no=(?)";
				preparedStmt.setInt(1, noofSeat);
				preparedStmt.setInt(2, scheduleNo);
				preparedStmt.executeUpdate();
			}
			flag[0] = pnr;
			flag[1] = amnt;
		} else
			flag[0] = -1;
		ConnectionClass.closeConnection(con);
		return flag;

	}
	// it is used to display the seats that are available

	public ArrayList<Integer> checkin(int pnrno, HttpServletRequest request) throws SQLException {
		Connection co = (Connection) ConnectionClass.establish();
		String query = null;
		query = "select flight_schedule_no,flight_class,no_of_seats from transaction where pnr=(?) and status=(?)";
		PreparedStatement preparedStmt = co.prepareStatement(query);
		preparedStmt.setInt(1, pnrno);
		preparedStmt.setString(2, "booked");
		ResultSet r = preparedStmt.executeQuery();
		int scheduleNo, noofSeat, flightNo;
		String clas;
		ArrayList<Integer> totalseats = new ArrayList<Integer>(100);
		if (r.next() == false)
			System.out.println("fails");
		else {
			do {
				scheduleNo = r.getInt(1);
				noofSeat = r.getInt(3);
				clas = r.getString(2);
			} while (r.next());
			query = "select flight_id from flight_schedule where flight_schedule_no=(?)";
			preparedStmt = co.prepareStatement(query);
			preparedStmt.setInt(1, scheduleNo);
			r = preparedStmt.executeQuery();

			ArrayList<Integer> boarded = new ArrayList<Integer>(100);
			if (r.next()) {
				flightNo = r.getInt(1);
				query = "select start_seat_no,ending_seat_no from flight inner join seats on flight.id=seats.flight_id and flight.id=(?) and seats.flight_class=(?)";
				preparedStmt = co.prepareStatement(query);
				preparedStmt.setInt(1, flightNo);
				preparedStmt.setString(2, clas);
				r = preparedStmt.executeQuery();
				int start = 0, end = 0;
				while (r.next()) {
					start = r.getInt(1);
					end = r.getInt(2);
				}

				for (; start <= end; start++) {
					totalseats.add(start);
				}

				query = "select seat_no from passenger";
				preparedStmt = co.prepareStatement(query);
				r = preparedStmt.executeQuery();

				while (r.next()) {
					boarded.add(r.getInt(1));
				}
				totalseats.removeAll(boarded);
				request.setAttribute("max", noofSeat);

			} else
				System.out.println("error .Try again!!!");

		}

		ConnectionClass.closeConnection(co);
		return totalseats;

	}

	// asks customer to choose seats from those that are not occupied yet
	public int board(String[] seats, int pnr) throws SQLException, FileNotFoundException, IOException {
		Connection co = (Connection) ConnectionClass.establish();
		String query = null;

		for (String s : seats) {
			int seat = Integer.parseInt(s);
			query = "update passenger set seat_no=(?) where pnr_no=(?) and seat_no=0 limit 1";
			PreparedStatement preparedStmt = co.prepareStatement(query);
			preparedStmt.setInt(1, seat);
			preparedStmt.setInt(2, pnr);
			preparedStmt.executeUpdate();
		}
		int flag = 0;

		query = "update transaction set status='checkedin' where pnr=(?)";
		PreparedStatement preparedStmt = co.prepareStatement(query);
		preparedStmt.setInt(1, pnr);
		flag = preparedStmt.executeUpdate();

		ConnectionClass.closeConnection(co);
		return flag;

	}

	// it is used to cancel a booked ticket by giving its pnr number
	public int cancel(int pnrno) throws SQLException {
		Connection co = (Connection) ConnectionClass.establish();
		String query = null;
		query = "select no_of_seats,flight_class,flight_schedule_no from transaction where pnr=(?) and status=(?)";
		PreparedStatement preparedStmt = co.prepareStatement(query);
		preparedStmt.setInt(1, pnrno);
		preparedStmt.setString(2, "booked");
		ResultSet r = preparedStmt.executeQuery();
		int seatcount = 0;
		String cls = null;
		int flight_schedule_no = 0;
		int flag = 0;
		if (r.next() == false) {
			flag = 0;

		}
		do {
			cls = r.getString(2);
			seatcount = r.getInt(1);
			flight_schedule_no = r.getInt(3);
			query = "update transaction set status=(?) where pnr=(?)";
			PreparedStatement tmt = co.prepareStatement(query);
			tmt.setString(1, "cancelled");
			tmt.setInt(2, pnrno);
			tmt.executeUpdate();
			if (cls.equals("e")) {
				query = "update flight_schedule set economy_seats=economy_seats+(?) where flight_schedule_no=(?)";
				preparedStmt = co.prepareStatement(query);
				preparedStmt.setInt(1, seatcount);
				preparedStmt.setInt(2, flight_schedule_no);
				preparedStmt.executeUpdate();
			} else if (cls.equals("b")) {
				query = "update flight_schedule set business_seats=business_seats+(?) where flight_schedule_no=(?)";
				preparedStmt = co.prepareStatement(query);
				preparedStmt.setInt(1, seatcount);
				preparedStmt.setInt(2, flight_schedule_no);
				preparedStmt.executeUpdate();
			}

		} while (r.next());
		flag = 1;
		ConnectionClass.closeConnection(co);
		return flag;

	}

	// it is used to display all the transactions that has been made by the customer
	public ArrayList<History> viewHistory(String cid) throws SQLException {
		Connection co = (Connection) ConnectionClass.establish();
		String query = null;
		query = "select * from transaction where customer_id=(?) ";
		PreparedStatement statement = co.prepareStatement(query);
		statement.setString(1, cid);
		ResultSet set = statement.executeQuery();
		ArrayList<History> search = new ArrayList<History>();
		if (set.next() == false) {
			return search;
		} else {

			while (set.next()) {
				History h = new History();
				h.setPnr(set.getInt(1));
				h.setCustomer_id(set.getString(2));
				h.setFlight_schedule_no(set.getInt(3));
				h.setFlight_class(set.getString(4));
				h.setNo_of_seats(set.getInt(5));
				h.setStatus(set.getString(6));
				h.setPrice(set.getDouble(7));
				search.add(h);

			}

		}
		ConnectionClass.closeConnection(co);
		return search;
	}

	// it is used to monitor the current status of a particular pnr number
	public History status(int pnr) throws SQLException {
		Connection co = (Connection) ConnectionClass.establish();
		String query = "select * from transaction where pnr=(?)";
		PreparedStatement preparedStmt = co.prepareStatement(query);
		preparedStmt.setInt(1, pnr);
		ResultSet r = preparedStmt.executeQuery();
		History status = new History();
		if (r.next() == false)
			status = null;
		else {

			do {

				status.setPnr(r.getInt(1));
				status.setCustomer_id(r.getString(2));
				status.setFlight_schedule_no(r.getInt(3));
				status.setFlight_class(r.getString(4));
				status.setNo_of_seats(r.getInt(5));
				status.setStatus(r.getString(6));
				status.setPrice(r.getDouble(7));
			} while (r.next());
			ConnectionClass.closeConnection(co);

		}
		return status;
	}

}
