package jamtwo.screen

import com.badlogic.gdx.Application.LOG_DEBUG
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.Texture
import jamtwo.Jam
import ktx.app.KtxGame
import ktx.app.KtxScreen
import ktx.log.debug
import ktx.log.logger


private val LOG = logger<SecondScreen>()

/** First screen of the application. Displayed after the application is created.  */
class SecondScreen(game: Jam) : JamScreen(game) {
    private val gameOver = Texture(Gdx.files.internal("graphics/gameOver.png"))
    override fun show(){
        LOG.debug{ "Second screen "}
    }

    override fun render(delta: Float){
        batch.begin()
        //  Wild magic bar updated every time magic is used
        batch.draw(gameOver, 0f, 0f, 16f*54, 9f*54)
        batch.end()

        if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_1)){
            game.setScreen<FirstScreen>()
        }
    }
}