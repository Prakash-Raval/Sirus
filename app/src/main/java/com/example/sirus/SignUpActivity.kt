package com.example.sirus

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.sirus.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
     fun changeLayout(){
        setContentView(R.layout.layout_two)

    }
    fun changeLayoutThree(view: View){
        setContentView(R.layout.layout_three)
    }

    fun changeLayout(view: View) {
        setContentView(R.layout.layout_two)
    }


}