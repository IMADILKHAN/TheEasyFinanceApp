package sag.project.theeasyfinappsplashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val btnBack = findViewById<Button>(R.id.btnBackSignupPage)

        btnBack.setOnClickListener {
            intent = Intent(applicationContext, ActualMainActivity::class.java)
            startActivity(intent)
        }
    }
}