package jamtwo

import com.badlogic.gdx.Game

class jam : Game() {
    override fun create() {
        setScreen(FirstScreen())
    }
}