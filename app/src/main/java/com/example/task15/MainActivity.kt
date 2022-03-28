package com.example.task15

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.task15.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter = ContactAdapter()
    private val app = App()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        app.init(this)

        binding.rv.layoutManager = LinearLayoutManager(this)
        binding.rv.adapter = adapter

        getContactsInfo()

        binding.btn.setOnClickListener {
            showContactsInfo()
        }
    }

    private fun getContactsInfo() {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_CONTACTS)
            != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.READ_CONTACTS),
                0
            )
        }

        val contentResolver = contentResolver
        val uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI
        val cursor = contentResolver.query(uri, null, null, null, null)

        if (cursor != null && cursor.moveToFirst()) {
            do {
                val contactName =
                    cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.Contacts.DISPLAY_NAME))
                val contactPhone =
                    cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.NUMBER))
                app.getContactDao().insert(ContactDbEntity(0, contactName, contactPhone))
            } while (cursor.moveToNext())
            cursor.close()
        }
    }

    private fun showContactsInfo() = with(binding) {
        adapter.clear()
        val contacts = app.getContactDao().getAll()
        for (contact in contacts) {
            adapter.addContact(contact)
        }
    }
}