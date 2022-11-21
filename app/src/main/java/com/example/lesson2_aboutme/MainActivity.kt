package com.example.lesson2_aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.lesson2_aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Maksat Maratov", )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
/*
        supportActionBar?.hide()
*/

        binding.myName = myName

        binding.btnDone.setOnClickListener{
            addNickname(it)
        }

        /*nickname_text = findViewById(R.id.nickname_text)
        nickname_text = binding.btnDone
        */
        binding.nicknameText.setOnClickListener{
            updateNickname(it)
        }



    }


    private fun updateNickname(view: View){
        binding.apply{
            btnDone.visibility = View.VISIBLE
            nicknameText.visibility = View.GONE
            etName.visibility = View.VISIBLE
        }
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.showSoftInput(binding.etName, 0)
    }

    private fun addNickname(view: View){

        binding.apply{
            /*nicknameText.text = binding.etName.text*/
            myName?.nickname = etName.text.toString()
            invalidateAll()
            etName.visibility = View.GONE
            btnDone.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }

        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)


    }
}