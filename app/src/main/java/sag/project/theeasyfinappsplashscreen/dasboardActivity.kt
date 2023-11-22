package sag.project.theeasyfinappsplashscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class dasboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dasboard)

        val bottomView = findViewById<BottomNavigationView>(R.id.bottomNavViewDashboard)

        replaceWithFragment(HomeFragment())
        //Setting Home Fragment visible by default

        bottomView.setOnItemSelectedListener {

            when(it.itemId){
                R.id.HomeItem -> replaceWithFragment(HomeFragment())
                R.id.CardsItem -> replaceWithFragment(CardFragment())
                R.id.InvestItem -> replaceWithFragment(InvestFragment())
                R.id.UsersItem -> replaceWithFragment(ProfileFragment())
                else -> {

                }
            }
            true
        }

    }

    private fun replaceWithFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.flDashboard,fragment)
        fragmentTransaction.commit()
    }
}