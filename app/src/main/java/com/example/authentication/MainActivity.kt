package com.example.authentication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var inputEmail : EditText
    private lateinit var inputPassword : EditText
    private lateinit var buttonSubmit : Button
    private lateinit var mAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inputEmail = findViewById(R.id.editTextTextEmailAddress)
        inputPassword = findViewById(R.id.editTextTextPassword)
        buttonSubmit = findViewById(R.id.buttonSubmit)
        mAuth = FirebaseAuth.getInstance()

        buttonSubmit.setOnClickListener{
            val email = inputEmail.text.toString()
            val password = inputPassword.text.toString()

            if(email.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "Empty", Toast.LENGTH_SHORT).show()
            }else{
                mAuth.createUserWithEmailAndPassword(email, password)
                Toast.makeText(this, "User created with email: $email", Toast.LENGTH_LONG).show()
                inputEmail.setText("")
                inputPassword.setText("")
            }
        }
    }
}