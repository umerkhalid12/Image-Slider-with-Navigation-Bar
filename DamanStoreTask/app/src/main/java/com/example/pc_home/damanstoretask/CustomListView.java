package com.example.pc_home.damanstoretask;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListView extends ArrayAdapter<String> {

    private int[] imgId;
    private String[] prices, ObjectName;
    private Activity context;
    public CustomListView(Activity context, int[] imgId, String[] prices, String[] ObjectName) {
        super(context, R.layout.listviewlayout,prices);

        this.context = context;
        this.ObjectName = ObjectName;
        this.imgId = imgId;
        this.prices = prices;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        ViewHolder viewHolder = null;
        if(v == null){
            LayoutInflater layoutInflater = context.getLayoutInflater();
            v = layoutInflater.inflate(R.layout.listviewlayout,null,true);
            viewHolder = new ViewHolder(v);
            v.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder)v.getTag();
        }
        viewHolder.imageView.setImageResource(imgId[position]);
       // viewHolder.imageView.setBackgroundResource(imgId[position]);
        viewHolder.textView.setText("$" + prices[position]);
        viewHolder.textView2.setText(ObjectName[0]);


        return v;
    }

    class ViewHolder{
        TextView textView;
        ImageView imageView;
        TextView textView2;
        ViewHolder(View v){
            textView = (TextView) v.findViewById(R.id.textView);
            imageView = (ImageView) v.findViewById(R.id.viewImages);
            textView2 = (TextView) v.findViewById(R.id.textView2);
        }
    }

}
