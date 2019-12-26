package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class FavouriteActivity extends AppCompatActivity {
    ListView listView;
    final ArrayList<Fan> fans = new ArrayList<Fan>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Takip Ettiğim Seferler");
        setContentView(R.layout.activity_favourite);
        listView = findViewById(R.id.listViewFans);
        fans.add(new Fan("1234"));
        fans.add(new Fan("5678"));
        fans.add(new Fan("9870"));
        FanAdapter fanAdapter = new FanAdapter(this, fans);
        if (listView != null) {
            listView.setAdapter(fanAdapter);
        }

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
            intent = new Intent(FavouriteActivity.this, ComplaintActivity.class);
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
