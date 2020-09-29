package com.example.list.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.list.R;

import java.sql.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<String> {

        private Context context;
        private ArrayList<String>list;
    public ListAdapter( Context context, ArrayList<String>list) {
        super(context, R.layout.content_list);
        this.context=context;
        this.list=list;
    }
    public  int getCount(){
        return  list.size();

    }


    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {
        View view;

        final ViewHolder viewHolder;

        if(convertView==null|| convertView.getTag()==null){
            viewHolder=new ViewHolder();
            view=  LayoutInflater.from(context).inflate(R.layout.content_list,parent,false);
            viewHolder.vItemName=(TextView)view.findViewById(R.id.textlist);
            viewHolder.vItemImage=(ImageView) view.findViewById(R.id.img);
            view.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder)convertView.getTag();
            view=convertView;

        }

        viewHolder.vItemName.setText(list.get(position));
        Glide.with(context).load("https://viejosteve.wixsite.com/misitio-1")
                .centerCrop().into(viewHolder.vItemImage);
        //System.out.println("LA LISTA ES: "+list.get(position));
        return view;
    }
    static class ViewHolder{
        protected TextView vItemName;
        protected ImageView vItemImage;
    }
}
