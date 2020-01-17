package com.example.project;

import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;

public class MyMenu {

    public static Intent menuClick(MenuItem item, Activity activity){
        int id = item.getItemId();
        Intent intent = null;
        switch (id){
            case R.id.fullness: intent = new Intent(activity, FullnessActivity.class); break;
            case R.id.new_request: intent = new Intent(activity, NewRequestActivity.class); break;
            case R.id.all_requests: intent = new Intent(activity, AllRequestsActivity.class); break;
            case R.id.favourite: intent = new Intent(activity, FavouriteActivity.class); break;
            case R.id.complaint: intent = new Intent(activity, ComplaintActivity.class); break;
            case R.id.settings: intent = new Intent(activity, SettingsActivity.class); break;
            case R.id.logout: new Person(); intent = new Intent(activity, MainActivity.class); break;
        }
        return intent;
    }

}
