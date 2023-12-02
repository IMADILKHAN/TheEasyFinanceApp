// UserProfileActivity.kt

package sag.project.theeasyfinappsplashscreen

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import sag.project.theeasyfinappsplashscreen.database.AppDatabase
import sag.project.theeasyfinappsplashscreen.database.User
import sag.project.theeasyfinappsplashscreen.database.UserDao

class UserProfileActivity : AppCompatActivity() {
    private lateinit var userDao: UserDao

    private lateinit var userEmail: String
    private lateinit var username: String
    private lateinit var contactNumber: String
    private lateinit var joiningDate: String
    private lateinit var age: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        // Initialize Room Database and UserDao
        val db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "user-database").build()
        userDao = db.userDao()

        // Retrieve user information from Room Database
        userEmail = intent.getStringExtra("userEmail") ?: ""
        loadUserData()

        // Update UI with user information
        val imageViewProfilePhoto = findViewById<ImageView>(R.id.imageViewProfilePhoto)
        // Load and set the user's profile photo using a library like Glide or Picasso

        val textViewUsername = findViewById<TextView>(R.id.textViewUsername)
        textViewUsername.text = "Username: $username"

        val textViewEmail = findViewById<TextView>(R.id.textViewEmail)
        textViewEmail.text = "Email: $userEmail"

        val textViewContactNumber = findViewById<TextView>(R.id.textViewContactNumber)
        textViewContactNumber.text = "Contact Number: $contactNumber"

        val textViewJoiningDate = findViewById<TextView>(R.id.textViewJoiningDate)
        textViewJoiningDate.text = "Joining Date: $joiningDate"

        val textViewAge = findViewById<TextView>(R.id.textViewAge)
        textViewAge.text = "Age: $age"
    }

    private fun loadUserData() {
        // Assuming you have a 'users' table in your Room Database
        val user = userDao.getUserByEmail(userEmail)
        if (user != null) {
            // Extract user information from the User object
            username = user.username
            contactNumber = user.contactNumber
            joiningDate = user.joiningDate
            age = user.age
        }
    }
}
