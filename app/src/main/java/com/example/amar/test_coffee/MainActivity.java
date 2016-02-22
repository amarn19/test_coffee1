package com.example.amar.test_coffee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    int q1=0,q2=0,q3=0,q4=0;String pm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void increment(View v)
    { int id=v.getId();
        switch(id)
        {
            case R.id.m2:q1++;display(1,q1);break;
            case R.id.m4:q2++;display(2,q2);break;
            case R.id.m6:q3++;display(3,q3);break;
            case R.id.m8:q4++;display(4,q4);break;
        }
    }
    public void decrement(View v) {
        int id=v.getId();
        switch(id)
        {
            case R.id.m1: if (q1 > 0) {
                q1--;
                display(1,q1);
            }break;
            case R.id.m3:if (q2 > 0) {
                q2--;
                display(2,q2);}break;
            case R.id.m5:if (q3 > 0) {
                q3--;
                display(3,q3);}break;
            case R.id.m7:if (q4 > 0) {
                q4--;
                display(4,q4);}break;
        }

    }
    public void orders(View view)
    {

        EditText txt= (EditText) findViewById(R.id.name);
        String name=txt.getText().toString();
        int a=(q1 * 5) + (q2 * 4) + (q3 * 3) + (q4 * 2);
       display_price(a);
        display_summary(name,a);
    }
    public void display_summary(String n,int a)
    {
         pm="Mill Name:" + n;
        pm+="\nNo A3 sheets: " + q1;
        pm+="\nNo A2 sheets: " + q2;
        pm+="\nNo A4 sheets: " + q3;
        pm+="\nNo legal sheets: " + q4;
        pm+="\nTotal price: " +a;
        pm+="\nThank you ";
        TextView text=(TextView)findViewById(R.id.s1);
        text.setText("" + pm);
    }
    public void display(int z,int p)
    {
        switch(z)
    {
        case 1: TextView text=(TextView)findViewById(R.id.q1);
            text.setText(""+p);break;
        case 2:TextView text1=(TextView)findViewById(R.id.q2);
            text1.setText(""+p);break;
        case 3:TextView text2=(TextView)findViewById(R.id.q3);
            text2.setText(""+p);break;
        case 4:TextView text3=(TextView)findViewById(R.id.q4);
            text3.setText(""+p);break;
    }

    }
    public void display_price(int q)
    {
       TextView text1=(TextView)findViewById(R.id.price);
        text1.setText(NumberFormat.getCurrencyInstance().format(q));

    }
    public void sendemail(View view)
    {
        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{"amarp94@yahoo.com"});
        email.putExtra(Intent.EXTRA_SUBJECT, "orderSummary");
        email.putExtra(Intent.EXTRA_TEXT,pm);
        email.setType("message/rfc822");
        startActivity(Intent.createChooser(email, "Choose an Email client :"));
    }
}
