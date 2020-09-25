package com.practice.hiltpractice

import com.practice.hiltpractice.domain.Repository
import com.practice.hiltpractice.domain.RepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindsRepository(repositoryImpl: RepositoryImpl): Repository
}