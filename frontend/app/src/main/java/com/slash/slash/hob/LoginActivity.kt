package com.slash.slash.hob

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() { // 로그인을 위한 액티비티

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun aboutView () { // 각 뷰들의 동작을 정의해 주는 함수
        // TODO : 회원가입, 구글로그인, 카카오 로그인, 네이버 로그인, 페이스북 로그인 구
    }
}
