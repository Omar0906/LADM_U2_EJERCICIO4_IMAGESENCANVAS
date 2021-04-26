package mx.tecnm.tepic.ladm_u2_ejercicio4_imagesencanvas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
/*
* Poner 2 imágenes pequeñas
* 1ra IMAGEN: la vas a mover en coordenada X y va a rebotar de un lado a otro en la pantalla
* 2da IMAGEN: la vas a MOVER con el dedo
* */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val lienzo = Lienzo(this)
        setContentView(lienzo)
        var hilo = Hilo(lienzo.getLienzo())
        hilo.start()
    }
}