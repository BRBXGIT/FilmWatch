package com.example.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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
    fun provideMainScreenApiInstance() {
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }
}