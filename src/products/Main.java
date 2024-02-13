package products;

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
		   		   
		   MediaProduct item = new MediaProduct("Test", 100.0, 1999, Genre.ROCK);
		   
		   boolean test2 = initialize.addItem(item);
		   
		   //Show if the test failed or succeeded.
		   System.out.println("Test2: " + test2);
		   
		   for(MediaProduct i : initialize.productList) {
				System.out.println(i.toString());
			}
	}
}
