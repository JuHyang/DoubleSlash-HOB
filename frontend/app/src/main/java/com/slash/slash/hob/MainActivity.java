package com.slash.slash.hob;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.slash.slash.hob.models.User;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    final String TAG = "MainACtivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.helloWorld);
        connectionTest();
    }

    public void connectionTest() {
        User user = new User("122", "112312", 25, "1", "1");
        ServerHandler.INSTANCE.signUp(user)
                .subscribe(result -> {
                    String temp = textView.getText().toString() + " ";
                    textView.setText(temp + result);
                    System.out.println(result);
                }, throwable -> {
                    Log.e(TAG, "Throwable " + throwable.getMessage());
                });

        ServerHandler.INSTANCE.getAllHobList(1)
                .subscribe(result -> {
                    String temp = textView.getText().toString() + " ";
                    textView.setText(temp + result);
                    System.out.println(result);
                }, throwable -> {
                    Log.e(TAG, "Throwable " + throwable.getMessage());
                });

        ServerHandler.INSTANCE.getClassList("5e4a719055b2692d34c663eb", 1)
                .subscribe(result -> {
                    String temp = textView.getText().toString() + " ";
                    textView.setText(temp + result);
                    System.out.println(result);
                }, throwable -> {
                    Log.e(TAG, "Throwable " + throwable.getMessage());
                });

        ServerHandler.INSTANCE.getPickList("5e4a719055b2692d34c663eb", 1)
                .subscribe(result -> {
                    String temp = textView.getText().toString() + " ";
                    textView.setText(temp + result);
                    System.out.println(result);
                }, throwable -> {
                    Log.e(TAG, "Throwable " + throwable.getMessage());
                });

        ServerHandler.INSTANCE.getFinList("5e4a719055b2692d34c663eb", 1)
                .subscribe(result -> {
                    String temp = textView.getText().toString() + " ";
                    textView.setText(temp + result);
                    System.out.println(result);
                }, throwable -> {
                    Log.e(TAG, "Throwable " + throwable.getMessage());
                });

        ServerHandler.INSTANCE.classRegister("5e4a719055b2692d34c663eb", "5e3fe6c6e228761b2864388e", "기타 첫걸음1")
                .subscribe(result -> {
                    String temp = textView.getText().toString() + " ";
                    textView.setText(temp + result);
                    System.out.println(result);
                }, throwable -> {
                    Log.e(TAG, "Throwable " + throwable.getMessage());
                });

        ServerHandler.INSTANCE.classPickup("5e4a719055b2692d34c663eb", "5e3fe6c6e228761b2864388e", "기타 첫걸음1")
                .subscribe(result -> {
                    String temp = textView.getText().toString() + " ";
                    textView.setText(temp + result);
                    System.out.println(result);
                }, throwable -> {
                    Log.e(TAG, "Throwable " + throwable.getMessage());
                });

        ServerHandler.INSTANCE.classFin("5e4a719055b2692d34c663eb", "5e3fe6c6e228761b2864388e", "1")
                .subscribe(result -> {
                    String temp = textView.getText().toString() + " ";
                    textView.setText(temp + result);
                    System.out.println(result);
                }, throwable -> {
                    Log.e(TAG, "Throwable " + throwable.getMessage());
                });

        ServerHandler.INSTANCE.classGetDetail("5e3fe6c6e228761b2864388e")
                .subscribe(result -> {
                    String temp = textView.getText().toString() + " ";
                    textView.setText(temp + result);
                    System.out.println(result);
                }, throwable -> {
                    Log.e(TAG, "Throwable " + throwable.getMessage());
                });

        ServerHandler.INSTANCE.classSearch("기타 첫걸음1")
                .subscribe(result -> {
                    String temp = textView.getText().toString() + " ";
                    textView.setText(temp + result);
                    System.out.println(result);
                }, throwable -> {
                    Log.e(TAG, "Throwable " + throwable.getMessage());
                });
    }
}
