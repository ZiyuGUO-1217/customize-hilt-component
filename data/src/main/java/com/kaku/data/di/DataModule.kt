package com.kaku.data.di

import com.kaku.data.repository.IRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.EntryPoints
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    //[NOTICE] return type must be an interface
    @Provides
    fun provideRepository(
        myComponentManager: MyComponentManager
    ): IRepository = EntryPoints
        .get(myComponentManager, MyEntryPoint::class.java)
        .getRepository()
}
