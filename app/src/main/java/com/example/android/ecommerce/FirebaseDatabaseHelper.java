package com.example.android.ecommerce;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FirebaseDatabaseHelper {
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mReference;
    private ArrayList<Elements> data=new ArrayList<>();
    public interface DataStatus{
        void DataLoaded(ArrayList<Elements> data, ArrayList<String> keys);
        void DataDeleted();
        void DataUpdated();
    }

    public FirebaseDatabaseHelper() {
        this.mFirebaseDatabase=FirebaseDatabase.getInstance();
        this.mReference=mFirebaseDatabase.getReference("foods");
    }
    public void readFood(final DataStatus dataStatus)
    {
        mReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                data.clear();
                ArrayList<String> keys=new ArrayList<>();
                for(DataSnapshot keyNode: snapshot.getChildren())
                {
                    keys.add(keyNode.getKey());
                    Elements elements=keyNode.getValue(Elements.class);
                    data.add(elements);
                }
                dataStatus.DataLoaded(data,keys);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
