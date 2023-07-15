package co.za.pocketfarm.models;

public class Tips {
    private final int image;
    private final String title;
    private final String author;
    private final String dateUpdated;


    public Tips(int image, String title, String author, String dateUpdated) {
        this.image = image;
        this.title = title;
        this.author = author;
        this.dateUpdated = dateUpdated;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return (title.length() < 50) ? title : title.substring(0, 50) + "...";
    }

    public String getAuthor() {
        return author;
    }
    public String getDateUpdated() {
        return dateUpdated;
    }
}
