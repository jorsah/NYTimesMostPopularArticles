package com.example.nytimesmostpopulararticles.helpers

import com.example.nytimesmostpopulararticles.domain.ArticlesRepository
import com.example.nytimesmostpopulararticles.domain.RepositoryModule
import dagger.Module
import dagger.Provides
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.testing.TestInstallIn

@TestInstallIn(
    components = [ViewModelComponent::class],
    replaces = [RepositoryModule::class]
)
@Module
class FakeRepoModule {
    @Provides
    fun getRepoSource(): ArticlesRepository = FakeDataRepoImpl()

}