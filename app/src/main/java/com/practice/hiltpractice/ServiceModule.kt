package com.practice.hiltpractice

import com.practice.hiltpractice.data.Service
import com.practice.hiltpractice.data.ServiceFancyImpl
import com.practice.hiltpractice.data.ServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Named

@Module
@InstallIn(ApplicationComponent::class)
object ServiceModule {
    @Provides
    fun provideDefaultService(): Service {
        return ServiceImpl()
    }

    @Provides
    @Named("ServiceFancyImpl")
    fun provideFancyService(): Service {
        return ServiceFancyImpl()
    }
}