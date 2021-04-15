package jamtwo.engine.component

import com.badlogic.ashley.core.Component
import com.badlogic.gdx.utils.Pool
import ktx.ashley.mapperFor

class Movement : Component, Pool.Poolable {

    override fun reset(){

    }

    companion object{
        val mapper = mapperFor<Movement>()
    }


}