package com.example.iteradmin.bluetooth

import android.app.Activity
import android.app.DownloadManager
import android.bluetooth.BluetoothAdapter
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private  val REQUEST_CODE:Int = 108

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val active = findViewById<Button>(R.id.button)

        val batp:BluetoothAdapter=BluetoothAdapter.getDefaultAdapter()
        active.setOnClickListener {
            if (batp == null) {
                Toast.makeText(this, "Bluetooth  not found", Toast.LENGTH_LONG).show()
            }else{
                if (batp.isEnabled  == false) {
                    val intent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)

                    startActivityForResult(intent,REQUEST_CODE)
                }else{
                    Toast.makeText(this, "Bluetooth  already on...", Toast.LENGTH_LONG).show()

                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK){
            Toast.makeText(this,"success",Toast.LENGTH_LONG).show()
        }

    }
}
