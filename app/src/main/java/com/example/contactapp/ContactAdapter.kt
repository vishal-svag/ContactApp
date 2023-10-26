package com.example.contactapp

import android.content.Context
import android.provider.ContactsContract.Contacts
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter ( private val listOfContacts: List<contactdatafile>): RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    class ContactViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val image : ImageView = itemView.findViewById(R.id.profile_image)
        val name : TextView = itemView.findViewById(R.id.text_name)
        val number : TextView = itemView.findViewById(R.id.text_phone_number)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val  view = LayoutInflater.from(parent.context).inflate(R.layout.layout_contact,parent,false)
        return ContactViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  listOfContacts.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val currentContact = listOfContacts[position]
        holder.name.text = currentContact.name
        holder.number.text = currentContact.phone_number
        holder.image.setImageResource(currentContact.image)
    }
}