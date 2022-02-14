package com.example.simplecarssalesapp.ui

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.simplecarssalesapp.R
import com.squareup.picasso.Picasso

class CarDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car_detail)

        val imageView: ImageView = findViewById(R.id.imageView1_carPhoto)
        // Something wrong with the given uri, cannot find the image
        //Picasso.get().load(intent.getStringExtra("photo")).into(imageView);

        // When we use a working uri, the image can be displayed
        val url = "https://imageio.forbes.com/specials-images/imageserve/5d3703b3090f4300070d570d/2020-Cadillac-CT5/0x0.jpg?fit=crop&format=jpg&crop=4842,2723,x288,y538,safe"
        Picasso.get().load(url).into(imageView);

        val name: TextView = findViewById(R.id.textView1_yearMakeModelTrim)
        name.text = intent.getStringExtra("yearMakeModelTrim")

        val priceMileage: TextView = findViewById(R.id.textView2_priceMileage)
        priceMileage.text = intent.getStringExtra("priceMileage")

        val location: TextView = findViewById(R.id.textView_location)
        location.text = intent.getStringExtra("location")

        val exColor: TextView = findViewById(R.id.textView_exteriorColor)
        exColor.text = intent.getStringExtra("exteriorColor")

        val inColor: TextView = findViewById(R.id.textView_interiorColor)
        inColor.text = intent.getStringExtra("interiorColor")

        val driveType: TextView = findViewById(R.id.textView_driveType)
        driveType.text = intent.getStringExtra("driveType")

        val trans: TextView = findViewById(R.id.textView_transmission)
        trans.text = intent.getStringExtra("transmission")

        val bodyStyle: TextView = findViewById(R.id.textView_bodyStyle)
        bodyStyle.text = intent.getStringExtra("bodyStyle")

        val engine: TextView = findViewById(R.id.textView_engine)
        engine.text = intent.getStringExtra("engine")

        val fuel: TextView = findViewById(R.id.textView_fuel)
        fuel.text = intent.getStringExtra("fuel")

        val button1: Button = findViewById(R.id.button1_callDealer)
        button1.setOnClickListener {
            intent.getStringExtra("phone")?.let { it1 -> dialPhoneNumber(it1) }
        }
    }

    private fun dialPhoneNumber(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phoneNumber")
        }
        startActivity(intent)
    }

}