package co.za.pocketfarm.adaptors;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;

import java.text.DecimalFormat;
import java.util.List;

import co.za.pocketfarm.R;
import co.za.pocketfarm.models.CatalogItems;

public class CheckoutAdaptor extends RecyclerView.Adapter<CheckoutAdaptor.CheckoutViewHolder> {

    private final List<CatalogItems> checkoutItems;
    private String price;

    public CheckoutAdaptor(List<CatalogItems> checkoutItems) {
        this.checkoutItems = checkoutItems;
        price = "0.00";
    }

    @NonNull
    @Override
    public CheckoutViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.checkout_item_two,
                parent,
                false);
        return new CheckoutViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CheckoutViewHolder holder, int position) {
        CatalogItems checkoutItem = checkoutItems.get(position);
        changeQuantity("", checkoutItem);
        holder.btnAdd.setOnClickListener(view -> {
            changeQuantity("add", checkoutItem);
            holder.quantity.setText(String.valueOf(checkoutItem.getQuantity()));
            holder.price.setText(String.valueOf(price));
        });
        holder.btnMinus.setOnClickListener(view -> {
            changeQuantity("minus", checkoutItem);
            holder.quantity.setText(String.valueOf(checkoutItem.getQuantity()));
            holder.price.setText(String.valueOf(price));
        });
        System.out.println("\ncheckoutItem: " + checkoutItem);
        if(position != 0) holder.qty.setVisibility(View.INVISIBLE);
        holder.title.setText(checkoutItem.getTitle());
        String tempDescription = (checkoutItem.getDescription().length() < 40) ?
                                    checkoutItem.getDescription() :
                                    checkoutItem.getDescription().substring(0, 38) + "...";
        holder.description.setText(tempDescription);
        holder.price.setText(String.valueOf(price));
        holder.quantity.setText(String.valueOf(checkoutItem.getQuantity()));
    }

    @Override
    public int getItemCount() {
        return checkoutItems.size();
    }
    private void changeQuantity(String action, CatalogItems checkoutItem){
        double tempPrice = (checkoutItem.getSpecial() == 0.00) ? checkoutItem.getPrice() : checkoutItem.getSpecial();
        double _price = 0.00;
        if(action.equals("add")){
            if(checkoutItem.getQuantity() >= 0){
                checkoutItem.setQuantity(checkoutItem.getQuantity()+1);
                _price = tempPrice * checkoutItem.getQuantity();
            }
        }else if(action.equals("minus")){
            if(checkoutItem.getQuantity() > 0){
                checkoutItem.setQuantity(checkoutItem.getQuantity()-1);
                _price = tempPrice * checkoutItem.getQuantity();
            }
        }else{
            _price = tempPrice;
        }
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        price = String.valueOf(Double.parseDouble(decimalFormat.format(_price)));

        String [] _p = price.split("\\.");
        if(_p[1].length() != 2){
            _p[1] = "0" + _p[1];
        }
        price = (checkoutItem.getQuantity() == 1) ? _p[0] + "." + _p[1] : tempPrice + " * " + checkoutItem.getQuantity() + " = " + _p[0] + "." + _p[1];
    }

    public static class CheckoutViewHolder extends RecyclerView.ViewHolder{
        public TextView title, description, price, qty, btnAdd, quantity, btnMinus;

        public CheckoutViewHolder(@NonNull View itemView) {
            super(itemView);
            this.title = itemView.findViewById(R.id.itemName);
            this.description = itemView.findViewById(R.id.itemDescription);
            this.price = itemView.findViewById(R.id.totalPrice);
            this.qty = itemView.findViewById(R.id.qty);
            this.btnAdd = itemView.findViewById(R.id.btnAdd);
            this.quantity = itemView.findViewById(R.id.quantity);
            this.btnMinus = itemView.findViewById(R.id.btnMinus);
        }
    }
}
