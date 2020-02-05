package com.slash.slash.hob;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.helloWorld);
        getText();
    }

    String temp;
    public void getText () {
        ServerInterface serverInterface = ServerHandler.INSTANCE.getInterface();
        serverInterface.getText()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> {
                    textView.setText(result);
                    // 통신 성공했을때 동작 ! result 안에 결과값이 들어있음 (정해놓은 형태로)
                    temp = result;
                    System.out.println(result);
                });
    }
}
