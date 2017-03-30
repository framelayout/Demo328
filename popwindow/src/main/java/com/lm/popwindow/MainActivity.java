package com.lm.popwindow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btn);


    }

    public void show(View view) {
        PopupWindow popupWindow=new PopupWindow(this);

        View popview= LayoutInflater.from(this).inflate(R.layout.popwindow,null,false);

        popupWindow.setContentView(popview);
        popupWindow.setWidth(100);
        popupWindow.setHeight(100);

        popupWindow.setBackgroundDrawable(getResources().getDrawable(R.drawable.timg));

        popupWindow.showAsDropDown(btn);
    }
}
