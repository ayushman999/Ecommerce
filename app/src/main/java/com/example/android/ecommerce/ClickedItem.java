package com.example.android.ecommerce;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

public class ClickedItem extends AppCompatActivity {
    ImageView foodImage;
    TextView foodName;
    TextView foodPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clicked_item);
        foodImage=(ImageView) findViewById(R.id.clicked_img);
        foodName=(TextView) findViewById(R.id.clicked_food_name);
        foodPrice=(TextView) findViewById(R.id.clicked_food_price);
        String name=getIntent().getStringExtra("Name");
        String price=getIntent().getStringExtra("Price");
        String url=getIntent().getStringExtra("Url");
        Glide.with(this).load(url).into(foodImage);
        foodName.setText(name);
        foodPrice.setText(price+"Rs");
    }
}