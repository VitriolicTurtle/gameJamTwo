package jamtwo

import com.badlogic.ashley.core.Engine
import com.badlogic.ashley.core.PooledEngine
import com.badlogic.gdx.Application.LOG_DEBUG
import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Animation
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.utils.viewport.FitViewport
import jamtwo.engine.component.Direction
import jamtwo.engine.component.EntityLinkComponent
import jamtwo.engine.system.AnimationPlayerSystem
import jamtwo.engine.system.EntityLinkSystem
import jamtwo.engine.system.InputSystem
import jamtwo.engine.system.RenderSystem
import jamtwo.screen.Controller
import jamtwo.screen.FirstScreen
import jamtwo.screen.SecondScreen
import ktx.app.KtxGame
import ktx.app.KtxScreen
import ktx.log.debug
import ktx.log.logger
import javax.print.DocFlavor

private val LOG = logger<Jam>()
const val unitScale = 1/16f

class Jam(var type1: String, var type2: String) : KtxGame<KtxScreen>() {
    val gameViewport = FitViewport(16f, 9f)
    val batch: Batch by lazy { SpriteBatch() }
    val controller: Controller by lazy {Controller(batch as SpriteBatch)}


    //      Get bodyparts
    private val playerTexture1 = when(type1){
        "Earth" ->  "character/earthhat.png"
        "Wind" ->  "character/airhat.png"
        "Fire" ->  "character/firehat.png"
        "Water" ->  "character/waterhat.png"
        else -> "character/airhat.png"
    }
    private val playerTexture1L = when(type1){
        "Earth" ->  "character/left/earthhatLeft.png"
        "Wind" ->  "character/left/airhatLeft.png"
        "Fire" ->  "character/left/firehatLeft.png"
        "Water" ->  "character/left/waterhatLeft.png"
        else -> "character/left/airhatL.png"
    }
    private val playerTexture2 = when(type1){
        "Earth" ->  "character/earthbody.png"
        "Wind" ->  "character/airbody.png"
        "Fire" ->  "character/firebody.png"
        "Water" ->  "character/waterbody.png"
        else -> "character/airbody.png"
    }
    private val playerTexture2L = when(type1){
        "Earth" ->  "character/left/earthbodyLeft.png"
        "Wind" ->  "character/left/airbodyLeft.png"
        "Fire" ->  "character/left/firebodyLeft.png"
        "Water" ->  "character/left/waterbodyLeft.png"
        else -> "character/left/airbodyLeft.png"
    }


    private val playerBodyTextureRight by lazy { TextureRegion(Texture(Gdx.files.internal(playerTexture2))) }
    private val playerBodyTextureLeft by lazy { TextureRegion(Texture(Gdx.files.internal(playerTexture2L))) }
    private val playerHeadTextureRight by lazy { TextureRegion(Texture(Gdx.files.internal(playerTexture1))) }
    private val playerHeadTextureLeft by lazy { TextureRegion(Texture(Gdx.files.internal(playerTexture1L))) }


    val engine: Engine by lazy { PooledEngine().apply{

        addSystem(InputSystem(gameViewport))
        addSystem(AnimationPlayerSystem(
            playerBodyTextureRight,
            playerBodyTextureLeft,
            playerBodyTextureRight
        ))
        addSystem(EntityLinkSystem(
            playerHeadTextureRight,
            playerHeadTextureLeft
        ))
        addSystem(RenderSystem(batch, gameViewport))
        }
    }


    override fun create() {
        Gdx.app.logLevel = LOG_DEBUG
        LOG.debug { "Create game instance" }
        addScreen(FirstScreen(this))
        addScreen(SecondScreen(this))
        setScreen<FirstScreen>()
    }


    /*
    override fun resize(width: Int, height: Int) {
        super.resize(width, height)
        controller.resize(width, height)
    }
     */

    override fun render() {
        super.render()
        controller.draw()
    }


    override fun dispose() {
        super.dispose()
        playerHeadTextureLeft.texture.dispose()
        playerHeadTextureRight.texture.dispose()
        playerBodyTextureLeft.texture.dispose()
        playerBodyTextureRight.texture.dispose()
    }

}