package co.za.pocketfarm;


import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class ScanItem extends AppCompatActivity {


    AlertDialog.Builder dialogBuilder;
    AlertDialog dialog;
    private static final int pic_id = 123;
    // Define the button and imageview type variable
    Button camera_open_id;
    ImageView click_image_id;
    boolean analyzingImage = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_item);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        setTitle("Upload picture");


        click_image_id = findViewById(R.id.click_image);
        Button btnUploadImage = findViewById(R.id.upload_image);

        btnUploadImage.setOnClickListener(view -> {
            PleaseWaitDialog pleaseWaitDialog = new PleaseWaitDialog();
            pleaseWaitDialog.show(this, "Analyzing image. Please wait...");
            analyzingImage = true;

            pleaseWaitDialog.performBackgroundTask(new PleaseWaitDialog.OnBackgroundTaskCompleteListener() {
                @Override
                public void onTaskComplete() {
                    setTitle("Image analyzed");

                    launchResults();

                    analyzingImage = false;
                    btnUploadImage.setVisibility(View.GONE);
                    click_image_id.setVisibility(View.GONE);
                    pleaseWaitDialog.dismiss();
                }
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

        dialogBuilder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.analyzed_results, null);

        view.findViewById(R.id.shopForremedies).setOnClickListener(view1 -> {
            startActivity(new Intent(this, Catalog.class));
            finish();
        });

        dialogBuilder.setCancelable(false);
        dialogBuilder.setView(view);
        dialog = dialogBuilder.create();
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