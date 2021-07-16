package com.example.loginproshecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.content.Intent
class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val x = findViewById<ImageView>(R.id.SplashLogo)

        x.alpha = 0f
        x.animate().setDuration(1500).alpha(1f).withEndAction{
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }
    }
}