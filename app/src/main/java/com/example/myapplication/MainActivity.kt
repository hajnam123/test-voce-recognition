package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {
    val SPEECH_INPUT = 12312

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);

        findViewById<TextView>(R.id.text1).setOnClickListener {
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, findViewById<TextView>(R.id.text1).text)
            startActivityForResult(intent, SPEECH_INPUT)
        }
        findViewById<TextView>(R.id.text2).setOnClickListener {
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, findViewById<TextView>(R.id.text2).text)
            startActivityForResult(intent, SPEECH_INPUT)
        }
        findViewById<TextView>(R.id.text3).setOnClickListener {
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, findViewById<TextView>(R.id.text3).text)
            startActivityForResult(intent, SPEECH_INPUT)
        }
        findViewById<TextView>(R.id.text4).setOnClickListener {
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, findViewById<TextView>(R.id.text4).text)
            startActivityForResult(intent, SPEECH_INPUT)
        }
        findViewById<TextView>(R.id.text5).setOnClickListener {
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, findViewById<TextView>(R.id.text5).text)
            startActivityForResult(intent, SPEECH_INPUT)
        }
        findViewById<TextView>(R.id.text6).setOnClickListener {
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, findViewById<TextView>(R.id.text6).text)
            startActivityForResult(intent, SPEECH_INPUT)
        }
        findViewById<TextView>(R.id.text7).setOnClickListener {
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, findViewById<TextView>(R.id.text7).text)
            startActivityForResult(intent, SPEECH_INPUT)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == SPEECH_INPUT) {
            if (resultCode == RESULT_OK) {
                println("result ok")
                val result = data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
                result?.forEach {
                    println(it)
                }
            } else {
                println("result not ok")
            }
        }
    }
}
