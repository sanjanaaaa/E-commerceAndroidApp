package com.example.salesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.salesapp.MainActivity
import com.example.salesapp.R
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreenAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        iv_note.alpha=0f
        iv_note.animate().setDuration(1000).alpha(1f).withEndAction{
            val i= Intent(this, MainActivity::class.java)
            startActivity(i)
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            finish()
        }
    }
}