package com.example.project;

import android.app.Activity;
import android.widget.BaseAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class FanAdapter extends BaseAdapter{

    private LayoutInflater mInflater;
    private ArrayList<Fan> fansArrayList;

    public FanAdapter(Activity activity, ArrayList<Fan> fansArrayList) {
        this.mInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.fansArrayList = fansArrayList;
    }

    @Override
    public int getCount() {
        return fansArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return fansArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(R.layout.row_fan, null);
        TextView textViewFavExp = convertView.findViewById(R.id.textViewFavExp);
        Fan fan = fansArrayList.get(position);
        textViewFavExp.setText(fan.getExpeditionId());
        return convertView;
    }
}


