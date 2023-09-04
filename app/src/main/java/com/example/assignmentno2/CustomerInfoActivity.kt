package com.example.assignmentno2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.assignmentno2.databinding.ActivityCustomerInfoBinding

class CustomerInfoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCustomerInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomerInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve selected brand and model
        val brand = intent.getStringExtra("brand")
        val model = intent.getStringExtra("model")

        binding.checkoutButton.setOnClickListener {
            val name = binding.nameEditText.text.toString()
            val address = binding.addressEditText.text.toString()
            val city = binding.cityEditText.text.toString()
            val postalCode = binding.postalCodeEditText.text.toString()
            val phoneNumber = binding.phoneNumberEditText.text.toString()
            val cardNumber = binding.cardNumberEditText.text.toString()
            val cardType = binding.cardTypeEditText.text.toString()
            val expiration = binding.expirationEditText.text.toString()
            val cvv = binding.cvvEditText.text.toString()
            val capacity = intent.getStringExtra("capacity")
            val color = intent.getStringExtra("color")


            showConfirmation(brand, model, name, address, city, postalCode, phoneNumber, cardNumber, cardType, expiration, cvv, capacity, color)
        }
    }

    private fun showConfirmation(
        brand: String?,
        model: String?,
        name: String,
        address: String,
        city: String,
        postalCode: String,
        phoneNumber: String,
        cardNumber: String,
        cardType: String,
        expiration: String,
        cvv: String,
        capacity: String?,
        color: String?
    ) {
        val intent = Intent(this, ConfirmationActivity::class.java)
        intent.putExtra("brand", brand)
        intent.putExtra("model", model)
        intent.putExtra("name", name)
        intent.putExtra("address", address)
        intent.putExtra("city", city)
        intent.putExtra("postalCode", postalCode)
        intent.putExtra("phoneNumber", phoneNumber)
        intent.putExtra("cardNumber", cardNumber)
        intent.putExtra("cardType", cardType)
        intent.putExtra("expiration", expiration)
        intent.putExtra("cvv", cvv)
        intent.putExtra("capacity", capacity)
        intent.putExtra("color", color)
        startActivity(intent)
    }
}