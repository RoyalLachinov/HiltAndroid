package com.hilt.android.di

import com.hilt.android.data.ac_retain_scope.LogRepoApiService
import com.hilt.android.data.ac_retain_scope.LogRepository
import com.hilt.android.data.ac_retain_scope.LogViewModel
import com.hilt.android.data.fr_scope.LogFragmentRepo
import com.hilt.android.data.fr_scope.LogFragmentViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@InstallIn(ActivityRetainedComponent::class)
@Module
object ViewModelModule {

    @Provides
    fun provideLaunchListApi(retrofit: Retrofit): LogRepoApiService {
        return retrofit.create(LogRepoApiService::class.java)
    }

    @Provides
    @ActivityRetainedScoped
    fun provideLogRepository(logRepoApiService: LogRepoApiService): LogRepository {
        return LogRepository(logRepoApiService)
    }

    @Provides
    @ActivityRetainedScoped
    fun retrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.spacexdata.com/v3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    @Provides
    @ActivityRetainedScoped
    fun provideLogViewModel(logRepository: LogRepository): LogViewModel {
        return LogViewModel(logRepository)
    }

    @Provides
    @ActivityRetainedScoped
    fun provideLogFragmentViewModel(logRepository: LogFragmentRepo): LogFragmentViewModel {
        return LogFragmentViewModel(logRepository)
    }
}