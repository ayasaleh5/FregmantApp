package com.example.fregmantapp;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListFrag.itemselected{

    TextView tvdescription;
    String[] descriptions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvdescription = findViewById(R.id.tv_defult);

        descriptions = getResources().getStringArray(R.array.descriptions);

        if (findViewById(R.id.layout_portrait)!=null){

            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction()
                    .hide(manager.findFragmentById(R.id.detailfragment))
                    .show(manager.findFragmentById(R.id.listfragment))
            .commit();

        }
        if (findViewById(R.id.layout_land)!=null){

            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.detailfragment))
                    .show(manager.findFragmentById(R.id.listfragment))
                    .commit();
        }


    }


    @Override
    public void onItemSelected(int index) {
        tvdescription.setText(descriptions[index]);

        if (findViewById(R.id.layout_portrait)!=null){

            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.detailfragment))
                    .hide(manager.findFragmentById(R.id.listfragment))
                    .addToBackStack(null)
                    .commit();

        }
    }
}
