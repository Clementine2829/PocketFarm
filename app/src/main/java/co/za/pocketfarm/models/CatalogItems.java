package co.za.pocketfarm.models;

public class CatalogItems {

    private final String id;
    private final int imageView;
    private final String title;
    private final String miniDescription;
    private final String description;
    private final double price;
    private double special = 0.00;
    private int quantity = 1;

    public CatalogItems(String id, int imageView, String title, String miniDescription, String description, double price) {
        this.id = id;
        this.imageView = imageView;
        this.title = title;
        this.miniDescription = miniDescription;
        this.description = description;
        this.price = price;;
    }

    public String getId() {
        return id;
    }

    public int getImageView() {
        return imageView;
    }

    public String getTitle() {
        return title;
    }

    public String getMiniDescription() {
        return miniDescription;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getSpecial() {
        return special;
    }

    public void setSpecial(double special) {
        this.special = special;
    }

    @Override
    public String toString() {
        return "CatalogItems{" +
                "id='" + id + '\'' +
                ", imageView=" + imageView +
                ", title='" + title + '\'' +
                ", miniDescription='" + miniDescription + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", special='" + special + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
