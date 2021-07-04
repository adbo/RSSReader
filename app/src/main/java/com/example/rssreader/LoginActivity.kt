package com.example.rssreader

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlin.math.log


class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        updateUI(currentUser)
    }

    private fun updateUI(account: FirebaseUser?) {
        if (account != null) {
            Toast.makeText(this, "You Signed In successfully", Toast.LENGTH_LONG).show()
            startActivity(Intent(this, MainActivity::class.java))
        } else {
            Toast.makeText(this, "You Didn't signed in", Toast.LENGTH_LONG).show()
        }
    }

    private fun loginUser(email: String, password: String) {
        if (email == "") {
            Toast.makeText(
                this, "Enter Email!!",
                Toast.LENGTH_SHORT
            ).show()
        } else if (password == "") {
            Toast.makeText(
                this, "Enter Password!!",
                Toast.LENGTH_SHORT
            ).show()
        } else {
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this,
                    OnCompleteListener<AuthResult?> { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            val user = auth.currentUser
                            updateUI(user)
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(
                                this, "Authentication failed: " + task.exception,
                                Toast.LENGTH_SHORT
                            ).show()
                            updateUI(null)
                        }
                    })
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = Firebase.auth

        val tvRegister: TextView = findViewById(R.id.tvRegister)
        val bSignIn: Button = findViewById(R.id.bSignIn)

        tvRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        bSignIn.setOnClickListener {
            val etEmail: EditText = findViewById(R.id.etEmail)
            val etPassword: EditText = findViewById(R.id.etPassword)

            loginUser(etEmail.text.toString(), etPassword.text.toString())
        }
    }
}