package functionality;
import java.io.Serializable;

/**
 * Date is the class that handles time-related operations.
 * 
 * @author Kenneth Jensen
 * @author Florin Bordei
 * @author Teakosheen Joulak
 * @author Jimmi Børgesen
 * @version 1.0
 */
public class Date implements Serializable {

	/* Fields */
	private int day, month, year;
	private static String[] monthNames = { "January", "February", "March", "April", "May", "June", "July", "August",
			"September", "October", "November", "December" };

	/**
	 * This is the class constructor.
	 * 
	 * @param day day of the month.
	 * @param month	month of the year, ranging from 1-12.
	 * @param year the year in the gregorian calendar.
	 */
	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	/**
	 * Method to set the date, similar to the class constructor.
	 * 
	 * @param day day of the month.
	 * @param month	month of the year, ranging from 1-12.
	 * @param year the year in the gregorian calendar.
	 */
	public void setDate(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	/**
	 * Method to get the day of the month.
	 * 
	 * @return the day of the month.
	 */
	public int getDay() {
		return day;
	}

	/**
	 * Method to get the month of the year.
	 * 
	 * @return the month of the year, ranging from 1-12.
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * Method to get the year.
	 * 
	 * @return the year of the Date.
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Method to check, whether the year is a leap year.
	 * 
	 * @param year the year the method is to check.<!-- -->The usual use case is to pass the Dates year to this method.
	 * @return A boolean denoting whether or not the year is a leap year.
	 */
	public boolean isLeapYear(int year) {
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Method to get the number of days in a specific month.
	 * 
	 * @return the amount of days in the month.
	 */
	public int numberOfDaysInMonth() {
		switch (this.month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			return 31;
		case 2:
			if (isLeapYear(2)) {
				return 29;
			} else {
				return 28;
			}
		case 4:
		case 6:
		case 9:
		case 11:
			return 30;
		default:
			return -1;
		}
	}

	/**
	 * Method to get the month name, using a static field holding the names of the months.
	 * 
	 * @return the month name.
	 */
	public String getMonthName() {
		return monthNames[this.month];
	}
	
	/**
	 * Method to forward this Date to the next day.
	 */
	public void nextDay() {
		if(day + 1 > numberOfDaysInMonth()) {
			day = 1;
			if(month + 1 > 12) {
				month = 1;
				year++;
			} else {
				month++;
			}
		} else {
			day++;
		}
	}
	
	/**
	 * Method to forward this Date a set amount of days.
	 * 
	 * @param days amount of days to forward.
	 * @return a Date Object of that dates day, month and year.
	 */
	public Date nextDays(int days) {
		for(int i = 0; i < days; i++) {
			nextDay();
		}
		return this;
	}
	
	/**
	 * Method to copy this date, used for composition
	 * 
	 * @return a Date object, thats a copy of this
	 */
	public Date copy() {
		return new Date(day, month, year);
	}
	
	/**
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String s = "";
		// Pad string with leading zeros
		// Day/Month has a width of 2
		// Year has a width of 4
		s += String.format("%02d/%02d/%04d", day, month, year);
		return s;
	}
	
	/**
	 * Method returning a string version of this Date in a formal format.
	 * 
	 * @return a String containing the data of the date formatted in a format, for example: "12th of October, 2000".
	 * @see java.lang.Object#toString()
	 */
	public String toFormalString() {
		String s = "";
		s += String.format("%dth of %s, %d", day, getMonthName(), year);
		return s;
	}
	
	/**
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if(!(obj instanceof Date)) {
			return false;
		}
		Date other = (Date) obj;
		return day == other.day
				&& month == other.month
				&& year == other.year;
	}
	
	/**
	 * Method to check whether this is between two given dates
	 * 
	 * @param lowerBound the earlier of the two Date parameters
	 * @param upperBound the later of the two Date parameters
	 * @return a boolean denoting whether the date is between the two parameters
	 */
	public boolean isBetween(Date lowerBound, Date upperBound) {
		if(lowerBound.equals(upperBound)) {
			if(this.equals(lowerBound)) {
				return true;
			} else {
				return false;
			}
		}
		
		if(lowerBound.getYear() == lowerBound.getYear()) {
			if(lowerBound.getMonth() == upperBound.getMonth()) {
				return this.day > lowerBound.getDay() && this.day < upperBound.getDay();
			} else {
				if(this.month == lowerBound.getMonth()) {
					return this.day > lowerBound.day;
				} else if(this.month == upperBound.getMonth()) {
					return this.day < upperBound.getDay();
				} else {
					return false;
				}
			}
		} else {
			if(this.getYear() == lowerBound.getYear() && this.getMonth() == lowerBound.getMonth()) {
				return this.getDay() > lowerBound.getDay();
			} else if(this.getYear() == upperBound.getYear() && this.getMonth() == upperBound.getMonth()) {
				return this.day < upperBound.getDay();
			} else {
				return false;
			}
		}
	}
	
	/**
	 * Method to check whether this is before a given date.
	 * 
	 * @param date the Date to check against.
	 * @return a boolean denoting whether the date is before the given date.
	 */
	public boolean isBefore(Date date) {
		if(year <= date.getYear()) {
			if(month <= date.getMonth()) {
				if(day < date.getDay()) {
					return true;
				} else {
					return true;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
}
