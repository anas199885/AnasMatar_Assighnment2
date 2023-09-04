package com.example.assignmentno2

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.assignmentno2.databinding.ActivityConfirmationBinding

class ConfirmationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConfirmationBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConfirmationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve selected brand, model, and customer information
        val brand = intent.getStringExtra("brand")
        val model = intent.getStringExtra("model")
        val name = intent.getStringExtra("name")
        val address = intent.getStringExtra("address")
        val city = intent.getStringExtra("city")
        val postalCode = intent.getStringExtra("postalCode")
        val phoneNumber = intent.getStringExtra("phoneNumber")

        val capacity = intent.getStringExtra("capacity")
        val color = intent.getStringExtra("color")


        // Set the values in the respective TextView elements
        binding.brandTextView.text = "Brand: $brand, capacity: $capacity, color: $color"
        binding.modelTextView.text = "Model: $model"
        binding.nameTextView.text = "Customer: $name"
        binding.addressTextView.text = "Address: $address"
        binding.cityTextView.text = "City: $city"
        binding.postalCodeTextView.text = "Postal Code: $postalCode"
        binding.phoneNumberTextView.text = "Phone: $phoneNumber"
    }
}