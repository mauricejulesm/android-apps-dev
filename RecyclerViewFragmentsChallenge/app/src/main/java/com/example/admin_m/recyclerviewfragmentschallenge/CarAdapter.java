package com.example.admin_m.recyclerviewfragmentschallenge;

import android.content.ClipData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.ViewHolder> {

    ArrayList<Car> cars;
    ItemClicked activity;

    public interface ItemClicked {
        void onItemClicked(int index);
    }

    public CarAdapter(Context context, ArrayList<Car> list) {
        cars = list;
        activity = (ItemClicked) context;

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivMake;
        TextView tvModel, tvOwner;

        public ViewHolder(View itemView) {
            super(itemView);
            ivMake = itemView.findViewById(R.id.ivMake);
            tvModel = itemView.findViewById(R.id.tvModel);
            tvOwner = itemView.findViewById(R.id.tvOwner);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.onItemClicked(cars.indexOf((Car)v.getTag()));
                }
            });
        }
    }

    @NonNull
    @Override
    public CarAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_layout, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarAdapter.ViewHolder holder, int position) {
        holder.itemView.setTag(cars.get(position));

        holder.tvOwner.setText(cars.get(position).getOwnerName());
        holder.tvModel.setText(cars.get(position).getModel());

        if ((cars.get(position).getMake().equals("Volkswagen"))) {
            holder.ivMake.setImageResource(R.drawable.volkswagen);
        } else if ((cars.get(position).getMake().equals("Nissan"))) {
            holder.ivMake.setImageResource(R.drawable.nissan);
        } else {
            holder.ivMake.setImageResource(R.drawable.mercedes);

        }
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }
}
