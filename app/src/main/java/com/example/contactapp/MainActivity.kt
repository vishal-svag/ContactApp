package com.example.contactapp

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var rv : RecyclerView
    private lateinit var fab : FloatingActionButton
    private lateinit var edtname : EditText
    private lateinit var edtphone : EditText
    private lateinit var previmg : ImageView
    private lateinit var cibtn : Button
    private  lateinit var submitbtn : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv = findViewById(R.id.rv)
        fab = findViewById(R.id.fab)

        fab.setOnClickListener {
            showDialog()

        }
    }
    private fun showDialog(){
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.fab_layout)

         edtname = dialog.findViewById(R.id.edt_name)
         edtphone = dialog.findViewById(R.id.edt_pnum)
         previmg = dialog.findViewById(R.id.previmg)
         cibtn = dialog.findViewById(R.id.cibtn)
         submitbtn = dialog.findViewById(R.id.submitbtn)

        cibtn.setOnClickListener {
            val galleryIntent = Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(galleryIntent,101)
        }
        dialog.show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 101 && resultCode == RESULT_OK){
            previmg.visibility = View.VISIBLE
            previmg.setImageURI(data?.data)
        }
    }

}