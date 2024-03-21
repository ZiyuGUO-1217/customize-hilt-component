package com.kaku.data.di

import com.kaku.data.repository.DefaultRepository
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn

@InstallIn(MyComponent::class)
@EntryPoint
interface MyEntryPoint {

    //[NOTICE] return type must be an instance
    fun getRepository(): DefaultRepository
}
