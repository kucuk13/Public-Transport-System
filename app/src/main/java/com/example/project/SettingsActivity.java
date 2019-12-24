package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Ayarlar");
        setContentView(R.layout.activity_settings);
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
            intent = new Intent(SettingsActivity.this, MainActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}
