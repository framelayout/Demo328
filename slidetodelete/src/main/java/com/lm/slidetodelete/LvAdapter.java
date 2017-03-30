package com.lm.slidetodelete;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/3/28.
 */

public class LvAdapter extends BaseAdapter{
    private List<String> data;
    private Context context;

    public LvAdapter(List<String> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        Log.e("TAG", "getCount: "+data.size());
        return data.size();

    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder vh=null;
        if (convertView==null)
        {
            vh=new ViewHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.lv_item,parent,false);

            vh.tv= (TextView) convertView.findViewById(R.id.lv_item_tv);



            convertView.setTag(vh);
        }
        else {
            vh= (ViewHolder) convertView.getTag();
        }

        vh.tv.setText("this is "+data.get(position)+"th new!");
        return convertView;
    }

     class ViewHolder{
        TextView tv;
    }
}
