# PagerSlidingTabStrip
Android-导航栏特效，主要是导航栏字体大小和颜色的渐变特效
可以是固定的几个,可也可以是水平滚动
#原理分析与实现
<http://blog.csdn.net/ta893115871/article/details/44724953/>
# 效果图
<img src="/screenshots/1.gif"/>
<img src="/screenshots/2.gif"/>
<img src="/screenshots/3.gif"/>
# 属性
```java
app:pstsIndicatorColor  指示器的颜色
app:pstsIndicatorHeight 指示器的高度
app:pstsUnderlineColor 底部线的颜色
app:pstsUnderlineHeight 底部线的高度
app:pstsDividerColor 分割线的颜色
app:pstsDividerPaddingTopBottom 分割线的上下间距
app:pstsTabPaddingLeftRight 文本的左右间距
app:pstsTextSelectedColor TAB选中的颜色
app:pstsScrollOffset
app:pstsTabBackground 每一个TAB的背景
<!--该属性表示里面的TAB是否均分整个PagerSlidingTabStrip控件的宽,true是,false不均分,从左到右排列,默认false-->
app:pstsShouldExpand
app:pstsTextAllCaps 所有的小写英文文本自动大写 ,默认是true,默认大写
<!--缩放的最大值,0.3表示放大后最大是原来的0.3倍,默认为0.3-->
app:pstsScaleZoomMax
android:textColor="@color/color_45c01a" 正常状态的文字颜色
android:textSize="16sp" 正常状态的文字的大小
app:pstsSmoothScrollWhenClickTab="false" 当点击tab时内容区域Viewpager是否是左右滑动,默认是true
```

# 声明-布局中
```java
<com.gxz.PagerSlidingTabStrip
    android:id="@+id/tabs"
    android:layout_width="match_parent"
    android:layout_height="40dp"
    android:textColor="@color/color_45c01a"
    android:textSize="16sp"
    app:pstsDividerColor="@android:color/transparent"
    app:pstsIndicatorColor="@color/accent_material_light"
    app:pstsIndicatorHeight="5dp"
    app:pstsShouldExpand="false"
    app:pstsTextSelectedColor="@color/accent_material_light"
    app:pstsUnderlineColor="@color/colorAccent" />
```
# Java  代码
```java
private PagerSlidingTabStrip tabs;
tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
ArrayList<String> list=new ArrayList<>();
    for (int i=0;i<10;i++){
        list.add("TAB "+i);
    }
    pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(),list));
    tabs.setViewPager(pager);
    pager.setCurrentItem(1);
        
// 设置Tab是自动填充满屏幕的
tabs.setShouldExpand(true);

// 设置Tab的分割线的颜色
tabs.setDividerColor(getResources().getColor(R.color.color_80cbc4));
// 设置分割线的上下的间距,传入的是dp
tabs.setDividerPaddingTopBottom(12);

// 设置Tab底部线的高度,传入的是dp
tabs.setUnderlineHeight(1);
//设置Tab底部线的颜色
tabs.setUnderlineColor(getResources().getColor(R.color.color_1A000000));

// 设置Tab 指示器Indicator的高度,传入的是dp
tabs.setIndicatorHeight(4);
// 设置Tab Indicator的颜色
tabs.setIndicatorColor(getResources().getColor(R.color.color_45c01a));

// 设置Tab标题文字的大小,传入的是sp
tabs.setTextSize(16);
// 设置选中Tab文字的颜色
tabs.setSelectedTextColor(getResources().getColor(R.color.color_45c01a));
//设置正常Tab文字的颜色
tabs.setTextColor(getResources().getColor(R.color.color_C231C7));
//设置Tab文字的左右间距,传入的是dp
tabs.setTabPaddingLeftRight(24);

//设置点击每个Tab时的背景色
tabs.setTabBackground(R.drawable.background_tab);

//是否支持动画渐变(颜色渐变和文字大小渐变)
tabs.setFadeEnabled(false);
// 设置最大缩放,是正常状态的0.3倍
tabs.setZoomMax(0.3F);

//这是当点击tab时内容区域Viewpager是否是左右滑动,默认是true
tabs.setSmoothScrollWhenClickTab(true);
```
#Maven
```java
<dependency>
        <groupId>com.gxz.pagerslidingtabstrip</groupId>
        <artifactId>library</artifactId>
        <version>1.3.1</version>
        <type>jar</type>
        <classifier>sources</classifier>
</dependency>
```
 
# Gradle
```java
dependencies {
        compile 'com.gxz.pagerslidingtabstrip:library:1.3.1'
}
```

# 注意
因项目中的library中依赖了两个库
```java
dependencies {
  compile 'com.android.support:appcompat-v7:23.1.1'
  compile 'com.nineoldandroids:library:2.4.0'
}
使用时有可能这两个依赖有新版本了 你可以这样将library中两个依赖库导出,用法如下,再依赖你自己的最新的库
dependencies {
compile('com.gxz.pagerslidingtabstrip:library:1.3') {
        // exclusion for update the android support jar
        // for example, you can use the appcompat-v7 in your project
        exclude group: 'com.android.support', module: 'appcompat-v7'
        exclude group: 'com.nineoldandroids', module: 'library'
    }
}
```
#V-1.2 FIX-BUG
1.修改点击TAB颜色渐变不全的问题</p>
2.增加:当点击tab时内容区域Viewpager是否是左右滑动,默认是true
```java
app:pstsSmoothScrollWhenClickTab="false"  属性
tabs.setSmoothScrollWhenClickTab(true);   JAVA方法
```
#V-1.3 FIX-BUG
1.setTabPaddingLeftRight(int padding) 设置不起作用的问题

#V-1.3.1 加入对title单击和双击的处理监听即OnPagerTitleItemClickListener
```java
  mPagerSlidingTabStrip.setOnPagerTitleItemClickListener(new PagerSlidingTabStrip.OnPagerTitleItemClickListener() {
            @Override
            public void onSingleClickItem(int position) {
                Toast.makeText(LayoutActivity.this, "单击", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDoubleClickItem(int position) {
                Toast.makeText(LayoutActivity.this, "双击", Toast.LENGTH_SHORT).show();
            }
        });
```