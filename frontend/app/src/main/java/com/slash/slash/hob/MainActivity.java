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
        User user = new User("1", "1", 25, "1", "1");
        ServerInterface serverInterface = ServerHandler.INSTANCE.getInterface();
        serverInterface.signUp(user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> {
                    String temp = textView.getText().toString() + " ";
                    textView.setText(temp + result);
                    System.out.println(result);
                }, throwable -> {
                    Log.e(TAG, "Throwable " + throwable.getMessage());
                });

        serverInterface.getAllHobList(1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> {
                    String temp = textView.getText().toString() + " ";
                    textView.setText(temp + result);
                    System.out.println(result);
                }, throwable -> {
                    Log.e(TAG, "Throwable " + throwable.getMessage());
                });

        serverInterface.getClassList("5e4a719055b2692d34c663eb", 1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> {
                    String temp = textView.getText().toString() + " ";
                    textView.setText(temp + result);
                    System.out.println(result);
                }, throwable -> {
                    Log.e(TAG, "Throwable " + throwable.getMessage());
                });

        serverInterface.getPickList("5e4a719055b2692d34c663eb", 1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> {
                    String temp = textView.getText().toString() + " ";
                    textView.setText(temp + result);
                    System.out.println(result);
                }, throwable -> {
                    Log.e(TAG, "Throwable " + throwable.getMessage());
                });

        serverInterface.getFinList("5e4a719055b2692d34c663eb", 1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> {
                    String temp = textView.getText().toString() + " ";
                    textView.setText(temp + result);
                    System.out.println(result);
                }, throwable -> {
                    Log.e(TAG, "Throwable " + throwable.getMessage());
                });

        serverInterface.classRegister("5e4a719055b2692d34c663eb", "5e3fe6c6e228761b2864388e", "기타 첫걸음1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> {
                    String temp = textView.getText().toString() + " ";
                    textView.setText(temp + result);
                    System.out.println(result);
                }, throwable -> {
                    Log.e(TAG, "Throwable " + throwable.getMessage());
                });

        serverInterface.classPickup("5e4a719055b2692d34c663eb", "5e3fe6c6e228761b2864388e", "기타 첫걸음1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> {
                    String temp = textView.getText().toString() + " ";
                    textView.setText(temp + result);
                    System.out.println(result);
                }, throwable -> {
                    Log.e(TAG, "Throwable " + throwable.getMessage());
                });

        serverInterface.classFin("5e4a719055b2692d34c663eb", "5e3fe6c6e228761b2864388e", "1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> {
                    String temp = textView.getText().toString() + " ";
                    textView.setText(temp + result);
                    System.out.println(result);
                }, throwable -> {
                    Log.e(TAG, "Throwable " + throwable.getMessage());
                });

        serverInterface.classGetDetail("5e3fe6c6e228761b2864388e")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> {
                    String temp = textView.getText().toString() + " ";
                    textView.setText(temp + result);
                    System.out.println(result);
                }, throwable -> {
                    Log.e(TAG, "Throwable " + throwable.getMessage());
                });

        serverInterface.classSearch("기타 첫걸음1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> {
                    String temp = textView.getText().toString() + " ";
                    textView.setText(temp + result);
                    System.out.println(result);
                }, throwable -> {
                    Log.e(TAG, "Throwable " + throwable.getMessage());
                });
    }
}
