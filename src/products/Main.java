package products;

import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		
		   StockManagerSingleton initialize = new StockManagerSingleton();
		   
		   // Read product data from a file and initialize Product objects.
		   boolean test = initialize.initializeStock();
		   
		   //Show if the test failed or succeeded.
		   System.out.println("Test: " + test);
		   
		   //Print out products.
		   for(MediaProduct i : initialize.productList) {
				System.out.println(i.toString());
			}
		   
		   //Update the price of the first object in the productList
		   MediaProduct updatedProduct = initialize.productList.get(0);
		   initialize.updateItemPrice(updatedProduct, 27.99);
		   

		   MediaProduct item = new MediaProduct("Test", 100.0, 1999, Genre.ROCK);
		   
		   boolean test2 = initialize.addItem(item);
		   
		   //Show if the test failed or succeeded.
		   System.out.println("Test2: " + test2);
		   
		   for(MediaProduct i : initialize.productList) {
				System.out.println(i.toString());
			}
		   
		   boolean test3 = initialize.removeItem(item);
		   
		   //Show if the test failed or succeeded.
		   System.out.println("Test3: " + test3);
		   
		   for(MediaProduct i : initialize.productList) {
				System.out.println(i.toString());
<<<<<<< HEAD
			}
		   
		   int maxPrice = 50;
		   getMediaProductBelowPrice(maxPrice);
		   
		   for(MediaProduct i : initialize.mediaBelowPrice) {
				System.out.println(i.toString());
		   }
=======
		   }
		   
		   
>>>>>>> branch 'main' of https://github.com/petbz6/G-CS3330-Hw3.git
	}
}

