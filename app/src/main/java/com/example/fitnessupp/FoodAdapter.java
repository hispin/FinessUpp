package com.example.fitnessupp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.MyViewHolder> {
    private ArrayList<Food> foods;
    private OnItemClickLister lister;

    public FoodAdapter(ArrayList<Food> Foods, OnItemClickLister lister) {
        this.foods = foods;
        this.lister = lister;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.food, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(foods.get(position), lister);
    }

    @Override
    public int getItemCount() {
        return foods.size();
    }
//TODO
    public interface OnItemClickLister {
        void onItemClick(Food food);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView foodName;
        private ImageView foodImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            foodName = itemView.findViewById(R.id.foodNameTv);
            foodImage = itemView.findViewById(R.id.foodImageIv);
        }

        public void bind(final Food food, final OnItemClickLister lister) {
            foodName.setText(food.getName() + "");
            foodImage.setImageResource(food.getDrawable());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    lister.onItemClick(food);
                }
            });
        }
    }
}
