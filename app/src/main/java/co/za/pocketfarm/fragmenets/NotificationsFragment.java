package co.za.pocketfarm.fragmenets;

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

        // Set the orientation of the layout manager to horizontal
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        // Create and set the adapter
        List<TipsOrNotifications> tipsItems = new ArrayList<>();
        String title = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas";
        String dateUpdated = "17/07/2023";
        tipsItems.add(new TipsOrNotifications(R.drawable.img1, title, "Clement", dateUpdated));
        title = "Maecenas ut suscipit velit, sit amet viverra lectus. Vestibulum ante ipsum primis ";
        dateUpdated = "02/07/2023";
        tipsItems.add(new TipsOrNotifications(R.drawable.img2, title, "Bob Smith", dateUpdated));
        title = "Donec nec tellus eleifend, cursus nunc et, fermentum tellus. Phasellus sapien lacus, consequat";
        tipsItems.add(new TipsOrNotifications(R.drawable.img3, title, "Sophia Moore", dateUpdated));
        title = "Integer dolor elit, interdum nec posuere vel, laoreet non justo.";
        dateUpdated = "29/08/2023";
        tipsItems.add(new TipsOrNotifications(R.drawable.img4, title, "Jame", dateUpdated));
        title = "Donec nec tellus eleifend, cursus nunc et, fermentum tellus. Phasellus sapien lacus, consequat";
        tipsItems.add(new TipsOrNotifications(R.drawable.img5, title, "Clement", dateUpdated));


        List<ObjectTypes> tipsObjects = new ArrayList<>();
        for (TipsOrNotifications t:tipsItems) {
            tipsObjects.add(new ObjectTypes(1, t));
        }
        TipsAndNotificationsAdaptor adapter = new TipsAndNotificationsAdaptor(tipsObjects);
        recyclerView.setAdapter(adapter);


        return view;
    }
}
