package sag.project.theeasyfinappsplashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity : AppCompatActivity() {

    //This is for animation
    companion object{
        const val ANIMATION_TIME: Long = 6000
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()  //If the supportActionBar is null then it will not run if we put question mark.

        Handler(this.mainLooper).postDelayed({   //has two parameters one is package context and second is time for which it should be displayed
            val intent = Intent(this,ActualMainActivity::class.java)
            startActivity(intent)
            //To remove activity from backstack so that this activity will not show when user closes MainAcctivity
        }, ANIMATION_TIME)

    }
}

