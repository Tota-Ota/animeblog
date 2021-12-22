package com.example.blog_anime

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SplashScreen : AppCompatActivity() {

    private val splashScreen = 4000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        val topAnim: Animation = AnimationUtils.loadAnimation(this, R.anim.top_animation)
        val bottomAnim: Animation = AnimationUtils.loadAnimation(this, R.anim.bottom_animation)
        val appLogo: ImageView = findViewById(R.id.appLogo)
        val appName: TextView = findViewById(R.id.appName)
        val slogan: TextView = findViewById(R.id.slogan)

        appLogo.animation = topAnim
        appName.animation = bottomAnim
        slogan.animation = bottomAnim

        Handler().postDelayed({
            startActivity(intent)
            val intent = Intent(this@SplashScreen, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, splashScreen.toLong())
    }
}