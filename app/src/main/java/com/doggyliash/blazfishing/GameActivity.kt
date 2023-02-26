package com.doggyliash.blazfishing

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.Rect
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.view.animation.*
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_finish.view.*
import kotlinx.android.synthetic.main.activity_game.*
import java.util.*


class GameActivity: AppCompatActivity(){

    var gameTimer: CountDownTimer? = null
    private lateinit var fish1: ImageView
    private lateinit var fish2: ImageView
    private lateinit var fish3: ImageView
    private lateinit var fish4: ImageView
    private lateinit var fish5: ImageView
    private lateinit var fish6: ImageView
    private lateinit var fish7: ImageView
    private lateinit var fish8: ImageView
    private lateinit var fish9: ImageView
    private lateinit var fish10: ImageView
    private lateinit var hook: ImageView

    var globalVariable = 0
    var isButtonPressed = false

    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

        fish1 = findViewById(R.id.fish1)
        fish2 = findViewById(R.id.fish2)
        fish3 = findViewById(R.id.fish3)
        fish4 = findViewById(R.id.fish4)
        fish5 = findViewById(R.id.fish5)
        fish6 = findViewById(R.id.fish6)
        fish7 = findViewById(R.id.fish7)
        fish8 = findViewById(R.id.fish8)
        fish9 = findViewById(R.id.fish9)
        fish10 = findViewById(R.id.fish10)

        hook = findViewById(R.id.hook_image)
        val screenWidth = resources.displayMetrics.widthPixels
        val fishWidth = fish1.width

        val anim1 = ObjectAnimator.ofFloat(fish1, "x", -fishWidth.toFloat(), screenWidth.toFloat() + fishWidth, -fishWidth.toFloat())
        anim1.duration = 4500
        anim1.repeatCount = ObjectAnimator.INFINITE
        anim1.repeatMode = ObjectAnimator.RESTART
        anim1.start()
        fish1.x = screenWidth.toFloat() + fishWidth
        fish1.pivotX = 0f


        val anim2 = ObjectAnimator.ofFloat(fish2, "x", -fishWidth.toFloat(), screenWidth.toFloat() + fishWidth, -fishWidth.toFloat())
        anim2.duration = 3800
        anim2.repeatCount = ObjectAnimator.INFINITE
        anim2.repeatMode = ObjectAnimator.RESTART
        fish2.x = screenWidth.toFloat() + fishWidth

        anim2.start()
        fish2.pivotX = 0f

        val anim3 = ObjectAnimator.ofFloat(fish3, "x", fish3.x, fish3.x + 2500)
        anim3.duration = 3600
        anim3.repeatCount = ObjectAnimator.INFINITE
        anim3.repeatMode = ObjectAnimator.RESTART
        anim3.start()
        fish3.x = screenWidth.toFloat() + fishWidth
        fish3.pivotX = 0f

        val anim4 = ObjectAnimator.ofFloat(fish4, "x", -fishWidth.toFloat(), screenWidth.toFloat() + fishWidth, -fishWidth.toFloat())
        anim4.duration = 4000
        anim4.repeatCount = ObjectAnimator.INFINITE
        anim4.repeatMode = ObjectAnimator.RESTART
        anim4.start()
        anim4.interpolator = AccelerateInterpolator()
        fish4.x = screenWidth.toFloat() + fishWidth
        fish4.pivotX = 0f

        val anim5 = ObjectAnimator.ofFloat(fish5, "x", screenWidth.toFloat(), 0f)
        anim5.duration = 3800
        anim5.repeatCount = ObjectAnimator.INFINITE
        anim5.repeatMode = ObjectAnimator.RESTART
        anim5.start()
        fish5.x = screenWidth.toFloat()
        anim5.interpolator = AccelerateInterpolator()
        fish5.pivotX = 0f

        val anim6 = ObjectAnimator.ofFloat(fish6, "x", -fishWidth.toFloat(), screenWidth.toFloat() + fishWidth, -fishWidth.toFloat())
        anim6.duration = 4500
        anim6.repeatCount = ObjectAnimator.INFINITE
        anim6.repeatMode = ObjectAnimator.RESTART
        anim6.start()
        fish6.x = screenWidth.toFloat() + fishWidth
        fish6.pivotX = 0f


        val anim7 = ObjectAnimator.ofFloat(fish7, "x", -fishWidth.toFloat(), screenWidth.toFloat() + fishWidth, -fishWidth.toFloat())
        anim7.duration = 3800
        anim7.repeatCount = ObjectAnimator.INFINITE
        anim7.repeatMode = ObjectAnimator.RESTART
        fish7.x = screenWidth.toFloat() + fishWidth
        anim7.start()
        fish7.pivotX = 0f

        val anim8 = ObjectAnimator.ofFloat(fish8, "x", fish8.x, fish8.x + 2500)
        anim8.duration = 3600
        anim8.repeatCount = ObjectAnimator.INFINITE
        anim8.repeatMode = ObjectAnimator.RESTART
        anim8.start()
        fish8.x = screenWidth.toFloat() + fishWidth
        fish8.pivotX = 0f

        val anim9 = ObjectAnimator.ofFloat(fish9, "x", -fishWidth.toFloat(), screenWidth.toFloat() + fishWidth, -fishWidth.toFloat())
        anim9.duration = 4000
        anim9.repeatCount = ObjectAnimator.INFINITE
        anim9.repeatMode = ObjectAnimator.RESTART
        anim9.start()
        anim9.interpolator = AccelerateInterpolator()
        fish9.x = screenWidth.toFloat() + fishWidth
        fish9.pivotX = 0f

        val anim10 = ObjectAnimator.ofFloat(fish10, "x", screenWidth.toFloat(), 0f)
        anim10.duration = 3800
        anim10.repeatCount = ObjectAnimator.INFINITE
        anim10.repeatMode = ObjectAnimator.RESTART
        anim10.start()
        fish10.x = screenWidth.toFloat()
        anim10.interpolator = AccelerateInterpolator()
        fish10.pivotX = 0f

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


        startTimer()
        //

        val ImageViewRope = findViewById<ImageView>(R.id.rope)
        val ImageViewHook = findViewById<ImageView>(R.id.hook_image)
        val ImageButtonLower = findViewById<ImageButton>(R.id.lower_button)


        ImageButtonLower.setOnClickListener {
            startCheckingIntersection()

            if (!isButtonPressed) {
                isButtonPressed = true
                ImageButtonLower.isClickable = false  // set to false before animation starts

                val animHookDown = ObjectAnimator.ofFloat(ImageViewHook, "y", ImageViewHook.y, ImageViewHook.y + 500)
                animHookDown.duration = 1000
                ImageViewRope.pivotY = 0f
                animHookDown.start()
                animHookDown.interpolator = AccelerateInterpolator()

                animHookDown.addListener(object : AnimatorListenerAdapter(){
                    override fun onAnimationStart(animation: Animator){}
                    override fun onAnimationEnd(animation: Animator) {
                        super.onAnimationEnd(animation)
                        isButtonPressed = false
                        val animHookUp = ObjectAnimator.ofFloat(ImageViewHook, "y", ImageViewHook.y, ImageViewHook.y - 500)
                        animHookUp.duration = 1000
                        ImageViewRope.pivotY = 0f
                        animHookUp.start()
                        animHookUp.interpolator = DecelerateInterpolator()
                        animHookUp.addListener(object : AnimatorListenerAdapter(){
                            override fun onAnimationEnd(animation: Animator) {
                                super.onAnimationEnd(animation)
                                ImageButtonLower.isClickable = true  // set to true after animation ends
                            }
                        })
                    }
                })

                val animRope = ObjectAnimator.ofFloat(ImageViewRope, "scaleY", 1f, 2.69f)
                animRope.duration = 1000
                animRope.start()
                ImageViewRope.pivotY = 0f
                animRope.interpolator = AccelerateInterpolator()

                animRope.addListener(object : AnimatorListenerAdapter(){
                    override fun onAnimationEnd(animation: Animator) {
                        super.onAnimationEnd(animation)
                        val animRope = ObjectAnimator.ofFloat(ImageViewRope, "scaleY", 2.69f, 1f)
                        animRope.duration = 1000
                        animRope.start()
                        animRope.interpolator = DecelerateInterpolator()
                    }
                })
            }
        }
        // code to update the score counter
    }
    private var handler = Handler()

    private fun startCheckingIntersection() {
        handler.postDelayed({
            checkIntersection()
            startCheckingIntersection()
        }, 500) // update the score every 500 milliseconds
    }
    private fun checkIntersection() {
        val scoreCounter = findViewById<TextView>(R.id.points_text_view)

        val hookRect = Rect()
        hook.getHitRect(hookRect)
        val fishRect1 = Rect()
        fish1.getHitRect(fishRect1)
        val fishRect2 = Rect()
        fish2.getHitRect(fishRect2)
        val fishRect3 = Rect()
        fish3.getHitRect(fishRect3)
        val fishRect4 = Rect()
        fish4.getHitRect(fishRect4)
        val fishRect5 = Rect()
        fish5.getHitRect(fishRect5)
        val fishRect6 = Rect()
        fish6.getHitRect(fishRect6)
        val fishRect7 = Rect()
        fish7.getHitRect(fishRect7)
        val fishRect8 = Rect()
        fish8.getHitRect(fishRect8)
        val fishRect9 = Rect()
        fish9.getHitRect(fishRect9)
        val fishRect10 = Rect()
        fish10.getHitRect(fishRect10)

        if (hookRect.intersect(fishRect1)) {
            score += 1
            fish1.visibility = View.GONE
            // spawn a new fish here
            spawnFish(fish6)
        }
        if (hookRect.intersect(fishRect2)) {
            score += 1
            fish2.visibility = View.GONE
            // spawn a new fish here
            spawnFish(fish7)
        }
        if (hookRect.intersect(fishRect3)) {
            score += 1
            fish3.visibility = View.GONE
            // spawn a new fish here
            spawnFish(fish8)
        }
        if (hookRect.intersect(fishRect4)) {
            score += 1
            fish4.visibility = View.GONE
            // spawn a new fish here
            spawnFish(fish9)
        }
        if (hookRect.intersect(fishRect5)) {
            score += 1
            fish5.visibility = View.GONE
            // spawn a new fish here
            spawnFish(fish10)
        }

        if (hookRect.intersect(fishRect6)) {
            score += 1
            fish6.visibility = View.GONE
            // spawn a new fish here
            spawnFish(fish1)
        }
        if (hookRect.intersect(fishRect7)) {
            score += 1
            fish7.visibility = View.GONE
            // spawn a new fish here
            spawnFish(fish2)
        }
        if (hookRect.intersect(fishRect8)) {
            score += 1
            fish8.visibility = View.GONE
            // spawn a new fish here
            spawnFish(fish3)
        }
        if (hookRect.intersect(fishRect9)) {
            score += 1
            fish9.visibility = View.GONE
            // spawn a new fish here
            spawnFish(fish4)
        }
        if (hookRect.intersect(fishRect10)) {
            score += 1
            fish10.visibility = View.GONE
            // spawn a new fish here
            spawnFish(fish10)
        }
            runOnUiThread {
                scoreCounter.text = "$score"

            }

    }


    private fun spawnFish(fish: ImageView) {
        fish.visibility = View.VISIBLE
        val x = fish.x
        val y = fish.y
        fish.x = x.toFloat()
        fish.y = y.toFloat()
    }
    fun startTimer() {
        gameTimer = object : CountDownTimer(90000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val timer = findViewById<TextView>(R.id.timer)
                val remainingTime = millisUntilFinished / 1000
                timer.text = "$remainingTime"
                // you can update the UI here with the remaining time
            }
            override fun onFinish() {
                //when time is over
                showFinishActivity()
            }
        }
        gameTimer?.start()
    }
    fun showFinishActivity() {
        val intent = Intent(this, GameOverActivity::class.java)
        intent.putExtra("score", score)
        startActivity(intent)

    }


}