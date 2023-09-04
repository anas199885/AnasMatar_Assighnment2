package com.example.assignmentno2

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import com.example.assignmentno2.databinding.ActivityPhoneModelsBinding

class PhoneModelsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPhoneModelsBinding
    private lateinit var selectedCapacity: String
    private lateinit var selectedColor: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPhoneModelsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val brand = intent.getStringExtra("brand")
        val models = getPhoneModels(brand)

        binding.brandTextView.text = brand

        val adapter = ArrayAdapter(this, R.layout.array_item, models)
        binding.modelsListView.adapter = adapter

        binding.modelsListView.setOnItemClickListener { _, _, position, _ ->
            val selectedModel = models[position]
            showCapacityAndColorOptions(brand, selectedModel)
        }
    }

    private fun showCapacityAndColorOptions(brand: String?, model: String) {
        binding.modelTextView.text = model

        binding.confirmButton.setOnClickListener {
            val selectedCapacityId = binding.capacityRadioGroup.checkedRadioButtonId
            val selectedColorId = binding.colorRadioGroup.checkedRadioButtonId

            if (selectedCapacityId != -1 && selectedColorId != -1) {
                val selectedCapacityRadioButton = findViewById<RadioButton>(selectedCapacityId)
                val selectedColorRadioButton = findViewById<RadioButton>(selectedColorId)

                selectedCapacity = selectedCapacityRadioButton.text.toString()
                selectedColor = selectedColorRadioButton.text.toString()

                showCustomerInfo(brand, model)
            }
        }
    }

    private fun getPhoneModels(brand: String?): List<String> {
        return when (brand) {
            "iPhone" -> listOf("iPhone 14", "iPhone 14 pro Max", "iPhone 14 Pro")
            "Samsung" -> listOf("Galaxy S22", "Galaxy S22 Ultra", "Galaxy Z")
            "Google Pixel" -> listOf("Google Pixel 6", "Google Pixel 6 Pro", "Google Pixel 6a")
            "Oppo" -> listOf("Oppo Find X5", "Oppo Find X5 Pro", "Oppo Find X3")
            else -> emptyList()
        }
    }

    private fun showCustomerInfo(brand: String?, model: String) {
        val intent = Intent(this, CustomerInfoActivity::class.java)
        intent.putExtra("brand", brand)
        intent.putExtra("model", model)
        intent.putExtra("capacity", selectedCapacity)
        intent.putExtra("color", selectedColor)
        startActivity(intent)
    }
}