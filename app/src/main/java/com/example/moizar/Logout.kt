package com.example.moizar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.facebook.login.LoginManager
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth

class Logout : AppCompatActivity() {
    var auth : FirebaseAuth ?= null
    private lateinit var googleSignInClient: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logout)
        val LogoutBtn: Button = findViewById(R.id.Logout)
        val Mainbtn: Button = findViewById(R.id.Main)
        val profileName: Button = findViewById(R.id.profileName)
        var Loginway = intent.getStringExtra("Login way")
        // 구글 로그아웃을 위해 로그인 세션 가져오기
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.firebase_web_client_id))
            .requestEmail()
            .build()
        googleSignInClient = GoogleSignIn.getClient(this, gso)
        auth = FirebaseAuth.getInstance()
        LogoutBtn.setOnClickListener {
            if (Loginway == "Google"){
                GoogleLogout()
            }
            else if(Loginway.equals("Facebook")){
                FacebookLogout()
            }
            else{
                FirebaseAuth.getInstance().signOut()
                googleSignInClient.signOut().addOnCompleteListener(this) {
                    //updateUI(null)
                }
                LoginManager.getInstance().logOut()
                val intent = Intent(this, Login::class.java)
                startActivity(intent)
                finish()
            }
        }
        Mainbtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        profileName.setOnClickListener {
            val intent = Intent(this, Profile_Name::class.java)
            startActivity(intent)
            finish()
        }
    }
    private fun GoogleLogout() {
        FirebaseAuth.getInstance().signOut()
        googleSignInClient.signOut().addOnCompleteListener(this) {
            //updateUI(null)
        }
        val intent = Intent(this, Login::class.java)
        startActivity(intent)
        finish()
    }
    private fun FacebookLogout() {
        FirebaseAuth.getInstance().signOut()
        LoginManager.getInstance().logOut()
        val intent = Intent(this, Login::class.java)
        startActivity(intent)
        finish()
    }
}

