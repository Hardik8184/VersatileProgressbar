package com.hardik.versatileprogressbar

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView

import com.aseem.versatileprogressbar.R
import com.bumptech.glide.Glide

class VersatileProgressbar : RelativeLayout {

  private var mContext: Context? = null
  private var attrs: AttributeSet? = null
  private var styleAttr: Int = 0
  private var imageView: ImageView? = null
  private var imageFile: Int = 0
  private var view: View? = null
  private var progBg: View? = null
  private var textMsg: TextView? = null
  private var customMsg: String? = null
  private var textColor: Int = 0
  private var enlarge: Int = 0
  private var textSize: Float = 0.toFloat()

  constructor(context: Context) : super(context) {
    initView()
  }

  constructor(
    context: Context,
    attrs: AttributeSet
  ) : super(context, attrs) {
    this.mContext = context
    this.attrs = attrs
    initView()
  }

  constructor(
    context: Context,
    attrs: AttributeSet,
    defStyleAttr: Int
  ) : super(context, attrs, defStyleAttr) {
    this.mContext = context
    this.attrs = attrs
    this.styleAttr = defStyleAttr
    initView()
  }

  private fun initView() {
    this.view = this
    View.inflate(mContext, R.layout.progress_bar_layout, this)

    val arr =
      mContext!!.obtainStyledAttributes(attrs, R.styleable.VersatileProgressbar, styleAttr, 0)

    imageFile = arr.getInt(R.styleable.VersatileProgressbar_barType, R.drawable.clock)
    customMsg = arr.getString(R.styleable.VersatileProgressbar_text)
    textColor = arr.getColor(R.styleable.VersatileProgressbar_androidtextColor, Color.BLACK)
    textSize = arr.getDimension(R.styleable.VersatileProgressbar_textSize, 16f)
    enlarge = arr.getInt(R.styleable.VersatileProgressbar_enlarge, 2)
    imageView = findViewById(R.id.progressImg)
    progBg = findViewById(R.id.progBg)
    textMsg = findViewById(R.id.textMsg)

    setProgressVector(imageFile)

    if (customMsg != null) {
      setTextMsg(customMsg!!)
    }

    setTextColor(textColor)
    setTextSize(textSize)
    enlarge(enlarge)

    arr.recycle()
  }

  fun setScaleType(scaleType: ImageView.ScaleType) {
    imageView!!.scaleType = scaleType
  }

  fun setProgressVector(imageFile: Int) {
    Glide
        .with(mContext!!)
        .asGif()
        .load(imageFile)
        .into(imageView!!)
  }

  private fun enlarge(enlarge: Int) {
    if (enlarge in 1..10) {
      imageView!!.layoutParams.height = enlarge * 100
    }
  }

  fun setTextMsg(message: String) {
    textMsg!!.text = message
  }

  fun setTextColor(color: Int) {
    textMsg!!.setTextColor(color)
  }

  fun setTextSize(size: Float) {
    textMsg!!.setTextSize(TypedValue.COMPLEX_UNIT_SP, size)
  }
}
