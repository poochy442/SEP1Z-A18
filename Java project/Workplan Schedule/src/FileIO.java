import java.io.*;

public class FileIO {

	private static String fileName;

	public static void saveToBin(Object obj) {
		ObjectOutputStream out = null;

		try {
			File file = new File(fileName);
			FileOutputStream fos = new FileOutputStream(file);
			out = new ObjectOutputStream(fos);

			out.writeObject(obj);
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

	public static Object loadFromBin() {
		ObjectInputStream in = null;
		Object obj = null;
		
		try {
			File file = new File(fileName);
			FileInputStream fis = new FileInputStream(file);
			in = new ObjectInputStream(fis);
			
			obj = (Object) in.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return obj;
	}

}
