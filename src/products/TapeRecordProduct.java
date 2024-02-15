package products;

public class TapeRecordProduct extends MediaProduct{
	
	public TapeRecordProduct(String title, double price, int year, Genre genre) {
		
		super(title, price, year, genre);
	}
	
	public TapeRecordProduct(TapeRecordProduct tapeRecordProduct) {
		super(tapeRecordProduct.getTitle(),
	          tapeRecordProduct.getPrice(),
	          tapeRecordProduct.getYear(),
	          tapeRecordProduct.getGenre()
	        );
	}
}

