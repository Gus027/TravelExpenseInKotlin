package com.example.travelexpense

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.travelexpense.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() , View.OnClickListener{

    private lateinit var dist: EditText
    private lateinit var price: EditText
    private lateinit var auto: EditText

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalc.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_calc) {
            calculate()
        }
    }

    private fun isValid(): Boolean{
        return ( binding.editDistance.text.toString() != ""
                && binding.editPreco.text.toString() != ""
                && binding.editAutonomic.text.toString() != ""
                && binding.editAutonomic.text.toString().toFloat() != 0f
                )
    }


    fun calculate(){
        if(isValid()){
            val distance = binding.editDistance.text.toString().toFloat()
            val price = binding.editPreco.text.toString().toFloat()
            val autonomy = binding.editAutonomic.text.toString().toFloat()

            var totalPrice = (distance * price) / autonomy
            var totalValueStr = "R$ ${"%.2f".format(totalPrice)}"

            binding.textPrice.text = totalValueStr
        }
        else
        {
            Toast.makeText(this,R.string.fill_all_filter, Toast.LENGTH_SHORT).show()
        }
    }

}