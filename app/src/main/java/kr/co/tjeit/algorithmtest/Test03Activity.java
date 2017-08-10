package kr.co.tjeit.algorithmtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import kr.co.tjeit.algorithmtest.adapter.GuguAdapter;
import kr.co.tjeit.algorithmtest.data.GuguData;

public class Test03Activity extends AppCompatActivity {


    private android.widget.Button btn02;
    private android.widget.ListView guguListView;

    List<GuguData> guguDatas = new ArrayList<>();
    GuguAdapter mAdapter;
    private Button btn03;
    private Button btn04;
    private Button btn05;
    private Button btn06;
    private Button btn07;
    private Button btn08;
    private Button btn09;
    private Button btnTotal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test03);
        bindViews();
        setupEvents();
        setValues();
    }

    private void setValues() {
        mAdapter = new GuguAdapter(Test03Activity.this, guguDatas);
        guguListView.setAdapter(mAdapter);
    }

    private void setupEvents() {

        View.OnClickListener guguListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int dan = Integer.parseInt(v.getTag().toString());
                // Integer 클래스 : Wrapper 클래스
                // int 를 감싼다. => int : 기본형 변수.
                // 그외의 대문자로 시작하는 클래스 : 참조형 변수.
                // Ex. 참조형 변수 : String => 클래스 (변수, 메쏘드)
                // int -> 클래스화 : Integer
                // double -> 클래스화 : Double

                // parse -> 분쇄하다. => 개발 : 분석하다
                // 날아온 자료를 분석해서 다르게 활용하고자 할때 : parse


                printGuguDan(dan);
                // 클릭된 버튼에 달려있는 Tag를 기반으로
                // 몇단을 출력해야 하는지 판단하여 실행 메쏘드.

            }
        };

        btn02.setOnClickListener(guguListener);
        btn03.setOnClickListener(guguListener);
        btn04.setOnClickListener(guguListener);
        btn05.setOnClickListener(guguListener);
        btn06.setOnClickListener(guguListener);
        btn07.setOnClickListener(guguListener);
        btn08.setOnClickListener(guguListener);
        btn09.setOnClickListener(guguListener);


    }

    private void printGuguDan(int dansu) {
        // 해야 할 일 ?
        // 2단 데이터들을 guguDatas 에 집어넣어야 함.
        // mAdapter한테 새로고침.

        // 누적으로 추가되는걸 막기 위해 기존의 데이터를 전부 삭제.
        guguDatas.clear();

        // 2단의 데이터들을 추가.
        for (int i = 1 ; i <= 9 ; i++) {
            guguDatas.add(new GuguData(dansu, i));
        }

        //추가가 끝났으니 어댑터가 새로고침 하도록 명령
        mAdapter.notifyDataSetChanged();

    }

    private void bindViews() {

        this.guguListView = (ListView) findViewById(R.id.guguListView);
        this.btnTotal = (Button) findViewById(R.id.btnTotal);
        this.btn09 = (Button) findViewById(R.id.btn09);
        this.btn08 = (Button) findViewById(R.id.btn08);
        this.btn07 = (Button) findViewById(R.id.btn07);
        this.btn06 = (Button) findViewById(R.id.btn06);
        this.btn05 = (Button) findViewById(R.id.btn05);
        this.btn04 = (Button) findViewById(R.id.btn04);
        this.btn03 = (Button) findViewById(R.id.btn03);
        this.btn02 = (Button) findViewById(R.id.btn02);
    }
}
