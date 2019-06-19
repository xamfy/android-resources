package com.xamfy.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.xamfy.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding : ActivityMainBinding = DataBindingUtil.setContentView(this,
            R.layout.activity_main)

//        binding.tvName.text = "xamfy"
//        binding.tvEmail.text = "xamfy@example.com"
        binding.contact = Contact("xamfy", "xamfy@example.com")
        binding.handler = EventHandler(this)
        binding.imageUrl = "https://i.redd.it/lhw4vp5yoy121.jpg"

    }
}
