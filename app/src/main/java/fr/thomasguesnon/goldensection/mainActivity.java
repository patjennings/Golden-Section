package fr.thomasguesnon.goldensection;

import java.math.BigDecimal;
import java.math.RoundingMode;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextWatcher;
import android.widget.EditText;
import android.text.Editable;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;

public class mainActivity extends Activity{

    EditText et0, et1, et2;
    RelativeLayout zone;
    TextView tv0, tv1, tv2;

    BigDecimal BD_newTotalValue = new BigDecimal(1618);
    BigDecimal BD_newBigValue = new BigDecimal(1000);
    BigDecimal BD_newSmallValue = new BigDecimal(618);

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        zone = (RelativeLayout)findViewById(R.id.entireZone);

        et0 = (EditText)findViewById(R.id.editText0);
        et1 = (EditText)findViewById(R.id.editText1);
        et2 = (EditText)findViewById(R.id.editText2);

        tv0 = (TextView)findViewById(R.id.textView0);
        tv1 = (TextView)findViewById(R.id.textView1);
        tv2 = (TextView)findViewById(R.id.textView2);

        Typeface RobotoTypeface = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Thin.ttf");
        et0.setTypeface(RobotoTypeface);
        et1.setTypeface(RobotoTypeface);
        et2.setTypeface(RobotoTypeface);

        tv0.setTypeface(RobotoTypeface);
        tv1.setTypeface(RobotoTypeface);
        tv2.setTypeface(RobotoTypeface);

        et0.setVisibility(View.INVISIBLE);
        et1.setVisibility(View.INVISIBLE);
        et2.setVisibility(View.INVISIBLE);

        tv0.setText(""+BD_newTotalValue);
        tv1.setText(""+BD_newBigValue);
        tv2.setText(""+BD_newSmallValue);

        zone.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {


                et0.setVisibility(View.INVISIBLE);
                et1.setVisibility(View.INVISIBLE);
                et2.setVisibility(View.INVISIBLE);

                tv0.setVisibility(View.VISIBLE);
                tv1.setVisibility(View.VISIBLE);
                tv2.setVisibility(View.VISIBLE);

            }
        });


        tv0.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                et0.setVisibility(View.VISIBLE);
                et1.setVisibility(View.INVISIBLE);
                et2.setVisibility(View.INVISIBLE);

                tv0.setVisibility(View.INVISIBLE);
                tv1.setVisibility(View.VISIBLE);
                tv2.setVisibility(View.VISIBLE);

                et0.setText(""+BD_newTotalValue);

            }
        });

        tv1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                et0.setVisibility(View.INVISIBLE);
                et1.setVisibility(View.VISIBLE);
                et2.setVisibility(View.INVISIBLE);

                tv0.setVisibility(View.VISIBLE);
                tv1.setVisibility(View.INVISIBLE);
                tv2.setVisibility(View.VISIBLE);

                et1.setText(""+BD_newBigValue);

            }
        });

        tv2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                et0.setVisibility(View.INVISIBLE);
                et1.setVisibility(View.INVISIBLE);
                et2.setVisibility(View.VISIBLE);

                tv0.setVisibility(View.VISIBLE);
                tv1.setVisibility(View.VISIBLE);
                tv2.setVisibility(View.INVISIBLE);

                et2.setText(""+BD_newSmallValue);

            }
        });

        // Listen to text change inside fields

        et0.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {

                if (et0.getText().length() > 0) {
                    double newTotalValue = Integer.parseInt(et0.getText().toString());
                    int editTextId = getResources().getIdentifier("editText0", "id", getPackageName());
                    updateFields(newTotalValue, editTextId);
                }

            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

        });

        et1.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {

                if(et1.getText().length() > 0)
                {
                    double newTotalValue = Integer.parseInt(et1.getText().toString());
                    int editTextId = getResources().getIdentifier("editText1", "id", getPackageName());
                    updateFields(newTotalValue, editTextId);
                }

            }
          public void beforeTextChanged(CharSequence s, int start, int count, int after){}
          public void onTextChanged(CharSequence s, int start, int before, int count){}

        });

        et2.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {

                if(et2.getText().length() > 0)
                {
                    double newTotalValue = Integer.parseInt(et2.getText().toString());
                    int editTextId = getResources().getIdentifier("editText2", "id", getPackageName());
                    updateFields(newTotalValue, editTextId);
                }

            }
          public void beforeTextChanged(CharSequence s, int start, int count, int after){}
          public void onTextChanged(CharSequence s, int start, int before, int count){}

        });

    }



    public void updateFields(double updatedValue, int etId) {

        System.out.println("//////// HERE !" + etId);

        double newTotalValue = 0;
        double newBigValue = 0;
        double newSmallValue = 0;

        if (etId == 2131230722) {
            newTotalValue = updatedValue;
            newBigValue = newTotalValue / 1.618;
            newSmallValue = newBigValue / 1.618;

        }
        if (etId == 2131230726) {
            newBigValue = updatedValue;
            newTotalValue = newBigValue * 1.618;
            newSmallValue = newBigValue / 1.618;

        }
        if (etId == 2131230729) {
            newSmallValue = updatedValue;
            newTotalValue = (newSmallValue * 1.618) * 1.618;
            newBigValue = newSmallValue * 1.618;

        }


        BD_newTotalValue = new BigDecimal(newTotalValue);
        BD_newTotalValue = BD_newTotalValue.setScale(0, RoundingMode.FLOOR);

        BD_newBigValue = new BigDecimal(newBigValue);
        BD_newBigValue = BD_newBigValue.setScale(0, RoundingMode.FLOOR);

        BD_newSmallValue = new BigDecimal(newSmallValue);
        BD_newSmallValue = BD_newSmallValue.setScale(0, RoundingMode.CEILING);


        tv0.setText(""+BD_newTotalValue);
        tv1.setText(""+BD_newBigValue);
        tv2.setText(""+BD_newSmallValue);

    }

}