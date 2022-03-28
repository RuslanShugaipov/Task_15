package com.example.task15

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.task15.databinding.ActivityNoteBinding

class NoteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNoteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNoteBinding.inflate(layoutInflater)

        binding.btnBackToMain.setOnClickListener{
            finish()
        }

        setContentView(R.layout.activity_note)
    }
}