package functionality;

import java.awt.Desktop;
import java.io.*;
import java.util.*;

/**
 * HTMLGenerator is a Class that takes a pre-written HTML file and changes the
 * value within to output a schedule.
 * 
 * @author Kenneth Jensen
 * @author Florin Bordei
 * @author Teakosheen Joulak
 * @author Jimmi Børgesen
 * @version 1.0
 */
public class HTMLGenerator {

	/**
	 * Method to save the data to a new HTML file.
	 * 
	 * @param schedule the schedule to save.
	 * @param name     the name of the file the class will create.
	 */
	public static void saveToHTML(Schedule schedule, String name) {
		if (schedule.getAssignments().isEmpty()) {
			return;
		}
		List<String> emptyTable = new ArrayList<String>();
		List<String> lines = new ArrayList<String>();

		String filename = "Schedule.html";
		File file = new File(filename);
		File output = new File(name);
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

		checkArray(lines, schedule.getStartDate(), schedule);

		divEnd = 0;

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

	public static void checkArray(List<String> lines, Date startDate, Schedule schedule) {
		int rowAdded = 0;
		String tableDataRow = null;
		List<Person> people = new ArrayList<>();
		for (Person p : schedule.getAssignments().keySet()) {
			if (schedule.getAssignments().get(p).isEmpty()) {
				// Do nothing
			} else {
				people.add(p);
			}
		}
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
				int assignments = schedule.getAssignments().get(people.get(rowAdded)).size();
				lines.set(i, lines.get(i).replace("$dataName", people.get(rowAdded).toString()));
				lines.set(i, lines.get(i).replace("$dataMon",
						schedule.getAssignments().get(people.get(rowAdded)).get(0).getTest()));
				lines.set(i, lines.get(i).replace("$dataTue",
						schedule.getAssignments().get(people.get(rowAdded)).get(1).getTest()));
				lines.set(i, lines.get(i).replace("$dataWed",
						schedule.getAssignments().get(people.get(rowAdded)).get(2).getTest()));
				lines.set(i, lines.get(i).replace("$dataThur",
						schedule.getAssignments().get(people.get(rowAdded)).get(3).getTest()));
				lines.set(i, lines.get(i).replace("$dataFri",
						schedule.getAssignments().get(people.get(rowAdded)).get(4).getTest()));
				lines.set(i, lines.get(i).replace("$dataSat",
						schedule.getAssignments().get(people.get(rowAdded)).get(5).getTest()));
				lines.set(i, lines.get(i).replace("$dataSun",
						schedule.getAssignments().get(people.get(rowAdded)).get(6).getTest()));
				if (rowAdded < people.size() - 1) {
					lines.add(i + 1, tableDataRow);
					rowAdded++;
				}
			}
		}
	}
}
