package kr.co.tjeit.algorithmtest;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import kr.co.tjeit.algorithmtest.adapter.ChattingAdapter;
import kr.co.tjeit.algorithmtest.data.ChattingData;

public class Test05Activity extends BaseActivity {

//    1. 야구게임의 문제는 고정되어 있고, S/B 판별하는 로직 짜서

    int questionNumber = 471; // 이숫자를 맞추는 로직을 짜보자.
    // 문제 숫자가 바뀌더라도 대응가능한 채점 로직을 만들자.

    int[] questionNumberArray = {4,7,1}; // 출제된 문제를 세자리 배열로 분할
    // 한자리씩 비교하기에 편하게 하려고 만든 배열.

    int strikeCount = 0; // 문제를 입력하면 계산되는 스트라이크의 개수
    int ballCount = 0; // 문제를 입력하면 계산되는 볼의 개수.

    int tryCount = 0;

//    2. 사용자에게 몇S 몇B 채팅 메세지로 던져줌
//    3. 몇번 시도했는지 세서, 사용자에게 "현재까지 %d회 시도했습니다." 메세지 전송
//    4. 만약 3S 축하합니다! 클리어했습니다! => EditText 입력 / 전송 버튼 막는것.

    private android.widget.ListView chattingListView;
    private android.widget.EditText inputEdt;
    private android.widget.Button sendBtn;

    List<ChattingData> chattingDatas = new ArrayList<>();
    ChattingAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test05);
        bindViews();
        setupEvents();
        setValues();
    }


    @Override
    public void setupEvents() {
        // 화면에서 사용자가 터치로 인해 발생하는 모든 이벤트 코드를 작성.


        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });



    }

    private void checkAnswer() {

        // 3. 전송버튼을 누르면, 내가 입력한 내용이 리스트뷰에 나타나게.
        // => 선행작업. ☆

        // adapter에 물려 있는 list에 어떤 클래스들이 추가/삭제 되느냐에 따라
        // 리스트뷰에 나타나는 내용이 영향을 받는다.
        // 추가/삭제 하면 반드시 refresh 해줘야함. -> 변경내용 반영.
        // => mAdapter.notifyDataSetChanged();

        // 반대로 보면, 내가 입력한게 리스트뷰에 나타나려면
        // 어댑터에 물려있는 리스트에 적절한 데이터를 추가하고 새로고침 하면된다.

        chattingDatas.add(new ChattingData(true, inputEdt.getText().toString()));

        mAdapter.notifyDataSetChanged();


        // 1. 전송버튼을 누르면 Toast로 "데이터를 입력합니다."
//        Toast.makeText(mContext, "데이터를 입력합니다.", Toast.LENGTH_SHORT).show();


        // 5. 3자리의 숫자 까지만 입력을 받을 수 있게 EditText를 설정.
        // => 문자 입력 금지, 4자리 이상 숫자 입력 금지.





        // 4. 입력한 내용이 맨 아래에 달리니, 바로 스크롤을 맨 밑으로 끌어내려서
        //   입력한 내용을 바로 읽어볼 수 있게.


        // 리스트뷰 맨 밑으로 끌어내리기
//        chattingListView.setSelection(mAdapter.getCount() - 1);
        chattingListView.smoothScrollToPosition(mAdapter.getCount() - 1);

        // ※ 지금은 채팅을 입력하면 컴퓨터가 즉시 답장해주는데,
        // 내가 말한건 바로 뜨고, 그로부터 0.5~1초 정도 후에 컴퓨터가 답장하도록
        // 어려울 수 있다.

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                // 0.7초 후에 할 일은?
                // 컴퓨터가 답장을 해주고
                // 스크롤을 끌어내리는것.


                // 6. 숫자를 넣으면, 무조건 컴퓨터가 "확인했습니다." 답장해주는 시스템.

                chattingDatas.add(new ChattingData(false, "확인했습니다."));

//                7. 숫자를 넣으면, 몇S 몇B인지 계산해서 답장해주는 시스템.

                // 스트라이크와 볼의 갯수를 초기화.
                strikeCount = 0;
                ballCount = 0;

                // strikeCount, ballCount의 개수가 몇개인지 계산.

                int inputNum = Integer.parseInt(inputEdt.getText().toString());

                // 2. 전송버튼을 누르면 EditText의 내용을 비움.
                inputEdt.setText("");

                int[] inputArr = new int[3];

                inputArr[0] = inputNum / 100;
                inputArr[1] = inputNum % 100 / 10;
                inputArr[2] = inputNum % 10;


//                int index = 0;
//                while (inputNum > 0) {
//                    inputArr[index] = inputNum % 10;
//                    inputNum /= 10;
//                }

//                inputArr 와 questionNumberArray를 비교하는 부분.

                for (int i=0 ; i < 3; i++) {
                    for (int j=0; j < 3 ; j++) {

//                        inputArr[i] 와 questionNumberArray[j] 의 숫자가 같은지.

                        if (inputArr[i] == questionNumberArray[j]) {
                            // 스트라이크와 볼의 갯수를 판정

                            // i와 j의 값 자체가 같다면, 위치가 같으므로
                            // strike로 판정

                            // 그렇지 않다면, 위치가 다르지만, 이미 숫자는 같은걸 확인했으니
                            // ball 로 판정.

                            if (i == j) {
                                strikeCount++;
                            }
                            else {
                                ballCount++;
                            }

                        }

                    }
                }

                String resultStr = String.format(Locale.KOREA, "%d 스트라이크, %d 볼 입니다.", strikeCount, ballCount);
                chattingDatas.add(new ChattingData(false, resultStr));

//                tryCount를 활용하여, "%d번 시도했습니다." 메세지 던져주기.

//                3S인 경우, "축하합니다. 클리어하셨습니다." 메세지를 던지고
//                EditText와 버튼을 비활성화.

                mAdapter.notifyDataSetChanged();

                chattingListView.smoothScrollToPosition(mAdapter.getCount() - 1);


            }
        }, 700);


    }

    @Override
    public void setValues() {
        // 화면에 데이터를 뿌려주는 모든 코드를 작성.

//        리스트뷰 - Adapter 연결

//        1. Adapter를 객체화
        mAdapter = new ChattingAdapter(mContext, chattingDatas);
//        객체화 : 거의 대부분 new. 가끔씩 static메쏘드로 from, getInstance

//        2. 객체화 된 어댑터와, 화면에 그려진 리스트뷰를 setAdatper로 연결
//        리스트뷰.setAdapter(객체화된어댑터);

        chattingListView.setAdapter(mAdapter);

    }



    @Override
    public void bindViews() {

        this.sendBtn = (Button) findViewById(R.id.sendBtn);
        this.inputEdt = (EditText) findViewById(R.id.inputEdt);
        this.chattingListView = (ListView) findViewById(R.id.chattingListView);
    }
}
