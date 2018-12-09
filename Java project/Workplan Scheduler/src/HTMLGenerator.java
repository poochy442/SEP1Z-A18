import java.awt.Desktop;
import java.io.*;
import java.util.*;

public class HTMLGenerator {

	// Fields

	// Methods

	// main() method for testing
	public static void main(String[] args) {
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
		
		while(in.hasNext()) {
			lines.add(in.nextLine());
		}
		
		int divStart = 0; int divEnd = 0;
		
		// Save div
		for(int i = 0; i < lines.size(); i++) {
			if(lines.get(i).matches("(.*)class=\"table\"(.*))")) {
				divStart = i;
			}
			if(lines.get(i).matches("(.*)End Point(.*)")) {
				divEnd = i;
			}
			
			if(divEnd != 0 && divStart != 0) {
				for(int j = divStart; j <= divEnd; j++) {
					emptyTable.add(lines.get(j));
				}
				break;
			}
		}
		
		// TODO: CheckArray call
		
		divEnd = 0;
		
		// Insert div
		for(int i = 0; i < lines.size(); i++) {
			if(lines.get(i).matches("(.*)End Point(.*)")) {
				divEnd = i;
			}
			
			if(divEnd != 0) {
				for(int j = 0; j < emptyTable.size(); j++) {
					lines.add(divEnd + 1 + j, emptyTable.get(j));
				}
				break;
			}
		}
		
		// TODO: CheckArray call
		
		for(int i = 0; i < lines.size(); i++) {
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
	
	public static void checkArray(List<String> lines, List<String> list) {
		// TODO: Change values of the lines
	}
}
