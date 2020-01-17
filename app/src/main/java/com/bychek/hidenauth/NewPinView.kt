package com.bychek.hidenauth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class NewPinView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_pin_view)
        Log.e(this@NewPinView.localClassName, "im hidden auth")
    }
}
