package sag.project.theeasyfinappsplashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import sag.project.theeasyfinappsplashscreen.databinding.ActivityLogInBinding
import sag.project.theeasyfinappsplashscreen.databinding.ActivitySignUpBinding

class LogInActivity : AppCompatActivity() {
    private lateinit var binding:ActivityLogInBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Binding and fire-base connection Initialization
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()
        //======================================

        val btnBack = findViewById<Button>(R.id.btnBackLoginPage)
        val loginBtn = findViewById<Button>(R.id.btnLoginLoginPage)

        btnBack.setOnClickListener {
            intent = Intent(applicationContext, ActualMainActivity::class.java)
            startActivity(intent)
        }

        loginBtn.setOnClickListener {
            //fetching email and pass values
            val email = binding.emailET.text.toString()
            val pass = binding.passET.text.toString()


            if (email.isNotEmpty() && pass.isNotEmpty()){
                //firebase function to signin user
                firebaseAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener{
                    if(it.isSuccessful){
                        //if signin is successfull go to the dashboardActivity
                        val intent = Intent(this,dasboardActivity::class.java)
                        startActivity(intent)
                    }
                    else{
                        intent = Intent(applicationContext, ActualMainActivity::class.java)
                        startActivity(intent)
                        Toast.makeText(this,it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            }
            else{
                intent = Intent(applicationContext, ActualMainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}