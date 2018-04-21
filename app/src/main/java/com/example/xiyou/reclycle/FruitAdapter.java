package com.example.xiyou.reclycle;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by XiYou on 2018/4/21.
 */

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder>{

    public static final int ONE_ITEM=1;
    public static final int TWO_ITEM=2;

    private RecyclerView mRecyclerView;
    private List<Fruit> mFruitList;


    public FruitAdapter(List<Fruit> fruitList){
       mFruitList=fruitList;
        Log.e(TAG, "FruitAdapter: "+mFruitList.size() );
    }

    @Override
    public FruitAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater mInflater=LayoutInflater.from(parent.getContext());
        ViewHolder holder;
        if (ONE_ITEM==viewType){
            View view=mInflater.inflate(R.layout.fruit_item,parent,false);
            holder=new ViewHolder(view);
        } else {
            View view=mInflater.inflate(R.layout.item_two,parent,false);
            holder=new ViewHolder(view);
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(FruitAdapter.ViewHolder holder, int position){
        holder.getItemViewType();

        if (holder.getItemViewType() == ONE_ITEM) {
            holder.imageView.setImageResource(mFruitList.get(position).getImageId());
            holder.textView_two.setText(mFruitList.get(position).getName());
        } else {
            holder.textView_one.setText(mFruitList.get(position).getName());
        }
    }


    @Override
    public int getItemViewType(int position){
        if (position % 2==0){
            return TWO_ITEM;
        }else {
            return ONE_ITEM;
        }
    }

    @Override
    public int getItemCount(){
        return mFruitList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder{

        TextView textView_one;
        TextView textView_two;
        ImageView imageView;

        public ViewHolder(View view){
            super(view);
            textView_one = view.findViewById(R.id.two_text);
            textView_two = view.findViewById(R.id.fruit_name);
            imageView = view.findViewById(R.id.fruit_image);
        }
    }


}

