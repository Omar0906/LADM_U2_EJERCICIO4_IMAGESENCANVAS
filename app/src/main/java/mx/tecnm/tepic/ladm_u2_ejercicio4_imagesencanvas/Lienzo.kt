package mx.tecnm.tepic.ladm_u2_ejercicio4_imagesencanvas

import android.graphics.*
import android.view.MotionEvent
import android.view.View

var posY: Float = 0f
var posX: Float = 0f
var imgX: Float = 0f
var imgY: Float = 0f

class Lienzo(act: MainActivity) : View(act) {
    var imagen1 = BitmapFactory.decodeResource(this.resources, R.drawable.iconoa5)
    var imagen2 = BitmapFactory.decodeResource(this.resources, R.drawable.iconoa6)
    var img1 : Rect = Rect(0,0,imagen1.width,imagen1.height)
    var img2 : Rect = Rect(0,0,imagen2.width,imagen2.height)
    fun getLienzo(): Lienzo {
        return this
    }

    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        val pincel = Paint()
        pincel.color = Color.TRANSPARENT
        c.drawColor(Color.parseColor("#E57722"))
        c.drawBitmap(imagen1, posX, 655f, pincel)
        c.drawBitmap(imagen2, imgX, imgY, pincel)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                imgX = event.x - 128f
                imgY = event.y - 128f
            }
            MotionEvent.ACTION_UP -> {
                imgX = event.x - 128f
                imgY = event.y - 128f
            }
            MotionEvent.ACTION_MOVE -> {
                imgX = event.x - 128f
                imgY = event.y - 128f
            }
        }
        invalidate()
        return true
    }
}

class Hilo(canvas: Lienzo) : Thread() {
    var incremento: Float = 16f
    val can: Lienzo = canvas
    override fun run() {
        super.run()
        while (true) {
            if (posX > 510f) {
                incremento = -16f
            }
            if (posX < 2f) {
                incremento = 16f
            }
            posX += incremento
            can.invalidate()
            sleep(200)
        }
    }
}