package com.example.sirus


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.sirus.adapters.ViewPagerAdapter
import com.example.sirus.databinding.ActivityOnBoardingBinding


class OnBoardingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnBoardingBinding
    private lateinit var sliderAdapter: ViewPagerAdapter
    private var currentPosition = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sliderAdapter = ViewPagerAdapter(this)
        binding.slider.adapter = sliderAdapter
        //methods
        buttonClicks()
        binding.slider.addOnPageChangeListener(changeListener)
        binding.dot2.attachTo(binding.slider)
    }


    private fun buttonClicks() {
        binding.skipBtn.setOnClickListener {
            startActivity(Intent(this, DashBoardActivity::class.java))
            finish()
        }
        binding.nextBtn.setOnClickListener {
            binding.slider.currentItem = currentPosition.plus(1)
        }
        binding.getStartedBtn.setOnClickListener {
            startActivity(Intent(this, DashBoardActivity::class.java))
            finish()
        }
    }

    private val changeListener: ViewPager.OnPageChangeListener =
        object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                currentPosition = position
                when (position) {
                    0 -> {
                        binding.getStartedBtn.visibility = View.INVISIBLE
                        binding.nextBtn.visibility = View.VISIBLE
                        binding.skipBtn.visibility = View.VISIBLE
                    }
                    1 -> {
                        binding.getStartedBtn.visibility = View.INVISIBLE
                        binding.nextBtn.visibility = View.VISIBLE
                        binding.skipBtn.visibility = View.VISIBLE
                    }
                    2 -> {
                        binding.getStartedBtn.visibility = View.INVISIBLE
                        binding.nextBtn.visibility = View.VISIBLE
                        binding.skipBtn.visibility = View.VISIBLE
                    }
                    else -> {
                        val bottom =
                            AnimationUtils.loadAnimation(this@OnBoardingActivity, R.anim.bootm_anim)
                        binding.getStartedBtn.animation = bottom
                        binding.getStartedBtn.visibility = View.VISIBLE
                        binding.nextBtn.visibility = View.INVISIBLE
                        binding.skipBtn.visibility = View.INVISIBLE
                    }
                }
            }

            override fun onPageScrollStateChanged(state: Int) {}
        }
}