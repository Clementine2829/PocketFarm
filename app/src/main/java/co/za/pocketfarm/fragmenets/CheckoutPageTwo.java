package co.za.pocketfarm.fragmenets;

import static co.za.pocketfarm.Checkout.proceed;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import co.za.pocketfarm.R;

public class CheckoutPageTwo extends Fragment {

    EditText fullName, addressLine1, addressLine2, city, state, postalCode, country;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.checkout_page_two, container, false);

        fullName = view.findViewById(R.id.etName);
        addressLine1 = view.findViewById(R.id.etAddressLine1);
        addressLine2 = view.findViewById(R.id.etAddressLine2);
        city = view.findViewById(R.id.etCity);
        state = view.findViewById(R.id.etState);
        postalCode = view.findViewById(R.id.etZipCode);
        country = view.findViewById(R.id.etCountry);

        if(fullName.getText().toString().trim().isEmpty()) fullName.setError("Full name is required");
        if(addressLine1.getText().toString().trim().isEmpty()) addressLine1.setError("Address line one is required");
        if(city.getText().toString().trim().isEmpty()) city.setError("City is required");
        if(state.getText().toString().trim().isEmpty()) state.setError("State/Province is required");
        if(postalCode.getText().toString().trim().isEmpty()) postalCode.setError("Postal code is required");
        if(country.getText().toString().trim().isEmpty()) country.setError("Country is required");

        if(fullName.getText().toString().trim().isEmpty() ||
            addressLine1.getText().toString().trim().isEmpty() ||
            city.getText().toString().trim().isEmpty() ||
            state.getText().toString().trim().isEmpty() ||
            postalCode.getText().toString().trim().isEmpty() ||
            country.getText().toString().trim().isEmpty()){
            // do something in the future
        }
        proceed = true;

        return view;
    }

}
