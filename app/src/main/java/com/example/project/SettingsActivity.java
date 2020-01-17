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
                            new Person(Person.id,
                                    editTextUserName.getText().toString(),
                                    editTextMail.getText().toString(),
                                    editTextPass.getText().toString(),
                                    editTextTel.getText().toString());
                            Toast.makeText(SettingsActivity.this, "Güncellendi.", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(SettingsActivity.this, Main2Activity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(SettingsActivity.this, "Bir şeyler ters gitti.", Toast.LENGTH_LONG).show();
                        }

                    }
                }
        );

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = MyMenu.menuClick(item, SettingsActivity.this);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }

}
