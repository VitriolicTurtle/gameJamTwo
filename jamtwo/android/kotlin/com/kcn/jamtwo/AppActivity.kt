package com.kcn.jamtwo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class AppActivity : AppCompatActivity() {
    private val FIRST_GAME_REQUEST_CODE = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)


        //get the spinner from the xml.
        val spinner1 = findViewById<Spinner>(R.id.spinner1)
        val spinner2 = findViewById<Spinner>(R.id.spinner2)
        //create a list of items for the spinner.
        val items1 = arrayOf("Earth", "Wind", "Fire", "Water")
        val items2 = arrayOf("Earth", "Wind", "Fire", "Water")
        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
        //There are multiple variations of this, but this is the basic variant.
        val adapter1 = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items1)
        val adapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items2)
        //set the spinners adapter to the previously created one.
        spinner1.adapter = adapter1
        spinner2.adapter = adapter2

        val headImage = findViewById<ImageView>(R.id.imageHead)
        val bodyImage = findViewById<ImageView>(R.id.imageBody)
        val text: String = spinner1.selectedItem.toString()
        val text1: String = spinner2.selectedItem.toString()

        when (text){
            "Earth" ->  headImage.setImageResource(R.drawable.earthhat);
            "Wind" ->  headImage.setImageResource(R.drawable.airhat);
            "Fire" ->  headImage.setImageResource(R.drawable.firehat);
            "Water" ->  headImage.setImageResource(R.drawable.waterhat);
        }

        when (text1){
            "Earth" ->  bodyImage.setImageResource(R.drawable.earthbody);
            "Wind" ->  bodyImage.setImageResource(R.drawable.airbody);
            "Fire" ->  bodyImage.setImageResource(R.drawable.firebody);
            "Water" ->  bodyImage.setImageResource(R.drawable.waterbody);
        }





        val gameButton = findViewById<Button>(R.id.gameButton)
        gameButton.setOnClickListener {
            // getting user's input
            val username = findViewById<EditText>(R.id.edit_text_username).text.toString()
            val type1: String = spinner1.selectedItem.toString()
            val type2: String = spinner2.selectedItem.toString()

            Log.i("USER INPUT TEST", username)
            Log.i("USER INPUT TEST", type1)
            Log.i("USER INPUT TEST", type2)
            


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