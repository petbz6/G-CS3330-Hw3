package products;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;

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
	
	public boolean updateItemPrice(MediaProduct product, double newPrice) {
	    for (MediaProduct item : productList) {
	        if (item.equals(product)) {
	            item.setPrice(newPrice);
	            return true;
	        }
	    }
	    return false;
	}
	
	public boolean addItem(MediaProduct product) {
		if(product == null) {
			return false;
		}
		productList.add(product);
		return true;
	}
	
	public boolean removeItem(MediaProduct product) {
		int index = 0;
		for(MediaProduct i : productList) {
			System.out.println(i.toString());
			if(product.genre == i.genre && product.price == i.price && product.title == i.title && product.year == i.year) {
				productList.remove(index);
				return true;
			}
			index++;
		}
		return false;
	}
	
	public boolean savestock() {
		try {
			FileWriter writer = new FileWriter(inventoryFilePath);
			for(MediaProduct product: productList) {
				  writer.write(product + System.lineSeparator());
				}
			writer.close();
			return true;
		}catch (FileNotFoundException e) {
			System.out.println("An error has occurred. File not found.");
			return false;
		}
		
	}
	
	public ArrayList<MediaProduct> getMediaProductBelowPrice(int maxPrice){
		ArrayList<MediaProduct>mediaBelowPrice = new ArrayList<MediaProduct>();
		for (MediaProduct product :productList) {
			if(product.price < maxPrice) {
				mediaBelowPrice.add(product);
			}
		}
		return mediaBelowPrice;
	}
	
}