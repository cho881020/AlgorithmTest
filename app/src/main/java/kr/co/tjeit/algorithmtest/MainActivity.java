package kr.co.tjeit.algorithmtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private android.widget.Button test01Btn;
    private Button test02Btn;
    private Button test03Btn;
    private Button test04Btn;
    private Button test05Btn;
    private Button test06Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
        setupEvents();
    }

    private void setupEvents() {
        test01Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Test01Activity.class);
                startActivity(intent);
            }
        });

        test02Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Test02Activity.class);
                startActivity(intent);
            }
        });

        test03Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Test03Activity.class);
                startActivity(intent);
            }
        });

        test04Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Test04Activity.class);
                startActivity(intent);
            }
        });

        test05Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Test05Activity.class);
                startActivity(intent);
            }
        });

        test06Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Test06Activity.class);
                startActivity(intent);
            }
        });


    }

    private void bindViews() {
        this.test06Btn = (Button) findViewById(R.id.test06Btn);
        this.test05Btn = (Button) findViewById(R.id.test05Btn);
        this.test04Btn = (Button) findViewById(R.id.test04Btn);
        this.test03Btn = (Button) findViewById(R.id.test03Btn);
        this.test02Btn = (Button) findViewById(R.id.test02Btn);
        this.test01Btn = (Button) findViewById(R.id.test01Btn);
    }
}
