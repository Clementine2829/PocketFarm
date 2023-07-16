package co.za.pocketfarm;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import co.za.pocketfarm.adaptors.TipsAndNotificationsAdaptor;
import co.za.pocketfarm.fragmenets.NotificationsFragment;
import co.za.pocketfarm.fragmenets.TipsFragment;
import co.za.pocketfarm.models.ObjectTypes;
import co.za.pocketfarm.models.Tips;
import co.za.pocketfarm.models.TipsOrNotifications;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnItemSelectedListener {

    private EditText searchEditText;
    AlertDialog.Builder dialogBuilder;
    AlertDialog dialog;

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

        displayFragment(R.id.displayTipsFragment, new TipsFragment());
        System.out.println("Notificatoips");
        displayFragment(R.id.displayNotificationsFragment, new NotificationsFragment());



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

    private void displayFragment(int displayer, Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(displayer, fragment).commit();
    }
    private void performSearch(String query) {

    }
    private void about() {
        startActivity(new Intent(this, About.class));
        finishAffinity();
    }
    private void disclaimer() {
        startActivity(new Intent(this, Disclaimer.class));
        finishAffinity();
    }
    private void logout() {
        // todo
        // clear everything before redirecting
        startActivity(new Intent(this, Login.class));
        finishAffinity();
    }
    private void launchCamera(){

        dialogBuilder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.image_picker, null);

        view.findViewById(R.id.cameraPlants).setOnClickListener(view1 -> {
            startActivity(new Intent(this, ScanItem.class));
            finish();
        });
        view.findViewById(R.id.cameraPlants).setOnClickListener(view1 -> {
            startActivity(new Intent(this, ScanItem.class));
            finish();
        });

        dialogBuilder.setView(view);
        dialog = dialogBuilder.create();
        dialog.show();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
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
            launchCamera();
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
        int itemId = item.getItemId();
        if (itemId == android.R.id.home) {
            // Handle the Up button (back button) click here
            finish();
            return true;
        }else if(itemId == R.id.menu_about){
            about();
        }else if(itemId == R.id.menu_disclaimer){
            disclaimer();
        }else if(itemId == R.id.menu_logout) {
            logout();
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
