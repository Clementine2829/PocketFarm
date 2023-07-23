package co.za.pocketfarm.fragmenets;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.Objects;

import co.za.pocketfarm.MainActivity;
import co.za.pocketfarm.PleaseWaitDialog;
import co.za.pocketfarm.R;
import co.za.pocketfarm.ScanItem;

public class CheckoutPageThree extends Fragment {

    private EditText etCardNumber, etExpiryDate, etCVV;
    private LinearLayout layoutCreditCardDetails, layoutBankTransferInstructions;
    private RadioGroup radioGroupPayment;

    AlertDialog.Builder dialogBuilder;
    AlertDialog dialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.checkout_page_three, container, false);

        etCardNumber = view.findViewById(R.id.etCardNumber);
        etExpiryDate = view.findViewById(R.id.etExpiryDate);
        etCVV = view.findViewById(R.id.etCVV);
        layoutCreditCardDetails = view.findViewById(R.id.layoutCreditCardDetails);
        layoutBankTransferInstructions = view.findViewById(R.id.layoutBankTransferInstructions);
        radioGroupPayment = view.findViewById(R.id.radioGroupPayment);
        RadioButton rbCreditCard = view.findViewById(R.id.rbCreditCard);
        RadioButton rbBankTransfer = view.findViewById(R.id.rbBankTransfer);
        RadioButton rbPayFast = view.findViewById(R.id.rbPayFast);
        Button btnPlaceOrder = view.findViewById(R.id.btnMakePayment);
        LinearLayout paidHolder =  view.findViewById(R.id.paidHolder);
        paidHolder.setVisibility(View.INVISIBLE);
//        int heightInPixels = 10;
//        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
//        layoutParams.height = heightInPixels;
//        paidHolder.setLayoutParams(layoutParams);

        // Set listeners for radio group to handle payment method selection
        radioGroupPayment.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // Show/hide relevant views based on the selected payment method
                if(checkedId == R.id.rbCreditCard){
                    layoutCreditCardDetails.setVisibility(View.VISIBLE);
                    layoutBankTransferInstructions.setVisibility(View.GONE);
                }else if(checkedId == R.id.rbBankTransfer){
                    layoutCreditCardDetails.setVisibility(View.GONE);
                    layoutBankTransferInstructions.setVisibility(View.VISIBLE);
                }else if(checkedId == R.id.rbPayFast){
                    layoutCreditCardDetails.setVisibility(View.GONE);
                    layoutBankTransferInstructions.setVisibility(View.GONE);
                }
            }
        });

        // Set listener for the "Place Order" button
        btnPlaceOrder.setOnClickListener(v -> {
            // Get selected payment method
            int selectedPaymentId = radioGroupPayment.getCheckedRadioButtonId();
            if (selectedPaymentId == -1) {
                // No payment method selected
                Toast.makeText(getContext(), "Please select a payment method", Toast.LENGTH_SHORT).show();
                return;
            }

            RadioButton selectedRadioButton = view.findViewById(selectedPaymentId);
            String selectedPaymentMethod = selectedRadioButton.getText().toString();

            // Handle the payment processing based on the selected payment method
            if (selectedPaymentMethod.equals("Credit Card")) {
                // Extract credit card details and process payment
                String cardNumber = etCardNumber.getText().toString();
                String expiryDate = etExpiryDate.getText().toString();
                String cvv = etCVV.getText().toString();
                if(cardNumber.isEmpty()) etCardNumber.setError("Enter card number");
                if(expiryDate.isEmpty()) etExpiryDate.setError("Enter expiry date");
                if(cvv.isEmpty()) etCVV.setError("Enter CVV");
                if(cardNumber.isEmpty() || expiryDate.isEmpty() || cvv.isEmpty()){
                    return;
                }
                performCreditCardPayment(view, cardNumber, expiryDate, cvv);
            } else if (selectedPaymentMethod.equals("Bank Transfer")) {
                performBankTransferPayment(view);
            } else if (selectedPaymentMethod.equals("PayPal")) {
                performPayFastPayment(view);
            }
        });

        view.findViewById(R.id.backToMain).setOnClickListener(view1 -> {
            startActivity(new Intent(getContext(), MainActivity.class));
            requireActivity().finish();;
        });
        return view;
    }

    private void performCreditCardPayment(View v, String cardNumber, String expiryDate, String cvv) {
        makePayment(v);
    }

    private void performBankTransferPayment(View v) {
        makePayment(v);
    }

    private void performPayFastPayment(View v) {
        makePayment(v);
    }

    // Sample method for order placement logic
    private void makePayment(View v) {

        dialogBuilder = new AlertDialog.Builder(getContext());
        View view = getLayoutInflater().inflate(R.layout.please_wait, null);

        performBackgroundTask(()->{
            v.findViewById(R.id.paidHolder).setVisibility(View.VISIBLE);
            v.findViewById(R.id.paymentHolder).setVisibility(View.GONE);
            dialog.dismiss();
        });

        dialogBuilder.setView(view);
        dialog = dialogBuilder.create();
        dialog.show();
    }
    public void performBackgroundTask(final PleaseWaitDialog.OnBackgroundTaskCompleteListener listener) {
        // Simulating a background task with a delay of 10 seconds
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Task completed, notify the listener
                listener.onTaskComplete();
            }
        }, 10000);
    }

}