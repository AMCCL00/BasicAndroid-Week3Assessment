package com.example.rodneytressler.week3assessmentkey;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements AccountFragment.ActivityCallback {

    private AccountFragment accountFragment;

    public String name;
    public String accountClass;


    @BindView(R.id.welcome_text)
    protected TextView welcomeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        AccountFragment accountFragment = AccountFragment.newInstance();
        accountFragment.attachParent(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder, accountFragment).commit();


        }

    @Override
    public void accountCreated(String name, String accountClass){
        getSupportFragmentManager().beginTransaction().remove(accountFragment);
        welcomeText.setText("Welcome, " + name + " the " + accountClass +  "! /n The fate of the world is in your hands!");
    }
}
