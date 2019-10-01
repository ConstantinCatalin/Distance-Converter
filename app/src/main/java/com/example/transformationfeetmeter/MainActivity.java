package com.example.transformationfeetmeter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    TextView conv_result;
    TextView indicator_txt;
    EditText input;
    Button transform_btn;
    Button swap_btn;
    boolean swap = true;

    DecimalFormat df = new DecimalFormat("####0.0000");

    public void method_transform(View v)
    {
        if(input.getText().toString().equals(""))
        {
            Log.d("error", "incorrect input");
            input.setText("0");
        }

        if(swap)
        {
            double result = Double.parseDouble(input.getText().toString());
            result = result * 0.3048;
            String finalResult = df.format(result) + " meters";
            conv_result.setText(finalResult);
        }else
        {
            double result = Double.parseDouble(input.getText().toString());
            result = result * (1 / 0.3048);
            String finalResult = df.format(result) + " feet";
            conv_result.setText(finalResult);
        }


    }

    public void method_swap(View v)
    {
        swap = !swap;
        if(swap)
        {
            indicator_txt.setText("ft");
            conv_result.setText("0");
            input.setText("");
            input.setHint("Insert feet");
        }else
        {
            indicator_txt.setText("m");
            input.setHint("Insert meters");
            conv_result.setText("0");
            input.setText("");
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swap_btn= findViewById(R.id.swap_btn);
        transform_btn= findViewById(R.id.transform_btn);
        input= findViewById(R.id.input);
        conv_result= findViewById(R.id.conv_result);
        indicator_txt= findViewById(R.id.indicator_txt);

    }

}
