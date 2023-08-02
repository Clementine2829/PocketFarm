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
import co.za.pocketfarm.adaptors.GrowthAdaptor;
import co.za.pocketfarm.models.Growth;

public class GrowthFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.growth_fragment, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        view.findViewById(R.id.btnGrowth).setOnClickListener(view1 -> {});

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        List<Growth> growths = new ArrayList<>();
        growths.add(new Growth("", R.drawable.img15, "FARM MM01", "ALL GOOD", 1));
        growths.add(new Growth("", R.drawable.img21, "FARM LL65", "LOW WATER", 2));
        growths.add(new Growth("", R.drawable.img3, "FARM PP22", "HIGH TEMP", 3));
        growths.add(new Growth("", R.drawable.img23, "FARM QP97", "LOW WATER", 2));
        growths.add(new Growth("", R.drawable.img24, "FARM KL55", "ALL GOOD", 1));

        GrowthAdaptor adapter = new GrowthAdaptor(growths);
        recyclerView.setAdapter(adapter);
        return view;
    }
}
