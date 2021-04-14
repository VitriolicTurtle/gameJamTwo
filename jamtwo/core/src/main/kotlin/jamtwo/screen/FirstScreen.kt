package jamtwo.screen

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Gdx.graphics
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.utils.viewport.FitViewport
import jamtwo.Jam
import jamtwo.engine.component.DirectionComponent
import jamtwo.engine.component.GraphicComponent
import jamtwo.engine.component.PlayerComponent
import jamtwo.engine.component.TransformComponent
import jamtwo.unitScale
import ktx.app.KtxScreen
import ktx.ashley.entity
import ktx.ashley.get
import ktx.ashley.with
import ktx.graphics.use
import ktx.log.debug
import ktx.log.logger
import javax.xml.crypto.dsig.Transform


private val LOG = logger<FirstScreen>()

/** First screen of the application. Displayed after the application is created.  */
class FirstScreen(game: Jam) : JamScreen(game) {
    private val viewport = FitViewport(16f, 9f)


    private val player = game.engine.entity{
        with<TransformComponent>{pos.set(3f, 2f, 0f)}
        with<GraphicComponent>()
        with<PlayerComponent>()
        with<DirectionComponent>()

    }


    override fun show(){
        LOG.debug{ "First screen "}
    }



    override fun render(delta: Float){
        engine.update(delta)

        if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_2)){
            game.setScreen<SecondScreen>()
        }
    }

    override fun dispose() {
       // super.dispose()
    }
}