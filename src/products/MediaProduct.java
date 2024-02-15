package products;

public class MediaProduct {
	protected String title;
	protected double price;
	protected int year;
	protected Genre genre;
	protected String type;
	
	public MediaProduct(String title, double price, int year, Genre genre) {
		this.title = title;
		this.price = price;
		this.year = year;
		this.genre = genre;
	}
	
	public MediaProduct(MediaProduct mediaproduct) {
		this.title = mediaproduct.getTitle();
		this.price = mediaproduct.getPrice();
		this.year = mediaproduct.getYear();
		this.genre = mediaproduct.getGenre();
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
   public String toString() {
       return "Title: " + title + ", Price: " + price + ", Year: " + year + ", Genre: " + genre;
   }
}