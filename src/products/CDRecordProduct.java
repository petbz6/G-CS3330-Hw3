package products;

public class CDRecordProduct extends MediaProduct {
	
	public CDRecordProduct(String title, double price, int year, Genre genre) {
		
		super(title, price, year, genre);
	}
	
	public CDRecordProduct(CDRecordProduct cdRecordProduct) {
		super(cdRecordProduct.getTitle(),
	          cdRecordProduct.getPrice(),
	          cdRecordProduct.getYear(),
	          cdRecordProduct.getGenre()
	        );
	}
}
