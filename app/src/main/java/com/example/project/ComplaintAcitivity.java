package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class ComplaintAcitivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Şikayet Er");
        setContentView(R.layout.activity_complaint);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_complaint, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent intent;
        if (id == R.id.fullness) {
            intent = new Intent(ComplaintAcitivity.this, FullnessActivity.class);
            startActivity(intent);
        } else if (id == R.id.new_request) {
            intent = new Intent(ComplaintAcitivity.this, NewRequestActivity.class);
            startActivity(intent);
        } else if (id == R.id.all_requests) {
            intent = new Intent(ComplaintAcitivity.this, AllRequestsActivity.class);
            startActivity(intent);
        } else if (id == R.id.favourite) {
            intent = new Intent(ComplaintAcitivity.this, FavouriteActivity.class);
            startActivity(intent);
        } else if (id == R.id.complaint) {
            intent = new Intent(ComplaintAcitivity.this, ComplaintAcitivity.class);
            startActivity(intent);
        } else if (id == R.id.settings) {
            intent = new Intent(ComplaintAcitivity.this, SettingsActivity.class);
            startActivity(intent);
        } else if (id == R.id.logout) {
            intent = new Intent(ComplaintAcitivity.this, MainActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }


}
