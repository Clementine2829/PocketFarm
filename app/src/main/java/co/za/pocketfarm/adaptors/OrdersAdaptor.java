package co.za.pocketfarm.adaptors;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.List;

import co.za.pocketfarm.R;
import co.za.pocketfarm.models.Orders;

public class OrdersAdaptor extends RecyclerView.Adapter<OrdersAdaptor.CatalogViewHolder> {

    private final List<Orders> orders;

    public OrdersAdaptor(List<Orders> orders) {
        this.orders = orders;
    }

    @NonNull
    @Override
    public CatalogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.order_item,
                parent,
                false);
        return new CatalogViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatalogViewHolder holder, int position) {
        Orders order = orders.get(position);
        holder.btnCheckOut.setOnClickListener(view -> {

        });
        holder.imageView.setImageResource(order.getImageId());
        holder.orderNumber.setText(String.format("Order # %s", order.getOrderNumber()));
        holder.numberOfItems.setText(order.getNumberOfItems());
        holder.totalAmount.setText(order.getTotalAmount());
    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    public static class CatalogViewHolder extends RecyclerView.ViewHolder{
        public ShapeableImageView imageView;
        public TextView orderNumber, numberOfItems, totalAmount;
        public Button btnCheckOut;

        public CatalogViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.imageView);
            this.orderNumber = itemView.findViewById(R.id.orderNumber);
            this.numberOfItems = itemView.findViewById(R.id.numberOfItems);
            this.totalAmount= itemView.findViewById(R.id.totalAmount);
            this.btnCheckOut = itemView.findViewById(R.id.btnCheckout);
        }
    }

}
