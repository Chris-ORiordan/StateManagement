package com.example.standard.statemanagement;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.standard.statemanagement.databinding.ActivityMainBinding;

import icepick.*;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Bundle mState;
    @State String name;
    @State String age;
    @State boolean consenting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        Icepick.restoreInstanceState(this, savedInstanceState);
        binding.buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        name = binding.textName.getText().toString();
        age = binding.textAge.getText().toString();
        consenting = binding.checkConsent.isChecked();
        Icepick.saveInstanceState(this, outState);
    }
}
