package com.example.inclass2a;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.text.TextUtils.isEmpty;

public class MainActivity extends AppCompatActivity {


    /* Creating variables for the application */
    EditText height_ft,height_inch,weight;
    TextView disBmi,disCategory;
    String weightValue,height_ft_Value,height_inch_value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        setTitle("BMI Calculator");
        weight=(EditText) findViewById(R.id.bd_weight);
        height_ft=(EditText) findViewById(R.id.bd_height_ft);
        height_inch=(EditText) findViewById(R.id.bd_height_inch);
        disBmi=(TextView) findViewById(R.id.bvalue_id);
        disCategory=(TextView)findViewById(R.id.bmi_category_id);

    }
    public void calculateBmi(View v)
    {
        weightValue=weight.getText().toString();
        Editable weightStr = weight.getText();
        Editable height_ft_str=height_ft.getText();
        Editable height_inch_str=height_inch.getText();
        if(isEmpty(weightStr)) {
            weight.setError("Enter a valid weight");
            weight.requestFocus();
            Toast.makeText(getBaseContext(), "Invalid Input" , Toast.LENGTH_SHORT).show();
            return;
        }else if (isEmpty(height_ft_str))
        {
            height_ft.setError("Enter a valid height in feets");
            height_ft.requestFocus();
            Toast.makeText(getBaseContext(), "Invalid Input" , Toast.LENGTH_SHORT).show();
            return;
        }else if (isEmpty(height_inch_str))
        {
            height_inch.setError("Enter a valid height in inches");
            height_inch.requestFocus();
            Toast.makeText(getBaseContext(), "Invalid Input" , Toast.LENGTH_SHORT).show();
            return;
        }

        float weightVal=Float.parseFloat(weightValue);

        height_ft_Value=height_ft.getText().toString();
        float heightftVal=Float.parseFloat(height_ft_Value)*12;

        height_inch_value=height_inch.getText().toString();
        float heightinchVal=Float.parseFloat(height_inch_value);

        float finalheight=heightftVal+heightinchVal;
        float BMIvalue=(weightVal/(finalheight*finalheight))*703;
        String dummytext="Your BMI: " + BMIvalue;
        disBmi.setText(dummytext);

        categoryDisplay(BMIvalue);
        Toast.makeText(getBaseContext(), "BMI Calculated" , Toast.LENGTH_SHORT).show();

    }

    private void categoryDisplay(float bmIvalue) {
        String CategoryText="";
        if(bmIvalue <= 18.5)
        {
            CategoryText="You are underweight" ;
        }else  if (bmIvalue > 18.5 && bmIvalue <= 24.9)
        {
            CategoryText="You are Normal weight" ;
        }else  if (bmIvalue > 24.9 && bmIvalue <= 29.9)
        {
            CategoryText="You are Over Weight" ;
        }
        else  if (bmIvalue > 29.9)
        {
            CategoryText="You are Obese" ;
        }
        disCategory.setText(CategoryText);
    }

}
