package com.example.healthspot;

import static com.example.healthspot.R.id.editTextRegEmail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText edUsername,edEmail,edConfirm, edPassword;
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edPassword=findViewById(R.id.editTextRegPassword);
        edUsername=findViewById(R.id.editTextRegUsername);
        edEmail=findViewById(editTextRegEmail);
        edConfirm=findViewById(R.id.editTextRegConfirmPassword);
        btn= findViewById(R.id.buttonRegister);
        tv=findViewById(R.id.textViewExistingUser);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edUsername.getText().toString();
                String password = edPassword.getText().toString();
                String email = edEmail.getText().toString();
                String confirm = edConfirm.getText().toString();
                Database db=new Database(getApplicationContext(),"healthcare",null,1);
                if (username.length() == 0 || password.length() == 0 || confirm.length() == 0 || email.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please fill all details", Toast.LENGTH_SHORT).show();
                } else {
                    if (password.compareTo(confirm)==0) {
                       db.register(username,email,password);
                        Toast.makeText(getApplicationContext(), "Register Successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Password and confirm password does not match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        tv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });
    }
}