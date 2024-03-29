package products;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class StockManagerSingleton {
    ArrayList<MediaProduct> productList = new ArrayList<MediaProduct>();

    private static String inventoryFilePath = "src/products/inventory.csv";

    public boolean initializeStock() {
        try {
            Scanner fileIn = new Scanner(new FileInputStream(inventoryFilePath));
            fileIn.nextLine();

            while (fileIn.hasNextLine()) {
                String[] fields = fileIn.nextLine().split(",");
                String type = fields[0];
                String title = fields[1];
                double price = Double.parseDouble(fields[2]);
                int year = Integer.parseInt(fields[3]);
                Genre genre = Genre.valueOf(fields[4]);
                MediaProduct product;
                switch (type) {
                    case "CD":
                        product = new CDRecordProduct(title, price, year, genre);
                        break;
                    case "Tape":
                        product = new TapeRecordProduct(title, price, year, genre);
                        break;
                    case "Vinyl":
                        product = new VinylRecordProduct(title, price, year, genre);
                        break;
                    default:
                        continue;
                }
                product.setType(type);
                productList.add(product);
            }
            fileIn.close();
            return true;
        } catch (FileNotFoundException e) {
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
        if (product == null) {
            return false;
        }
        productList.add(product);
        return true;
    }

    public boolean removeItem(MediaProduct product) {
        int index = 0;
        for (MediaProduct i : productList) {
            System.out.println(i.toString());
            if (product.genre == i.genre && product.price == i.price && product.title == i.title && product.year == i.year) {
                productList.remove(index);
                return true;
            }
            index++;
        }
        return false;
    }

    public ArrayList<MediaProduct> getMediaProductBelowPrice(int maxPrice) {
        ArrayList<MediaProduct> mediaBelowPrice = new ArrayList<MediaProduct>();

        for (MediaProduct product : productList) {
            if (product.price < maxPrice) {
                mediaBelowPrice.add(product);
                System.out.println(product.toString());
            }
        }
        return mediaBelowPrice;
    }

    public boolean saveStock() {
        try (FileWriter writer = new FileWriter(inventoryFilePath)) {
            String[] headers = { "Type", "Title", "Price", "Year", "Genre" };
            for (int i = 0; i < headers.length; i++) {
                writer.append(headers[i]);
                if (i < headers.length - 1) {
                    writer.append(", ");
                }
            }
            writer.append(System.getProperty("line.separator"));

            for (MediaProduct product : productList) {
                if (product instanceof CDRecordProduct) {
                    writer.write("CD, " + product.getTitle() + "," + product.getPrice() + "," + product.getYear()
                            + "," + product.getGenre() + System.getProperty("line.separator"));
                } else if (product instanceof TapeRecordProduct) {
                    writer.write("Tape," + product.getTitle() + "," + product.getPrice() + "," + product.getYear()
                            + "," + product.getGenre() + System.getProperty("line.separator"));
                } else {
                    writer.write("Vinyl," + product.getTitle() + "," + product.getPrice() + "," + product.getYear()
                            + "," + product.getGenre() + System.getProperty("line.separator"));
                }
            }
            return true;
        } catch (IOException e) {
            System.out.println("An error has occurred");
            e.printStackTrace();
            return false;
        }
    }

    public void printListOfMediaProduct(ArrayList<MediaProduct> productList) {
        for (MediaProduct i : productList) {
            System.out.println(i.toString());
        }
    }

    public ArrayList<VinylRecordProduct> getVinylRecordList(ArrayList<MediaProduct> productList) {
        ArrayList<VinylRecordProduct> vinylRecordList = new ArrayList<>();
        for (MediaProduct product : productList) {
        	if ("Vinyl".equals(product.getType())) {
                if (product instanceof VinylRecordProduct) {
                    vinylRecordList.add((VinylRecordProduct) product);
                }
            }
        }
        return vinylRecordList;
    }

    public ArrayList<CDRecordProduct> getCDRecordList(ArrayList<MediaProduct> productList) {
        ArrayList<CDRecordProduct> CDRecordList = new ArrayList<>();
        for (MediaProduct product : productList) {
        	if ("CD".equals(product.getType())) {
                if (product instanceof CDRecordProduct) {
                    CDRecordList.add((CDRecordProduct) product);
                }
            }
        }
        return CDRecordList;
    }

    public ArrayList<TapeRecordProduct> getTapeRecordList(ArrayList<MediaProduct> productList) {
        ArrayList<TapeRecordProduct> TapeRecordList = new ArrayList<>();
        for (MediaProduct product : productList) {
        	if ("Tape".equals(product.getType())) {
                if (product instanceof TapeRecordProduct) {
                    TapeRecordList.add((TapeRecordProduct) product);
                }
            }
        }
        return TapeRecordList;
    }
}



	
