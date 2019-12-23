package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class NewRequestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Yeni İstek Ekle");
        setContentView(R.layout.activity_new_request);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_new_requests, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent intent;
        if (id == R.id.fullness) {
            intent = new Intent(NewRequestActivity.this, FullnessActivity.class);
            startActivity(intent);
        } else if (id == R.id.new_request) {
            intent = new Intent(NewRequestActivity.this, NewRequestActivity.class);
            startActivity(intent);
        } else if (id == R.id.all_requests) {
            intent = new Intent(NewRequestActivity.this, AllRequestsActivity.class);
            startActivity(intent);
        } else if (id == R.id.favourite) {
            intent = new Intent(NewRequestActivity.this, FavouriteActivity.class);
            startActivity(intent);
        } else if (id == R.id.complaint) {
            intent = new Intent(NewRequestActivity.this, ComplaintAcitivity.class);
            startActivity(intent);
        } else if (id == R.id.settings) {
            intent = new Intent(NewRequestActivity.this, SettingsActivity.class);
            startActivity(intent);
        } else if (id == R.id.logout) {
            intent = new Intent(NewRequestActivity.this, MainActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
