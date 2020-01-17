package com.bychek.hidenauth

import OnSwipeTouchListener
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_with_content.*


class NewEmptyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_with_content)

        val swipeArray = mutableListOf("", "", "", "")

        emptyView.setOnTouchListener(object : OnSwipeTouchListener() {
            override fun onSwipeLeft() {
                Log.e(this@NewEmptyActivity.localClassName, "Left")
                swipeArray.add("Left")
                openNewPinViewIfCombinationFounded(lastFourSwipesEqualsToSpecialCombination(swipeArray))
            }

            override fun onSwipeRight() {
                Log.e(this@NewEmptyActivity.localClassName, "Right")
                swipeArray.add("Right")
                openNewPinViewIfCombinationFounded(lastFourSwipesEqualsToSpecialCombination(swipeArray))
            }

            override fun onSwipeTop() {
                Log.e(this@NewEmptyActivity.localClassName, "Up")
                swipeArray.add("Up")
                openNewPinViewIfCombinationFounded(lastFourSwipesEqualsToSpecialCombination(swipeArray))
            }

            override fun onSwipeBottom() {
                Log.e(this@NewEmptyActivity.localClassName, "Down")
                swipeArray.add("Down")
                openNewPinViewIfCombinationFounded(lastFourSwipesEqualsToSpecialCombination(swipeArray))
            }
        })


    }

    fun lastFourSwipesEqualsToSpecialCombination(inputArray: MutableList<String>): Boolean{
        val lastFourSwipes = mutableListOf(
            inputArray.get(inputArray.size - 1),
            inputArray.get(inputArray.size - 2),
            inputArray.get(inputArray.size - 3),
            inputArray.get(inputArray.size - 4)
        )

        val accessCombination = mutableListOf("Left", "Left", "Up", "Down")
        return lastFourSwipes.equals(accessCombination)
    }

    fun openNewPinViewIfCombinationFounded(founded: Boolean) {
        if (founded) {
            startActivity(Intent(this@NewEmptyActivity, NewPinView::class.java))
        }
    }
}
