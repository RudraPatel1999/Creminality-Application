package com.example.rudra.criminalityapplication;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class FirstPage extends AppCompatActivity {

    Button btn1,btn2,skip;
    EditText usname,pwd;
    CheckBox checkBox;
    TextView txt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);

        usname=(EditText)findViewById(R.id.usname);
        pwd=(EditText)findViewById(R.id.pwd);
        checkBox=(CheckBox)findViewById(R.id.checkbox);
        btn1=(Button)findViewById(R.id.btn1);
        btn2=(Button)findViewById(R.id.btn2);
        txt1=(TextView)findViewById(R.id.txt1);
        skip=(Button)findViewById(R.id.skip);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(usname.getText().toString().equals("admin")&&
                        pwd.getText().toString().equals("admin")){
                    Toast.makeText(getApplicationContext(),
                            "Redirecting...",Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(getApplicationContext(),"Wrong Credentials",Toast.LENGTH_SHORT).show();
                    txt1.setVisibility(View.VISIBLE);
                    txt1.setBackgroundColor(Color.RED);

                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
