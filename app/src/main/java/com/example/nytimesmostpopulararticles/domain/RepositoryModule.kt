package com.example.nytimesmostpopulararticles.domain

import com.example.nytimesmostpopulararticles.data.ArticlesRepositoryImpl
import com.example.nytimesmostpopulararticles.data.remote.RetrofitServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Singleton
    @Provides
    fun provideRecipeRepository(services: RetrofitServices): ArticlesRepository {
        return ArticlesRepositoryImpl(
            services
        )
    }
}