package co.za.pocketfarm.models;

public class Notifications {
    private final int image;
    private final String tempStatus;
    private final String farmName;
    private final String weatherTemperature;


    public Notifications(int image, String tempStatus, String farmName, String weatherTemperature) {
        this.image = image;
        this.tempStatus = tempStatus;
        this.farmName = farmName;
        this.weatherTemperature = weatherTemperature;
    }

    public int getImage() {
        return image;
    }

    public String getFarmName() {
        return (farmName.length() < 10) ? farmName : farmName.substring(0, 8) + "..";
    }

    public String getTempStatus() {
        return tempStatus;
    }

    public String getWeatherTemperature() {
        return weatherTemperature;
    }
}
