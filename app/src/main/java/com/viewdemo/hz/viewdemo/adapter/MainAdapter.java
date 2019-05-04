package com.viewdemo.hz.viewdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.viewdemo.hz.viewdemo.MainActivity;
import com.viewdemo.hz.viewdemo.R;

import java.util.List;


/**
 * Created by zyand on 2019/4/17.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private Onclike onClick;

    private Context context;

    private List<String> list;

    public MainAdapter(MainActivity mainActivity, List<String> recylist) {
        this.context = mainActivity;

        this.list = recylist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.adapter_main, parent, false);
        ViewHolder holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.text.setText(list.get(position));
        holder.text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClick.textonclike(position);
            }
        });
    }

    public interface Onclike{
        void textonclike(int position);
    }

    public void SetItemOnclike(Onclike onClick){
      this.onClick = onClick;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView text;
        public ViewHolder(View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.text);
        }
    }
}
