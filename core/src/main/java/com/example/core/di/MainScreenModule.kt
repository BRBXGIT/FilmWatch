package com.example.core.di

import android.content.Context
import com.example.core.data.network.MainScreenApiInstance
import com.example.core.data.repos.MainScreenRepoImpl
import com.example.core.domain.MainScreenRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainScreenModule {

    @Provides
    @Singleton
    fun provideMainScreenApiInstance(): MainScreenApiInstance {
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideMainScreenRepo(
        mainScreenApiInstance: MainScreenApiInstance,
        @ApplicationContext context: Context
    ): MainScreenRepo {
        return MainScreenRepoImpl(mainScreenApiInstance, context)
    }
}