package com.hilt.android.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.hilt.android.R
import com.hilt.android.data.*
import com.hilt.android.data.ac_retain_scope.LogRepository
import com.hilt.android.data.ac_retain_scope.LogViewModel
import com.hilt.android.data.fr_scope.LogFragmentRepo
import com.hilt.android.data.fr_scope.LogFragmentViewModel
import com.hilt.android.di.InMemoryLogger
import com.hilt.android.navigator.AppNavigator
import com.hilt.android.navigator.Screens
import com.hilt.android.util.DateFormatter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * Fragment that displays buttons whose interactions are recorded.
 */

@AndroidEntryPoint
class ButtonsFragment : Fragment() {

    @InMemoryLogger//DatabaseLogger
    @Inject lateinit var logger: LoggerDataSource
    @Inject lateinit var dateFormatter: DateFormatter
    @Inject lateinit var navigator: AppNavigator

    @Inject lateinit var logViewModel: LogViewModel
    @Inject lateinit var logFragmentViewModel: LogFragmentViewModel
    @Inject lateinit var logFragmentRepository: LogFragmentRepo
    @Inject lateinit var logRepository: LogRepository
    @Inject lateinit var appDatabase: AppDatabase
    @Inject lateinit var logDao: LogDao

    override fun onAttach(context: Context) {
        super.onAttach(context)
        //navigator = (context as MainActivity).navigator
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_buttons, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("InstancesNav","AppNavIns $navigator")
        Log.d("Instances","LoggerLocalIns $logger")
        Log.d("Instances","DateFormIns $dateFormatter")

        Log.d("Instances","ViewModelIns $logViewModel")
        Log.d("Instances","RepositoryIns $logRepository")
        Log.d("Instances","AppDataBaseIns $appDatabase")
        Log.d("Instances","LogDaoIns $logDao")

        Log.d("Instances","FragViewModelIns $logFragmentViewModel")
        Log.d("Instances","FragRepositoryIns $logFragmentRepository")


        view.findViewById<Button>(R.id.button1).setOnClickListener {
            logger.addLog("Interaction with 'Button 1'")
        }

        view.findViewById<Button>(R.id.button2).setOnClickListener {
            logger.addLog("Interaction with 'Button 2'")
        }

        view.findViewById<Button>(R.id.button3).setOnClickListener {
            logger.addLog("Interaction with 'Button 3'")
        }

        view.findViewById<Button>(R.id.all_logs).setOnClickListener {
            navigator.navigateTo(Screens.LOGS)
        }

        view.findViewById<Button>(R.id.delete_logs).setOnClickListener {
            logger.removeLogs()
        }
    }
}