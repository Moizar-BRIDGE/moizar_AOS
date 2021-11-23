package com.example.moizar

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import coil.api.load
import com.facebook.Profile
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException
import java.net.MalformedURLException
import java.net.URI
import java.net.URL

class Profile_Name : AppCompatActivity() {
    private val GALLERY = 1
    private var textnum : Int = 0
    private var user_name : String? = null
    private var link : String? = null
    private var photoUrl : Uri? = null
    private var user : FirebaseUser? = null
    private lateinit var nextButton: Button
    private lateinit var user_name_edit: EditText
    private lateinit var user_name_num: TextView
    private lateinit var profileimage: CircleImageView
    private lateinit var imageButton: ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_name)
        user = Firebase.auth.currentUser
        nextButton = findViewById(R.id.step_1_next)
        user_name_edit = findViewById(R.id.user_name_edit)
        user_name_num = findViewById(R.id.user_name_num)
        profileimage = findViewById(R.id.profileimage)
        imageButton = findViewById(R.id.imagebutton)
        user_set()
        edit_set()
        imageview_set()

        imageButton.setOnClickListener {
            imagebutton_set()
        }

        nextButton.setOnClickListener {
            val intent = Intent(this, Profile_Major::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun user_set() {
        user?.let {
            for (profile in it.providerData) {
                user_name = profile.displayName
                photoUrl = profile.photoUrl
            }
        }
    }

    private fun edit_set() {
        user_name_edit.setText("$user_name")
        textnum = user_name_edit.length()
        user_name_num.setText("$textnum/5")

        user_name_edit.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                textnum = p0!!.length
                user_name_num.setText("$textnum/5")
            }
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
        })
    }

    private fun imageview_set() {
        link = photoUrl.toString()
        profileimage.load(link)
    }

    private fun imagebutton_set() {
        var writePermission = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        var readPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
        if (writePermission == PackageManager.PERMISSION_DENIED || readPermission == PackageManager.PERMISSION_DENIED) {
        // 권한 없어서 요청
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE), 2)
        } else { // 권한 있음
          var intent = Intent(Intent.ACTION_PICK)
            intent.data = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            intent.type = "image/*"
            startActivityForResult(intent, GALLERY) }
        }

    @Override override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if( resultCode == Activity.RESULT_OK) {
            if( requestCode == GALLERY) {
                var ImnageData: Uri? = data?.data
                try {
                    link = ImnageData.toString()
                    profileimage.load(link)
                    } catch (e:Exception) {
                        e.printStackTrace()
                    }
            }
        }
    }


}