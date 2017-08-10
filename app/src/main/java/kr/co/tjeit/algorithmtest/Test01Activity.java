package kr.co.tjeit.algorithmtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class Test01Activity extends AppCompatActivity {

    private android.widget.EditText inputEdt;
    private android.widget.Button okBtn;
    private android.widget.TextView resultTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test01);
        bindViews();
        setupEvents();
    }

    private void setupEvents() {
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateSum();
            }
        });
    }

    private void calculateSum() {
        int result = 0;

        // EditText에 입력된것은 무조건 String으로 변환해서 사용.
        // 우리가 하고자 하는 계산은, 숫자 연산 (int)
        // String -> int 변환.
        // Google -> java (android) String to int

        int forSize = Integer.parseInt(inputEdt.getText().toString());


        for (int i=1 ; i <= forSize ; i++) {

            if (i % 3 == 0 || i % 5 == 0) {
                result += i;
            }

        }
        String resultStr = String.format(Locale.KOREA, "입력한 숫자까지의 3과 5의 배수의 총 합은 %d 입니다.", result);
        resultTxt.setText(resultStr);

    }

    private void bindViews() {

        this.resultTxt = (TextView) findViewById(R.id.resultTxt);
        this.okBtn = (Button) findViewById(R.id.okBtn);
        this.inputEdt = (EditText) findViewById(R.id.inputEdt);
    }
}
