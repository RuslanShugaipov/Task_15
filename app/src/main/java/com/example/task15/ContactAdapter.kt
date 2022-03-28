package com.example.task15

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.task15.databinding.ContactNoteBinding

class ContactAdapter : RecyclerView.Adapter<ContactAdapter.ContactNoteViewHolder>() {
    private val contactList = ArrayList<ContactDbEntity>()

    class ContactNoteViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = ContactNoteBinding.bind(item)

        fun bind(contactDbEntity: ContactDbEntity) = with(binding) {
            tvPhone.text = contactDbEntity.phone
            tvName.text = contactDbEntity.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactNoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_note, parent, false)
        return ContactNoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactNoteViewHolder, position: Int) {
        holder.bind(contactList[position])
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    fun addContact(contactDbEntity: ContactDbEntity) {
        contactList.add(contactDbEntity)
        notifyDataSetChanged()
    }

    fun clear() {
        contactList.clear()
    }
}