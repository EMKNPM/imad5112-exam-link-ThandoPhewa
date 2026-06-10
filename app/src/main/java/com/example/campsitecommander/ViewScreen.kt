package com.example.campsitecommander

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ViewScreen : AppCompatActivity() {

    //Declarations
    private lateinit var tvDetails: TextView
    private lateinit var btnBack: Button




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_view_screen)

        //typecasting
        tvDetails = findViewById(R.id.tvDetails)
        btnBack = findViewById(R.id.btnBack)

        var display = ""

        for (i in MainScreen.itemNames.indices){

            display +=

                "Items: ${MainScreen.itemNames[i]}\n" +
                "Category: ${MainScreen.Categories[i]}\n"  +
                "Quantity: ${MainScreen.Quantity[i]}\n" +
                "Comments: ${MainScreen.Comments[i]}\n\n"



        }

        tvDetails.text = display

        btnBack.setOnClickListener {
            finish()
        }






        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}