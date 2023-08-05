package co.za.pocketfarm;


import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.Objects;

public class ScanItem extends AppCompatActivity {

    private static final int pic_id = 123;
    private ImageView click_image_id;
    private String scanType = "";
    private boolean analyzingImage = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_item);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        setTitle("Upload picture");

        click_image_id = findViewById(R.id.click_image);
        Button btnUploadImage = findViewById(R.id.upload_image);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            String tempScanType = extras.getString("scanType");
            scanType = ((tempScanType.equals("plants")) ||
                        (tempScanType.equals("leaves")) ||
                        (tempScanType.equals("soil")) ||
                        (tempScanType.equals("pests"))) ? tempScanType : "";
        }
        btnUploadImage.setOnClickListener(view -> {
            PleaseWaitDialog pleaseWaitDialog = new PleaseWaitDialog();
            pleaseWaitDialog.show(this, "Analyzing image. Please wait...");
            analyzingImage = true;

            pleaseWaitDialog.performBackgroundTask(() -> {
                setTitle("Image analyzed");

                launchResults();

                analyzingImage = false;
                btnUploadImage.setVisibility(View.GONE);
                click_image_id.setVisibility(View.GONE);
                pleaseWaitDialog.dismiss();
            });

        });

        Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(camera_intent, pic_id);
    }
    // This method will help to retrieve the image
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Match the request 'pic id with requestCode
        if (requestCode == pic_id) {
            // BitMap is data structure of image file which store the image in memory
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            // Set the image in imageview for display
            click_image_id.setImageBitmap(photo);
        }
    }
    private void launchResults(){

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.analyzed_results, null);

        TextView description = view.findViewById(R.id.description);
        TextView disease = view.findViewById(R.id.disease);
        String strDescription;
        String strDisease;
        switch (scanType) {
            case "plants":
                strDisease = "Early Blight (Alternaria solani)";
                strDescription = "Description: \nEarly blight is a fungal disease that affects a wide range " +
                        "of plants, including tomatoes and potatoes. It manifests as dark concentric lesions" +
                        " with a target-like appearance on the leaves and stems." +
                        "\n\nImpact:\nLeaves develop yellow spots that progress into larger lesions, eventually " +
                        "leading to defoliation. This can significantly reduce plant health and yield";
                break;
            case "leaves":
                strDisease = "Powdery Mildew";
                strDescription = "Description: \nPowdery mildew is a common fungal disease that affects the leaves " +
                        "of various plants. It appears as a white, powdery substance on the upper surface of leaves, " +
                        "stems, and sometimes flowers." +
                        "\n\nImpact:\nInfected leaves become distorted, turn yellow, and may eventually die. " +
                        "Severe infections can reduce photosynthesis and overall plant vitality.";
                break;
            case "soil":
                strDisease = "Pythium Root Rot";
                strDescription = "Description: \nPythium root rot is a soilborne disease caused by various species of " +
                        "the Pythium fungus. It affects the root systems of plants, " +
                        "leading to reduced water and nutrient uptake, stunted growth, and overall plant decline." +
                        "\n\nImpact:\nInfected plants exhibit wilting, yellowing of leaves, and reduced vigor. " +
                        "It's particularly problematic in waterlogged or poorly drained soils.";
                break;
            case "pests":
                strDisease = "Aphids";
                strDescription = "Description: \nAphids are small, soft-bodied insects that feed on the sap of plants " +
                        "by piercing their tissues with their needle-like mouthparts. They reproduce rapidly " +
                        "and can be found in various colors" +
                        "\n\nImpact:\nAphids can cause damage by sucking out plant juices, leading to distorted " +
                        "growth, curling leaves, and the transmission of plant viruses. They also excrete a " +
                        "sticky substance called honeydew, which can attract other pests like ants and promote " +
                        "the growth of sooty mold.";
                break;
            default:
                strDisease = "";
                strDescription = "";
        }

        strDisease = "Disease: " + strDisease;
        Spannable spannableDisease = new SpannableString(strDisease);
        Spannable spannable = new SpannableString(strDescription);
        int startOne = 0;
        int endOne = 11;
        int startTwo = strDescription.indexOf("\n\nImpact:\n");
        int endTwo = startTwo + 10;

        spannable.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), startOne, endOne, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannable.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), startTwo, endTwo, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        spannableDisease.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this, R.color.black)), 0, 8, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        description.setText(spannable);
        disease.setText(spannableDisease);

        view.findViewById(R.id.shopForRemedies).setOnClickListener(view1 -> {
            startActivity(new Intent(this, Catalog.class));
            finish();
        });
        dialogBuilder.setCancelable(false);
        dialogBuilder.setView(view);
        AlertDialog dialog = dialogBuilder.create();
        dialog.show();

    }

    public void backToMainPage(){
//        if(analyzingImage){
//            String message  = "Please wait while image is being analyzed";
//            AlertDialog.Builder builder = new AlertDialog.Builder(this);
//            builder.setTitle("Alert!");
//            builder.setMessage(message);
//            builder.setPositiveButton("OKAY", (dialog, which) ->{
//
//            });
//            AlertDialog alertDialog = builder.create();
//            alertDialog.show();
//        }else{
            startActivity(new Intent(this, MainActivity.class));
            finishAffinity();
//        }
    }

    @Override
    public void onBackPressed() {
        backToMainPage();
    }

}