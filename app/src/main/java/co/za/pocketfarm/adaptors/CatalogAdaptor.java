package co.za.pocketfarm.adaptors;

import static co.za.pocketfarm.Catalog.context;
import static co.za.pocketfarm.Catalog.displayCartHeading;
import static co.za.pocketfarm.Catalog.items;
import static co.za.pocketfarm.Catalog.labelAddCard;
import static co.za.pocketfarm.Catalog.selectedItems;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.StrikethroughSpan;
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

import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;
import java.util.List;

import co.za.pocketfarm.Catalog;
import co.za.pocketfarm.R;
import co.za.pocketfarm.models.CatalogItems;

public class CatalogAdaptor extends RecyclerView.Adapter<CatalogAdaptor.CatalogViewHolder> {

    private final List<CatalogItems> itemsInCart;

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
            displayCartHeading();
            holder.btnAddToCart.setBackgroundColor(Color.GRAY);
            holder.btnAddToCart.setClickable(false);
            addItemInSelectedItems(selectedItems, catalogItem);
        });
        holder.imageView.setImageResource(catalogItem.getImageView());
        holder.title.setText(catalogItem.getTitle());
        holder.miniDescription.setText(catalogItem.getMiniDescription());
        holder.description.setText(catalogItem.getDescription());
        if(catalogItem.getSpecial() != 0.00){
            Spannable spannable = new SpannableString("R " + catalogItem.getPrice());
            spannable.setSpan(new StrikethroughSpan(), 0, String.valueOf(catalogItem.getPrice()).length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            holder.price.setText(spannable);
            holder.price.setTextColor(Color.RED);
            holder.special.setText(String.format("R %s", catalogItem.getSpecial()));
        }else{
            holder.price.setText(String.format("R %s", catalogItem.getPrice()));
            holder.special.setVisibility(View.GONE);
        }
    }

    private void addItemInSelectedItems(List<CatalogItems> selectedItems, CatalogItems catalogItem) {
        boolean itemExistInList = false;
        for (CatalogItems obj : selectedItems) {
            if (obj.getId().equals(catalogItem.getId())) {
                obj.setQuantity(obj.getQuantity()+1);
                itemExistInList = true;
            }
        }
        if(!itemExistInList) selectedItems.add(catalogItem);
    }

    @Override
    public int getItemCount() {
        return itemsInCart.size();
    }

    public static class CatalogViewHolder extends RecyclerView.ViewHolder{
        public ShapeableImageView imageView;
        public TextView title, miniDescription, description, price, special;
        public Button btnAddToCart;

        public CatalogViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.imgCatalog);
            this.title = itemView.findViewById(R.id.title);
            this.miniDescription = itemView.findViewById(R.id.miniDescription);
            this.description = itemView.findViewById(R.id.description);
            this.price = itemView.findViewById(R.id.price);
            this.special = itemView.findViewById(R.id.special);
            this.btnAddToCart = itemView.findViewById(R.id.btnAddToCart);
        }
    }

}
