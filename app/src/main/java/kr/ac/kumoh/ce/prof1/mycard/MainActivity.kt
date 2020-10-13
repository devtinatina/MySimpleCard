package kr.ac.kumoh.ce.prof1.mycard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_deal.setOnClickListener {
            val c = IntArray(5)
            val res = IntArray(5)

            //for (i in 0..4)
            //for (i in 0 until 5)
            //for (i in 0 until c.size)
            for (i in c.indices) {
                c[i] = Random.nextInt(52)

                Log.i("Test", "${c[i]} : " +
                        "${getCardName(c[i])}")

                res[i] = resources.getIdentifier(
                    getCardName(c[i]),
                    "drawable",
                    packageName
                )
            }
            
            //card1.setImageResource(R.drawable.c_2_of_hearts)
            card1.setImageResource(res[0])
            card2.setImageResource(res[1])
            card3.setImageResource(res[2])
            card4.setImageResource(res[3])
            card5.setImageResource(res[4])
        }
    }

    private fun getCardName(c: Int) : String {
        val shape = when (c / 13) {
            0 -> "spades"
            1 -> "diamonds"
            2 -> "hearts"
            3 -> "clubs"
            else -> "error"
        }

        val number = when (c % 13) {
            0 -> "ace"
            in 1..9 -> (c % 13 + 1).toString()
            10 -> "jack"
            11 -> "queen"
            12 -> "king"
            else -> "error"
        }
        return "c_${number}_of_${shape}"
    }
}