package Functionality;

import java.io.*;

import view.Model;

public class FileIO {

	private static String fileName = "data";

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
