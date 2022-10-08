package com.lunarvnx.scorekeeper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Nilai Counter
    private int mCounter1;
    private int mCounter2;

    // Deklarasi Component
    private TextView tvCounter1;
    private TextView tvCounter2;
    private Button btnPlus1;
    private Button btnMinus1;
    private Button btnPlus2;
    private Button btnMinus2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Variable Counter
        mCounter1 = 0;
        mCounter2 = 0;

        // Deklarasi ID Komponen
        tvCounter1 = (TextView) findViewById(R.id.tvCounterTeam1);
        tvCounter2 = (TextView) findViewById(R.id.tvCounterTeam2);
        btnPlus1 = (Button) findViewById(R.id.btnPlusTeam1);
        btnMinus1 = (Button) findViewById(R.id.btnMinusTeam1);
        btnPlus2 = (Button) findViewById(R.id.btnPlusTeam2);
        btnMinus2 = (Button) findViewById(R.id.btnMinusTeam2);

        // Mengisi Value TextView
        tvCounter1.setText(String.valueOf(mCounter1));
        tvCounter2.setText(String.valueOf(mCounter2));

        if (savedInstanceState != null) {
            String count1 = savedInstanceState.getString("STATE_SCORE_1");
            String count2 = savedInstanceState.getString("STATE_SCORE_2");
            if (count1 != null){
                tvCounter1.setText(String.valueOf(count1));
            } else if( count2 != null){
                tvCounter1.setText(String.valueOf(count2));
            }

        }

        // Cara Alternative set onClick
//        btnPlus1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.menuNightMode).setTitle("Night Mode");
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menuNightMode){
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
            recreate();
        }
        return true;
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("STATE_SCORE_1", String.valueOf(mCounter1));
        outState.putString("STATE_SCORE_2", String.valueOf(mCounter2));

    }



    public void increaseScore(View view){
        int viewId = view.getId();
        switch (viewId){
            case R.id.btnPlusTeam1:
                ++mCounter1;
                tvCounter1.setText(String.valueOf(mCounter1));
                break;

            case R.id.btnPlusTeam2:
                ++mCounter2;
                tvCounter2.setText(String.valueOf(mCounter2));
                break;
        }


    }

    public void decreaseScore(View view){
        int viewId = view.getId();
        switch (viewId){
            case R.id.btnMinusTeam1:
                if(mCounter1 == 0){
                    Toast.makeText(this, "Score Cannot Be Minus", Toast.LENGTH_SHORT).show();
                } else {
                    --mCounter1;
                    tvCounter1.setText(String.valueOf(mCounter1));
                }

                break;

            case R.id.btnMinusTeam2:
                if(mCounter2 == 0){
                    Toast.makeText(this, "Score Cannot Be Minus", Toast.LENGTH_SHORT).show();
                } else{
                    --mCounter2;
                    tvCounter2.setText(String.valueOf(mCounter2));
                }
                break;
        }


    }


}