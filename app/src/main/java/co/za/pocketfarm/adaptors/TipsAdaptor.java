package co.za.pocketfarm.adaptors;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import co.za.pocketfarm.R;
import co.za.pocketfarm.models.Tips;

public class TipsAdaptor extends RecyclerView.Adapter<TipsAdaptor.ViewHolder> {

    private final List<Tips> tipsItems;

    public TipsAdaptor(List<Tips> tipsItems) {
        this.tipsItems = tipsItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tips_items, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Tips tipItem = tipsItems.get(position);
        int imageRes = tipItem.getImage();
        String title = tipItem.getTitle();
        String author = tipItem.getAuthor();
        String dateUpdated = tipItem.getDateUpdated();

        holder.imageView.setImageResource(imageRes);
        holder.title.setText(title);
        holder.author.setText(String.format("By %s", author));
        holder.dateUpdated.setText(dateUpdated);
    }

    @Override
    public int getItemCount() {
        return tipsItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView title, author, dateUpdated;
        public ViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.imageView);
            title = view.findViewById(R.id.subDescription);
            author = view.findViewById(R.id.author);
            dateUpdated = view.findViewById(R.id.dateUpdated);
        }
    }

}
