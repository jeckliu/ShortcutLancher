package com.jeckliu.shortcutlauncher;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String PARAM = "param";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSample(View view) {
        startActivity(new Intent(this, SampleActivity.class));
    }

    public void onSample1(View view) {
        startActivity(new Intent(this, Sample1Activity.class));
    }

    public void onSample2(View view) {
        startActivity(new Intent(this, Sample2Activity.class));

    }

    public void onSample3(View view) {
        startActivity(new Intent(this, Sample3Activity.class));
    }

    public void onSample4(View view) {
        createShortcut(this,"炫酷一",SampleActivity.class);
    }

    public void onSample5(View view) {
        createShortcut(this,"炫酷二",Sample1Activity.class);
    }

    public void onSample6(View view) {
        createShortcut(this,"炫酷三",Sample2Activity.class);
    }

    public void onSample7(View view) {
        createShortcut(this,"炫酷四",Sample3Activity.class);
    }

    public static void createShortcut(Context context, String name, Class mClass) {
        Intent objIntent = new Intent();
        objIntent.setClass(context, mClass);//点击后进入的Activity
        objIntent.putExtra(PARAM,name);

        Intent installer = new Intent();
        installer.putExtra("android.intent.extra.shortcut.INTENT", objIntent);
        installer.putExtra("android.intent.extra.shortcut.NAME", name);
        installer.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(context,R.drawable.icon));
        installer.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
        context.sendBroadcast(installer);//发送安装桌面图标的通知
        Toast.makeText(context,"成功创建快捷方式",Toast.LENGTH_SHORT).show();
    }

}