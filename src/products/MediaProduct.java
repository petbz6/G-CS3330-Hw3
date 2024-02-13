package products;

public class MediaProduct {
	protected String title;
	protected double price;
	protected int year;
	protected Genre genre;
	
	public MediaProduct(String title, double price, int year, Genre genre) {
		this.title = title;
		this.price = price;
		this.year = year;
		this.genre = genre;
	}
	
	public MediaProduct(MediaProduct mediaproduct) {
		this.title = mediaproduct.title;
		this.price = mediaproduct.price;
		this.year = mediaproduct.year;
		this.genre = mediaproduct.genre;
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

	@Override
   public String toString() {
       return "Title: " + title + ", Price: " + price + ", Year: " + year + ", Genre: " + genre;
   }
}