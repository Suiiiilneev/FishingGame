package com.doggyliash.blazfishing

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class GameOverActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

        val game_score = findViewById<TextView>(R.id.textView)
        val score = intent.getIntExtra("score", 0)
        game_score.text = "$score"




        val decorView = window.decorView
        val uiOptions = (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
        decorView.systemUiVisibility = uiOptions
        val handler = Handler()
        val hideSystemUI = Runnable { decorView.systemUiVisibility = uiOptions }

        decorView.setOnSystemUiVisibilityChangeListener { visibility ->
            if (visibility and View.SYSTEM_UI_FLAG_FULLSCREEN == 0) {
                // The system bars are visible. Schedule a task to hide the navigation and status bar after a few seconds.
                handler.postDelayed(hideSystemUI, 5000)
            }
        }

        val imageButtonStart = findViewById<ImageButton>(R.id.start)
        val imageButtonHome = findViewById<ImageButton>(R.id.back_home)
        imageButtonHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        imageButtonStart.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
        }
    }
}
