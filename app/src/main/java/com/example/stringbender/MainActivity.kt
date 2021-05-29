

/////////////////////////////////////////////////////////////////////////////

/// ICA #03 - String Bender

///

/// Using NAIT ICAs to practice with Android Studio

/// String Bender App to practice the equivalent of delegates on here. Working

/// Towards Concurrency

///  Author: Maxwell McEvoy

///

///  Modification History:

///  MAY 28, 2021 - Created. Functional. Need to now test out delegates

///  MAY 28, 2021 - found a KTX extension that does the add text change listener easier

///  May 28, 2021 - Added when statement, removed redundancies, more listeners. XML vs Listeners?
/////////////////////////////////////////////////////////////////////////////
package com.example.stringbender

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.core.widget.doAfterTextChanged


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        //initializes the app
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // listener for text changes. Found an easier way to add it
        val etValue: EditText = findViewById(R.id.UI_PT_input)
        // https://developer.android.com/kotlin/ktx/extensions-list#androidxcorewidget
        etValue.doAfterTextChanged { convertString() }
        findViewById<RadioButton>(R.id.UI_RB_Upper).setOnClickListener { convertString() }
        findViewById<RadioButton>(R.id.UI_RB_Lower).setOnClickListener { convertString() }
        findViewById<RadioButton>(R.id.UI_RB_Flip).setOnClickListener { convertString() }
    }

   private fun convertString() {
        val input: String = findViewById<EditText>(R.id.UI_PT_input).text.toString()
        var output = ""
        if (findViewById<RadioButton>(R.id.UI_RB_Upper).isChecked){
            output = input.uppercase()
        }
        if(findViewById<RadioButton>(R.id.UI_RB_Lower).isChecked){
            output = input.lowercase()
        }
        if(findViewById<RadioButton>(R.id.UI_RB_Flip).isChecked) {
            for (c in input) {
                when {
                    c.isLowerCase() -> output += c.uppercase()
                    c.isUpperCase() -> output += c.lowercase()
                    else -> output += c
                }
            }
        }

       findViewById<TextView>(R.id.UI_PT_Output).text = output
    }


}