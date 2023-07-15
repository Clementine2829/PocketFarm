package co.za.pocketfarm;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import co.za.pocketfarm.adaptors.TipsAdaptor;
import co.za.pocketfarm.models.Tips;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnItemSelectedListener {

    private EditText searchEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Objects.requireNonNull(this.getSupportActionBar()).setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.nav_header);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.GRAY));
        //getSupportActionBar().setElevation(0);
        View view = getSupportActionBar().getCustomView();
        TextView name = view.findViewById(R.id.name);
        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "You have clicked on the tittle", Toast.LENGTH_LONG).show();
            }
        });



        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        // Set the orientation of the layout manager to horizontal
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        // Create and set the adapter
        List<Tips> tipsItems = new ArrayList<>();
        String title = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas";
        String dateUpdated = "17/07/2023";
        tipsItems.add(new Tips(R.drawable.img1, title, "Clement", dateUpdated));
        title = "Maecenas ut suscipit velit, sit amet viverra lectus. Vestibulum ante ipsum primis ";
        dateUpdated = "02/07/2023";
        tipsItems.add(new Tips(R.drawable.img2, title, "Bob Smith", dateUpdated));
        title = "Donec nec tellus eleifend, cursus nunc et, fermentum tellus. Phasellus sapien lacus, consequat";
        tipsItems.add(new Tips(R.drawable.img3, title, "Sophia Moore", dateUpdated));
        title = "Integer dolor elit, interdum nec posuere vel, laoreet non justo.";
        dateUpdated = "29/08/2023";
        tipsItems.add(new Tips(R.drawable.img4, title, "Jame", dateUpdated));
        title = "Donec nec tellus eleifend, cursus nunc et, fermentum tellus. Phasellus sapien lacus, consequat";
        tipsItems.add(new Tips(R.drawable.img5, title, "Clement", dateUpdated));


        TipsAdaptor adapter = new TipsAdaptor(tipsItems);
        recyclerView.setAdapter(adapter);


//        searchEditText = findViewById(R.id.searchEditText);
//        ImageView searchButton = findViewById(R.id.searchButton);
//
//        searchButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String searchQuery = searchEditText.getText().toString();
//                // Perform search or send data here
//                performSearch(searchQuery);
//            }
//        });


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(this);
    }

    private void performSearch(String query) {
        // Implement your search functionality here
        // You can start a new activity, show search results, etc.
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.navigation_home) {
            // Handle Home item selection
            return true;
        } else if (itemId == R.id.navigation_water_drop) {
            // Handle water drop item selection
            return true;
        } else if (itemId == R.id.navigation_scan) {
            startActivity(new Intent(this, ScanItem.class));
            finish();
            return true;
        } else if (itemId == R.id.navigation_notifications) {
            // Handle Notifications item selection
            return true;
        } else if (itemId == R.id.navigation_chat) {
            // Handle chat item selection
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
