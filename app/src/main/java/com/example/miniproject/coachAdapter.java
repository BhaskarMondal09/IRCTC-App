package com.example.miniproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class coachAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private String[] coachNum;
    private int[] imageNum;

    public coachAdapter(coach c, String[] coachNum, int[] imageNum) {
        context=c;
        this.coachNum=coachNum;
        this.imageNum=imageNum;
    }

    @Override
    public int getCount() {
        return coachNum.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater ==null){
            inflater =(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        }
        if (convertView==null)
        {
            convertView= inflater.inflate(R.layout.row_item,null);
        }
        ImageView imageView=convertView.findViewById(R.id.image_view);
        TextView textView=convertView.findViewById(R.id.text_view);
        imageView.setImageResource(imageNum[position]);
        textView.setText(coachNum[position]);
        return convertView;
    }
    }

