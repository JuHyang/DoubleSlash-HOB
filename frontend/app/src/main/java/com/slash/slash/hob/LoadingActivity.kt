package com.slash.slash.hob

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class LoadingActivity : AppCompatActivity() { // 로딩화면 -> 움직이는지 ? 물어봐야함 다른 progress 를 사용하는지?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)
    }
}
