package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    DatabaseHelper mydb;
    EditText editTextUserName, editTextMail, editTextTel, editTextPass;
    Button buttonUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Ayarlar");
        setContentView(R.layout.activity_settings);
        mydb = new DatabaseHelper(this);
        editTextUserName = findViewById(R.id.editTextUpdateUser);
        editTextMail = findViewById(R.id.editTextUpdateMail);
        editTextTel = findViewById(R.id.editTextUpdateTel);
        editTextPass = findViewById(R.id.editTextUpdatePass);

        editTextUserName.setText(Person.name.toCharArray(), 0,  Person.name.length());
        editTextMail.setText(Person.email.toCharArray(), 0, Person.email.length());
        editTextTel.setText(Person.tel.toCharArray(), 0, Person.tel.length());
        editTextPass.setText(Person.password.toCharArray(), 0, Person.password.length());

        buttonUpdate = findViewById(R.id.buttonUpdate);
        buttonUpdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdated = mydb.updateUser(Person.id,
                                editTextUserName.getText().toString(),
                                editTextMail.getText().toString(),
                                editTextPass.getText().toString(),
                                editTextTel.getText().toString());
                        if (isUpdated){
                            Toast.makeText(SettingsActivity.this, "Data Updated", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(SettingsActivity.this, "Data NOT Updated", Toast.LENGTH_LONG).show();
                        }

                    }
                }
        );

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent intent;
        if (id == R.id.fullness) {
            intent = new Intent(SettingsActivity.this, FullnessActivity.class);
            startActivity(intent);
        } else if (id == R.id.new_request) {
            intent = new Intent(SettingsActivity.this, NewRequestActivity.class);
            startActivity(intent);
        } else if (id == R.id.all_requests) {
            intent = new Intent(SettingsActivity.this, AllRequestsActivity.class);
            startActivity(intent);
        } else if (id == R.id.favourite) {
            intent = new Intent(SettingsActivity.this, FavouriteActivity.class);
            startActivity(intent);
        } else if (id == R.id.complaint) {
            intent = new Intent(SettingsActivity.this, ComplaintActivity.class);
            startActivity(intent);
        } else if (id == R.id.settings) {
            intent = new Intent(SettingsActivity.this, SettingsActivity.class);
            startActivity(intent);
        } else if (id == R.id.logout) {
            new Person();
            intent = new Intent(SettingsActivity.this, MainActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}
