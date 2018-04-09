# MarqueeTextView
Android滚动字幕，支持动态添加和删除，支持消息数据的更新

## 1、演示（请star支持）
![](https://github.com/xuexiangjys/MarqueeTextView/blob/master/img/1.gif)

## 2、如何使用
目前支持主流开发工具AndtoidStudio的使用，直接配置build.gradle，增加依赖即可.

### 2.1、Android Studio导入方法，添加Gradle依赖

   先在项目根目录的 build.gradle 的 repositories 添加:
```
     allprojects {
         repositories {
            ...
            maven { url "https://jitpack.io" }
        }
    }
```

 然后在dependencies添加:

```
        dependencies {
        ...
        compile 'com.github.xuexiangjys:MarqueeTextView:1.0'
        }
```

### 2.2、项目中如何使用

#### 2.2.1、布局中如何使用
```
       <com.xuexiang.view.MarqueeTextView
               android:id="@+id/tv_marquee"
               android:layout_width="match_parent"
               android:layout_height="40dp"
               android:layout_marginTop="20dp"
               android:background="#88dddddd"
               app:mtv_isAutoFit="true"
               app:mtv_isAutoDisplay="true"/>
```

#### 2.2.2、代码中如何使用
```
        final List<String> datas = Arrays.asList("《赋得古原草送别》", "离离原上草，一岁一枯荣。", "野火烧不尽，春风吹又生。", "远芳侵古道，晴翠接荒城。", "又送王孙去，萋萋满别情。");
        mTvMarquee.setSpeed(2);
        mTvMarquee.startSimpleRoll(datas);
```

#### 2.2.3、滚动事件
```
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
```

#### 2.2.4、属性说明(以下属性全部可以通过xml文件配置和代码进行设置)

属性名 | 字段 | 描述 | 默认值
:-|:-:|:-:|:-:
mtv_speed | integer  | 滚动速度，单位px  | 3px
mtv_isAutoFit | boolean  | 尺寸是否自适应  | true
mtv_isAutoDisplay | boolean  | 控件是否自动显示与隐藏（根据显示数量）| true
