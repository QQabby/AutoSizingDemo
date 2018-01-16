package com.example.fancy;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    float count = 0f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("xx","MainActivity taskId:::"+getTaskId());
        count = getResources().getDisplayMetrics().density * 2;

        tv =  findViewById(R.id.tv);
        EditText et =  findViewById(R.id.et);


        tv.setText(et.getText().toString());
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                tv.setText(charSequence.toString());

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public void onBig(View view){

//        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) tv.getLayoutParams();
//        params.width-= count;
//        params.height-= count;
//        tv.setLayoutParams(params);
        PackageManager packageManager = getPackageManager();
        Intent intent = new Intent();//this,ActivityB.class
        // 这里面的值是你要跳转app的包名，你跳转的清单文件里的package名com.tencent.mobileqq.activity.SplashActivity
        intent = packageManager.getLaunchIntentForPackage("com.example.service");
        startActivity(intent);
    }
}
