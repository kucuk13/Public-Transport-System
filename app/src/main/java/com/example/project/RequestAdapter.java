package com.example.project;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class RequestAdapter extends RecyclerView.Adapter<RequestAdapter.ViewHolder> {
    ArrayList<Request> requestArrayList = new ArrayList<>();
    LayoutInflater layoutInflater;
    Context context;

    public RequestAdapter(ArrayList<Request> requestArrayList, Context context) {
        this.requestArrayList = requestArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        layoutInflater = LayoutInflater.from(context);
        View v = layoutInflater.inflate(R.layout.row_all_requests, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtWhereFrom.setText(requestArrayList.get(position).getFrom());
        holder.txtWhereTo.setText(requestArrayList.get(position).getTo());
        holder.imageView.setImageResource(requestArrayList.get(position).getImg());
        holder.txtNumber.setText(requestArrayList.get(position).getNumber());
        holder.linearLayout.setTag(holder);
    }

    @Override
    public int getItemCount() {
        return requestArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtWhereFrom, txtWhereTo, txtNumber;
        ImageView imageView;
        LinearLayout linearLayout;
        public ViewHolder(View itemView){
            super(itemView);
            txtWhereFrom = itemView.findViewById(R.id.textViewWhereFrom);
            txtWhereTo = itemView.findViewById(R.id.textViewWhereTo);
            imageView = itemView.findViewById(R.id.imageViewStar);
            txtNumber = itemView.findViewById(R.id.textViewNumber);
            linearLayout = itemView.findViewById(R.id.linear);
        }

    }

}