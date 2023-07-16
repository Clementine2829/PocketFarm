package co.za.pocketfarm.models;

public class TipsOrNotifications {
    private final int image;
    private final String text1;
    private final String text2;
    private final String text3;


    public TipsOrNotifications(int image, String text1, String text2, String text3) {
        this.image = image;
        this.text1 = text1;
        this.text2 = text2;
        this.text3 = text3;
    }

    public int getImage() {
        return image;
    }

    public String getText1() {
        return text1;
    }

    public String getText2() {
        return text2;
    }

    public String getText3() {
        return text3;
    }
}
