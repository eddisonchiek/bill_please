package sg.edu.sg.c346.id21034014.billplease;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;


public class MainActivity extends AppCompatActivity {
    EditText amount;
    EditText numPax;
    ToggleButton svs;
    ToggleButton gst;
    TextView totalBill;
    TextView eachPays;
    Button split;
    Button reset;
    EditText discount;
    Button PayNow;




    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        amount = findViewById(R.id.editInputAmount);
        numPax = findViewById(R.id.editInputNumPax);
        totalBill = findViewById(R.id.textTotalBill);
        eachPays = findViewById(R.id.textEachPays);
        svs = findViewById(R.id.tbSvs);
        gst = findViewById(R.id.Gst);
        split = findViewById(R.id.split);
        reset = findViewById(R.id.reset);
        discount = findViewById(R.id.editInputDiscount);
        PayNow = findViewById(R.id.PayNowBTN);



        split.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (amount.getText().toString().trim().length() != 0 && numPax.getText().toString().trim().length() != 0) {
                    double newAmt = 0.0;
                    if (!svs.isChecked() && !gst.isChecked()) {
                        newAmt = Double.parseDouble(amount.getText().toString());
                    } else if (svs.isChecked() && !gst.isChecked()) {
                        newAmt = Double.parseDouble(amount.getText().toString()) * 1.1;
                    } else if (!svs.isChecked() && gst.isChecked()) {
                        newAmt = Double.parseDouble(amount.getText().toString()) * 1.07;
                    } else {
                        newAmt = Double.parseDouble(amount.getText().toString()) * 1.17;
                    }
//Discount
                    if (discount.getText().toString().trim().length() != 0) {
                        newAmt *= 1 - Double.parseDouble(discount.getText().toString()) / 100;
                    }
                    totalBill.setText("Total Bill: $" + String.format("%.2f", newAmt));
                    int numPerson = Integer.parseInt(numPax.getText().toString());
                    if (numPerson != 1 && PayNow.isPressed())
                        eachPays.setText("Each Pays: $" + String.format("%.2f", newAmt / numPerson) + " to 98273887");
                    else if(numPerson!=1)
                        eachPays.setText("Each Pays: $" + String.format("%.2f", newAmt / numPerson);
                    else
                        eachPays.setText("Each Pays: $" + newAmt);



                }
                if(reset.isPressed())
                    isDestroyed();



            }

        });



    }



}
