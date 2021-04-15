package jamtwo.screen

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.InputListener
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Image
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.utils.viewport.FitViewport
import com.badlogic.gdx.utils.viewport.Viewport



class Controller {
    var viewport: Viewport
    var stage: Stage
    var isUpPressed = false
    var isDownPressed = false
    var isLeftPressed = false
    var isRightPressed = false
    var cam: OrthographicCamera
    fun draw() {
        stage.draw()
    }

    fun resize(width: Int, height: Int) {
        viewport.update(width, height)
    }

    constructor(batch: SpriteBatch) {
        cam = OrthographicCamera()
        viewport = FitViewport(800f, 480f, cam)
        stage = Stage(viewport, batch)
        stage.addListener(object : InputListener() {
            override fun keyDown(event: InputEvent, keycode: Int): Boolean {
                when (keycode) {
                    Input.Keys.UP -> isUpPressed = true
                    Input.Keys.DOWN -> isDownPressed = true
                    Input.Keys.LEFT -> isLeftPressed = true
                    Input.Keys.RIGHT -> isRightPressed = true
                }
                return true
            }

            override fun keyUp(event: InputEvent, keycode: Int): Boolean {
                when (keycode) {
                    Input.Keys.UP -> isUpPressed = false
                    Input.Keys.DOWN -> isDownPressed = false
                    Input.Keys.LEFT -> isLeftPressed = false
                    Input.Keys.RIGHT -> isRightPressed = false
                }
                return true
            }
        })
        Gdx.input.inputProcessor = stage
        val table = Table()
        table.left().bottom()
        val upImg = Image(Texture(Gdx.files.internal("graphics/uparrow.png")))
        upImg.setSize(50f, 50f)
        upImg.addListener(object : InputListener() {
            override fun touchDown(event: InputEvent, x: Float, y: Float, pointer: Int, button: Int): Boolean {
                isUpPressed = true
                return true
            }

            override fun touchUp(event: InputEvent, x: Float, y: Float, pointer: Int, button: Int) {
                isUpPressed = false
            }
        })
        val downImg = Image(Texture(Gdx.files.internal("graphics/downarrow.png")))
        downImg.setSize(50f, 50f)
        downImg.addListener(object : InputListener() {
            override fun touchDown(event: InputEvent, x: Float, y: Float, pointer: Int, button: Int): Boolean {
                isDownPressed = true
                return true
            }

            override fun touchUp(event: InputEvent, x: Float, y: Float, pointer: Int, button: Int) {
                isDownPressed = false
            }
        })
        val rightImg = Image(Texture(Gdx.files.internal("graphics/rightarrow.png")))
        rightImg.setSize(50f, 50f)
        rightImg.addListener(object : InputListener() {
            override fun touchDown(event: InputEvent, x: Float, y: Float, pointer: Int, button: Int): Boolean {
                isRightPressed = true
                return true
            }

            override fun touchUp(event: InputEvent, x: Float, y: Float, pointer: Int, button: Int) {
                isRightPressed = false
            }
        })
        val leftImg = Image(Texture(Gdx.files.internal("graphics/leftarrow.png")))
        leftImg.setSize(50f, 50f)
        leftImg.addListener(object : InputListener() {
            override fun touchDown(event: InputEvent, x: Float, y: Float, pointer: Int, button: Int): Boolean {
                isLeftPressed = true
                return true
            }

            override fun touchUp(event: InputEvent, x: Float, y: Float, pointer: Int, button: Int) {
                isLeftPressed = false
            }
        })
        table.add()
        table.add(upImg).size(upImg.width, upImg.height)
        table.add()
        table.row().pad(5f, 5f, 5f, 5f)
        table.add(leftImg).size(leftImg.width, leftImg.height)
        table.add()
        table.add(rightImg).size(rightImg.width, rightImg.height)
        table.row().padBottom(5f)
        table.add()
        table.add(downImg).size(downImg.width, downImg.height)
        table.add()
        stage.addActor(table)
    }
}