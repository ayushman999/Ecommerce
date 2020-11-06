package com.example.android.ecommerce;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

public class foodAdapter extends RecyclerView.Adapter<foodAdapter.foodViewHolder> {
    ArrayList<Elements> items=new ArrayList<>();
    Context context;
    private foodItemClicked listener;

    public foodAdapter(ArrayList<Elements> items, Context context, foodItemClicked listener) {
        this.items = items;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public foodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View elementView= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_element,parent,false);
        final foodViewHolder holder=new foodViewHolder(elementView);
        elementView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=items.get(holder.getPosition()).getName();
                int price=items.get(holder.getPosition()).getPrice();
                String url=items.get(holder.getPosition()).getImg_url();
                listener.onItemClicked(name,price,url);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull foodViewHolder holder, int position) {
        Elements currentElement=items.get(position);
        holder.foodTitle.setText(currentElement.getName());
        holder.foodPrice.setText("Price: "+currentElement.getPrice()+"Rs");
        String ImgUrl=currentElement.getImg_url();
        Glide.with(context).load(ImgUrl).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.foodImage);


    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class foodViewHolder extends RecyclerView.ViewHolder{
        ImageView foodImage;
        TextView foodTitle;
        TextView foodPrice;
        public foodViewHolder(@NonNull View itemView) {
            super(itemView);
            foodImage=(ImageView) itemView.findViewById(R.id.food_img);
            foodTitle=(TextView) itemView.findViewById(R.id.product_name);
            foodPrice=(TextView) itemView.findViewById(R.id.product_price);
        }
    }

}
interface foodItemClicked{
    public void onItemClicked(String FoodName,int Price, String ImageUrl);
}

