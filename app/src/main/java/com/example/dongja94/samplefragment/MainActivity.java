package com.example.dongja94.samplefragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    FirstFragment firstFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstFragment = (FirstFragment)getSupportFragmentManager().findFragmentById(R.id.first_fragment);

        Button btn = (Button)findViewById(R.id.btn_show_fragment);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment f = new FirstFragment();
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, f);
                ft.commit();
            }
        });

        btn = (Button)findViewById(R.id.btn_message);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = firstFragment.getMessage();
                Toast.makeText(MainActivity.this, "message : " + message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
