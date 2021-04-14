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
import jamtwo.engine.system.AnimationPlayerSystem
import jamtwo.engine.system.InputSystem
import jamtwo.engine.system.RenderSystem
import jamtwo.screen.FirstScreen
import jamtwo.screen.SecondScreen
import ktx.app.KtxGame
import ktx.app.KtxScreen
import ktx.log.debug
import ktx.log.logger

private val LOG = logger<Jam>()
const val unitScale = 1/16f

class Jam() : KtxGame<KtxScreen>() {
    val gameViewport = FitViewport(16f, 9f)
    val batch: Batch by lazy { SpriteBatch() }


    private val playerHeadTextureRight by lazy {TextureRegion(Texture(Gdx.files.internal("graphics/airhat.png")))}
    private val playerHeadTextureLeft by lazy {TextureRegion(Texture(Gdx.files.internal("graphics/left/airhatLeft.png")))}


    val engine: Engine by lazy { PooledEngine().apply{
        addSystem(InputSystem(gameViewport))
        addSystem(AnimationPlayerSystem(
            playerHeadTextureRight,
            playerHeadTextureLeft,
            playerHeadTextureRight
        ))
        addSystem(RenderSystem(batch, gameViewport))
        }
    }

    override fun create() {
        Gdx.app.logLevel = LOG_DEBUG
        LOG.debug { "x" }
        addScreen(FirstScreen(this))
        addScreen(SecondScreen(this))
        setScreen<FirstScreen>()
    }

    override fun dispose() {
        super.dispose()
        playerHeadTextureRight.texture.dispose()
        //playerHeadTextureLeft.texture.dispose()
    }
}