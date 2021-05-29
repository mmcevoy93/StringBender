

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

/////////////////////////////////////////////////////////////////////////////
package com.example.stringbender

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        //initializes the app
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //on text change. Need to find a simpler listener or something
        val etValue: EditText = findViewById(R.id.UI_PT_input)
        etValue.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, start: Int, count: Int, after: Int) {
                //
            }

            override fun onTextChanged(p0: CharSequence?, start: Int, before: Int, count: Int) {
                convertString()
            }
            override fun afterTextChanged(s: Editable) {
                //
            }
        })
    }

   fun convertString(view: View? = null) {
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
                if (c.isLowerCase())
                    output += c.uppercase()
                else if (c.isUpperCase())
                    output += c.lowercase()
                else
                    output += c
            }
        }

       findViewById<TextView>(R.id.UI_PT_Output).text = output
    }


}