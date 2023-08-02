package co.za.pocketfarm.adaptors;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.List;

import co.za.pocketfarm.R;
import co.za.pocketfarm.models.Growth;

public class GrowthAdaptor extends RecyclerView.Adapter<GrowthAdaptor.GrowthViewHolder> {

    private final List<Growth> growths;

    public GrowthAdaptor(List<Growth> growths) {
        this.growths = growths;
    }

    @NonNull
    @Override
    public GrowthViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.growth_item,
                parent,
                false);
        return new GrowthAdaptor.GrowthViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GrowthViewHolder holder, int position) {
        Growth growth = growths.get(position);
        holder.clickableIcon.setOnClickListener(view -> {
            Toast.makeText(view.getContext(), "Ops..", Toast.LENGTH_SHORT).show();
        });
        holder.imageView.setImageResource(growth.getImageView());
        holder.farmName.setText(growth.getFarmName());
        holder.farmStatus.setText(growth.getDescription());
        if(growth.getFarmStatus() == 1){
            holder.waterIcon.setVisibility(View.GONE);
            holder.sunIcon.setVisibility(View.GONE);
            holder.growthItemHolder.setBackgroundColor(Color.rgb(0, 128, 43));
            holder.clickableIcon.setBackgroundColor(Color.rgb(0, 128, 43));
            holder.farmStatus.setTextColor(Color.rgb(0, 128, 43));
        }else if(growth.getFarmStatus() == 2){
            holder.waterIcon.setVisibility(View.VISIBLE);
            holder.sunIcon.setVisibility(View.GONE);
            holder.growthItemHolder.setBackgroundColor(Color.rgb(204, 153, 0));
            holder.clickableIcon.setBackgroundColor(Color.rgb(204, 153, 0));
            holder.farmStatus.setTextColor(Color.rgb(204, 153, 0));
        }else if(growth.getFarmStatus() == 3){
            holder.waterIcon.setVisibility(View.GONE);
            holder.sunIcon.setVisibility(View.VISIBLE);
            holder.growthItemHolder.setBackgroundColor(Color.rgb(204, 0, 0));
            holder.clickableIcon.setBackgroundColor(Color.rgb(204, 0, 0));
            holder.farmStatus.setTextColor(Color.rgb(204, 0, 0));
        }
    }

    @Override
    public int getItemCount() {
        return growths.size();
    }

    public static class GrowthViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public TextView farmName, farmStatus, sunIcon, waterIcon, clickableIcon;
        RelativeLayout growthItemHolder;

        public GrowthViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.imageView);
            this.farmName = itemView.findViewById(R.id.farmName);
            this.farmStatus = itemView.findViewById(R.id.status);
            this.waterIcon= itemView.findViewById(R.id.waterIcon);
            this.sunIcon= itemView.findViewById(R.id.sunIcon);
            this.clickableIcon = itemView.findViewById(R.id.clickableIcon);
            this.growthItemHolder = itemView.findViewById(R.id.growthItemHolder);
        }
    }

}
