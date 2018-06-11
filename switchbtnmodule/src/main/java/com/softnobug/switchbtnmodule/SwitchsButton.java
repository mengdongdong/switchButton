package com.softnobug.switchbtnmodule;

import android.content.Context;
import android.graphics.Color;
import android.print.PrintAttributes;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class SwitchsButton extends LinearLayout {

    private View view;
    private Context mcontext;
    private LinearLayout bottomLayout;
    private Button curBtn;
    private ArrayList<TextView> btnList;
    private ArrayList<String> list;
    private switchListener listener;

    public void setListener(switchListener listener) {
        this.listener = listener;
    }

    public switchListener getListener() {
        return listener;
    }

    public SwitchsButton(Context context) {
        this(context, null);
        mcontext = context;
    }

    public SwitchsButton(Context context, AttributeSet attrs) {

        super(context, attrs);
        mcontext = context;
        view = LayoutInflater.from(context).inflate(R.layout.switchs_button_layout, this, true);
        bottomLayout = view.findViewById(R.id.bottomLayout);
        curBtn = view.findViewById(R.id.curBtn);
        list = new ArrayList<>();

        btnList = new ArrayList<>();

    }


    public void showList(ArrayList<String> titleArr) {

        list = titleArr;

        for (int i = 0; i < titleArr.size(); i++) {

            TextView button = new TextView(mcontext);
            button.setText(titleArr.get(i));
            button.setWidth(Integer.valueOf(dp2px(mcontext, 100)));
            button.setHeight(Integer.valueOf(dp2px(mcontext, 36)));
            button.setTextColor(Color.parseColor("#ffffff"));
            button.setGravity(Gravity.CENTER);

            button.setBackgroundColor(Color.parseColor("#00000000"));
            bottomLayout.addView(button);
            btnList.add(button);
            button.setId(i);
            button.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {

                    Integer m = btnList.indexOf(v);

                    setIndex(m);
                    listener.itemClick(m);

                }
            });

        }

    }

    public void setIndex(Integer m) {

        curBtn.setText(list.get(m));
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) curBtn.getLayoutParams();

        params.setMargins(curBtn.getWidth() * m, 0, 0, 0);// 通过自定义坐标来放置你的控件

        curBtn.setLayoutParams(params);


    }


    public interface switchListener {
        void itemClick(Integer m);
    }


    public static int dp2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

}
