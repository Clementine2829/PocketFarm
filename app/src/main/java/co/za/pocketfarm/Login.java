package co.za.pocketfarm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    private EditText username, password;
    private Button login;
    private TextView loginMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.emailEditText);
        password = findViewById(R.id.passwordEditText);

        loginMessage = findViewById(R.id.loginMessage);

        findViewById(R.id.loginButton).setOnClickListener(view -> {
            if(username.getText().toString().isEmpty() || password.getText().toString().isEmpty()){
                loginMessage.setText(R.string.invalid_login_credentials);
            }else{
                Intent intent = new Intent(this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent );
                finish();
            }
        });

        findViewById(R.id.forgotPasswordTextView).setOnClickListener(view -> {
            startActivity( new Intent(this, Register.class));
            finish();
        });

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, Launcher.class));
        finishAffinity();
    }
}