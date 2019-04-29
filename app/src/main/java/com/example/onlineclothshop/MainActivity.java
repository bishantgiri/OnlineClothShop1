package com.example.onlineclothshop;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import fragment.LoginFragment;
import fragment.SignupFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnLoad;
    private Boolean status=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLoad=findViewById(R.id.btnLoad);
        btnLoad.setOnClickListener(this);
    }
    public void onClick(View v){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

        if(status){
            LoginFragment loginFragment=new LoginFragment();
            fragmentTransaction.replace(R.id.FragContainer,loginFragment);
            fragmentTransaction.commit();
            btnLoad.setText("Login");
            status=false;

        }else{
            SignupFragment signupFragment=new SignupFragment();
            fragmentTransaction.replace(R.id.FragContainer,signupFragment);
            fragmentTransaction.commit();
            btnLoad.setText("SignUp");
            status=true;
        }

    }
}
