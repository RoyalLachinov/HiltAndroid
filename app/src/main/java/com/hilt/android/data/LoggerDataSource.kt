package com.hilt.android.data

interface LoggerDataSource {

    fun addLog(msg: String)
    fun getAllLogs(callback: (List<Log>) -> Unit)
    fun removeLogs()

}