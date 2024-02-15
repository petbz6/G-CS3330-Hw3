package products;

import java.util.ArrayList;

public class Main {
    
    public static void main(String[] args) {
        
           StockManagerSingleton initialize = new StockManagerSingleton();
           
           // Read product data from a file and initialize Product objects.
           boolean test = initialize.initializeStock();
           //Show if the test failed or succeeded.
           System.out.println("Stock Initialization: " + test);
           
           //Update the price of the first media product in the productList
           MediaProduct updatedProduct = initialize.productList.get(0);
           initialize.updateItemPrice(updatedProduct, 27.99);
           
           //Add new media product to the inventory
           MediaProduct item = new MediaProduct("Test", 100.0, 1999, Genre.ROCK);
           boolean test2 = initialize.addItem(item);
           //Show if the test failed or succeeded.
           System.out.println("\nAdd Item: " + test2);
           
           
           //Remove media product from the inventory
           boolean test3 = initialize.removeItem(item);
           //Show if the test failed or succeeded.
           System.out.println("\nRemove Item: " + test3);
           
           //Add another new media product to demonstrate updated inventory
           MediaProduct item2 = new MediaProduct("Test2", 10.0, 2003, Genre.CLASSICAL);
           boolean test4 = initialize.addItem(item2);
           System.out.println("\nSecond Item Added: " + test4);
           
           //Save updated inventory back to CSV
           boolean test5 = initialize.saveStock();
           System.out.println("\nSave Stock: " + test5);
           
           //Get all media products below max price of 20
           ArrayList<MediaProduct> belowPrice20List = initialize.getMediaProductBelowPrice(20);
           System.out.println("\nMedia Products below $20:");
           for (MediaProduct product : belowPrice20List) {
               System.out.println(product.toString());
           }
           System.out.println("\n");
           
           //Print media product list
           System.out.println("Media Product List");
           initialize.printListOfMediaProduct(initialize.productList);

           //Print VinylRecordProduct array
		   ArrayList<VinylRecordProduct> vinylRecordList = initialize.getVinylRecordList(initialize.productList);
		   System.out.println("\nVinyl Record Products: ");
		    for (VinylRecordProduct vinylRecordProduct : vinylRecordList) {
		        System.out.println(vinylRecordProduct.toString());
		    }
		    
			//Print CDRecordProduct array
			ArrayList<CDRecordProduct> CDRecordList = initialize.getCDRecordList(initialize.productList);
			System.out.println("\nCD Record Products: ");
			for (CDRecordProduct CDRecordProduct : CDRecordList) {
				System.out.println(CDRecordProduct.toString());
				}
			
			//Print TapeRecordProduct array
			ArrayList<TapeRecordProduct> TapeRecordList = initialize.getTapeRecordList(initialize.productList);
			System.out.println("\nTape Record Products: ");
			for (TapeRecordProduct TapeRecordProduct : TapeRecordList) {
				System.out.println(TapeRecordProduct.toString());
				}
			}
}

