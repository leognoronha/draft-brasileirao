package com.example.draftbrasileirao

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStartDraft: Button = findViewById(R.id.btnStartDraft)
        btnStartDraft.setOnClickListener {
            val intent = Intent(this, FormationActivity::class.java)
            startActivity(intent)
        }
    }
}
