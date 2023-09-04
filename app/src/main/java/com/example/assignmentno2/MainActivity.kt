package com.example.assignmentno2

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var brandListView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        brandListView = findViewById(R.id.brandListView)
        val brands = listOf("iPhone", "Samsung", "Google Pixel", "Oppo")
        val adapter = ArrayAdapter(this, R.layout.array_item, brands)
        brandListView.adapter = adapter

        brandListView.setOnItemClickListener { _, _, position, _ ->
            val selectedBrand = brands[position]
            showPhoneModels(selectedBrand)
        }
    }

    private fun showPhoneModels(brand: String) {
        val intent = Intent(this, PhoneModelsActivity::class.java)
        intent.putExtra("brand", brand)
        startActivity(intent)
    }
}