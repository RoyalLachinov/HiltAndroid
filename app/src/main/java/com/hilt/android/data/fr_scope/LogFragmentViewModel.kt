package com.hilt.android.data.fr_scope

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import dagger.hilt.android.scopes.ActivityRetainedScoped

@ActivityRetainedScoped
class LogFragmentViewModel
@ViewModelInject constructor(private val logFragmentRepo: LogFragmentRepo):
    ViewModel()