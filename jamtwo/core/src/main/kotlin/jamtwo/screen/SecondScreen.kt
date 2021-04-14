package jamtwo.screen

import com.badlogic.gdx.Application.LOG_DEBUG
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.Screen
import jamtwo.Jam
import ktx.app.KtxGame
import ktx.app.KtxScreen
import ktx.log.debug
import ktx.log.logger


private val LOG = logger<SecondScreen>()

/** First screen of the application. Displayed after the application is created.  */
class SecondScreen(game: Jam) : JamScreen(game) {
    override fun show(){
        LOG.debug{ "Second screen "}
    }

    override fun render(delta: Float){
        if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_1)){
            game.setScreen<FirstScreen>()
        }
    }
}