package com.foodie.dogfoodcalculator;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class SecondActivity extends AppCompatActivity {

    public TextView BuyNum;
    public TextView LeftNum;
    // Call the No and Yes Buttons
    public Button Yes;
    public Button No;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        final String money = intent.getStringExtra("srMonLeft");
        final String food = intent.getStringExtra("srTtlFood");
        final String tax =intent.getStringExtra("ghostTax");
        final String price =intent.getStringExtra("ghostPrice");
        final String cash = intent.getStringExtra("ghostCash");
        BuyNum = (TextView) findViewById(R.id.tvBuyNum);
        LeftNum = (TextView) findViewById(R.id.tvleftNum);

        BuyNum.setText(food);
        LeftNum.setText(money);

        //tell it to look out for yes or no click and then say what to do
        No = (Button) findViewById(R.id.btNo);
        No.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(SecondActivity.this, RetryScreen.class);
//rechaning the variable names here is unnecessary, but ill fix it later
                String srMon = money;
                String ghostTax = tax;
                String ghostPrice = price;
                intent3.putExtra("srMon", srMon);
                intent3.putExtra("ghostTax", ghostTax);
                intent3.putExtra("ghostPrice", ghostPrice);
                intent3.putExtra("ghostCash", cash);
                startActivity(intent3);
            }
        });
        Yes = (Button) findViewById(R.id.btYes);
        Yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(SecondActivity.this, DogFoodCalc.class);
                startActivity(intent2);
            }
        });

        }}
    //}
