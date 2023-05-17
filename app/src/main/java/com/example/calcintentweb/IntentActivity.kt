package com.example.calcintentweb

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class IntentActivity : AppCompatActivity() {
    lateinit var Buttonsms:Button
    lateinit var Buttoncall:Button
    lateinit var Buttoncamera:Button
    lateinit var Buttonshare:Button
    lateinit var Buttonmpesa:Button
    lateinit var Buttondial:Button
    lateinit var Buttonemail:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)
        Buttonsms=findViewById(R.id.btn_sms)
        Buttoncall=findViewById(R.id.btn_call)
        Buttoncamera=findViewById(R.id.btn_cam)
        Buttonshare=findViewById(R.id.btn_share)
        Buttonmpesa=findViewById(R.id.btn_Mpesa)
        Buttondial=findViewById(R.id.btn_dial)
        Buttonemail=findViewById(R.id.btn_email)


        Buttonsms.setOnClickListener{
           val uri=Uri.parse("smsto:0734224509")
            val intent=Intent(Intent.ACTION_SENDTO,uri)
            intent.putExtra("Hello","Good morning")
            startActivity(intent)
        }
        Buttoncamera.setOnClickListener {
            val takepic=Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takepic,1)
        }
        Buttondial.setOnClickListener {
            val nambari="+2547564544"
            val intent=Intent(Intent.ACTION_DIAL,Uri.fromParts("tel",nambari,null))
            startActivity(intent)
        }
        Buttonemail.setOnClickListener {
            val emailintent=Intent(Intent.ACTION_SENDTO, Uri.fromParts("mail","harrykim931@gmail.com",null))
            emailintent.putExtra(Intent.EXTRA_SUBJECT,"subject")
            emailintent.putExtra(Intent.EXTRA_TEXT,"Body")
            startActivity(Intent.createChooser(emailintent,"send email..."))
        }
        Buttonmpesa.setOnClickListener {
            val simToolKitLaunchIntent =
                applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")

            simToolKitLaunchIntent?.let { startActivity(it) }
        }
        Buttonshare.setOnClickListener {
            val shareIntent=Intent(Intent.ACTION_SEND)
            shareIntent.flags=Intent.FLAG_ACTIVITY_NEW_TASK
            shareIntent.type="text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT,"Hi,click to download")
            startActivity(shareIntent)
        }
        Buttoncall.setOnClickListener {
            val intent=Intent(Intent.ACTION_CALL, Uri.parse("tel"+"+254 734224509"))
            if(ContextCompat.checkSelfPermission(this@IntentActivity,android.Manifest.permission.CALL_PHONE)!=PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this@IntentActivity, arrayOf(android.Manifest.permission.CALL_PHONE),1)

            }else{
                startActivity(intent)
            }


        }
    }
}