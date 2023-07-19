package co.za.pocketfarm.models;

public class Orders {
    private final String id;
    private final int imageId;
    private final String orderNumber;
    private final String numberOfItems;
    private final String totalAmount;

    public Orders(String id, int imageId, String orderNumber, String numberOfItems, String totalAmount) {
        this.id = id;
        this.imageId = imageId;
        this.orderNumber = orderNumber;
        this.numberOfItems = numberOfItems;
        this.totalAmount = totalAmount;
    }

    public String getId() {
        return id;
    }

    public int getImageId() {
        return imageId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public String getNumberOfItems() {
        return numberOfItems;
    }

    public String getTotalAmount() {
        return totalAmount;
    }
}
