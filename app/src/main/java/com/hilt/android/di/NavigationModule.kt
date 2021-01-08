package com.hilt.android.di

import com.hilt.android.navigator.AppNavigator
import com.hilt.android.navigator.AppNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@InstallIn(ActivityComponent::class)
@Module
abstract class NavigationModule {

    @Binds
    @ActivityScoped
    abstract fun bindNavigator(appNavigatorImpl: AppNavigatorImpl): AppNavigator
}