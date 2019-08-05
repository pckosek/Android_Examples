package com.example.pckosek.recyclerview_02;


import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.MyViewHolder> {

    private List<MyUser> usersList;

    public UsersAdapter(List<MyUser> ul) {
        this.usersList = ul;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        MyUser user = usersList.get(position);
        holder.textViewName.setText( user.name );
        holder.textViewAge.setText( String.valueOf(user.age) );
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewName, textViewAge;

        public MyViewHolder(View view) {
            super(view);
            textViewName = view.findViewById(R.id.tv_name);
            textViewAge = view.findViewById(R.id.tv_age);
        }
    }
}