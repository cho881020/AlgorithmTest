package kr.co.tjeit.algorithmtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class Test04Activity extends AppCompatActivity {

    private android.widget.CheckBox chkBox01;
    private android.widget.CheckBox chkBox02;
    private android.widget.CheckBox chkBox03;
    private android.widget.CheckBox chkBox04;
    private android.widget.CheckBox chkBox05;
    private android.widget.CheckBox chkBox06;
    private android.widget.CheckBox chkBox07;
    private android.widget.CheckBox chkBox08;
    private android.widget.CheckBox chkBox09;
    private android.widget.CheckBox chkBox10;
    private android.widget.CheckBox chkBox11;
    private android.widget.CheckBox chkBox12;
    private android.widget.CheckBox chkBox13;
    private android.widget.CheckBox chkBox14;
    private android.widget.CheckBox chkBox15;
    private android.widget.CheckBox chkBox16;
    private android.widget.CheckBox chkBox17;
    private android.widget.CheckBox chkBox18;
    private android.widget.CheckBox chkBox19;
    private android.widget.CheckBox chkBox20;
    private android.widget.CheckBox chkBox21;
    private android.widget.CheckBox chkBox22;
    private android.widget.CheckBox chkBox23;
    private android.widget.CheckBox chkBox24;
    private android.widget.CheckBox chkBox25;
    private android.widget.Button allBtn;
    private Button diagonalBtn;
    private Button boaderBtn;
    private Button resetBtn;
    private android.widget.TextView bingoCountTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test04);
        bindViews();
        setupEvents();
        setValues();
    }

    private void setValues() {


    }

    private void setupEvents() {

        final CheckBox[][] boxes =
                {
                        {chkBox01, chkBox02, chkBox03, chkBox04, chkBox05},
                        {chkBox06, chkBox07, chkBox08, chkBox09, chkBox10},
                        {chkBox11, chkBox12, chkBox13, chkBox14, chkBox15},
                        {chkBox16, chkBox17, chkBox18, chkBox19, chkBox20},
                        {chkBox21, chkBox22, chkBox23, chkBox24, chkBox25},
                };


        allBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        boxes[i][j].setChecked(true);
                    }
                }

            }
        });

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        boxes[i][j].setChecked(false);
                    }
                }
            }
        });

        diagonalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {

                        if (i == j || i + j == 4) {
                            boxes[i][j].setChecked(true);
                        } else {
                            boxes[i][j].setChecked(false);
                        }
                    }
                }
            }
        });

        boaderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {

                        if (i == 0 || i == 4 || j == 0 || j == 4) {
                            boxes[i][j].setChecked(true);
                        } else {
                            boxes[i][j].setChecked(false);
                        }
                    }
                }
            }
        });


        CompoundButton.OnCheckedChangeListener checkListener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                // 빙고 줄 판별 알고리즘.

                int bingoCount = 0;
                // 체크가 눌릴때 마다 빙고 갯수를 세어줄 변수.

                /* 가로 빙고 검사 반복문 */

                for (int i=0; i < 5 ; i++) {
                    // 세로로 내려가는걸 담당하는 반복문

                    boolean isBingo = true;
                    // 기본적으로는 빙고가 맞다 라고 전제.

                    for (int j=0 ; j<5 ; j++) {
                        // 가로로 한칸한칸 반복을 돌면서
                        if (!boxes[i][j].isChecked()) {
                            // 혹시 체크가 안된게 있는지 검사.
                            isBingo = false;
                            // 체크가 안된게 있다면, 이 가로줄은 빙고가 아니라고 변경.
                        }
                    }

                    if (isBingo) {
                        // 검사가 끝나고 난 후, 빙고 상태가 true로 유지되는지 물어봄.
                        bingoCount++;
                        // 유지 된다면 이 가로줄은 빙고가 맞으므로 카운트를 1개 올려줌.
                    }

                }

                // 세로 검사 로직.

                for (int i=0; i < 5 ; i++) {

                    boolean isBingo = true;

                    for (int j=0 ; j<5 ; j++) {
                        if (!boxes[j][i].isChecked()) {
                            isBingo = false;
                        }
                    }

                    if (isBingo) {
                        bingoCount++;
                    }

                }


                // 좌상 -> 우하 대각선 검사.
                boolean isBingo01 = true;
                // 전용 빙고 여부 변수
                for (int i=0 ; i < 5 ; i++) {
                    if (!boxes[i][i].isChecked()) {
                        // i,i => 0,0 1,1 2,2 3,3 4,4
                        isBingo01 = false;
                    }
                }
                if (isBingo01) {
                    bingoCount++;
                }


                // 우상 -> 좌하 대각선 검사
                boolean isBingo02 = true;
                for (int i=0 ; i < 5 ; i++) {
                    if (!boxes[i][4-i].isChecked()) {
                        // 0,4 1,3 2,2 3,1 4,0
                        isBingo02 = false;
                    }
                }
                if (isBingo02) {
                    bingoCount++;
                }



                String resultStr = String.format(Locale.KOREA, "빙고 줄 수는 %d개 입니다.", bingoCount);
                bingoCountTxt.setText(resultStr);

            }
        };

        for (int i=0; i < 5 ; i++) {
            for (int j=0 ; j < 5 ;j++) {
                boxes[i][j].setOnCheckedChangeListener(checkListener);
            }
        }

    }

    private void bindViews() {
        this.bingoCountTxt = (TextView) findViewById(R.id.bingoCountTxt);
        this.chkBox25 = (CheckBox) findViewById(R.id.chkBox25);
        this.chkBox24 = (CheckBox) findViewById(R.id.chkBox24);
        this.chkBox23 = (CheckBox) findViewById(R.id.chkBox23);
        this.chkBox22 = (CheckBox) findViewById(R.id.chkBox22);
        this.chkBox21 = (CheckBox) findViewById(R.id.chkBox21);
        this.chkBox20 = (CheckBox) findViewById(R.id.chkBox20);
        this.chkBox19 = (CheckBox) findViewById(R.id.chkBox19);
        this.chkBox18 = (CheckBox) findViewById(R.id.chkBox18);
        this.chkBox17 = (CheckBox) findViewById(R.id.chkBox17);
        this.chkBox16 = (CheckBox) findViewById(R.id.chkBox16);
        this.chkBox15 = (CheckBox) findViewById(R.id.chkBox15);
        this.chkBox14 = (CheckBox) findViewById(R.id.chkBox14);
        this.chkBox13 = (CheckBox) findViewById(R.id.chkBox13);
        this.chkBox12 = (CheckBox) findViewById(R.id.chkBox12);
        this.chkBox11 = (CheckBox) findViewById(R.id.chkBox11);
        this.chkBox10 = (CheckBox) findViewById(R.id.chkBox10);
        this.chkBox09 = (CheckBox) findViewById(R.id.chkBox09);
        this.chkBox08 = (CheckBox) findViewById(R.id.chkBox08);
        this.chkBox07 = (CheckBox) findViewById(R.id.chkBox07);
        this.chkBox06 = (CheckBox) findViewById(R.id.chkBox06);
        this.chkBox05 = (CheckBox) findViewById(R.id.chkBox05);
        this.chkBox04 = (CheckBox) findViewById(R.id.chkBox04);
        this.chkBox03 = (CheckBox) findViewById(R.id.chkBox03);
        this.chkBox02 = (CheckBox) findViewById(R.id.chkBox02);
        this.chkBox01 = (CheckBox) findViewById(R.id.chkBox01);
        this.resetBtn = (Button) findViewById(R.id.resetBtn);
        this.boaderBtn = (Button) findViewById(R.id.boaderBtn);
        this.diagonalBtn = (Button) findViewById(R.id.diagonalBtn);
        this.allBtn = (Button) findViewById(R.id.allBtn);
    }
}
