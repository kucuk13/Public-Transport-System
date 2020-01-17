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
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = MyMenu.menuClick(item, FavouriteActivity.this);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }


}
