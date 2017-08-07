package gjg.com.powerfulltitle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import gjg.com.powerfulltitle.title.DefaultTitleBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewGroup de = (ViewGroup) ((ViewGroup) findViewById(android.R.id.content)).getChildAt(0);
        ViewGroup bb = (ViewGroup) findViewById(R.id.content);
        DefaultTitleBar titleBar = new DefaultTitleBar//常用标题，如果需要还可以在此框架基础自行扩展
                .DefaultBuilder(this)//指定TitleBar所在的父容器
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
}
