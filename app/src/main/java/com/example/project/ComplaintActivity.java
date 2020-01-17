package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class ComplaintActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("İletişim");
        setContentView(R.layout.activity_complaint);
        final Spinner mailType = findViewById(R.id.spinnerMailType);
        final EditText message = findViewById(R.id.editTextMessage);
        final Button button = findViewById(R.id.buttonSendMail);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String messageStr = message.getText().toString();
                String subject = mailType.getSelectedItem().toString();
                Intent mailIntent = new Intent(Intent.ACTION_SEND);
                mailIntent.setType("message/rfc822");
                mailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"bu.kaan@outlook.com"});
                mailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
                mailIntent.putExtra(Intent.EXTRA_TEXT, messageStr);
                try {
                    startActivity(mailIntent);
                } catch (ActivityNotFoundException err){
                    Toast.makeText(getApplicationContext(), "Hata oluştu.\n" + err.getMessage(), Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_complaint, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = MyMenu.menuClick(item, ComplaintActivity.this);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }


}
