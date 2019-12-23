package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class FavouriteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Favori Seferlerim");
        setContentView(R.layout.activity_favourite);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_favourite, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent intent;
        if (id == R.id.fullness) {
            intent = new Intent(FavouriteActivity.this, FullnessActivity.class);
            startActivity(intent);
        } else if (id == R.id.new_request) {
            intent = new Intent(FavouriteActivity.this, NewRequestActivity.class);
            startActivity(intent);
        } else if (id == R.id.all_requests) {
            intent = new Intent(FavouriteActivity.this, AllRequestsActivity.class);
            startActivity(intent);
        } else if (id == R.id.favourite) {
            intent = new Intent(FavouriteActivity.this, FavouriteActivity.class);
            startActivity(intent);
        } else if (id == R.id.complaint) {
            intent = new Intent(FavouriteActivity.this, ComplaintAcitivity.class);
            startActivity(intent);
        } else if (id == R.id.settings) {
            intent = new Intent(FavouriteActivity.this, SettingsActivity.class);
            startActivity(intent);
        } else if (id == R.id.logout) {
            intent = new Intent(FavouriteActivity.this, MainActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }


}
