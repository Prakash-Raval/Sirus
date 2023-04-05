package com.example.sirus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Explode
import android.view.animation.DecelerateInterpolator

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setAnimation()
        setContentView(R.layout.activity_login)
    }
    private fun setAnimation(){
        val explode  = Explode()
        explode.duration = 1000
        explode.interpolator =  DecelerateInterpolator()
        window.enterTransition = explode
        window.exitTransition = explode
    }
}