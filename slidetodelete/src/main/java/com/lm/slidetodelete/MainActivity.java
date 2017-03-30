package com.lm.slidetodelete;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MyListView lv;
    private List<String> data;
    private LvAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (MyListView) findViewById(R.id.lv);

        data=new ArrayList<>();

        adapter=new LvAdapter(data,this);

        lv.setOnDeleteListener(new MyListView.OnDeleteListener() {
            @Override
            public void Delete(int index) {
                data.remove(index);
                adapter.notifyDataSetChanged();
                Log.e("TAG", "Delete: "+index);
            }
        });

        for (int i = 0; i < 20; i++) {
            data.add(""+i);
        }
        lv.setAdapter(adapter);


    }
}
