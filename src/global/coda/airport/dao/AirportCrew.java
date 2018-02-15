package global.coda.airport.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.mysql.jdbc.Connection;

import global.coda.airport.bean.CrewProfiles;
import global.coda.airport.bean.Schedule;
import global.coda.airport.connection.ConnectionClass;

public class AirportCrew {

	// it is used to verify the authenticity of crew
	public int verifyCrewLogin(int id, String password) throws SQLException {
		Connection co = (Connection) ConnectionClass.establish();
		String query = "select * from crew where id=(?) and password=(?)";
		PreparedStatement preparedStmt = co.prepareStatement(query);
		preparedStmt.setInt(1, id);
		preparedStmt.setString(2, password);
		ResultSet rs = preparedStmt.executeQuery();
		int rowCount = 0;
		while (rs.next())
			rowCount++;
		ConnectionClass.closeConnection(co);
		return rowCount;
	}

	// it displays all the details of the currently logged in crew
	public CrewProfiles viewCrewProfile(int cid) throws SQLException {
		Connection co = (Connection) ConnectionClass.establish();
		String query = "select * from crew where id=(?)";
		PreparedStatement preparedStmt = co.prepareStatement(query);
		preparedStmt.setInt(1, cid);
		ResultSet r = preparedStmt.executeQuery();
		String query1 = "select language from languages where crew_id=(?)";
		PreparedStatement prparedStmt = co.prepareStatement(query1);
		String resultset = "";
		prparedStmt.setInt(1, cid);
		ResultSet re = prparedStmt.executeQuery();
		CrewProfiles crew = new CrewProfiles();
		if (r.next() == false)
			crew = null;
		else {
			do {
				crew.setId(r.getInt(1));
				crew.setCrew_name(r.getString(2));
				crew.setDesignation(r.getString(3));
				crew.setContact_no(r.getString(4));
				crew.setPassword(r.getString(5));
				crew.setGender(r.getString(6));

				while (re.next()) {
					resultset = resultset + re.getString(1) + ",";
				}
				crew.setLanguage(resultset);
			} while (r.next());
			ConnectionClass.closeConnection(co);
		}
		return crew;
	}

	// it displays those flights that have been assigned to this crew
	public ArrayList<Schedule> viewAllotedFlight(int cid) throws SQLException {
		Connection co = (Connection) ConnectionClass.establish();
		String query = "select f.flight_schedule_no,f.flight_id,f.date,f.departure,f.arrival from flight_schedule f inner join  slot s on f.flight_schedule_no=s.flight_schedule_no and s.crew_id=(?)";
		PreparedStatement preparedStmt = co.prepareStatement(query);
		preparedStmt.setInt(1, cid);
		ResultSet r = preparedStmt.executeQuery();
		ArrayList<Schedule> alloted = new ArrayList<Schedule>();
		if (r.next() == false)
			alloted = null;
		else {
			do {
				Schedule s = new Schedule();
				s.setScheduleNo(r.getInt(1));
				s.setFlightNo(r.getInt(2));
				s.setDate(r.getDate(3));
				s.setDepartureTime(r.getTime(4));
				s.setArrivalTime(r.getTime(5));
				alloted.add(s);
			} while (r.next());
			ConnectionClass.closeConnection(co);
		}
		return alloted;
	}

	// it is used to view other crew those who are travelling with us
	public ArrayList<CrewProfiles> viewOtherCrew(int scheduleNo) throws SQLException {
		Connection co = (Connection) ConnectionClass.establish();
		String query = "select crew_id from slot where flight_schedule_no=(?)";
		PreparedStatement preparedStmt = co.prepareStatement(query);
		preparedStmt.setInt(1, scheduleNo);
		ResultSet r = preparedStmt.executeQuery();
		String res = "";
		CrewProfiles crew = new CrewProfiles();
		ArrayList<CrewProfiles> othercrew = new ArrayList<CrewProfiles>();
		if (r.next() == false)
			return othercrew;
		else {

			do {
				String query1 = "select * from crew where id=(?)";
				PreparedStatement preparedStmt1 = co.prepareStatement(query1);
				preparedStmt1.setInt(1, r.getInt(1));
				ResultSet r1 = preparedStmt1.executeQuery();
				String qery = "select language from languages where crew_id=(?)";
				PreparedStatement prparedStmt = co.prepareStatement(qery);
				prparedStmt.setInt(1, r.getInt(1));
				ResultSet re = prparedStmt.executeQuery();
				while (r1.next()) {
					crew.setId(r1.getInt(1));
					crew.setCrew_name(r1.getString(2));
					crew.setDesignation(r1.getString(3));
					crew.setContact_no(r1.getString(4));
					crew.setPassword(r1.getString(5));
					crew.setGender(r1.getString(6));
					while (re.next()) {
						res += re.getString(1) + ",";
					}
					crew.setLanguage(res);
					othercrew.add(crew);
				}
			} while (r.next());
			ConnectionClass.closeConnection(co);
		}
		return othercrew;
	}

	// it is used to find out those flight schedules that match our requirement
	public String requestSlot(int cid, String dest, Date date) throws SQLException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Connection co = (Connection) ConnectionClass.establish();
		String query = "select distinct f.flight_schedule_no from flight_schedule f inner join flight fl where f.date=(?) and fl.destination=(?)";
		PreparedStatement preparedStmt = co.prepareStatement(query);
		preparedStmt.setString(1, df.format(date));
		preparedStmt.setString(2, dest);
		ResultSet r = preparedStmt.executeQuery();
		String res = "";
		if (r.next() == false)
			res = "-1";
		else {
			do {
				res = res + r.getInt(1) + " ";

			} while (r.next());
		}
		ConnectionClass.closeConnection(co);
		return res;

	}

	// it is used to request slot to a particular destination on a particular date
	public int selectSlot(int cid, int schdlno) throws SQLException {
		Connection co = (Connection) ConnectionClass.establish();
		String query = "insert into slot_requests (crew_id,status,flight_schedule_no) values(?,?,?)";
		PreparedStatement preparedStmt = co.prepareStatement(query);
		preparedStmt.setInt(1, cid);// cid is crew id
		preparedStmt.setString(2, "req");
		preparedStmt.setInt(3, schdlno);
		int valid = preparedStmt.executeUpdate();
		ConnectionClass.closeConnection(co);
		return valid;
	}

	// it is used to request leave
	public int leaveRequests(int cid, Date dat, int count) throws SQLException, ParseException {
		Connection co = (Connection) ConnectionClass.establish();
		String query = "insert into leave_requests (crew_id,status,no_of_days,date) values(?,?,?,?)";
		PreparedStatement preparedStmt = co.prepareStatement(query);
		preparedStmt.setInt(1, cid);// crew id as cid
		preparedStmt.setString(2, "req");
		preparedStmt.setInt(3, count);
		preparedStmt.setDate(4, new java.sql.Date(dat.getTime()));
		int valid = preparedStmt.executeUpdate();
		ConnectionClass.closeConnection(co);
		return valid;
	}

	// it is used to request compensation
	public int compensation(int cid, int count, Date dat, Date[] dates) throws ParseException, SQLException {
		for (int temp = 0; temp < count; temp++) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Date d = dates[temp];
			System.out.println(df.format(dates[temp]));
			Connection co = (Connection) ConnectionClass.establish();
			String query = "insert into crew_availability values(?,?,?)";
			PreparedStatement preparedStmt = co.prepareStatement(query);
			preparedStmt.setInt(1, cid);
			preparedStmt.setDate(2, new java.sql.Date(d.getTime()));
			preparedStmt.setString(3, "available");
			preparedStmt.executeUpdate();
		}
		for (int c = 0; c < count; c++) {
			Connection co = (Connection) ConnectionClass.establish();
			String query = "insert into crew_availability values(?,?,?)";
			PreparedStatement preparedStmt = co.prepareStatement(query);
			preparedStmt.setInt(1, cid);
			preparedStmt.setDate(2, new java.sql.Date(dat.getTime() + c * (1000 * 60 * 60 * 24)));
			preparedStmt.setString(3, "unavailable");
			preparedStmt.executeUpdate();
			ConnectionClass.closeConnection(co);
		}
		return 1;

	}

}
