package com.kaku.data.repository

import kotlinx.coroutines.flow.Flow

interface IRepository {

    val currentRepoInfo: Flow<String>

    val num: Flow<Int>

    fun add()

    fun reduce()
}
