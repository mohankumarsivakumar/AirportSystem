package global.coda.airport.bean;

import java.util.Date;

public class CrewLeave {
	private int leaveno,crewid,noofdays;
	private Date leavedate;
	public int getLeaveno() {
		return leaveno;
	}
	public void setLeaveno(int leaveno) {
		this.leaveno = leaveno;
	}
	public int getCrewid() {
		return crewid;
	}
	public void setCrewid(int crewid) {
		this.crewid = crewid;
	}
	public int getNoofdays() {
		return noofdays;
	}
	public void setNoofdays(int noofdays) {
		this.noofdays = noofdays;
	}
	public Date getLeavedate() {
		return leavedate;
	}
	public void setLeavedate(Date leavedate) {
		this.leavedate = leavedate;
	}
}
