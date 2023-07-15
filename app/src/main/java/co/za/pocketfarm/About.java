package co.za.pocketfarm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Objects;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        setTitle("About");

        String appVersion = "1.0.0_dev";
        TextView tvBuildVersionNumber = findViewById(R.id.tvBuildVersionNumber);
        tvBuildVersionNumber.setText(appVersion);

    }

    public void backToMainPage(){
        startActivity(new Intent(this, MainActivity.class));
        finishAffinity();
    }

    @Override
    public void onBackPressed() {
        backToMainPage();
    }

    @Override
    public boolean onSupportNavigateUp() {
        backToMainPage();
        return true;
    }
}