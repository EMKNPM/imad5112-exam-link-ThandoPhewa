package com.example.campsitecommander

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Comment
import java.util.Locale

class MainScreen : AppCompatActivity() {

    //Declaring
    private lateinit var tvTotal: TextView
    private lateinit var edtItems: EditText
    private lateinit var edtCategory: EditText
    private lateinit var edtQuantity: EditText
    private lateinit var edtComment: EditText
    private lateinit var btnAdd: Button
    private lateinit var btnView: Button

    //Parallel arrays to store gear information
    val itemNames = ArrayList<String>()
    val Categories = ArrayList<String>()
    val Quantities = ArrayList<Int>()
    val Comments = ArrayList<String>()




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_screen)



        //Typecasting
        tvTotal = findViewById(R.id.tvTotal)
        edtItems = findViewById(R.id.edtItems)
        edtComment = findViewById(R.id.edtComment)
        edtCategory = findViewById(R.id.edtCategory)
        edtQuantity = findViewById(R.id.edtQuantity)
        btnAdd = findViewById(R.id.btnAdd)
        btnView = findViewById(R.id.btnView)



        if(itemNames.isEmpty()){

            itemNames.add("Tent")
            Categories.add("Shelter")
            Quantities.add(1)
            Comments.add("4-person waterproof")

            itemNames.add("Marshmallows")
            Categories.add("Food")
            Quantities.add(3)
            Comments.add("for S'mores(Mega size")

            itemNames.add("Flashlight")
            Categories.add("Safety")
            Quantities.add(2)
            Comments.add("Check batteries(AA)")
        }

        calculateTotal()
        btnAdd.setOnClickListener {

            if(edtItems.text.isEmpty() ||
                edtCategory.text.isEmpty() ||
                edtQuantity.text.isEmpty() ||
                edtComment.text.isEmpty()


                ){Toast.makeText(this,"Please complete all fields", Toast.LENGTH_SHORT).show()
        }else {

                itemNames.add(edtItems.text.toString())
                Categories.add(edtCategory.text.toString())
                Quantities.add(edtQuantity.text.toString().toInt())
                Comments.add(edtComment.text.toString())

                calculateTotal()
                Toast.makeText(this,"Gear added successfully", Toast.LENGTH_SHORT).show()

                edtItems.text.clear()
                edtCategory.text.clear()
                edtQuantity.text.clear()
                edtComment.text.clear()

        }

            }
        btnView.setOnClickListener {
            startActivity(Intent(this, ViewScreen::class.java))
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun calculateTotal(){

        var total = 0

        for (qty in Quantities){
            total += qty
        }
        tvTotal.text = "Total items Packed"
    }


}