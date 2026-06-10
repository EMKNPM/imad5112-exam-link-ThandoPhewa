package com.example.campsitecommander

import android.content.Intent
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

        //Parallel Array
        val itemNames = arrayOf(
            "Tent", "Sleeping bag", "Torch", "Camping chair", "First Aid kit"
        )
        val categories = arrayOf(
            "Shelter", "Sleeping ", "Lighting", "Furniture", "Safety"
        )
        val quantities = arrayOf(
            1, 2, 3, 2, 1
        )
        val comments = arrayOf(
            "4 person tent",
            "Warm weather bags",
            "Extra batteries packed",
            "Foldable chairs",
            "Emergency supplies"


        )


        var displayText = "Camping Gear List\n\n"

        for (i in itemNames.indices) {
            displayText +=

                "Items: ${itemNames[i]}\n" +
                        "Category: ${categories[i]}\n" +
                        "Quantity: ${quantities[i]}\n" +
                        "Comments: ${comments[i]}\n\n"

            tvDetails.text = displayText

            btnBack.setOnClickListener {
                startActivity(Intent(this, MainScreen::class.java))
                finish()
            }






            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }

        class Items {

        }
    }
}