package global.coda.airport.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.mysql.jdbc.Connection;

import global.coda.airport.bean.Crew;
import global.coda.airport.bean.CrewLeave;
import global.coda.airport.bean.Flight;
import global.coda.airport.connection.ConnectionClass;

public class AirportAdmin {

	// it is used to verify the authenticity of the admin
	public int verifyAdminLogin(int aid, String paswd) throws SQLException {
		Connection co = (Connection) ConnectionClass.establish();
		String query = "select * from admin where id=(?) and password=(?)";
		PreparedStatement preparedStmt = co.prepareStatement(query);
		preparedStmt.setInt(1, aid);
		preparedStmt.setString(2, paswd);
		ResultSet rs = preparedStmt.executeQuery();
		int rowCount = 0;
		while (rs.next())
			rowCount++;
		ConnectionClass.closeConnection(co);
		return rowCount;
	}

	// it is used to add flight
	public int addFlight(String flno, String airline, String boarding, String dest) throws SQLException {
		Connection co = (Connection) ConnectionClass.establish();
		String query = "insert into flight(flight_no,airline,boarding_place,destination) values(?,?,?,?)";
		PreparedStatement preparedStmt = co.prepareStatement(query);
		preparedStmt.setString(1, flno);
		preparedStmt.setString(2, airline);
		preparedStmt.setString(3, boarding);
		preparedStmt.setString(4, dest);
		int r = preparedStmt.executeUpdate();
		int flag = 0;
		if (r == 1) {
			Flight f = new Flight();
			f.setFlight(flno, airline, boarding, dest);
			query = "select * from flight where flight_no=(?) and airline=(?) and boarding_place=(?) and destination=(?)";
			preparedStmt = co.prepareStatement(query);
			preparedStmt.setString(1, flno);
			preparedStmt.setString(2, airline);
			preparedStmt.setString(3, boarding);
			preparedStmt.setString(4, dest);
			ResultSet rs = preparedStmt.executeQuery();

			while (rs.next())
				flag = rs.getInt(1);

		}

		ConnectionClass.closeConnection(co);
		return flag;
	}

	// it is used to schedule those flights that were added
	public int addSchedule(int flid, Date date, Date dept, Date arrival, int ecSeats, Float ecCost, int bsSeats,
			Float bsCost) throws SQLException {
		Connection co = (Connection) ConnectionClass.establish();
		String query = "insert into flight_schedule(flight_id,date,departure,arrival,economy_seats,economy_fare,business_seats,business_fare) values(?,?,?,?,?,?,?,?)";
		PreparedStatement preparedStmt = co.prepareStatement(query);
		preparedStmt.setInt(1, flid);
		preparedStmt.setDate(2, new java.sql.Date(date.getTime()));
		preparedStmt.setTime(3, new java.sql.Time(dept.getTime()));
		preparedStmt.setTime(4, new java.sql.Time(arrival.getTime()));
		preparedStmt.setInt(5, ecSeats);
		preparedStmt.setFloat(6, ecCost);
		preparedStmt.setInt(7, bsSeats);
		preparedStmt.setFloat(8, bsCost);
		int r = preparedStmt.executeUpdate();
		int flag = 0;
		if (r == 1) {
			query = "select * from flight_schedule where flight_id=(?) and date=(?) and departure=(?) and arrival=(?) and economy_seats=(?) and economy_fare=(?) and business_seats=(?) and business_fare=(?)";
			preparedStmt = co.prepareStatement(query);
			preparedStmt.setInt(1, flid);
			preparedStmt.setDate(2, new java.sql.Date(date.getTime()));
			preparedStmt.setTime(3, new java.sql.Time(dept.getTime()));
			preparedStmt.setTime(4, new java.sql.Time(arrival.getTime()));
			preparedStmt.setInt(5, ecSeats);
			preparedStmt.setFloat(6, ecCost);
			preparedStmt.setInt(7, bsSeats);
			preparedStmt.setFloat(8, bsCost);
			ResultSet rs = preparedStmt.executeQuery();

			while (rs.next())
				flag = rs.getInt(1);

		}

		ConnectionClass.closeConnection(co);
		return flag;

	}

	// it is used to divide the economy and business seats for a particular flight
	public int addSeats(int flid1, String clas, int start, int end) throws SQLException {
		Connection co = (Connection) ConnectionClass.establish();
		String query = "insert into seats(flight_id,flight_class,start_seat_no,ending_seat_no) values(?,?,?,?)";
		PreparedStatement preparedStmt = co.prepareStatement(query);
		preparedStmt.setInt(1, flid1);
		preparedStmt.setString(2, clas);
		preparedStmt.setInt(3, start);
		preparedStmt.setInt(4, end);
		int valid = preparedStmt.executeUpdate();
		ConnectionClass.closeConnection(co);
		return valid;
	}

	// it is used to add details of the new employees
	public int addCrew(String name, String designation, String contactno, String password, String gender)
			throws SQLException {
		Connection co = (Connection) ConnectionClass.establish();
		String query = "insert into crew(crew_name,designation,contact_no,password,gender) values(?,?,?,?,?)";
		PreparedStatement preparedStmt = co.prepareStatement(query);
		preparedStmt.setString(1, name);
		preparedStmt.setString(2, designation);
		preparedStmt.setString(3, contactno);
		preparedStmt.setString(4, password);
		preparedStmt.setString(5, gender);
		int flag = preparedStmt.executeUpdate();
		ConnectionClass.closeConnection(co);
		return flag;

	}

	// it is used to add languages to a crew
	public int addLanguage(int cid1, String next[]) throws SQLException {
		Connection co = (Connection) ConnectionClass.establish();
		int flag = 0;
		for (int j = 0; j < next.length; j++) {
			String query = "insert into languages values(?,?)";
			PreparedStatement preparedStmt = co.prepareStatement(query);
			preparedStmt.setInt(1, cid1);
			preparedStmt.setString(2, next[j]);
			flag = preparedStmt.executeUpdate();
		}
		ConnectionClass.closeConnection(co);
		return flag;
	}

	// this is used to fetch all the leave requests upon which admin has to take
	// action
	public ArrayList<CrewLeave> fetchLeave() throws SQLException {
		Connection co = (Connection) ConnectionClass.establish();
		String query = "select * from leave_requests where status='req'";
		PreparedStatement preparedStmt = co.prepareStatement(query);
		ResultSet rs = preparedStmt.executeQuery();
		ArrayList<CrewLeave> array = new ArrayList<CrewLeave>();
		while (rs.next()) {
			CrewLeave crew = new CrewLeave();
			crew.setLeaveno(rs.getInt(1));
			crew.setCrewid(rs.getInt(2));
			crew.setNoofdays(rs.getInt(4));
			crew.setLeavedate(rs.getDate(5));
			array.add(crew);
		}
		return array;
	}

	// admin aproves leave for selected leave requests
	public int approveLeave(String a[]) throws SQLException {
		int flag = 0;
		for (String c : a) {
			Connection co = (Connection) ConnectionClass.establish();
			int leaveid = Integer.parseInt(c);
			String query = "select crew_id,no_of_days,date from leave_requests where id=(?)";
			PreparedStatement preparedStmt = co.prepareStatement(query);
			preparedStmt.setInt(1, leaveid);
			ResultSet rs = preparedStmt.executeQuery();
			int crewid = 0, noofdays = 0;
			Date d = null;
			while (rs.next()) {
				crewid = rs.getInt(1);
				noofdays = rs.getInt(2);
				d = rs.getDate(3);
			}
			query = "update crew set leave_count=leave_count+(?) where id=(?)";
			preparedStmt = co.prepareStatement(query);
			preparedStmt.setInt(1, noofdays);
			preparedStmt.setInt(2, crewid);
			preparedStmt.executeUpdate();
			query = "update leave_requests set status='granted' where id=(?) and status=(?)";
			preparedStmt = co.prepareStatement(query);
			preparedStmt.setInt(1, leaveid);
			preparedStmt.setString(2, "req");
			int r = preparedStmt.executeUpdate();

			if (r > 0) {

				for (int k = 0; k < noofdays; k++) {
					query = "insert into crew_availability values(?,?,?)";
					preparedStmt = co.prepareStatement(query);
					preparedStmt.setInt(1,crewid);
					preparedStmt.setDate(2, new java.sql.Date(d.getTime() + k * (1000 * 60 * 60 * 24)));
					preparedStmt.setString(3, "unavailable");
					preparedStmt.executeUpdate();
				}
				flag = 1;
			} else
				flag = 0;
			ConnectionClass.closeConnection(co);

		}
		return flag;
	}

	// this is used to view all the slot requests
	public ArrayList<Crew> fetchSlotRequest(int sid) throws SQLException {
		Connection co = (Connection) ConnectionClass.establish();
		String query = "select date from flight_schedule where flight_schedule_no=(?)";
		PreparedStatement preparedStmt = co.prepareStatement(query);
		preparedStmt.setInt(1, sid);
		ResultSet rs = preparedStmt.executeQuery();
		ArrayList<Crew> array = new ArrayList<Crew>();
		Date d = null;
		while (rs.next())
			d = rs.getDate(1);
		if (d == null) {
			return array;
		} else {
			query = "select c.id,c.crew_name,c.designation,c.contact_no from crew c inner join crew_availability a on c.id=a.crew_id "
					+ "and status='available' and date=(?) and id not in(select crew_id from slot where flight_schedule_no=(?)) union select id,crew_name,designation,contact_no from crew where id not in(select crew_id from crew_availability where status='unavailable' and date=(?) union select crew_id from slot where flight_schedule_no=(?))";
			preparedStmt = co.prepareStatement(query);
			preparedStmt.setDate(1, new java.sql.Date(d.getTime()));
			preparedStmt.setInt(2, sid);
			preparedStmt.setDate(3, new java.sql.Date(d.getTime()));
			preparedStmt.setInt(4, sid);
			rs = preparedStmt.executeQuery();
			while (rs.next()) {
				Crew crew = new Crew();
				crew.setCrewId(rs.getInt(1));
				crew.setName(rs.getString(2));
				crew.setDesignation(rs.getString(3));
				crew.setContactno(rs.getString(4));
				array.add(crew);
			}
			ConnectionClass.closeConnection(co);
			return array;
		}
	}

	// it is used to grant slot to particular requests
	public int approveSlot(String a[], int sid) throws SQLException {

		Connection co = (Connection) ConnectionClass.establish();
		int flag = 0;
		for (String c : a) {
			int cid = Integer.parseInt(c);
			String query = "insert into slot values(?,?) ";
			PreparedStatement preparedStmt = co.prepareStatement(query);
			preparedStmt.setInt(1, sid);
			preparedStmt.setInt(2, cid);
			flag = preparedStmt.executeUpdate();
			ConnectionClass.closeConnection(co);
		}
		return flag;
	}

}
