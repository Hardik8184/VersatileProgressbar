package com.hardik.progressbar

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import com.hardik.versatileprogressbar.VersatileProgressbar

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    val progBar = findViewById<VersatileProgressbar>(R.id.myProgBar)
    progBar.setProgressVector(R.drawable.triad_ring)
    progBar.setTextMsg("Please wait...")
    progBar.setTextColor(Color.RED)
    progBar.setTextSize(14.0f)

    Handler().postDelayed({ progBar.visibility = View.GONE }, 5000)
  }
}
