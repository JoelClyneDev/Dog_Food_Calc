package com.foodie.dogfoodcalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ForwardCalculationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forward_calculation);

        RecyclerView itemList = (RecyclerView) findViewById(R.id.item_price_list);

        //the list will always be the same length
        itemList.setHasFixedSize(true);

        LinearLayoutManager listManager = new LinearLayoutManager(this);

        itemList.setLayoutManager(listManager);


        Button newItem = (Button) findViewById(R.id.add_item_button);
        newItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ForwardCalculationActivity.this, NewItemPopup.class));
            }
        });

    }
}
