package com.doggyliash.blazfishing

import android.content.Intent
import android.content.pm.ActivityInfo
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer
    var isSoundOn = true
    private fun startMusic(){
        mediaPlayer = MediaPlayer.create(this,R.raw.sound)
        mediaPlayer.setVolume(60f, 60f)
        mediaPlayer.isLooping = true
        mediaPlayer.start()
    }

    private fun stopMusic(){
        mediaPlayer.stop()
        mediaPlayer.release()
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        startMusic()
        setContentView(R.layout.activity_main)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        var isSoundOn = true
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




        val imageButtonSound = findViewById<ImageButton>(R.id.imageButtonSound)
        val imageButtonStart = findViewById<ImageButton>(R.id.imageButtonStart)
        val imageButtonList = findViewById<ImageButton>(R.id.imageButtonList)

        imageButtonSound.setOnClickListener {
           if (isSoundOn){
                stopMusic()
                imageButtonSound.setImageResource(R.drawable.sounds_off)
               isSoundOn = false
        } else{
               startMusic()
               imageButtonSound.setImageResource(R.drawable.sounds_on)
               isSoundOn = true
            }
        }
        imageButtonList.setOnClickListener{
            val intent = Intent(this, RecordTableActivity::class.java)
            startActivity(intent);

        }
        imageButtonStart.setOnClickListener{
            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
        }

    }
}