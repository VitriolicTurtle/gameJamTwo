package jamtwo.engine.component

import com.badlogic.ashley.core.Component
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.utils.Pool
import ktx.ashley.mapperFor

class PlayerComponent : Component, Pool.Poolable{
    var maxLife = 100f
    var currentLife = 100f
    var mana = 0f

    override fun reset(){
        currentLife = 100f
        maxLife = 100f
        mana = 0f
    }

    companion object{
        val mapper = mapperFor<PlayerComponent>()
    }
}