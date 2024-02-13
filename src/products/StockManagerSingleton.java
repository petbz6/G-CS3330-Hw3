package products;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class StockManagerSingleton {
	ArrayList<MediaProduct>productList = new ArrayList<MediaProduct>();
	
	private static String inventoryFilePath = "src/products/inventory.csv";
	
	public boolean initializeStock() {
		try {
			Scanner fileIn = new Scanner(new FileInputStream(inventoryFilePath));
			fileIn.nextLine();
			
			while (fileIn.hasNextLine()) {
				String[] fields = fileIn.nextLine().split(",");
				String title = fields[1];
				double price = Double.parseDouble(fields[2]);
				int year = Integer.parseInt(fields[3]);
				Genre genre = Genre.valueOf(fields[4]);
				
				MediaProduct product = new MediaProduct(title, price, year, genre);
				productList.add(product);
			}
			fileIn.close();
			return true;
		}catch (FileNotFoundException e) {
			System.out.println("An error has occurred. File not found.");
			return false;
		}
		
	}
	
	public boolean addItem(MediaProduct product) {
		if(product == null) {
			return false;
		}
		productList.add(product);
		return true;
	}
}