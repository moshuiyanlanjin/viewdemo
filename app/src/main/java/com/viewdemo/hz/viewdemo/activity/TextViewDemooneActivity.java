package com.viewdemo.hz.viewdemo.activity;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.viewdemo.hz.viewdemo.R;
import com.viewdemo.hz.viewdemo.View.TextDemo.TextViewDemooneView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zyand on 2019/4/24.
 */

public class TextViewDemooneActivity extends BaseActivity {

    @BindView(R.id.text)
    TextViewDemooneView text;
    private Paingbean paingbean;
    private List<Paingbean> beanes = new ArrayList<>();

    //number为购物车运行的次数
    private int number;



    //购物车大小
    private int shopp = 4;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_txetview_demo_one);
        ButterKnife.bind(this);
        paingbean = new Paingbean();

        text.getTextBounds("男儿何不带吴钩，\n夺取关山五十州",0,"男儿何不带吴钩，\n夺取关山五十州".length(),new Rect());
        int[] ints = smartBuylist(31, 3, 44, 1, 20, 3, 70, 0);
        for (int i = 0;i<ints.length;i++) {
            Log.d("ceshi",ints[i]+","+i);
        }

    }


    /**
     * 根据传递进去的要出货的货道编号和合并情况，返回出货的X轴
     * @param trackno1 第一个要出货的商品所在货道编号（例如：10）
     * @param len1 第一个货道的合并情况（1表示没有合并，2表合并了后面的1个轨道）
     * @param trackno2  第二个要出货的商品所在货道编号（例如：10），只出1个货物时，此值为0
     * @param len2  第二个货道的合并情况（1表示没有合并，2表合并了后面的1个轨道）
     * @param trackno3  第三个要出货的商品所在货道编号（例如：10），只出1个或2个货物时，此值为0
     * @param len3  第三个货道的合并情况（1表示没有合并，2表合并了后面的1个轨道）
     * @param startx 第一个货道的X轴的位置
     * @param endx 最后4个货道的X轴的位置
     * @return X轴的数组，有3个商品时返回数组长度为3的int数组，有2个商品时返回数组长度为2的int数组，
     * 有1个商品时返回数组长度为1的int数组，如果数组元素的值为0，表示该商品是独立1次出货的。
     * 注：9个轨道总长度为70cm，接货斗的宽度为35cm
     */
    public int[] smartBuylist(int trackno1,int len1,int trackno2,int len2,int trackno3,int len3,int startx,int endx){


        beanes.clear();
        if(trackno2 == 0){

            paingbean = new Paingbean();
            paingbean.setLine(len1);
            paingbean.setX(trackno1 % 10);
            beanes.add(paingbean);
        }else if(trackno2 != 0 && trackno3 == 0){

            paingbean = new Paingbean();
            paingbean.setLine(len1);
            paingbean.setX(trackno1 % 10);
            beanes.add(paingbean);

            paingbean = new Paingbean();
            paingbean.setLine(len2);
            paingbean.setX(trackno2 % 10);
            paingbean.setY(trackno2 / 10);
            beanes.add(paingbean);
        }else{

            paingbean = new Paingbean();
            paingbean.setLine(len1);
            paingbean.setX(trackno1 % 10);
            paingbean.setY(trackno1 / 10);
            beanes.add(paingbean);

            paingbean = new Paingbean();
            paingbean.setLine(len2);
            paingbean.setX(trackno2 % 10);
            paingbean.setY(trackno2 / 10);
            beanes.add(paingbean);

            paingbean = new Paingbean();
            paingbean.setLine(len3);
            paingbean.setX(trackno3 % 10);
            paingbean.setY(trackno3 / 10);
            beanes.add(paingbean);
        }


        number = 0;
        //购物车有三个商品
        if (beanes.size() == 3) {

            int x = 0;
            for (int i = 0; i < beanes.size(); i++) {
                if (beanes.get(i).getX() == 0) {
                    //总共有多少个产品x轴坐标为0
                    x++;
                }
            }
            Log.d("ceshi",x+"");
            //如果坐标为0,则必然需要起运一次购物车
            if (x <= 1) {
                if (beanes.get(0).getLine() <= beanes.get(1).getX() && beanes.get(0).getLine() + beanes.get(1).getLine() < shopp && beanes.get(0).getLine() + beanes.get(1).getLine() + beanes.get(2).getLine() <= shopp && beanes.get(0).getLine() + beanes.get(1).getLine() <= beanes.get(2).getX()) {

                    number = 1;
                } else if (beanes.get(0).getLine() <= beanes.get(1).getX() && beanes.get(0).getLine() + beanes.get(1).getLine() <= shopp && beanes.get(0).getLine() + beanes.get(1).getLine() + beanes.get(2).getLine() > shopp) {

                    number = 2;
                } else {
                    number = 3;
                }

                Log.d("ceshi", "numberone:" + number);
            } else if (x == 2) {
                number = 2;
                if (beanes.get(0).getLine() + beanes.get(1).getLine() + beanes.get(2).getLine() > shopp*2 ||
                        ((beanes.get(0).getX() + beanes.get(0).getLine() > beanes.get(1).getX() && beanes.get(1).getLine()+beanes.get(1).getX() > beanes.get(2).getX())) ||
                        (beanes.get(0).getLine() + beanes.get(1).getLine()>shopp && beanes.get(1).getLine()+beanes.get(2).getLine() >shopp)) {
                    number = 3;
                }
            } else if (x == 3) {
                number = 3;
            }


            if (number == 3) {
                int[] trackanes = new int[3];

                return trackanes;
            } else if (number == 1) {

                int[] trackanes = new int[3];

                trackanes[0] = beanes.get(0).getX()*78+startx;
                trackanes[1] = (beanes.get(1).getX()-beanes.get(0).getLine())*78+startx;
                trackanes[2] = (beanes.get(2).getX()-beanes.get(0).getLine()-beanes.get(1).getLine())*78+startx;
                return trackanes;


            } else if (number == 2) {
                int[] trackanes = new int[3];

                trackanes[0] = beanes.get(0).getX()*78+startx;
                trackanes[1] = (beanes.get(1).getX()-beanes.get(0).getLine())*78+startx;
                trackanes[2] = 0;
                return trackanes;

            }

        }
        //两个商品
        else if (beanes.size() == 2) {
            int x = 0;

            number = 0;
            for (int i = 0; i < beanes.size(); i++) {
                if (beanes.get(i).getX() == 0) {
                    //总共有多少个产品x轴坐标为0
                    x++;
                }
            }
            if (x <= 1) {
                if (beanes.get(0).getLine() + beanes.get(1).getLine() <= shopp && (beanes.get(0).getLine() + beanes.get(0).getX() <= beanes.get(1).getX() || beanes.get(1).getLine() + beanes.get(1).getX() <= beanes.get(0).getX())) {
                    number = 1;
                } else {
                    number = 2;
                }
            } else {
                number = 2;
            }

            if (number == 1) {
                int[] trackanes = new int[2];

                trackanes[0] = beanes.get(0).getX()*78+startx;
                trackanes[1] = (beanes.get(1).getX()-beanes.get(0).getLine())*78+startx;

                return trackanes;

            } else if (number == 2) {
                int[] trackanes = new int[2];

                return trackanes;
            }
        }

        //一个商品
        else if (beanes.size() == 1) {
            return new int[]{0};
        }

        return new int[]{0,0,0};
    }


    public class Paingbean {


        private int x;
        private int y;
        private int line;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getLine() {
            return line;
        }

        public void setLine(int line) {
            this.line = line;
        }
    }

}
