import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Date {

	private int year;
	private int month;
	private int day;
	private boolean isInitialized = false;
	
	public Date() {
		this.year = 0;
		this.month = 0;
		this.day = 0;
		isInitialized = true;
	}
	
	public Date(int year, int month, int day) {
		setYear(year);
		setMonth(month);
		setDay(day);
		isInitialized = true;
	}
	
	public Date(String string) {
		String[] array = string.split("-");
		setYear(Integer.parseInt(array[0]));
		setMonth(Integer.parseInt(array[1]));
		setDay(Integer.parseInt(array[2]));
		isInitialized = true;
	}
	
	public int getYear() {
		checkInitialization();
		return year;
	}
	
	public int getMonth() {
		checkInitialization();
		return month;
	}
	
	public int getDay() {
		checkInitialization();
		return day;
	}
	
	public void setYear(int year) {
		if(year <= 0) {
			throw new IllegalArgumentException("Given year cannot be less than or equal to 0.");
		}
		this.year = year;
	}
	
	public void setMonth(int month) {
		if(month <= 0 && month > 12) {
			throw new IllegalArgumentException("Given month cannot be less than 0 or more than 12.");
		}
		this.month = month;
	}
	
	public void setDay(int day) {
		if(day <= 0 && day > 31) {
			throw new IllegalArgumentException("Given day cannot be less than 0 or more than 31.");
		}
		this.day = day;
	}
	
	public String toString() {
		checkInitialization();
		String str = year + "-" + month + "-" + day;
		return str;
	}
	
	public static Date getCurrentDate() {
		String date = new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime());
		String[] dateArray = date.split("/");
		return new Date(Integer.parseInt(dateArray[0]), Integer.parseInt(dateArray[1]), Integer.parseInt(dateArray[2]));
	}
	
	public static int getDifference(Date date1, Date date2) {
		int difference = 0;
		if(date1.getYear() == date2.getYear()) {
			if(date1.getMonth() == date2.getMonth()) {
				if(date1.getDay() == date2.getDay()) {
					return difference;
				}else {
					difference = difference + (date1.getDay() - date2.getDay());
				}
			}else {
				difference = 30*(date1.getMonth() - date2.getMonth()) + (date1.getDay() - date2.getDay());
			}
		}else {
			difference = difference + 365*(date1.getYear() - date2.getYear())
								+ 30*(date1.getMonth() - date2.getMonth()) + (date1.getDay() - date2.getDay());
		}
		return difference;
	}
	
	public boolean equals(Date date) {
		if(getYear() == date.getYear() && getMonth() == date.getMonth() && getDay() == date.getDay()) {
			return true;
		}
		return false;
	}
	
	private void checkInitialization() {
		if(!isInitialized) {
			throw new IllegalStateException("Given date object was not created properly.");
		}
	}
}