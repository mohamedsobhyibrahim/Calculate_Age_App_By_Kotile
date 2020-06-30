package com.mohamedsobhy.findmyage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getMyAgeButton.setOnClickListener {
            getInputData(dayOfBirthEditText , monthOfBirthEditText , yearOfBirthEditText )
        }
    }

    private fun getInputData(dayEditText: EditText, monthEditText: EditText, yearEditText: EditText) {

        val dayOfBirth = dayEditText.text.toString()
        val monthOfBirth = monthEditText.text.toString()
        val yearOfBirth = yearOfBirthEditText.text.toString()

        if (yearOfBirth.isEmpty() || dayOfBirth.isEmpty() || monthOfBirth.isEmpty()) {

            if (yearOfBirth.isEmpty()) {
                yearEditText.error = "Please Enter Your Year"
            }
            if (dayOfBirth.isEmpty()) {

                dayEditText.error = "Please Enter Your Day"
            }

            if (monthOfBirth.isEmpty()) {
                monthEditText.error = "Please Enter Your Month"
            }


        } else {
            if (yearOfBirth.toInt() > Calendar.getInstance().get(Calendar.YEAR) ||
                monthOfBirth.toInt() > 12 || dayOfBirth.toInt() > 31){

                if (yearOfBirth.toInt() > Calendar.getInstance().get(Calendar.YEAR)) {
                    yearEditText.error = "Please Enter Valid Year"
                }

                if (monthOfBirth.toInt() > 12) {
                    monthEditText.error = "Please Enter Valid Month"
                }

                if (dayOfBirth.toInt() > 31) {
                    dayEditText.error = "Please Enter Valid Day"
                }
            } else{

                val  currentDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
                val  currentMonth = Calendar.getInstance().get(Calendar.MONTH)
                val currentYear = Calendar.getInstance().get(Calendar.YEAR)

                val ageByDay = currentDay - dayOfBirth.toInt()
                val ageByMonth = currentMonth - monthOfBirth.toInt()
                val ageByYear = currentYear - yearOfBirth.toInt()

                youAgeTextView.text = "Your age is $ageByYear years, $ageByMonth months, $ageByDay days"
            }
        }
    }
}
