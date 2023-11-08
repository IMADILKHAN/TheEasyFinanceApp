package sag.project.theeasyfinappsplashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LogInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        val btnBack = findViewById<Button>(R.id.btnBackLoginPage)

        btnBack.setOnClickListener {
            intent = Intent(applicationContext, ActualMainActivity::class.java)
            startActivity(intent)
        }
    }
}