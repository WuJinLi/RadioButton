package com.example.my.radiobutton;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.example.my.radiobutton.fragment.FenleiFragment;
import com.example.my.radiobutton.fragment.GengduoFragment;
import com.example.my.radiobutton.fragment.ShujiaFragment;
import com.example.my.radiobutton.fragment.TuijianFragment;

public class MainActivity extends AppCompatActivity {
    private RadioGroup radioGroup;
    private FenleiFragment fenleiFragment;
    private ShujiaFragment shujiaFragment;
    private TuijianFragment tuijianFragment;
    private GengduoFragment gengduoFragment;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //调用初始化UI控件的方法
        initView();
        //调用默认显示碎片的方法
        initData();
        //调用点击按钮事件的方法
        checkRadionButton();
    }

    //自定义方法实现radionButton的点击事件
    private void checkRadionButton() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radioButton_main_tuijian:
                        setSelection(0);
                        break;
                    case R.id.radioButton_main_shujia:
                        setSelection(1);
                        break;
                    case R.id.radioButton_main_fenlei:
                        setSelection(2);
                        break;
                    case R.id.radioButton_main_gengduo:
                        setSelection(3);
                        break;
                }
            }
        });
    }

    //在默认情况下显示第一个按钮对应的碎片
    private void initData() {
        //调用显示碎片的方法
        setSelection(0);
    }

    private void initView() {
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        manager = getSupportFragmentManager();
    }

    //自定义方法用于根据对应的按钮下角标，进行响应碎片的展示
    private void setSelection(int tabIndex) {
        //初始化事务，用于处理碎片的显示隐藏
        FragmentTransaction ft = manager.beginTransaction();
        //调用隐藏所有碎片的方法
        hindFragment(ft);
        switch (tabIndex) {
            case 0:
                //判断碎片是否为空，为空进行初始化，创建，不为空，直接显示
                if (tuijianFragment == null) {
                    tuijianFragment = new TuijianFragment();
                    ft.add(R.id.framelayout_main_container, tuijianFragment);
                } else {
                    ft.show(tuijianFragment);
                }
                break;
            case 1:
                if (shujiaFragment == null) {
                    shujiaFragment = new ShujiaFragment();
                    ft.add(R.id.framelayout_main_container, shujiaFragment);
                } else {
                    ft.show(shujiaFragment);
                }
                break;
            case 2:
                if (fenleiFragment == null) {
                    fenleiFragment = new FenleiFragment();
                    ft.add(R.id.framelayout_main_container, fenleiFragment);
                } else {
                    ft.show(fenleiFragment);
                }
                break;
            case 3:
                if (gengduoFragment == null) {
                    gengduoFragment = new GengduoFragment();
                    ft.add(R.id.framelayout_main_container, gengduoFragment);
                } else {
                    ft.show(gengduoFragment);
                }
                break;
        }
        //执行事务
        ft.commit();
    }

    //自定义隐藏碎片的方法
    private void hindFragment(FragmentTransaction ft) {
        if (tuijianFragment != null) {
            ft.hide(tuijianFragment);
        }
        if (shujiaFragment != null) {
            ft.hide(shujiaFragment);
        }
        if (fenleiFragment != null) {
            ft.hide(fenleiFragment);
        }
        if (gengduoFragment != null) {
            ft.hide(gengduoFragment);
        }
    }
}
