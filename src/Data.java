import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Data {
	public static List<Categories> categoriess = new ArrayList<>();
	public static List<Product> productt = new ArrayList<>();
	
	public static void writeCategoriess() {
		File f = new File("C:\\Users\\TO THICH CAU\\eclipse-workspace\\demo\\Categories.txt");
		try {
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(categoriess);
			fos.close();
			oos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void readCategoriess() {
		File f = new File("C:\\Users\\TO THICH CAU\\eclipse-workspace\\demo\\Categories.txt");
		try {
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			categoriess = (List<Categories>) ois.readObject();
			for (Categories categories : categoriess) {
				System.out.println(categories);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void writeProduct() {
		File f = new File("C:\\Users\\TO THICH CAU\\eclipse-workspace\\demo\\Product.txt");
		try {
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(productt);
			fos.close();
			oos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void readProduct() {
		File f = new File("C:\\Users\\TO THICH CAU\\eclipse-workspace\\demo\\Product.txt");
		try {
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			productt = (List<Product>) ois.readObject();
			for (Product product : productt) {
				System.out.println(productt);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
