package tw.org.iii.leo.leo18;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class F1 extends Fragment {
    private MainActivity mainActivity;
    private TextView lottery;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //做小小調整，如果view是null 表示我第一次來 才要建立新的畫面 如果下次再來 就保持原來畫面
        //如果每次切換fragment 都要讓view刷新 那就不要判斷這個條件
        if (view == null) {

            //這段就有點像onCreate做的事情
        view = inflater.inflate(R.layout.fragment_f1, container, false);

        Button loto = view.findViewById(R.id.page1_lotoBtn);
        lottery = view.findViewById(R.id.page1_lottery);
        loto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("leo", "loto");
                showLottery();
            }
        });
        view.findViewById(R.id.page1_test2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.changeTitle("Leo Big Corp.");
            }
        });
    }
        return view;
    }


    public void showLottery(){
        lottery.setText(""+(int)(Math.random()*49+1));
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity)context;

    }


}
