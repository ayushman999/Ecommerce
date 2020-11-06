package com.example.android.ecommerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements foodItemClicked {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView) findViewById(R.id.recycler_view);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        new FirebaseDatabaseHelper().readFood(new FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void DataLoaded(ArrayList<Elements> data, ArrayList<String> keys) {
                foodAdapter mAdapter=new foodAdapter(data,MainActivity.this,MainActivity.this);
                recyclerView.setAdapter(mAdapter);
            }

            @Override
            public void DataDeleted() {

            }

            @Override
            public void DataUpdated() {

            }
        });

    }

    @Override
    public void onItemClicked(String FoodName, int Price, String ImageUrl) {
        Intent transfer=new Intent(MainActivity.this,ClickedItem.class);
        transfer.putExtra("Name",FoodName);
        transfer.putExtra("Price",Price+"");
        transfer.putExtra("Url",ImageUrl);
        startActivity(transfer);
    }
}