package me.haowen.sample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import me.haowen.sample.adapter.TestAdapter;
import me.haowen.soulplanet.view.SoulPlanetsView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SoulPlanetsView soulPlanet = findViewById(R.id.soulPlanetView);
        soulPlanet.setAdapter(new TestAdapter());

        soulPlanet.setOnTagClickListener(new SoulPlanetsView.OnTagClickListener() {
            @Override
            public void onItemClick(ViewGroup parent, View view, int position) {
                //Toast.makeText(MainActivity.this, String.valueOf(position), Toast.LENGTH_SHORT).show();
                DiyDialog1(position);

            }
        });

    }

    /**
     * 自定义1 控制普通的dialog的位置，大小，透明度
     * 在普通的dialog.show下面添加东西
     */
    private void DiyDialog1(int position){
        View view = LayoutInflater.from(this).inflate(R.layout.alert, null);
        AlertDialog.Builder alterDiaglog = new AlertDialog.Builder(MainActivity.this).setView(view);
        //alterDiaglog.setIcon(R.drawable.ic_launcher_foreground);//图标
        final TextView tv_text=view.findViewById(R.id.tv_text);//获取内容
        final ImageView iv_image=view.findViewById(R.id.iv_image);//获取图片
            //position 范围0-29
        switch (position){
            case 0:
                alterDiaglog.setTitle("第一次见面");//标题文字
                tv_text.setText("  浮世三千，吾爱有三。日，月与君。日为朝，月为暮，卿为朝朝暮暮。 ");
                iv_image.setImageResource(R.mipmap.ic_001);
                break;
            case 1:
                alterDiaglog.setTitle("第一次约会");//标题文字
                tv_text.setText("  浮世三千，吾爱有三。日，月与君。日为朝，月为暮，卿为朝朝暮暮。 ");
                iv_image.setImageResource(R.mipmap.ic_001);
                break;
            case 2:
                alterDiaglog.setTitle("第一次生日");//标题文字
                tv_text.setText("  浮世三千，吾爱有三。日，月与君。日为朝，月为暮，卿为朝朝暮暮。  浮世三千，吾爱有三。日，月与君。日为朝，月为暮，卿为朝朝暮暮。  浮世三千，吾爱有三。日，月与君。日为朝，月为暮，卿为朝朝暮暮。  浮世三千，吾爱有三。日，月与君。日为朝，月为暮，卿为朝朝暮暮。  浮世三千，吾爱有三。日，月与君。日为朝，月为暮，卿为朝朝暮暮。  浮世三千，吾爱有三。日，月与君。日为朝，月为暮，卿为朝朝暮暮。  浮世三千，吾爱有三。日，月与君。日为朝，月为暮，卿为朝朝暮暮。  浮世三千，吾爱有三。日，月与君。日为朝，月为暮，卿为朝朝暮暮。  浮世三千，吾爱有三。日，月与君。日为朝，月为暮，卿为朝朝暮暮。  浮世三千，吾爱有三。日，月与君。日为朝，月为暮，卿为朝朝暮暮。 ");
                iv_image.setImageResource(R.mipmap.ic_001);
                break;
                default:
                    alterDiaglog.setTitle("默认标题");//标题文字
                    tv_text.setText("默认内容");
                    //                tv_text.setText("  浮世三千，吾爱有三。日，月与君。日为朝，月为暮，卿为朝朝暮暮。  浮世三千，吾爱有三。日，月与君。日为朝，月为暮，卿为朝朝暮暮。  浮世三千，吾爱有三。日，月与君。日为朝，月为暮，卿为朝朝暮暮。  浮世三千，吾爱有三。日，月与君。日为朝，月为暮，卿为朝朝暮暮。  浮世三千，吾爱有三。日，月与君。日为朝，月为暮，卿为朝朝暮暮。  浮世三千，吾爱有三。日，月与君。日为朝，月为暮，卿为朝朝暮暮。  浮世三千，吾爱有三。日，月与君。日为朝，月为暮，卿为朝朝暮暮。  浮世三千，吾爱有三。日，月与君。日为朝，月为暮，卿为朝朝暮暮。  浮世三千，吾爱有三。日，月与君。日为朝，月为暮，卿为朝朝暮暮。  浮世三千，吾爱有三。日，月与君。日为朝，月为暮，卿为朝朝暮暮。 ");
                    iv_image.setImageResource(R.mipmap.ic_002);
                    break;
        }
        alterDiaglog.setNegativeButton("返回", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               // Toast.makeText(MainActivity.this,"返回",Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog dialog = alterDiaglog.create();

        //显示
        dialog.show();
        //自定义的东西
        //放在show()之后，不然有些属性是没有效果的，比如height和width
        Window dialogWindow = dialog.getWindow();
        WindowManager m = getWindowManager();
        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
        WindowManager.LayoutParams p = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        // 设置高度和宽度
        // p.height = (int) (d.getHeight() * 0.9); // 高度设置为屏幕的0.9
        p.width = (int) (d.getWidth() * 0.9); // 宽度设置为屏幕的0.9
        p.windowAnimations=R.style.dialogStyle;
        p.gravity = Gravity.CENTER;//设置位置

        p.alpha = 0.8f;//设置透明度
        dialogWindow.setAttributes(p);
    }
}
