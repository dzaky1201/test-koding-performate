package com.example.performate.di

import com.example.performate.data.PhoneRemoteDataSource
import com.example.performate.data.PhoneRepository
import com.example.performate.ui.home.MainViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ViewModelModule{

    @Singleton
    @Provides
    fun providePhoneRepository(
       remoteDataSource: PhoneRemoteDataSource
    ): PhoneRepository {
        return PhoneRepository(remoteDataSource)
    }

    @Singleton
    @Provides
    fun provideMainViewModelFactory(
        repository: PhoneRepository,
    ): MainViewModelFactory {
        return MainViewModelFactory(repository)
    }
}