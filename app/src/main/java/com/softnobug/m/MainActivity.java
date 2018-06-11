package com.softnobug.m;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.softnobug.switchbtnmodule.SwitchsButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SwitchsButton switchsBtn = findViewById(R.id.swiftBtn);

        switchsBtn.setListener(new SwitchsButton.switchListener() {
            @Override
            public void itemClick(Integer m) {

            }
        });
        ArrayList<String> list = new ArrayList<>();
        list.add("正在进行");
        list.add("已经关闭");
//        list.add("剩下一个");
        switchsBtn.showList(list);
        switchsBtn.setIndex(0);

    }

}
