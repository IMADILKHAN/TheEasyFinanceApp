package sag.project.theeasyfinappsplashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import sag.project.theeasyfinappsplashscreen.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySignUpBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Binding and fire-base connection Initialization
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()
        //==================================

        val btnBack = findViewById<Button>(R.id.btnBackSignupPage)
        val signUpBtn = findViewById<Button>(R.id.btnSignupSignupPage)

        btnBack.setOnClickListener {
            intent = Intent(applicationContext, ActualMainActivity::class.java)
            startActivity(intent)
        }

        signUpBtn.setOnClickListener {
            //fetch values of email and pass
            val email = binding.emailET.text.toString()
            val pass = binding.passET.text.toString()


            if (email.isNotEmpty() && pass.isNotEmpty()){
                    //firebase function to create a user with email and pass
                    firebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener{
                        //if succesfull send to loginActivity
                        if(it.isSuccessful){
                            val intent = Intent(this,LogInActivity::class.java)
                            startActivity(intent)
                        }
                        else{
                            intent = Intent(applicationContext, ActualMainActivity::class.java)
                            startActivity(intent)
                            Toast.makeText(this,it.exception.toString(),Toast.LENGTH_SHORT).show()
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