package co.za.pocketfarm.adaptors;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import co.za.pocketfarm.R;
import co.za.pocketfarm.models.ObjectTypes;
import co.za.pocketfarm.models.TipsOrNotifications;

public class TipsAndNotificationsAdaptor extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<ObjectTypes> objectTypes;

    public TipsAndNotificationsAdaptor(List<ObjectTypes> objectTypes) {
        this.objectTypes = objectTypes;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // type 0 = tips & type 1 = notifications
        if(viewType == 0){
            System.out.println("Types here: 0123");
            return new TipsViewHolder (
                    LayoutInflater.from(parent.getContext()).inflate(
                            R.layout.tips_items,
                            parent,
                            false
                    )
            );
        }else{
            System.out.println("Types here: 1234 " + viewType);
            return new NotificationsViewHolder (
                    LayoutInflater.from(parent.getContext()).inflate(
                            R.layout.notifications_items,
                            parent,
                            false
                    )
            );
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(getItemViewType(position) == 0){
            TipsOrNotifications tips = (TipsOrNotifications) objectTypes.get(position).getObject();
            ((TipsViewHolder) holder).setupTipsViewHolder(tips);
        }else{
            TipsOrNotifications notifications = (TipsOrNotifications) objectTypes.get(position).getObject();
            ((NotificationsViewHolder) holder).setupNotificationsViewHolder(notifications);
        }
    }

    @Override
    public int getItemCount() {
        return objectTypes.size();
    }

    public static class TipsViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView title, author, dateUpdated;
        RelativeLayout relativeLayout;

        public TipsViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.imageView);
            title = view.findViewById(R.id.subDescription);
            author = view.findViewById(R.id.author);
            dateUpdated = view.findViewById(R.id.dateUpdated);
            relativeLayout = view.findViewById(R.id.relativeLayout);
        }
        void setupTipsViewHolder(TipsOrNotifications tipsOrNotifications){
            imageView.setImageResource(tipsOrNotifications.getImage());
            String tempTitle = tipsOrNotifications.getText1();
            title.setText((tempTitle.length() < 50) ? tempTitle : tempTitle.substring(0, 47) + "...");
            author.setText(String.format("By %s", tipsOrNotifications.getText2()));
            dateUpdated.setText(tipsOrNotifications.getText3());

        }
    }
    public static class NotificationsViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView tempStatus, farmName, weatherTemperature;
        RelativeLayout relativeLayout;

        public NotificationsViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.imageView);
            tempStatus = view.findViewById(R.id.tempStatus);
            farmName = view.findViewById(R.id.farmName);
            weatherTemperature = view.findViewById(R.id.weatherTemperature);
            relativeLayout = view.findViewById(R.id.relativeLayout2);
        }
        void setupNotificationsViewHolder(TipsOrNotifications tipsOrNotifications){
            imageView.setImageResource(tipsOrNotifications.getImage());
            tempStatus.setText(tipsOrNotifications.getText1());
            farmName.setText(String.format("By %s", tipsOrNotifications.getText2()));
            weatherTemperature.setText(tipsOrNotifications.getText3());

        }
    }

}
