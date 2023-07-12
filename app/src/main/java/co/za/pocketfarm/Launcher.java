package co.za.pocketfarm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Objects;

public class Launcher extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        Objects.requireNonNull(getSupportActionBar()).hide();

        findViewById(R.id.btnLogin).setOnClickListener(view -> {
            startActivity(new Intent(this, Login.class));
            finish();
        });
        findViewById(R.id.btnRegister).setOnClickListener(view -> {
            startActivity(new Intent(this, Register.class));
            finish();
        });

    }
}