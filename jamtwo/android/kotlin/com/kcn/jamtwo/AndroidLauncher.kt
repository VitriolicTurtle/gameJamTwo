package com.kcn.jamtwo

import android.os.Bundle
import com.badlogic.gdx.backends.android.AndroidApplication
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration
import jamtwo.jam

/** Launches the Android application.  */
// TOPIC:    Magic Gone Wrong

class AndroidLauncher : AndroidApplication() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialize(jam(), AndroidApplicationConfiguration())
    }
}