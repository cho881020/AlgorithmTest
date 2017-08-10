package kr.co.tjeit.algorithmtest.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

import kr.co.tjeit.algorithmtest.R;
import kr.co.tjeit.algorithmtest.data.GuguData;

/**
 * Created by user on 2017-08-10.
 */

public class GuguAdapter extends ArrayAdapter<GuguData> {

    Context mContext;
    List<GuguData> mList;
    LayoutInflater inf;

    public GuguAdapter(Context context, List<GuguData> list) {
        super(context, R.layout.gugu_list_item, list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View row = convertView;
        if (row == null) {
            row = inf.inflate(R.layout.gugu_list_item, null);
        }

        // 실제 데이터를 출력

        GuguData data = mList.get(position);

        TextView printTxt = (TextView) row.findViewById(R.id.printTxt);

        // 구구단 출력 문장 만들기.
        // 2 X 1 = 2
        String printStr = String.format(Locale.KOREA, "%d X %d = %d", data.getDansu(),
                data.getNumber(), (data.getDansu() * data.getNumber()));
        printTxt.setText(printStr);

        return  row;
    }


}






