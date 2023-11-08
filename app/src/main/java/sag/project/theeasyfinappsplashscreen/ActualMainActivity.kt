package sag.project.theeasyfinappsplashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ActualMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actual_main)

        val btnLogin = findViewById<Button>(R.id.btnLoginMainPage)
        val btnSignup = findViewById<Button>(R.id.btnSignUpMainPage)
        val btnBack = findViewById<Button>(R.id.btnBackMainPage)

        btnLogin.setOnClickListener {
            intent = Intent(applicationContext, LogInActivity::class.java)
            startActivity(intent)
        }

        btnSignup.setOnClickListener {
            intent = Intent(applicationContext, SignUpActivity::class.java)
            startActivity(intent)
        }

        btnBack.setOnClickListener {
            intent = Intent(applicationContext, SignUpActivity::class.java)
        }


    }
}