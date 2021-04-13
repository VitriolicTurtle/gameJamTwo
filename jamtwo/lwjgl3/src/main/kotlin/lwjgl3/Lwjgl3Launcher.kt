package lwjgl3

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration
import jamtwo.jam

/** Launches the desktop (LWJGL3) application.  */
fun main(args: Array<String>) {
    Lwjgl3Application(jam(), Lwjgl3ApplicationConfiguration().apply{
        setTitle("jamTwo")
        setWindowedMode(9 * 48, 16 * 48)
        setWindowIcon("libgdx128.png", "libgdx64.png", "libgdx32.png", "libgdx16.png")
    })
}
