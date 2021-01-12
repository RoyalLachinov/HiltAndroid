package com.hilt.android.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.hilt.android.R
import com.hilt.android.data.ac_retain_scope.LogViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LaunchActivity : AppCompatActivity() {

    @Inject
    lateinit var logViewModel: LogViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)

        Log.d("Instances","ViewModelInsLunch $logViewModel")

        startActivity(Intent(this,MainActivity::class.java))
        finish()
    }
}