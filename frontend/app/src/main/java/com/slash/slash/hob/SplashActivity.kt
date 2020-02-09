package com.slash.slash.hob

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            // TODO : 로그인 상태 레크해서 액티비티 결정해서 넘겨야함 !
            val intent = Intent (this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}
