package com.foodie.dogfoodcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DogFoodCalc extends AppCompatActivity {

    public EditText Tax;
    public EditText Price;
    public EditText Cash;
    private TextView Title;
    private Button Ready;
    public TextView BuyNum;
    public TextView LeftNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog_food_calc);
        Price = (EditText) findViewById(R.id.numPrice);
        Tax = (EditText) findViewById(R.id.numTax);
        Cash = (EditText) findViewById(R.id.numCash);
        Title = (TextView) findViewById(R.id.tvTitle);
        Ready = (Button) findViewById(R.id.btDone);
        BuyNum = (TextView) findViewById(R.id.tvBuyNum);
        LeftNum = (TextView) findViewById(R.id.tvleftNum);

//if there's anything from the retry screen it will just poplulate the first screen
        Intent intent2 = getIntent();
        String newTax = intent2.getStringExtra("newTax");
        String newMon = intent2.getStringExtra("test");

        Cash.setText(newMon);
        Tax.setText(newTax);

        Ready.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate(Price.getText().toString(), Tax.getText().toString(), Cash.getText().toString());
            }
        });
    }
    private void calculate(String pr, String tx, String csh){
        if (!(pr.equals("") || tx.equals("") || csh.equals(""))){
            float numP = Float.parseFloat(pr);
            float numT = Float.parseFloat(tx);
            float numC = Float.parseFloat(csh);
            float cashAfterTax = (numC - numC * numT);
            cashAfterTax = (float) (Math.floor(cashAfterTax * 100.0) / 100.0);
            int ttlFood = (int) (cashAfterTax / numP);
            ttlFood = (int) (Math.floor(ttlFood));
            float monLeft = cashAfterTax % numP;
            monLeft = (float) (Math.floor(monLeft * 100.0) / 100.0);
            String srMonLeft = Float.toString(monLeft);
            String srTtlFood = Integer.toString(ttlFood);
            String ghostTax = Float.toString(numT);
            String ghostPrice = Float.toString(numP);
            String ghostCash = Float.toString(numC);
            Intent intent = new Intent(DogFoodCalc.this, SecondActivity.class);
            intent.putExtra("srMonLeft", srMonLeft);
            intent.putExtra("srTtlFood", srTtlFood);
            intent.putExtra("ghostTax", ghostTax);
            intent.putExtra("ghostPrice", ghostPrice);
            intent.putExtra("ghostCash", ghostCash);
            startActivity(intent);
        }
    }

}