package com.xuexiang.marqueetextviewdemo;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.xuexiang.view.DisplayEntity;
import com.xuexiang.view.MarqueeTextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.tv_marquee)
    MarqueeTextView mTvMarquee;

    @BindView(R.id.tv_marquee1)
    MarqueeTextView mTvMarquee1;

    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        mHandler = new Handler();
        final List<String> datas = Arrays.asList("《赋得古原草送别》", "离离原上草，一岁一枯荣。", "野火烧不尽，春风吹又生。", "远芳侵古道，晴翠接荒城。", "又送王孙去，萋萋满别情。");

        mTvMarquee.setSpeed(2);
        mTvMarquee.startSimpleRoll(datas);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mTvMarquee.removeDisplayString(datas.get(0));
                mTvMarquee.addDisplayString("这是动态添加的消息");
            }
        }, 5000);

        mTvMarquee1.setOnMarqueeListener(new MarqueeTextView.OnMarqueeListener() {
            @Override
            public DisplayEntity onStartMarquee(DisplayEntity displayMsg, int index) {
                if (displayMsg.toString().equals("离离原上草，一岁一枯荣。")) {
                    return null;
                } else {
                    Toast("开始滚动：" + displayMsg.toString());
                    return displayMsg;
                }
            }
            @Override
            public List<DisplayEntity> onMarqueeFinished(List<DisplayEntity> displayDatas) {
                Toast("一轮滚动完毕！");
                return displayDatas;
            }
        });
        mTvMarquee1.startSimpleRoll(datas);

    }

    protected void Toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
