package co.za.pocketfarm.adaptors;

import static co.za.pocketfarm.Catalog.context;
import static co.za.pocketfarm.Catalog.items;
import static co.za.pocketfarm.Catalog.labelAddCard;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import co.za.pocketfarm.Catalog;
import co.za.pocketfarm.R;
import co.za.pocketfarm.models.CatalogItems;

public class CatalogAdaptor extends RecyclerView.Adapter<CatalogAdaptor.CatalogViewHolder> {

    private List<CatalogItems> itemsInCart;

    public CatalogAdaptor(List<CatalogItems> itemsInCart) {
        this.itemsInCart = itemsInCart;
    }

    @NonNull
    @Override
    public CatalogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.catalog_iterm,
                parent,
                false);
        return new CatalogViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatalogViewHolder holder, int position) {
        CatalogItems catalogItem = itemsInCart.get(position);
        holder.btnAddToCart.setOnClickListener(view -> {
            items++;
            if(labelAddCard != null && items > 0){
                String tempLabel = "Checkout items in cart (" + items + ")";
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
            holder.btnAddToCart.setVisibility(View.GONE);
        });
        holder.imageView.setImageResource(catalogItem.getImageView());
        holder.title.setText(catalogItem.getTitle());
        holder.miniDescription.setText(catalogItem.getMiniDescription());
        holder.description.setText(catalogItem.getDescription());
        holder.price.setText(catalogItem.getPrice());
    }

    @Override
    public int getItemCount() {
        return itemsInCart.size();
    }

    public static class CatalogViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public TextView title, miniDescription, description, price;
        public Button btnAddToCart;

        public CatalogViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.imgCatalog);
            this.title = itemView.findViewById(R.id.title);
            this.miniDescription = itemView.findViewById(R.id.miniDescription);
            this.description = itemView.findViewById(R.id.description);
            this.price = itemView.findViewById(R.id.price);
            this.btnAddToCart = itemView.findViewById(R.id.btnAddToCart);
        }
    }

}
