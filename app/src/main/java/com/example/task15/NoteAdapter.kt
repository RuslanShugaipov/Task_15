package com.example.task15

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.task15.databinding.ContactNoteBinding

class NoteAdapter: RecyclerView.Adapter<NoteAdapter.ContactNoteViewHolder>() {
    private val noteList = ArrayList<NoteDbEntity>()

    class ContactNoteViewHolder(item: View): RecyclerView.ViewHolder(item) {
        private val binding = ContactNoteBinding.bind(item)

        fun bind(noteDbEntity: NoteDbEntity) = with(binding) {
            tvNote.text = noteDbEntity.text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactNoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_note, parent, false)

        val button = view.findViewById<Button>(R.id.btnAddNote)
        button.setOnClickListener{
            Intent(view.context, NoteActivity::class.java).also {
                view.context.startActivity(it)
            }
        }

        return ContactNoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactNoteViewHolder, position: Int) {
        holder.bind(noteList[position])
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    fun addNote(noteDbEntity: NoteDbEntity){
        noteList.add(noteDbEntity)
        notifyDataSetChanged()
    }

    fun clear(){
        noteList.clear()
    }
}