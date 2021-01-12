package com.hilt.android.di

import com.hilt.android.data.fr_scope.LogFragmentApiService
import com.hilt.android.data.fr_scope.LogFragmentRepo
import com.hilt.android.data.fr_scope.LogFragmentViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import dagger.hilt.android.scopes.FragmentScoped
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@InstallIn(FragmentComponent::class)
@Module
object FragmentScopeModule {


/*    @FragmentScoped
    @Provides
    fun provideLaunchListApi(retrofit: Retrofit): LogFragmentApiService {
        return retrofit.create(LogFragmentApiService::class.java)
    }*/

    @Provides
    @FragmentScoped
    fun provideLogRepository(): LogFragmentRepo {
        return LogFragmentRepo()
    }

    @Provides
    @FragmentScoped
    fun retrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.spacexdata.com/v3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}