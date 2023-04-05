package com.example.sirus


import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.sirus.databinding.ActivityRetailerBinding


class RetailerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRetailerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        binding = ActivityRetailerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loginScreen()
        signUpScreen()
    }

    private fun loginScreen(){
        binding.btnLogin.setOnClickListener {
           val options = ActivityOptions.makeSceneTransitionAnimation(this)
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent,options.toBundle())
        }
    }
    private fun signUpScreen(){
        binding.btnSignUp.setOnClickListener {
            startActivity(Intent(this,SignUpActivity::class.java))
        }
    }
}