package com.example.smsreceiver

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.smsreceiver.databinding.ActivityMainBinding
import android.Manifest

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var binding: ActivityMainBinding? = null

    var requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        if (isGranted) {
            Toast.makeText(this, "Sms receiver permission diterima", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Sms receiver permission ditolak", Toast.LENGTH_SHORT).show()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.btnPermission?.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
       when (v?.id) {
            R.id.btn_permission -> requestPermissionLauncher.launch(Manifest.permission.RECEIVE_SMS)
       }
    }

    override fun onDestroy() {
        super.onDestroy()

        binding = null
    }
}