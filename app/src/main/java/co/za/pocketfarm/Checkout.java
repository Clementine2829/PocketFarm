package co.za.pocketfarm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

import co.za.pocketfarm.fragmenets.CheckoutPageOne;
import co.za.pocketfarm.fragmenets.CheckoutPageThree;
import co.za.pocketfarm.fragmenets.CheckoutPageTwo;

public class Checkout extends AppCompatActivity {

    private int pageNumber;
    public static boolean proceed = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        setTitle("Checkout");

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            String values = extras.getString("data");
            values = values.substring(1, values.length() -1); //remove this chars [ ]

            String [] data = values.split(", \\[");

            if(data[0].equals("pageOne")) {
                pageNumber = 1;
                displayFragment(R.id.checkoutFragment, new CheckoutPageOne());
            }else if(data[0].equals("pageTwo")) {
                pageNumber = 2;
                displayFragment(R.id.checkoutFragment, new CheckoutPageTwo());
            }else if(data[0].equals("pageThree")) {
                pageNumber = 3;
                displayFragment(R.id.checkoutFragment, new CheckoutPageThree());
            }
        }else{
            displayFragment(R.id.checkoutFragment, new CheckoutPageOne());
            pageNumber = 1;
        }

        TextView strPageNumber = findViewById(R.id.pageNumber);
        strPageNumber.setText(String.format("Step %s of 3", pageNumber));

        strPageNumber.setVisibility(View.VISIBLE);
        Button btnCheckout = findViewById(R.id.btnCheckout);
        btnCheckout.setVisibility(View.VISIBLE);

        btnCheckout.setOnClickListener(view -> {
            if(!proceed) return;
            if(pageNumber == 1){
                pageNumber = 2;
                strPageNumber.setText(String.format("Step %s of 3", pageNumber));
                displayFragment(R.id.checkoutFragment, new CheckoutPageTwo());
            }else if(pageNumber == 2){
                pageNumber = 3;
                strPageNumber.setText(String.format("Step %s of 3", pageNumber));
                displayFragment(R.id.checkoutFragment, new CheckoutPageThree());
//            }else {
                strPageNumber.setVisibility(View.INVISIBLE);
                findViewById(R.id.btnCheckout).setVisibility(View.INVISIBLE);
            }


        });


    }

    private void displayFragment(int displayer, Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(displayer, fragment).commit();
    }

    @Override
    public void onBackPressed() {
//        if(pageNumber == 3){
//
//        }
//
        startActivity(new Intent(this, Catalog.class));
        finish();
    }
}