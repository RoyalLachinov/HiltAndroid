package com.hilt.android.data.ac_retain_scope

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import dagger.hilt.android.scopes.ActivityRetainedScoped

@ActivityRetainedScoped
class LogViewModel @ViewModelInject constructor(private val logRepository: LogRepository): ViewModel()