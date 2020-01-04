package com.example.project;

import android.app.Activity;
import android.widget.BaseAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RequestAdapter extends BaseAdapter{

    private LayoutInflater mInflater;
    private ArrayList<Request> requestsArrayList;

    public RequestAdapter(Activity activity, ArrayList<Request> requestsArrayList) {
        this.mInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.requestsArrayList = requestsArrayList;
    }

    @Override
    public int getCount() {
        return requestsArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return requestsArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(R.layout.row_all_requests, null);
        TextView textViewFrom = convertView.findViewById(R.id.textViewWhereFrom);
        TextView textViewTo = convertView.findViewById(R.id.textViewWhereTo);
        ImageView imageViewStar = convertView.findViewById(R.id.imageViewStar);
        TextView textViewNumber = convertView.findViewById(R.id.textViewNumber);
        Request request = requestsArrayList.get(position);
        textViewFrom.setText(request.getFrom());
        textViewTo.setText(request.getTo());
        imageViewStar.setImageResource(request.getImg());
        textViewNumber.setText(request.getNumber());
        return convertView;
    }
}