package co.za.pocketfarm;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import co.za.pocketfarm.adaptors.CatalogAdaptor;
import co.za.pocketfarm.models.CatalogItems;

public class Catalog extends AppCompatActivity {

    public static boolean cartIsEmpty = true;
    public static List<CatalogItems> itemsInCart = new ArrayList<>();
    public static TextView labelAddCard = null;
    public static int items = 0;
    public static Context context;

    AlertDialog.Builder dialogBuilder;
    AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        setTitle("Shop for Remedies");

        context = this;
        labelAddCard = findViewById(R.id.labelAddCard);
        labelAddCard.setOnClickListener(view -> {
            if(items > 0){
                loadCheckoutPage();
            }else{
                Toast.makeText(this, "Cart is empty. Please shop some remedies", Toast.LENGTH_SHORT).show();
            }
        });

        itemsInCart.add(
                new CatalogItems(
                        "1",
                        R.drawable.img1,
                        "Plant 1",
                        "place on the sun",
                        "Lorem ipsum dolor sit amet sint elit tempor laborum ullamco exercitation dolor in culpa nulla sunt irure dolor enim nulla",
                        "R 150.00"));
        itemsInCart.add(
                new CatalogItems(
                        "1",
                        R.drawable.img1,
                        "Plant 1",
                        "place on the sun",
                        "Lorem ipsum dolor sit amet sint elit tempor laborum ullamco exercitation dolor in culpa nulla sunt irure dolor enim nulla",
                        "R 150.00"));
        itemsInCart.add(
                new CatalogItems(
                        "1",
                        R.drawable.img1,
                        "Plant 1",
                        "place on the sun",
                        "Lorem ipsum dolor sit amet sint elit tempor laborum ullamco exercitation dolor in culpa nulla sunt irure dolor enim nulla",
                        "R 150.00"));
        itemsInCart.add(
                new CatalogItems(
                        "1",
                        R.drawable.img1,
                        "Plant 1",
                        "place on the sun",
                        "Lorem ipsum dolor sit amet sint elit tempor laborum ullamco exercitation dolor in culpa nulla sunt irure dolor enim nulla",
                        "R 150.00"));
        itemsInCart.add(
                new CatalogItems(
                        "1",
                        R.drawable.img1,
                        "Plant 1",
                        "place on the sun",
                        "Lorem ipsum dolor sit amet sint elit tempor laborum ullamco exercitation dolor in culpa nulla sunt irure dolor enim nulla",
                        "R 150.00"));

        RecyclerView recyclerView = findViewById(R.id.catalogList);
        CatalogAdaptor adaptor = new CatalogAdaptor(itemsInCart);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adaptor);

    }

    private void loadCheckoutPage(){
        dialogBuilder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.checkout_page, null);

        dialogBuilder.setView(view);
        dialog = dialogBuilder.create();
        dialog.show();
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity.class));
        finishAffinity();
    }
}