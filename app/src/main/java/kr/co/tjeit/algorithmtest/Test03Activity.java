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
                printGuguDan(??);
            }
        };

        btn02.setOnClickListener(guguListener);
        btn03.setOnClickListener(guguListener);


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
        this.btn03 = (Button) findViewById(R.id.btn03);
        this.btn02 = (Button) findViewById(R.id.btn02);
    }
}
