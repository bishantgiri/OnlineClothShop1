package com.example.onlineclothshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewDetailsActivity extends AppCompatActivity {
    private TextView etItemName,etItemPrice_view,etDesc;
    private ImageView imgItemView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_details);

        imgItemView=findViewById(R.id.ivDetailsImage);
        etItemName=findViewById(R.id.etItemNameView);
        etItemPrice_view=findViewById(R.id.etPrice_view);
        etDesc=findViewById(R.id.etItemDesc_view);

        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            imgItemView.setImageResource(Integer.parseInt(bundle.getString("itemImage")));
            etItemName.setText(bundle.getString("itemName"));
            etItemPrice_view.setText(bundle.getString("itemPrice"));
            etDesc.setText(bundle.getString("itemDesc"));
        }

    }
}
