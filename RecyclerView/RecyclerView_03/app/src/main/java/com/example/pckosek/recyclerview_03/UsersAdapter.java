package com.example.pckosek.recyclerview_03;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.MyViewHolder> {

    private List<MyUser> usersList;
    private UsersAdapterInterface mCallback;

    public UsersAdapter(List<MyUser> ul, UsersAdapterInterface ucb) {
        this.usersList = ul;
        if (ucb instanceof UsersAdapterInterface) {
            this.mCallback = ucb;
        } else {
            throw new RuntimeException(ucb.toString()
                    + "[probably your MainActivity] must implement UsersAdapterInterface");
        }
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
        holder.imageViewEdit.setOnClickListener( new MyEditClickListener(position) );

    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }




    public class MyEditClickListener implements View.OnClickListener {

        private int position;

        public MyEditClickListener(int pos) {
            this.position = pos;
        }

        @Override
        public void onClick(View v) {
            mCallback.onEditItemClicked(v, position);
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewName, textViewAge;
        public ImageView imageViewEdit;

        public MyViewHolder(View view) {
            super(view);
            textViewName = view.findViewById(R.id.tv_name);
            textViewAge = view.findViewById(R.id.tv_age);
            imageViewEdit = view.findViewById(R.id.iv_more);
        }
    }

    public interface UsersAdapterInterface {
        void onEditItemClicked(View v, int pos);
    }
}
