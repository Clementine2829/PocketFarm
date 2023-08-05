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
import co.za.pocketfarm.adaptors.OrdersAdaptor;
import co.za.pocketfarm.adaptors.TipsAndNotificationsAdaptor;
import co.za.pocketfarm.models.ObjectTypes;
import co.za.pocketfarm.models.Orders;
import co.za.pocketfarm.models.TipsOrNotifications;

public class OrdersFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.orders, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.ordersItems);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        // Create and set the adapter
        List<Orders> orders = new ArrayList<>();
        orders.add(new Orders("1", R.drawable.img30, "544", "5 Items", "R55.45"));
        orders.add(new Orders("2", R.drawable.img29, "125", "2 Items", "R89.95"));
        orders.add(new Orders("3", R.drawable.img3, "885", "1 Item", "R50.00"));
        orders.add(new Orders("4", R.drawable.img28, "984", "55 Items", "R14565.45"));
        orders.add(new Orders("4", R.drawable.img26, "984", "55 Items", "R14565.45"));
        orders.add(new Orders("4", R.drawable.img24, "984", "55 Items", "R14565.45"));

        OrdersAdaptor adapter = new OrdersAdaptor(orders);
        recyclerView.setAdapter(adapter);
        return view;
    }
}