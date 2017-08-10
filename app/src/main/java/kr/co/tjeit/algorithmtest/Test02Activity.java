package kr.co.tjeit.algorithmtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Test02Activity extends AppCompatActivity {

    private android.widget.EditText inputEdt;
    private android.widget.Button btn01;
    private android.widget.TextView resultTxt;
    private Button btn02;
    private Button btn03;
    private Button btn04;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test02);
        bindViews();
        setupEvents();
    }

    private void setupEvents() {
        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printStar01();
            }
        });
        btn02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printStar02();
            }
        });
        btn03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printStar03();
            }
        });
        btn04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printStar04();
            }
        });
    }

    private void printStar01() {
        String resultStr = "";
        // 가공 과정...
        int forSize = Integer.parseInt(inputEdt.getText().toString());
        for (int i = 0; i < forSize; i++) {
            for (int j = 0; j <= i; j++) {
                resultStr += "*";
            }
            resultStr += "\n";
        }
        resultTxt.setText(resultStr);

        resultTxt.setGravity(Gravity.LEFT);
    }


    private void printStar02() {
        String resultStr = "";
        // 가공 과정...
        int forSize = Integer.parseInt(inputEdt.getText().toString());
        for (int i = 0; i < forSize; i++) {
            for (int j = 0; j <= i; j++) {
                resultStr += "*";
            }
            resultStr += "\n";
        }
        resultTxt.setText(resultStr);

        resultTxt.setGravity(Gravity.RIGHT);

    }


    private void printStar03() {
        String resultStr = "";
        // 가공 과정...
        int forSize = Integer.parseInt(inputEdt.getText().toString());

        for (int i = forSize; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                resultStr += "*";
            }
            resultStr += "\n";
        }
        resultTxt.setText(resultStr);

        resultTxt.setGravity(Gravity.LEFT);
    }


    private void printStar04() {
        String resultStr = "";
        // 가공 과정...
        int forSize = Integer.parseInt(inputEdt.getText().toString());

        for (int i = forSize; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                resultStr += "*";
            }
            resultStr += "\n";
        }
        resultTxt.setText(resultStr);

        resultTxt.setGravity(Gravity.RIGHT);
    }

    private void bindViews() {
        this.resultTxt = (TextView) findViewById(R.id.resultTxt);
        this.btn04 = (Button) findViewById(R.id.btn04);
        this.btn03 = (Button) findViewById(R.id.btn03);
        this.btn02 = (Button) findViewById(R.id.btn02);
        this.btn01 = (Button) findViewById(R.id.btn01);
        this.inputEdt = (EditText) findViewById(R.id.inputEdt);
    }
}
