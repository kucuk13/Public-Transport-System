package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    DatabaseHelper mydb;
    EditText editTextUserName, editTextMail, editTextTel, editTextPass, editTextPassAgain;
    Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setTitle("Üye Olun");
        mydb = new DatabaseHelper(this);
        editTextUserName = findViewById(R.id.editTextUserName);
        editTextMail = findViewById(R.id.editTextMail);
        editTextTel = findViewById(R.id.editTextUpdateTel);
        editTextPass = findViewById(R.id.editTextPass);
        editTextPassAgain = findViewById(R.id.editTextPassAgain);
        buttonRegister = findViewById(R.id.buttonSignup);
        buttonRegister.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = mydb.insertUser(editTextUserName.getText().toString(),
                                editTextMail.getText().toString(),
                                editTextPass.getText().toString(),
                                editTextPassAgain.getText().toString(),
                                editTextTel.getText().toString());
                        if (isInserted){
                            Toast.makeText(RegisterActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(RegisterActivity.this, "Data NOT Inserted", Toast.LENGTH_LONG).show();
                        }
                        Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                }
        );
    }


}
