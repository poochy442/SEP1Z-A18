package functionality;

import java.io.*;

import view.Model;

/**
 * FileIO is a class that handles the File I/O, meaning it saves to, and loads from, a binary file containing all the Objects in the model.
 * 
 * @author Kenneth Jensen
 * @author Florin Bordei
 * @author Teakosheen Joulak
 * @author Jimmi Børgesen
 * @version 1.0
 */
public class FileIO {

	private static String fileName = "data";

	/**
	 * Method to save a Model object to a binary file.
	 * 
	 * @param model model object to save.
	 */
	public static void saveToBin(Model model) {
		ObjectOutputStream out = null;

		try {
			File file = new File(fileName);
			FileOutputStream fos = new FileOutputStream(file);
			out = new ObjectOutputStream(fos);
			out.writeObject(model);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Method to load a Model from a binary file.
	 * 
	 * @return the model loaded from the binary file.
	 */
	public static Model loadFromBin() {
		ObjectInputStream in = null;
		Model model = new Model();

		File file = new File(fileName);

		if (!file.exists()) {
			return model;
		} else {

			try {
				FileInputStream fis = new FileInputStream(file);
				in = new ObjectInputStream(fis);
				model = (Model) in.readObject();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			return model;
		}
	}

}
