package jamtwo.engine.component

import com.badlogic.ashley.core.Component
import com.badlogic.gdx.utils.Pool
import ktx.ashley.mapperFor

enum class Direction{
    LEFT,
    DEFAULT,
    RIGHT
}

class DirectionComponent : Component, Pool.Poolable {
    var currentDirection = Direction.DEFAULT

    override fun reset() {
        currentDirection = Direction.DEFAULT
    }


    companion object{
        val mapper = mapperFor<DirectionComponent>()
    }
}