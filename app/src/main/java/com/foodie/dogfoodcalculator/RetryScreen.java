package com.foodie.dogfoodcalculator;

/**
 * Created by pkemn on 6/1/2018.
 */
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class RetryScreen extends  AppCompatActivity{

    public TextView Question;
    public EditText Amount;
    public Button Donzo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retry_screen);

        Amount = findViewById(R.id.numBox);
        Question = findViewById(R.id.BoxAsk);
        Donzo = findViewById(R.id.btReady2);

        //Get all of the variables over from Second Activity
        Intent intent3 = getIntent();
        String newCash = intent3.getStringExtra("srMon");
        final String newTax = intent3.getStringExtra("ghostTax");
        String newPrice = intent3.getStringExtra("ghostPrice");
        String newCash2 = intent3.getStringExtra("ghostCash");
        final float calcMon = Float.parseFloat(newCash);
        final float calcTax = Float.parseFloat(newTax);
        final float calcPrice = Float.parseFloat(newPrice);
        final float calcCash = Float.parseFloat(newCash2);
        Donzo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recalculate(Amount.getText().toString(), calcMon, calcTax, calcPrice,calcCash);
            }
        });
    }

    private void recalculate(String amt, Float csh, Float tx, Float pr, Float cc) {
        float left = Float.parseFloat(amt);
        float leftWithTax = cc - (pr * left + pr * left * tx);

        //double withTax = (double)leftWithTax;
       // double csh2 = (double)csh;
        //float monAftCalc = (float)(Math.floor(csh2 - withTax));
        //get rid of csh, cc works and is the right value (check other java files)

       //convert float to double for rounding down (makes float a string first, then parses the string as a double, then reversing it after math.floor rounds it to make it a float
        //then multiply by 100d for 2 decimal place precision, check the placing of the 100d's https://stackoverflow.com/questions/153724/how-to-round-a-number-to-n-decimal-places-in-java
        double rounding = (Math.floor((Double.parseDouble(new Float(leftWithTax).toString())) * 100d)/100d);
        float calcDone= Float.parseFloat(new Double(rounding).toString());

//it works but i rounded to the lower whole number and not to 2 decimal places, ill save it bcs its good to know tho
        String newMonAftCalc = Float.toString(calcDone);
        String strTax = Float.toString(tx);
        Intent intent2 = new Intent(RetryScreen.this, DogFoodCalc.class);
        //intent2.putExtra("newMonAftCalc", newMonAftCalc);
        intent2.putExtra("test", newMonAftCalc);
        intent2.putExtra("newTax", strTax);
        startActivity(intent2);
    }
}