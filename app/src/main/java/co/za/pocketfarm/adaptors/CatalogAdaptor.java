package co.za.pocketfarm.adaptors;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import co.za.pocketfarm.R;

public class CatalogAdaptor extends RecyclerView.Adapter<CatalogAdaptor.CatalogViewHolder> {


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

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public static class CatalogViewHolder extends RecyclerView.ViewHolder{

        public CatalogViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
