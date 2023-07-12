package co.za.pocketfarm;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Objects.requireNonNull(this.getSupportActionBar()).setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.nav_header);
//        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.GRAY));
        //getSupportActionBar().setElevation(0);
        View view = getSupportActionBar().getCustomView();
        TextView name = view.findViewById(R.id.name);
        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "You have clicked on the tittle", Toast.LENGTH_LONG).show();
            }
        });





        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.navigation_home) {
            // Handle Home item selection
            return true;
        } else if (itemId == R.id.navigation_scan) {
            startActivity(new Intent(this, ScanItem.class));
            finish();
            return true;
        } else if (itemId == R.id.navigation_notifications) {
            // Handle Notifications item selection
            return true;
        }
        return false;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            // Handle the Up button (back button) click here
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        AlertDialog.Builder confirm = new AlertDialog.Builder(this);
        confirm.setTitle("Alert");
        confirm.setMessage("This action will close the app. Are you sure you want to close the app?");
        confirm.setPositiveButton("Yes", (dialog1, which) -> finishAffinity());
        confirm.setNeutralButton("Cancel", (dialog1, which) -> {});
        AlertDialog alertDialog = confirm.create();
        alertDialog.show();
    }
}
