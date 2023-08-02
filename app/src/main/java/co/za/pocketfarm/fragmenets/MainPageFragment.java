package co.za.pocketfarm.fragmenets;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import co.za.pocketfarm.R;

public class MainPageFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TipsFragment tipsFragment = new TipsFragment();
        NotificationsFragment notificationsFragment = new NotificationsFragment();
        GrowthFragment growthFragment = new GrowthFragment();

        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.displayTipsFragment, tipsFragment);
        fragmentTransaction.replace(R.id.displayNotificationsFragment, notificationsFragment);
        fragmentTransaction.replace(R.id.displayGrowthFragment, growthFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
