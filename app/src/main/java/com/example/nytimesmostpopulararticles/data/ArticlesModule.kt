package com.example.nytimesmostpopulararticles.data

import com.example.nytimesmostpopulararticles.data.remote.RetrofitServices
import com.example.nytimesmostpopulararticles.app.utill.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ArticlesModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    @Provides
    fun provideRetrofitApi(retrofit: Retrofit): RetrofitServices {
        return retrofit.create(RetrofitServices::class.java)
    }
}