package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import java.util.ArrayList;

public class AllRequestsActivity extends AppCompatActivity {
    ListView listView;
    final ArrayList<Request> requests = new ArrayList<Request>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Tüm İstekler");
        setContentView(R.layout.activity_all_requests);
        listView = findViewById(R.id.listViewRequests);
        requests.add(new Request("Beşevler Metro", "Hastane", 1, R.drawable.star));
        requests.add(new Request("Gazi Üniversitesi", "Aşti", 3, R.drawable.star));
        RequestAdapter requestAdapter = new RequestAdapter(this, requests);
        if (listView != null) {
            listView.setAdapter(requestAdapter);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = MyMenu.menuClick(item, AllRequestsActivity.this);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }
}
