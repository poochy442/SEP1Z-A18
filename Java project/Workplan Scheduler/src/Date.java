
public class Date {

	/* Fields */
	private int day, month, year;
	private static String[] monthNames = { "January", "February", "March", "April", "May", "June", "July", "August",
			"September", "October", "November", "December" };

	/* Construcor */
	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	/* Methods */
	// Setters and getters
	public void setDate(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	// Method to check if it's a leap year
	public boolean isLeapYear(int year) {
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			return true;
		} else {
			return false;
		}
	}

	// Method to find out the number of days in a month
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

	// Method to get the name of the month
	public String getMonthName() {
		return monthNames[this.month];
	}
	
	// Method to forward one day
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
	
	// Method to forward a number of days, using the nextDay method
	public void nextDays(int days) {
		for(int i = 0; i < days; i++) {
			nextDay();
		}
	}
	
	// Copy method for returning the value
	public Date copy() {
		return new Date(day, month, year);
	}
	
	// Method converting our date to a string
	public String toString() {
		String s = "";
		// Pad string with leading zeros
		// Day/Month has a width of 2
		// Year has a width of 4
		s += String.format("%02d/%02d/%04d", day, month, year);
		return s;
	}
	
	// Method converting our date to a formal string
	public String toFormalString() {
		String s = "";
		s += String.format("%dth of %s, %d", day, getMonthName(), year);
		return s;
	}
	
}
