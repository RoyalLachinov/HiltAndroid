package com.hilt.android.di

import com.hilt.android.navigator.AppNavigator
import com.hilt.android.navigator.AppNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@InstallIn(ActivityComponent::class)
@Module
abstract class NavigationModule {

    @Binds
    abstract fun bindNavigator(appNavigatorImpl: AppNavigatorImpl): AppNavigator
}