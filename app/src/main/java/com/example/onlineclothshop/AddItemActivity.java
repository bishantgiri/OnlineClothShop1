package com.example.onlineclothshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.PrintStream;

public class AddItemActivity extends AppCompatActivity {
    private Button btnAddItem,btnback;
    private EditText etItemName,etPrice,etImageName,etItemDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        btnAddItem=findViewById(R.id.btnAddItem);
        etItemName=findViewById(R.id.etItemName);
        etPrice=findViewById(R.id.etItemPrice);
        etImageName=findViewById(R.id.etItemImage);
        etItemDesc=findViewById(R.id.etItemDesc);
        btnback=findViewById(R.id.btnback);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AddItemActivity.this,DashboardActivityOne.class);
            }
        });

        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveItme();

            }
        });
    }
    private void SaveItme(){
        String itemname="itemname";
        String itemprice="itemprice";
        String itemimage="itemimage";
        String itemdesc="itemdesc";
        try{
            PrintStream printStream=new PrintStream(openFileOutput("item.txt",MODE_PRIVATE | MODE_APPEND));
            printStream.println(etItemName.getText().toString()+"->"+etPrice.getText().toString()+"->"+etImageName.getText().toString()+"->"+etItemDesc.getText().toString());

            Toast.makeText(this,"Saved to"+getFilesDir(),Toast.LENGTH_SHORT).show();
            etImageName.setText("");
            etPrice.setText("");
            etItemDesc.setText("");
            etItemName.setText("");

        }catch (IOException e){
            Log.d("Online Cloth App","Error: "+e.toString());
            e.printStackTrace();
        }
    }
}
