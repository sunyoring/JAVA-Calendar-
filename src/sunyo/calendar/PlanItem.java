package sunyo.calendar;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class PlanItem {
	public Date planDate;
	public String detail;
	public String people = "";

	public static Date getDateFromString(String strDate) throws ParseException {
		Date date = null;
		date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
		return date;
	}
	public PlanItem(String date, String detail) throws ParseException {
		this.detail = detail;
		this.planDate = getDateFromString(date);
	}
	public void addPeople(String name) {
		people += name + ",";
	}
	public Date getDate() {
		return planDate;

	}
}
