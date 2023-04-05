package com.example.sirus

import android.content.Intent
import android.os.Bundle
import android.transition.Explode
import android.view.WindowManager
import android.view.animation.DecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import com.example.sirus.databinding.ActivityCategoryBinding

class CategoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCategoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setAnimation()
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        backButton()
    }

    private fun backButton() {
        binding.catBack.setOnClickListener {
            startActivity(Intent(this, DashBoardActivity::class.java))
            finish()
        }
    }

    private fun setAnimation(){
        val explode  = Explode()
        explode.duration = 1000
        explode.interpolator =  DecelerateInterpolator()
        window.enterTransition = explode
        window.exitTransition = explode
    }
}