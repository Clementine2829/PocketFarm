package co.za.pocketfarm;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentDate {
    public static String getCurrentDate(){
        Date currentDate = new Date();
        @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(currentDate);
    }
}
