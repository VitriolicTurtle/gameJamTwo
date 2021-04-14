package com.kcn.jamtwo

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class AppActivity : AppCompatActivity() {
    private val FIRST_GAME_REQUEST_CODE = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)


        var type1: String = ""
        var type2: String = ""
        val headImage = findViewById<ImageView>(R.id.imageHead)
        val bodyImage = findViewById<ImageView>(R.id.imageBody)
        //get the spinner from the xml.
        val spinner1 = findViewById<Spinner>(R.id.spinner1)
        val spinner2 = findViewById<Spinner>(R.id.spinner2)
        //create a list of items for the spinner.
        val items = arrayOf("Earth", "Wind", "Fire", "Water")
        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
        //There are multiple variations of this, but this is the basic variant.
        // initialize an array adapter for spinner
        val adapter:ArrayAdapter<String> = object: ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                items
        ){
            override fun getDropDownView(
                    position: Int,
                    convertView: View?,
                    parent: ViewGroup
            ): View {
                val view:TextView = super.getDropDownView(
                        position,
                        convertView,
                        parent
                ) as TextView
                // set item text bold
                view.setTypeface(view.typeface, Typeface.BOLD)

                // set selected item style
                if (position == spinner1.selectedItemPosition){
                    view.background = ColorDrawable(Color.parseColor("#FAEBD7"))
                    view.setTextColor(Color.parseColor("#008000"))
                }

                return view
            }
        }
        //set the spinners adapter to the previously created one.
        spinner1.adapter = adapter
        spinner2.adapter = adapter

        spinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View,
                    position: Int,
                    id: Long
            ) {
                type1 = parent.getItemAtPosition(position).toString()
                when (type1){
                    "Earth" ->  headImage.setImageResource(R.drawable.earthhat);
                    "Wind" ->  headImage.setImageResource(R.drawable.airhat);
                    "Fire" ->  headImage.setImageResource(R.drawable.firehat);
                    "Water" ->  headImage.setImageResource(R.drawable.waterhat);
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View,
                    position: Int,
                    id: Long
            ) {
                type2 = parent.getItemAtPosition(position).toString()
                when (type2){
                    "Earth" ->  bodyImage.setImageResource(R.drawable.earthbody);
                    "Wind" ->  bodyImage.setImageResource(R.drawable.airbody);
                    "Fire" ->  bodyImage.setImageResource(R.drawable.firebody);
                    "Water" ->  bodyImage.setImageResource(R.drawable.waterbody);
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }





        val gameButton = findViewById<Button>(R.id.gameButton)
        gameButton.setOnClickListener {
            // getting user's input
            val username = findViewById<EditText>(R.id.edit_text_username).text.toString()



            // start the game
            //launchGame()
        }
    }


    //  Starts game
    private fun launchGame(){
        val intent = Intent(this, GameActivity::class.java)
        intent.putExtra("Game", 1)
        startActivityForResult(intent, FIRST_GAME_REQUEST_CODE)
    }
}