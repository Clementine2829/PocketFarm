package co.za.pocketfarm.fragmenets;

import static co.za.pocketfarm.Catalog.context;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import co.za.pocketfarm.OnButtonClickListener;
import co.za.pocketfarm.R;
import co.za.pocketfarm.adaptors.TipsAndNotificationsAdaptor;
import co.za.pocketfarm.models.ObjectTypes;
import co.za.pocketfarm.models.TipsOrNotifications;

public class NotificationsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.notifications_fragment, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        view.findViewById(R.id.btnNotifications).setOnClickListener(view1 -> onButtonClick());

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        List<TipsOrNotifications> notifications = new ArrayList<>();
        String title = "Weather Alerts";
        String farmName = "Farm: YT251";
        String weather = "55°c";
        TipsOrNotifications n1 = new TipsOrNotifications(R.drawable.img16, title, farmName, weather);
        n1.setStatus(2);

        title = "Crop-specific Tips";
        farmName = "For farmers";
        weather = "On going";
        TipsOrNotifications n2 = new TipsOrNotifications(R.drawable.img21, title, farmName, weather);
        n2.setStatus(1);

        title = "Fertilizer and Nutrient Reminders";
        farmName = "Farm: MM658";
        weather = "In a week";
        TipsOrNotifications n3 = new TipsOrNotifications(R.drawable.img17, title, farmName, weather);
        n3.setStatus(2);

        title = "Temp is high";
        farmName = "All farms";
        weather = "In a week";
        TipsOrNotifications n4 = new TipsOrNotifications(R.drawable.img15, title, farmName, weather);
        n4.setStatus(3);


        notifications.add(n1);
        notifications.add(n2);
        notifications.add(n3);
        notifications.add(n4);

        List<ObjectTypes> tipsObjects = new ArrayList<>();
        for (TipsOrNotifications t:notifications) {
            tipsObjects.add(new ObjectTypes(1, t));
        }
        TipsAndNotificationsAdaptor adapter = new TipsAndNotificationsAdaptor(tipsObjects);
        recyclerView.setAdapter(adapter);

        return view;
    }

    private void onButtonClick() {

    }
}
