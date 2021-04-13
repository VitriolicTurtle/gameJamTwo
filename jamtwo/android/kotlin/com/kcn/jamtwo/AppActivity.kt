package com.kcn.jamtwo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class AppActivity : AppCompatActivity() {
    private val FIRST_GAME_REQUEST_CODE = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)

        val gameButton = findViewById<Button>(R.id.gameButton)
        gameButton.setOnClickListener {
            launchGame()
        }
    }


    //  Starts game
    fun launchGame(){
        val intent = Intent(this, GameActivity::class.java)
        intent.putExtra("Game", 1)
        startActivityForResult(intent, FIRST_GAME_REQUEST_CODE)
    }
}