package vanmang.com.Control_Page.Schedule;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import vanmang.com.Control_Page.R;


public class Tab3Fragment extends Fragment implements View.OnClickListener{

    public Tab3Fragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment3_layout, container, false);


        // Three buttons are call here
        Button DayService = (Button) view.findViewById(R.id.Sun_DayService);
        DayService.setOnClickListener(this);
        Button Lunch_Dinner = (Button) view.findViewById(R.id.Sun_Lunch_Dinner);
        Lunch_Dinner.setOnClickListener(this);
        Button Evening = (Button) view.findViewById(R.id.Sun_Evening);
        Evening.setOnClickListener(this);

        return view;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Sun_DayService:
                // launch Activity
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.EMPTY.parse("https://cbana2k18.github.io/program/index5.html"));
                startActivity(intent);
                break;
            case R.id.Sun_Lunch_Dinner:
                // launch Activity
                Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.EMPTY.parse("https://cbana2k18.github.io/program/index6.html"));
                startActivity(intent1);
                break;
            case R.id.Sun_Evening:
                // launch Activity
                Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.EMPTY.parse("https://cbana2k18.github.io/program/index7.html"));
                startActivity(intent2);
                break;

        }

    }
}