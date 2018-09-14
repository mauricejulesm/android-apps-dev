package com.example.admin_m.fragmentsrecyclerviewapp;

import android.content.ClipData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {

    private ArrayList<Person> people;

    ItemClicked activity;

    public interface ItemClicked {
        void onItemClicked(int index);
    }

    public PersonAdapter(Context context, ArrayList<Person> list) {
        people = list;
        activity = (ItemClicked) context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;

        public ViewHolder(final View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    activity.onItemClicked(people.indexOf(v.getTag()));
                }
            });
        }
    }

    @NonNull
    @Override
    public PersonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_layout, viewGroup, false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.ViewHolder viewHolder, int position) {
        viewHolder.itemView.setTag(people.get(position));
        viewHolder.tvName.setText(people.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return people.size();
    }
}
