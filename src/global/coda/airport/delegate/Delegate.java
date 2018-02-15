package global.coda.airport.delegate;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import global.coda.airport.bean.Crew;
import global.coda.airport.bean.CrewLeave;
import global.coda.airport.bean.CrewProfiles;
import global.coda.airport.bean.History;
import global.coda.airport.bean.Schedule;
import global.coda.airport.bean.ScheduleSearch;
import global.coda.airport.dao.AirportAdmin;
import global.coda.airport.dao.AirportCrew;
import global.coda.airport.dao.AirportCustomer;

public class Delegate {
	AirportCustomer customer = new AirportCustomer();
	AirportCrew crew = new AirportCrew();
	AirportAdmin admin = new AirportAdmin();
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	static Logger log = Logger.getLogger(Delegate.class);

	/**
	 * To configure logger properties whenever we create object for this class
	 */
	public Delegate() {
		BasicConfigurator.configure();
	}

	/**
	 * it is used to authenticate the given customer
	 */
	public int verifyCustomer(String phoneNo, String password) {
		int loginflag = 0;
		try {

			loginflag = customer.verifyLogin(phoneNo, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loginflag;
	}

	// it is used to create login id and password for the new customer
	public int addCustomer(int phoneNo, String name, String gender, String password) {

		int registervalid = 0;
		try {
			registervalid = customer.createLogin(phoneNo, name, gender, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return registervalid;
	}

	// it is used to display the result set that matches with our given requirements
	public ArrayList<ScheduleSearch> search(String source, String destination, Date date, String type, int number,
			String filter) {
		ArrayList<ScheduleSearch> searchResult = new ArrayList<ScheduleSearch>();
		try {
			searchResult = customer.search(source, destination, date, type, number, filter);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return searchResult;
	}
//it is used to book a flight by giving the names of the passengers
	public float[] book(String cid, int scheduleNo, String types, int noofSeat, String name[]) {
		float book[] = new float[3];
		try {
			book = customer.book(cid, scheduleNo, types, noofSeat, name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
	}
//it is used to display the seats that are available
	public ArrayList<Integer> checkin(int pnrno, HttpServletRequest request) {
		ArrayList<Integer> remainingSeats = new ArrayList<Integer>(100);
		try {
			remainingSeats = customer.checkin(pnrno, request);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return remainingSeats;

	}
//asks customer to choose seats from those that are not occupied yet
	public int board(String[] seats, int pnr) {
		int valid = 0;
		try {
			valid = customer.board(seats, pnr);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return valid;
	}
//it is used to cancel a booked ticket by giving its pnr number
	public int cancel(int pnrno) {
		int flag = 0;
		try {
			flag = customer.cancel(pnrno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
//it is used to display all the transactions that has been made by the customer
	public ArrayList<History> viewHistory(String cid) {
		ArrayList<History> history = new ArrayList<History>();
		try {
			history = customer.viewHistory(cid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return history;
	}
//it is used to monitor the current status of a particular pnr number
	public History status(int pnr) {
		History status = new History();
		try {
			status = customer.status(pnr);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
//it is used to verify the authenticity of crew
	public int verifyCrewLogin(int id, String password) {
		int valid = 0;
		try {
			valid = crew.verifyCrewLogin(id, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return valid;
	}
//it displays all the details of the currently logged in crew
	public CrewProfiles viewCrewProfile(int cid) {
		CrewProfiles crewProfile = new CrewProfiles();
		try {
			crewProfile = crew.viewCrewProfile(cid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return crewProfile;
	}
//it displays those flights that have been assigned to this crew
	public ArrayList<Schedule> viewAllotedFlight(int cid) {
		ArrayList<Schedule> alloted = new ArrayList<Schedule>();
		try {
			alloted = crew.viewAllotedFlight(cid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alloted;
	}
//it is used to view other crew those who are travelling with us
	public ArrayList<CrewProfiles> viewOtherCrew(int scheduleNo) {
		ArrayList<CrewProfiles> othercrew = new ArrayList<CrewProfiles>();
		try {
			othercrew = crew.viewOtherCrew(scheduleNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return othercrew;
	}
	
	//it is used to find out those flight schedules that match our requirement 
	public String requestSlot(int cid, String dest, Date date) {
		String res = "";
		try {
			res = crew.requestSlot(cid, dest, date);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;

	}
	
	//it is used to request slot to a particular destination on a particular date
	public int selectSlot(int cid, int schdlno) {
		int valid = 0;
		try {
			valid = crew.selectSlot(cid, schdlno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return valid;
	}
//it is used to request leave
	public int leaveRequests(int cid, Date dat, int count) {
		int valid = 0;
		try {
			try {
				valid = crew.leaveRequests(cid, dat, count);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return valid;
	}
//it is used to request compensation
	public int compensation(int cid, int count, Date dat, Date[] dates) throws ParseException, SQLException {
		crew.compensation(cid, count, dat, dates);
		return 1;

	}
//it is used to verify the authenticity of the admin
	public int verifyAdminLogin(int aid, String paswd) {

		int rowCount = 0;
		try {
			rowCount = admin.verifyAdminLogin(aid, paswd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowCount;
	}
//it is used to add flight
	public int addFlight(String flno, String airline, String boarding, String dest) {
		int flag = 0;
		try {
			flag = admin.addFlight(flno, airline, boarding, dest);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
//it is used to schedule those flights that were added
	public int addSchedule(int flid, Date date, Date dept, Date arrival, int ecSeats, Float ecCost, int bsSeats,
			Float bsCost) {

		int flag = 0;
		try {
			flag = admin.addSchedule(flid, date, dept, arrival, ecSeats, ecCost, bsSeats, bsCost);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;

	}
//it is used to divide the economy and business seats for a particular flight
	public int addSeats(int flid1, String clas, int start, int end) {
		int valid = 0;
		try {
			valid = admin.addSeats(flid1, clas, start, end);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return valid;
	}
//it is used to add details of the new employees
	public int addCrew(String name, String designation, String contactno, String password, String gender) {
		int valid = 0;
		try {
			valid = admin.addCrew(name, designation, contactno, password, gender);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return valid;

	}
//it is used to add languages to a crew
	public int addLanguage(int cid1, String next[]) {
		int valid = 0;
		try {
			valid = admin.addLanguage(cid1, next);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return valid;

	}
//this is used to fetch all the leave requests upon which admin has to take action
	public ArrayList<CrewLeave> fetchLeave() {
		ArrayList<CrewLeave> array = new ArrayList<CrewLeave>();
		try {
			array = admin.fetchLeave();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return array;
	}
//admin aproves leave for selected leave requests
	public int approveLeave(String a[]) {
		int flag = 0;
		try {
			flag = admin.approveLeave(a);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
//this is used to view all the slot requests
	public ArrayList<Crew> fetchSlotRequest(int sid) {
		ArrayList<Crew> array = new ArrayList<Crew>();
		try {
			array = admin.fetchSlotRequest(sid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return array;

	}
//it is used to grant slot to particular requests
	public int approveSlot(String a[], int sid) {
		int flag = 0;
		try {
			flag = admin.approveSlot(a, sid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

}
