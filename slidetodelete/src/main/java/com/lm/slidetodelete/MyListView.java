package com.lm.slidetodelete;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/3/28.
 */

public class MyListView extends ListView {
    private int touchSlop;
    private boolean isSliding;

    private int downX;
    private int downY;

    private int currentItem;

    public interface OnDeleteListener{
        void Delete(int index);
    }

    private OnDeleteListener onDeleteListener;

    public void setOnDeleteListener(OnDeleteListener listener){
        onDeleteListener=listener;
    }

    public MyListView(Context context, AttributeSet attrs)
    {
        super(context, attrs);


        touchSlop= ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        int action=ev.getAction();
        int x=(int)ev.getX();
        int y=(int)ev.getY();
        switch (action){
            case MotionEvent.ACTION_DOWN:
                downX=x;
                downY=y;
                break;
            case MotionEvent.ACTION_MOVE:
                int moveX=x;
                int moveY=y;

                currentItem=pointToPosition(x,y);
                Log.e("TAG", "dispatchTouchEvent: 当前是第"+currentItem+"个");

                int dx=moveX-downX;
                int dy=moveY-downY;

                if (moveX<downX&&Math.abs(dx)>touchSlop&&Math.abs(dy)<touchSlop)
                {
                }
                break;

        }
        return super.dispatchTouchEvent(ev);
    }


    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (ev.getAction()==MotionEvent.ACTION_UP)
        {
            View view=this.getChildAt(currentItem-getFirstVisiblePosition());
            Log.e("TAG", "onTouchEvent: "+getFirstVisiblePosition());
            final LinearLayout ll= (LinearLayout) view.findViewById(R.id.item_parent);

            TextView textView= (TextView) view.findViewById(R.id.lv_item_tv);

            Log.e("TAG", "onTouchEvent: "+textView.getText());

            Log.e("TAG", "onTouchEvent: this is uesed!");

            final View buttonview=LayoutInflater.from(getContext()).inflate(R.layout.deletebbutton,null,false);
            Button deletebutton= (Button) buttonview.findViewById(R.id.deletebutton);
            ll.addView(buttonview);

            deletebutton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    ll.removeView(buttonview);
                    onDeleteListener.Delete(currentItem);
                }
            });



        }



        return super.onTouchEvent(ev);
    }
}
