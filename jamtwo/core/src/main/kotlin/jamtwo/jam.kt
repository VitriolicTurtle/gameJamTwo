package jamtwo

import com.badlogic.ashley.core.Engine
import com.badlogic.ashley.core.PooledEngine
import com.badlogic.gdx.Application.LOG_DEBUG
import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.viewport.FitViewport
import jamtwo.engine.system.RenderSystem
import jamtwo.screen.FirstScreen
import jamtwo.screen.SecondScreen
import ktx.app.KtxGame
import ktx.app.KtxScreen
import ktx.log.debug
import ktx.log.logger
import javax.print.DocFlavor

private val LOG = logger<Jam>()
const val unitScale = 1 / 16f

class Jam(var type1: String, var type2: String) : KtxGame<KtxScreen>() {
    val gameViewport = FitViewport(16f, 9f)
    val batch: Batch by lazy { SpriteBatch() }
    val engine: Engine by lazy { PooledEngine().apply{
        addSystem(RenderSystem(batch, gameViewport))
        }
    }



    override fun create() {
        Gdx.app.logLevel = LOG_DEBUG
        LOG.debug { "Create game instance" }
        addScreen(FirstScreen(this, type1, type2))
        addScreen(SecondScreen(this))
        setScreen<FirstScreen>()
    }

}