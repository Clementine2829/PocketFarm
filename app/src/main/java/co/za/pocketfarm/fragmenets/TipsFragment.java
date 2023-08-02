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

public class TipsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tips_fragment, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);

        // Set the orientation of the layout manager to horizontal
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        // Create and set the adapter
        List<TipsOrNotifications> tipsItems = new ArrayList<>();
        String title = "Soil Health: Rotating Crops and Adding Organic Matter for Nutrient Balance";
        String dateUpdated = "01/02/2023";
        tipsItems.add(new TipsOrNotifications(R.drawable.img20, title, "Clement", dateUpdated));
        title = "Smart Plant Choices: Selecting Varieties Suited to Your Climate";
        dateUpdated = "18/07/2023";
        tipsItems.add(new TipsOrNotifications(R.drawable.img24, title, "Stuff", dateUpdated));
        title = "Natural Pest Control: Pest Management Techniques to integrate in your farm ";
        dateUpdated = "18/07/2023";
        tipsItems.add(new TipsOrNotifications(R.drawable.img18, title, "Thulani", dateUpdated));
        title = "Fertilization Fundamentals: Nourishing Plants with the Right Nutrients";
        dateUpdated = "18/07/2023";
        tipsItems.add(new TipsOrNotifications(R.drawable.img6, title, "Livett", dateUpdated));
        title = "Water Wisely: Following the Right Amount and Timing for Plant Hydration";
        dateUpdated = "18/07/2023";
        tipsItems.add(new TipsOrNotifications(R.drawable.img4, title, "Stuff", dateUpdated));



        List<ObjectTypes> tipsObjects = new ArrayList<>();
        for (TipsOrNotifications t:tipsItems) {
            tipsObjects.add(new ObjectTypes(0, t));
        }
        TipsAndNotificationsAdaptor adapter = new TipsAndNotificationsAdaptor(tipsObjects);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
