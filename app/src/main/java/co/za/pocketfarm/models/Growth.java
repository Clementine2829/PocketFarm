package co.za.pocketfarm.models;

public class Growth {
    private final String id;
    private final int imageView;
    private final String farmName;
    private final String description;
    private final int farmStatus;

    public Growth(String id, int imageView, String farmName, String description, int farmStatus) {
        this.id = id;
        this.imageView = imageView;
        this.farmName = farmName;
        this.description = description;
        this.farmStatus = farmStatus;
    }

    public String getId() {
        return id;
    }

    public int getImageView() {
        return imageView;
    }

    public String getFarmName() {
        return farmName;
    }

    public String getDescription() {
        return description;
    }

    public int getFarmStatus() {
        return farmStatus;
    }
}
