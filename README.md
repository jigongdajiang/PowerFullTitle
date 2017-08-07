# PowerFullTitle 封装TitleBar
## 1.功能描述
* 自动根据配置内容的有无来显示不同的Title
* 能通过简单的链式调用实现沉浸式状态和或者着色状态栏
* 有很好的扩展性,一套布局一套Title
* 不用在布局中去加入Title的布局
## 2.设计思路
基于Builder模式进行封装，通过链式调用的方式来创建绑定TitleBar
## 3.示例效果图
![示例图片](https://github.com/jigongdajiang/PowerFullTitle/raw/master/app/show_img.png "示例图片")
## 4.示例代码
```Java
  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DefaultTitleBar titleBar = new DefaultTitleBar//常用标题，如果需要还可以在此框架基础自行扩展
                .DefaultBuilder(this,//上下文
                    (ViewGroup) findViewById(R.id.content))//指定TitleBar所在的父容器
                .setTitle("牛逼的TitleBar")//设置标题
                .setSupportImmersion(true)//开启状态栏着色
                .setImmersionColorId(R.color.colorDark)//指定状态栏颜色
                .setLeftImageShow(true)//显示左箭头
//                .setLeftText("返回")//设置左边文字
                .setSubTitle("牛逼的副标题")//设置副标题
                .setRightImage1(R.drawable.ic_question)//设置右边图片
//                .setRightImage2(R.drawable.ic_question)//设置右边图片
                .setRightImage1ClickListner(new View.OnClickListener() {//设置右边第一个图片的点击事件
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this,"牛逼不",Toast.LENGTH_LONG).show();
                    }
                })
                .builder();
        TextView tv = (TextView) titleBar.getInsideView(R.id.tv_title_title);//得到TitleBar里面的某个控件
        tv.setTextColor(getResources().getColor(R.color.colorPrimaryDark));//改变属性
    }
```
