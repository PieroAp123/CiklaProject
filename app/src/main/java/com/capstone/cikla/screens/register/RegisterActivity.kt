package com.capstone.cikla.screens.register

import android.Manifest
import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.util.Base64
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.capstone.cikla.R
import com.capstone.cikla.screens.login.LoginActivity
import kotlinx.android.synthetic.main.activity_register.*
import java.io.ByteArrayOutputStream


class RegisterActivity: AppCompatActivity() {

    lateinit var viewModel: RegisterViewModel

    private val REQUEST_GALLERY = 1001
    private val REQUEST_CAMERA = 1002

    var pick: Uri? = null
    var imageBy: String = ""
    lateinit var imageG: ImageView
    lateinit var textImg: TextView
    lateinit var textImgDni: TextView
    lateinit var textImgDni2: TextView
    lateinit var textImgProfile: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        viewModel = ViewModelProviders.of(this).get(RegisterViewModel::class.java)

        //imageG = findViewById(R.id.imgDni)
        //textImgDni = findViewById(R.id.regImg1Cikla)
        //galleryClick()
        buttonRegister.setOnClickListener {
            viewModel.saveUser(regUserCikla.text.toString(), regPassCikla.text.toString(), regEmailCikla.text.toString(), regDniCikla.text.toString(), regNombreApellidoCikla.text.toString(),
                regDireccionCikla.text.toString(), regCelularCikla.text.toString(), regTelefonoCikla.text.toString(), regSexoCikla.text.toString(),
                regFechaNacCikla.text.toString(), regIdCikla.text.toString().toInt())

        }

        //userBack.setOnClickListener { onBackPressed() }
        txtGoLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode) {
            REQUEST_GALLERY -> {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    openGallery()
                } else {
                    Toast.makeText(this, "No puedes acceder a la galería", Toast.LENGTH_SHORT).show()
                }
            }
            REQUEST_CAMERA -> {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    openCamera()
                } else {
                    Toast.makeText(this, "No puedes acceder a la cámara", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    /*private fun cameraClick() {
        camera.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED || checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                    val permissionCamera = arrayOf(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    requestPermissions(permissionCamera, REQUEST_CAMERA)
                } else {
                    openCamera()
                }
            } else {
                openCamera()
            }
        }

    }*/

    /*private fun galleryClick() {
        gallery.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED || checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                    val permissionArchive = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    requestPermissions(permissionArchive, REQUEST_GALLERY)
                } else {
                    openGallery()
                }
            } else {
                openGallery()
            }
        }

    }*/



    private fun openGallery() {
        imageG.setImageBitmap(null)
        val intentGallery = Intent(Intent.ACTION_PICK)
        intentGallery.type = "image/*"
        startActivityForResult(intentGallery, REQUEST_GALLERY)
    }

    private fun openCamera() {
        val value = ContentValues()
        value.put(MediaStore.Images.Media.TITLE, "Nueva imagen")
        pick = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, value)
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, pick)
        startActivityForResult(cameraIntent, REQUEST_CAMERA)
    }

    private fun goLogin(){
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

    override fun onStart() {
        super.onStart()
        supportActionBar?.hide()
    }

   /* override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_GALLERY) {
            val uri = uri(data, textImgDni)
            imgDni.setImageURI(uri)
        }

        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CAMERA) {
            imgDni.setImageURI(pick)
        }

    }*/

    private fun uri(data: Intent?, textImage: TextView): Uri? {
        val uri = data?.data
        val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, uri)
        val stream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream)
        val bytes = stream.toByteArray()
        imageBy = Base64.encodeToString(bytes, Base64.DEFAULT)
        textImage.text = imageBy
        return uri
    }


    /*fun observerViewModel(){
        viewModel.userRegisterServiceResponse.observe(this, Observer {
            if (it) {
                Toast.makeText(this, "Registrado con éxito", Toast.LENGTH_SHORT).show()
                goLogin()
            } else {
                Toast.makeText(this, "Verifique sus datos ingresados", Toast.LENGTH_SHORT).show()
            }
        })
    }*/



}