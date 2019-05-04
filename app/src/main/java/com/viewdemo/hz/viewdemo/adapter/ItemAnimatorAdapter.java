package com.viewdemo.hz.viewdemo.adapter;

import android.animation.Animator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.viewdemo.hz.viewdemo.R;
import com.viewdemo.hz.viewdemo.activity.ItemAnimatorActivity;

import java.util.List;

/**
 * Created by zyand on 2019/4/22.
 */

public class ItemAnimatorAdapter extends RecyclerView.Adapter<ItemAnimatorAdapter.ViewHolder>{

    private Context context;

    private List<String> list;



    public ItemAnimatorAdapter(AppCompatActivity activity, List<String> list) {
        this.context = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_animtor, parent, false);
        ViewHolder holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.button.setText(list.get(position));
    }


    @Override
    public int getItemCount() {
        return list.size();
    }



    public void addDate(List<String> date){
        list = date;
        Log.d("ceshi",list.size()+"zzz");
        notifyDataSetChanged();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Button button;
        public ViewHolder(View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.butt);
        }
    }
}
