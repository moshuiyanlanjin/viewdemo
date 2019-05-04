package com.viewdemo.hz.viewdemo.activity;

import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.viewdemo.hz.viewdemo.R;
import com.viewdemo.hz.viewdemo.adapter.ItemAnimatorAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zyand on 2019/4/22.
 */

public class ItemAnimatorActivity extends BaseActivity {

    @BindView(R.id.recy)
    RecyclerView recy;
    @BindView(R.id.button)
    Button button;
    @BindView(R.id.button1)
    Button button1;

    int i = 1;

    ItemAnimatorAdapter adapter;

    private List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itemanimator);
        ButterKnife.bind(this);
        initDate();
        initView();
    }

    private void initDate() {
        list.add("1");
    }

    private void initView() {
        LayoutTransition transition = new LayoutTransition();

        ObjectAnimator animator = ObjectAnimator.ofFloat(null, "TranslationY", 0, 360, 0);
        transition.setAnimator(LayoutTransition.APPEARING, animator);

      //  recy.setLayoutTransition(transition);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        adapter = new ItemAnimatorAdapter(this, list);
        recy.setAdapter(adapter);
        recy.setLayoutManager(manager);
    }

    @OnClick({R.id.button, R.id.button1})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button:
                add();
                break;
            case R.id.button1:
                break;
        }
    }

    private void add() {
        i++;

       list.add(0,i+"");
        adapter.addDate(list);
    }
}
