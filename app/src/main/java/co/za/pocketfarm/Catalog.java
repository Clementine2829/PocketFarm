package co.za.pocketfarm;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import co.za.pocketfarm.adaptors.CatalogAdaptor;
import co.za.pocketfarm.adaptors.CheckoutAdaptor;
import co.za.pocketfarm.models.CatalogItems;

public class Catalog extends AppCompatActivity {

    public static boolean cartIsEmpty = true;
    public static List<CatalogItems> itemsInCart = new ArrayList<>();
    public static List<CatalogItems> selectedItems = new ArrayList<>();
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
        displayCartHeading();
        labelAddCard.setOnClickListener(view -> {
            if(items > 0){
                loadCheckoutPage();
            }else{
                Toast.makeText(this, "Cart is empty. Please shop some remedies", Toast.LENGTH_SHORT).show();
            }
        });


        CatalogItems i =  new CatalogItems(
                "1",
                R.drawable.img6,
                "Organic Fertilizers",
                "place on the sun",
                "Organic fertilizers, such as compost or well-rotted manure, provide essential nutrients to plants without harmful chemicals.",
                150.00);
        i.setSpecial(100.00);
        itemsInCart.add(i);
        itemsInCart.add(
                new CatalogItems(
                        "2",
                        R.drawable.img7,
                        "Neem Oil",
                        "place on the sun",
                        "Neem oil is a natural pesticide and fungicide that can help control various pests like aphids, mites, and whiteflies. It is safe for many plants and won't harm beneficial insect",
                        36.45));
        itemsInCart.add(
                new CatalogItems(
                        "3",
                        R.drawable.img8,
                        "Insecticidal Soaps",
                        "place on the sun",
                        "Insecticidal soaps are a safe and effective option for controlling soft-bodied insects like aphids, mealybugs, and spider mites",
                        99.99));
        itemsInCart.add(
                new CatalogItems(
                        "4",
                        R.drawable.img9,
                        "Copper-based Fungicides",
                        "place on the sun",
                        "Copper-based fungicides are used to prevent and control fungal diseases on plants. They are relatively safe when used according to the instructions",
                        98.45));
        itemsInCart.add(
                new CatalogItems(
                        "5",
                        R.drawable.img10,
                        "Epsom Salt",
                        "place on the sun",
                        "Epsom salt (magnesium sulfate) can be used as a supplement to provide magnesium to plants that require it",
                        366.00));

        RecyclerView recyclerView = findViewById(R.id.catalogList);
        CatalogAdaptor adaptor = new CatalogAdaptor(itemsInCart);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adaptor);

    }

    public static void displayCartHeading(){
        if(labelAddCard != null && items > 0){
            String tempLabel = items + ((items == 1) ? " item" : " items ") + " in cart. \nClick here to checkout";
            labelAddCard.setText(tempLabel);
            labelAddCard.setTextColor(Color.RED);

            Drawable drawable = ContextCompat.getDrawable(context, R.drawable.ic_cart_checkout);
            // Set the drawable to the left of the text
            labelAddCard.setCompoundDrawables(drawable, null, null, null);
        }else{
            String tempLabel = "Cart is empty, shop some remedies";
            assert labelAddCard != null;
            labelAddCard.setText(tempLabel);
            labelAddCard.setTextColor(Color.rgb(51, 204, 51 ));

            Drawable drawable = ContextCompat.getDrawable(context, R.drawable.ic_add_cart);
            // Set the drawable to the left of the text
            labelAddCard.setCompoundDrawables(drawable, null, null, null);
        }

    }
    private void loadCheckoutPage(){
        dialogBuilder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.checkout_page, null);

        System.out.println(selectedItems);
        RecyclerView recyclerView = view.findViewById(R.id.checkoutList);
        CheckoutAdaptor adaptor = new CheckoutAdaptor(selectedItems);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adaptor);

        view.findViewById(R.id.btnCheckout).setOnClickListener(view1 -> {
            StringBuilder message = new StringBuilder("The following items have zero quantity: ");
            boolean zeroQuantity = false;
            int index = 1;
            for (CatalogItems item: selectedItems) {
                if(item.getQuantity() == 0){
                    message.append("\n").append(index).append(". ").append(item.getTitle());
                    zeroQuantity = true;
                }
            }
            message.append("\nDo you want to continue? ");
            if(zeroQuantity){
                confirm(message.toString());
            }else{
                checkout();
            }
        });

        dialogBuilder.setView(view);
        dialog = dialogBuilder.create();
        dialog.show();
    }

    private void confirm(String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirm");
        builder.setMessage(message);
        builder.setPositiveButton("Yes", (dialog, which) -> checkout());
        builder.setNeutralButton("Cancel", (dialog, which) ->{});
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    private void checkout(){
        startActivity(new Intent(this, Checkout.class));
        finish();
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity.class));
        finishAffinity();
    }
}