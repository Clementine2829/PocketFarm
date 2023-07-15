package co.za.pocketfarm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Register extends AppCompatActivity {

    private final boolean [] allIsWell = {true,true,true,true};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setTitle("\t\tCreate account");

        TextView registerMessage = findViewById(R.id.registerMessage);
        EditText firstName = findViewById(R.id.firstNameEditText);
        EditText lastName = findViewById(R.id.lastNameEditText);
        EditText username = findViewById(R.id.emailEditText);
        EditText password = findViewById(R.id.passwordEditText);

        findViewById(R.id.signUpButton).setOnClickListener(view -> {
            validateData(firstName, "First name", 0);
            validateData(lastName, "Surname", 1);
            validateData(username, "Username", 2);
            validateData(password, "Password", 3);
            if(allIsWell[0] && allIsWell[1] && allIsWell[2] && allIsWell[3]){
                registerMessage.setText("Account created successfully. \nClick here to login");
                registerMessage.setClickable(true);
                firstName.setText("");
                lastName.setText("");
                username.setText("");
                password.setText("");
            }else{
                registerMessage.setClickable(false);
            }
        });

        findViewById(R.id.haveAccount).setOnClickListener(view -> {
            startActivity( new Intent(this, Login.class));
            finish();
        });
        registerMessage.setOnClickListener(view -> {
            startActivity( new Intent(this, Login.class));
            finish();
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, Launcher.class));
        finishAffinity();
    }

    private void validateData(EditText editText, String field, int index){
        if(editText.getText().toString().trim().isEmpty()){
            editText.setError(field + " is required");
            allIsWell[index] = false;
        }else{
            allIsWell[index] = true;
        }
    }

}