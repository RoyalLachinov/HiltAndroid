package com.hilt.android.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.hilt.android.R
import com.hilt.android.data.AppDatabase
import com.hilt.android.data.LogDao
import com.hilt.android.data.ac_retain_scope.LogRepository
import com.hilt.android.data.ac_retain_scope.LogViewModel
import com.hilt.android.data.fr_scope.LogFragmentRepo
import com.hilt.android.data.fr_scope.LogFragmentViewModel
import com.hilt.android.navigator.AppNavigator
import com.hilt.android.navigator.Screens
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject lateinit var navigator: AppNavigator
    @Inject lateinit var logViewModel: LogViewModel
    @Inject lateinit var logFragmentViewModel: LogFragmentViewModel
    @Inject lateinit var logFragmentRepository: LogFragmentRepo
    @Inject lateinit var logRepository: LogRepository
    @Inject lateinit var appDatabase: AppDatabase
    @Inject lateinit var logDao: LogDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("InstancesNav","AppNavIns $navigator")

        Log.d("Instances","ViewModelIns $logViewModel")
        Log.d("Instances","RepositoryIns $logRepository")

        Log.d("Instances","FragViewModelIns $logFragmentViewModel")
        Log.d("Instances","FragRepositoryIns $logFragmentRepository")

        Log.d("Instances","AppDataBaseIns $appDatabase")
        Log.d("Instances","LogDaoIns $logDao")

        if (savedInstanceState == null) {
            navigator.navigateTo(Screens.BUTTONS)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()

        if (supportFragmentManager.backStackEntryCount == 0) {
            finish()
        }
    }
}