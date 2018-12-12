import java.awt.Desktop;
import java.io.*;
import java.util.*;

public class HTMLGenerator {

	// Fields

	// Methods
	public static void saveToHTML() {
		List<String> emptyTable = new ArrayList<String>();
		List<String> lines = new ArrayList<String>();

		String filename = "Schedule.html";
		File file = new File(filename);
		File output = new File("NewSchedule.html");
		Scanner in = null;
		PrintWriter out = null;

		try {
			in = new Scanner(file);
			out = new PrintWriter(output);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		while (in.hasNext()) {
			lines.add(in.nextLine());
		}

		int divStart = 0;
		int divEnd = 0;

		// Save div
		for (int i = 0; i < lines.size(); i++) {
			if (lines.get(i).matches("(.*)class=\"table\"(.*)")) {
				divStart = i;
			}
			if (lines.get(i).matches("(.*)End Point(.*)")) {
				divEnd = i;
			}

			if (divEnd != 0 && divStart != 0) {
				for (int j = divStart; j <= divEnd; j++) {
					emptyTable.add(lines.get(j));
				}
				break;
			}
		}

		checkArray(lines, new Date(17, 12, 2018));

		divEnd = 0;

		// Insert div
		/*
		 * for (int i = 0; i < lines.size(); i++) { if
		 * (lines.get(i).matches("(.*)End Point(.*)")) { divEnd = i; }
		 * 
		 * if (divEnd != 0) { for (int j = 0; j < emptyTable.size(); j++) {
		 * lines.add(divEnd + 1 + j, emptyTable.get(j)); } break; } }
		 */
		// TODO: CheckArray call

		for (int i = 0; i < lines.size(); i++) {
			out.println(lines.get(i));
			out.flush();
		}

		out.close();
		in.close();

		try {
			Desktop.getDesktop().open(output);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void checkArray(List<String> lines, Date startDate) {
		int rowAdded = 0;
		String tableDataRow = null;
		for (int i = 0; i < lines.size(); i++) {
			int dollarFound = lines.get(i).indexOf("$");
			String line = "$";

			if (dollarFound != -1) {
				int counter = 1;
				while (true) {
					if (lines.get(i).charAt(dollarFound + counter) == '<') {
						break;
					} else {
						line += lines.get(i).charAt(dollarFound + counter);
					}

					counter++;
				}
			}

			switch (line) {
			case "$dataTeam":
				lines.set(i, lines.get(i).replace("$dataTeam", "Team 1"));
			case "$DateMon":
				Date workingDate = startDate;
				lines.set(i, lines.get(i).replace("$DateMon", startDate.toString()));
				workingDate.nextDay();
				lines.set(i, lines.get(i).replace("$DateTue", workingDate.toString()));
				workingDate.nextDay();
				lines.set(i, lines.get(i).replace("$DateWed", workingDate.toString()));
				workingDate.nextDay();
				lines.set(i, lines.get(i).replace("$DateThu", workingDate.toString()));
				workingDate.nextDay();
				lines.set(i, lines.get(i).replace("$DateFri", workingDate.toString()));
				workingDate.nextDay();
				lines.set(i, lines.get(i).replace("$DateSat", workingDate.toString()));
				workingDate.nextDay();
				lines.set(i, lines.get(i).replace("$DateSun", workingDate.toString()));
				break;
			case "$dataName":
				tableDataRow = lines.get(i);
				lines.set(i, lines.get(i).replace("$dataName", "Kenneth/KJ"));
				lines.set(i, lines.get(i).replace("$dataMon", "Feed"));
				lines.set(i, lines.get(i).replace("$dataTue", "Food"));
				lines.set(i, lines.get(i).replace("$dataWed", "Dairy"));
				lines.set(i, lines.get(i).replace("$dataThur", "Dairy"));
				lines.set(i, lines.get(i).replace("$dataFri", "Feed"));
				lines.set(i, lines.get(i).replace("$dataSat", ""));
				lines.set(i, lines.get(i).replace("$dataSun", ""));
				// add rows
			default:
				break;
			}
		}

	}

	public static void main(String[] args) {
		saveToHTML();
	}
}
