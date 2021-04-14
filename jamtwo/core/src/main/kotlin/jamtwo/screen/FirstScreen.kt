package jamtwo.screen

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Gdx.graphics
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.utils.viewport.FitViewport
import jamtwo.Jam
import jamtwo.engine.component.GraphicComponent
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
class FirstScreen(game: Jam, type1: String, type2: String) : JamScreen(game) {
    private val viewport = FitViewport(16f, 9f)

    private var playerTexture1 = Texture(Gdx.files.internal("graphics/Grass.png"))
    private var playerTexture2 = Texture(Gdx.files.internal("graphics/Grass.png"))


    private val player = game.engine.entity{

        when (type1){
            "Earth" ->  playerTexture1 = Texture(Gdx.files.internal("character/earthhat.png"))
            "Wind" ->  playerTexture1 = Texture(Gdx.files.internal("character/airhat.png"))
            "Fire" ->  playerTexture1 = Texture(Gdx.files.internal("character/firehat.png"))
            "Water" ->  playerTexture1 = Texture(Gdx.files.internal("character/waterhat.png"))
        }

        when (type2){
            "Earth" ->  playerTexture2 = Texture(Gdx.files.internal("character/earthbody.png"))
            "Wind" ->  playerTexture2 = Texture(Gdx.files.internal("character/airbody.png"))
            "Fire" ->  playerTexture2 = Texture(Gdx.files.internal("character/firebody.png"))
            "Water" ->  playerTexture2 = Texture(Gdx.files.internal("character/waterbody.png"))
        }

        with<TransformComponent>{pos.set(1f, 1f, 0f)}
        with<GraphicComponent>{sprite.run{
            setRegion(playerTexture1)
            setSize(texture.width* unitScale, texture.height * unitScale)
            setOriginCenter()
        }
        }


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
        playerTexture1.dispose()
    }
}