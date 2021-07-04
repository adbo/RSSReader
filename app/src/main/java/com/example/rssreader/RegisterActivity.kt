package com.example.rssreader

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegisterActivity : AppCompatActivity() {

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

    private fun registerUser(email: String, password: String) {
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
        }
        else {
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val user = auth.currentUser
                        updateUI(user)
                    } else {
                        Toast.makeText(baseContext, "Authentication failed.",
                            Toast.LENGTH_SHORT).show()
                        updateUI(null)
                    }
                }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = Firebase.auth

        val bSignUp: Button = findViewById(R.id.bSignUp)

        bSignUp.setOnClickListener {
            val etEmail: EditText = findViewById(R.id.etEmail)
            val etPassword: EditText = findViewById(R.id.etPassword)
            val etConfirmPassword: EditText = findViewById(R.id.etConfirmPassword)

            if(etPassword.text.toString() == etConfirmPassword.text.toString()) {
                registerUser(etEmail.text.toString(), etPassword.text.toString())
            } else {
                Toast.makeText(
                    this, "Please make sure your passwords match.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}