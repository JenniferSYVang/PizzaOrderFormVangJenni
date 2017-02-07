package jvang.cs.cis3334.pizzaorderformvangjenni;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;

public class MainActivity extends AppCompatActivity
{
    RadioButton rbLarge;
    RadioButton rbMedium;
    RadioButton rbSmall;
    CheckBox chkbxCheese;
    CheckBox chbxDelivery;
    Double total;
    TextView totalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rbLarge = (RadioButton) findViewById(R.id.radioButtonLarge);
        rbMedium = (RadioButton) findViewById(R.id.radioButtonMedium);
        rbSmall = (RadioButton) findViewById(R.id.radioButtonSmall);
        chkbxCheese = (CheckBox) findViewById(R.id.checkBoxXChz);
        chbxDelivery = (CheckBox) findViewById(R.id.checkBoxDelivery);
        total = 0.0;
        totalPrice = (TextView) findViewById(R.id.textViewDisplayTotal);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Pizza Order");
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Pizza Order", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void onBtnCalcClick(View view)
    {
        total = 0.00;
        if (rbSmall.isChecked())
        {
            rbMedium.setChecked(false);
            rbLarge.setChecked(false);
            total = total + 7.00;
        }
        else if(rbMedium.isChecked())
        {
            rbSmall.setChecked(false);
            rbLarge.setChecked(false);
            total = total + 9.00;
        }
        else if(rbLarge.isChecked())
        {
            rbMedium.setChecked(false);
            rbSmall.setChecked(false);
            total = total + 13.0;
        }

        if(chkbxCheese.isChecked() && chbxDelivery.isChecked())
        {
            total = total + 1.75 + 2.50;
        }
        else if(chbxDelivery.isChecked())
        {
            total = total + 2.50;
        }
        else if(chkbxCheese.isChecked())
        {
            total = total + 1.75;
        }

        totalPrice.setText(String.format("Total Price = $%.2f", total));
    }
}
