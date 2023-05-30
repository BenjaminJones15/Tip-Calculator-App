package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button NoRound = findViewById(R.id.NoRound);     //creates instances of all buttons and textboxes
        Button TipRound = findViewById(R.id.TipRound);
        Button NearestDollar = findViewById(R.id.NearestDollar);
        EditText BillAmount = findViewById(R.id.BillAmount);
        EditText TipAmount = findViewById(R.id.TipAmount);
        TextView TipValue = findViewById(R.id.TipValue);
        TextView FinalBillValue = findViewById(R.id.FinalBillValue);
        double Bill = 0;
        double Tip = 0;

        NoRound.setOnClickListener(new View.OnClickListener() {     //listener for No Round button
            @Override
            public void onClick(View v) {
                double Bill;
                double Tip;

                try {           //turns Bill into integer and then double
                    Bill = Integer.parseInt(BillAmount.getText().toString());
                    if (Bill <= 0){
                        throw new IllegalArgumentException();
                    }
                } catch(NumberFormatException nfe) {        //catches if anything but integer is entered
                    Toast.makeText(MainActivity.this, "Please enter a number for the bill",Toast.LENGTH_LONG).show();
                    return;
                } catch(IllegalArgumentException e){        //catches if a negative number is entered
                    Toast.makeText(MainActivity.this, "Please enter a positive number for the bill",Toast.LENGTH_LONG).show();
                    return;
                }

                try {           //turns Tip into integer and then double
                    Tip = Integer.parseInt(TipAmount.getText().toString());
                    if (Tip <= 0){
                        throw new IllegalArgumentException();
                    }
                } catch(NumberFormatException nfe) {        //catches if anything but integer is entered
                    Toast.makeText(MainActivity.this, "Please enter a number for the tip",Toast.LENGTH_LONG).show();
                    return;
                } catch(IllegalArgumentException e){        //catches if a negative number is entered
                    Toast.makeText(MainActivity.this, "Please enter a positive number for the tip",Toast.LENGTH_LONG).show();
                    return;
                }

                Tip =  (Tip/100)*Bill;      //gets tip value
                Bill = Bill + Tip;          //gets total bill value with tip

                NumberFormat TwoDP = NumberFormat.getNumberInstance();      //turns bill and tip into 2 decimal places
                TwoDP.setMinimumFractionDigits(2);
                TwoDP.setMaximumFractionDigits(2);

                String tip = TwoDP.format(Tip);
                String bill = TwoDP.format(Bill);

                TipValue.setText("£" + tip);               //sets values of TipValue and FinalBillValue to the right values
                FinalBillValue.setText("£" + bill);
            }
        });

        TipRound.setOnClickListener(new View.OnClickListener() {     //listener for No Round button
            @Override
            public void onClick(View v) {
                double Bill;
                double Tip;

                try {       //turns Bill into integer and then double
                    Bill = Integer.parseInt(BillAmount.getText().toString());
                    if (Bill <= 0){
                        throw new IllegalArgumentException();
                    }
                } catch(NumberFormatException nfe) {            //catches if anything but integer is entered
                    Toast.makeText(MainActivity.this, "Please enter a number for the bill",Toast.LENGTH_LONG).show();
                    return;
                } catch(IllegalArgumentException e){        //catches if a negative number is entered
                Toast.makeText(MainActivity.this, "Please enter a positive number for the bill",Toast.LENGTH_LONG).show();
                return;
            }

                try {           //turns Tip into integer and then double
                    Tip = Integer.parseInt(TipAmount.getText().toString());
                    if (Tip <= 0){
                        throw new IllegalArgumentException();
                    }
                } catch(NumberFormatException nfe) {        //catches if anything but integer is entered
                    Toast.makeText(MainActivity.this, "Please enter a number for the tip",Toast.LENGTH_LONG).show();
                    return;
                } catch(IllegalArgumentException e){        //catches if a negative number is entered
                    Toast.makeText(MainActivity.this, "Please enter a positive number for the tip",Toast.LENGTH_LONG).show();
                    return;
                }

                Tip =  (Tip/100)*Bill;      //gets tip value
                Bill = Bill + Tip;          //gets total bill value with tip
                int RBill = (int) Math.round(Bill);     //rounds total bill to nearest dollar
                Bill = RBill;

                NumberFormat TwoDP = NumberFormat.getNumberInstance();      //turns bill and tip into 2 decimal places
                TwoDP.setMinimumFractionDigits(2);
                TwoDP.setMaximumFractionDigits(2);

                String tip = TwoDP.format(Tip);
                String bill = TwoDP.format(RBill);

                TipValue.setText("£" + tip);               //sets values of TipValue and FinalBillValue to the right values
                FinalBillValue.setText("£" + bill);
            }
        });

        NearestDollar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double Bill;
                double Tip;

                try {           //turns Bill into integer and then double
                    Bill = Integer.parseInt(BillAmount.getText().toString());
                    if (Bill <= 0){
                        throw new IllegalArgumentException();
                    }
                } catch(NumberFormatException nfe) {        //catches if anything but integer is entered
                    Toast.makeText(MainActivity.this, "Please enter a number for the bill",Toast.LENGTH_LONG).show();
                    return;
                } catch(IllegalArgumentException e){        //catches if a negative number is entered
                    Toast.makeText(MainActivity.this, "Please enter a positive number for the bill",Toast.LENGTH_LONG).show();
                    return;
                }

                try {           //turns Tip into integer and then double
                    Tip = Integer.parseInt(TipAmount.getText().toString());
                    if (Tip <= 0){
                        throw new IllegalArgumentException();
                    }
                } catch(NumberFormatException nfe) {        //catches if anything but integer is entered
                    Toast.makeText(MainActivity.this, "Please enter a number for the tip",Toast.LENGTH_LONG).show();
                    return;
                } catch(IllegalArgumentException e){        //catches if a negative number is entered
                    Toast.makeText(MainActivity.this, "Please enter a positive number for the tip",Toast.LENGTH_LONG).show();
                    return;
                }

                Tip =  (Tip/100)*Bill;      //gets tip value
                int RTip = (int) Math.round(Tip);       //rounds tip to nearest dollar
                Bill = Bill + RTip;          //gets total bill value with tip

                NumberFormat TwoDP = NumberFormat.getNumberInstance();      //turns bill and tip into 2 decimal places
                TwoDP.setMinimumFractionDigits(2);
                TwoDP.setMaximumFractionDigits(2);

                String tip = TwoDP.format(Tip);
                String bill = TwoDP.format(Bill);

                TipValue.setText("£" + tip);               //sets values of TipValue and FinalBillValue to the right values
                FinalBillValue.setText("£" + bill);
            }
        });

    }
}