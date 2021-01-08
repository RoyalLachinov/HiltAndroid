package com.hilt.android.ui

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.hilt.android.util.DateFormatter
import com.hilt.android.R
import com.hilt.android.data.Log
import com.hilt.android.data.LoggerDataSource
import com.hilt.android.di.DatabaseLogger
import com.hilt.android.di.InMemoryLogger
import com.hilt.android.navigator.AppNavigator
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * Fragment that displays the database logs.
 */

@AndroidEntryPoint
class LogsFragment : Fragment() {

    @InMemoryLogger//DatabaseLogger
    @Inject lateinit var logger: LoggerDataSource
    @Inject lateinit var dateFormatter: DateFormatter
    @Inject lateinit var navigator: AppNavigator

    private lateinit var recyclerView: RecyclerView

    override fun onAttach(context: Context) {
        super.onAttach(context)
        //navigator = (context as MainActivity).navigator
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_logs, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        android.util.Log.d("InstancesNav","AppNavIns $navigator")
        android.util.Log.d("Instances","LoggerLocalIns $logger")
        android.util.Log.d("Instances","DateFormIns $dateFormatter")

        recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view).apply {
            setHasFixedSize(true)
        }
    }

    override fun onResume() {
        super.onResume()

        logger.getAllLogs { logs ->
            recyclerView.adapter =
                LogsViewAdapter(
                    logs,
                    dateFormatter
                )
        }
    }
}

/**
 * RecyclerView adapter for the logs list.
 */
private class LogsViewAdapter(
    private val logsDataSet: List<Log>,
    private val daterFormatter: DateFormatter
) : RecyclerView.Adapter<LogsViewAdapter.LogsViewHolder>() {

    class LogsViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LogsViewHolder {
        return LogsViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.text_row_item, parent, false) as TextView
        )
    }

    override fun getItemCount(): Int {
        return logsDataSet.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: LogsViewHolder, position: Int) {
        val log = logsDataSet[position]
        holder.textView.text = "${log.msg}\n\t${daterFormatter.formatDate(log.timestamp)}"
    }
}