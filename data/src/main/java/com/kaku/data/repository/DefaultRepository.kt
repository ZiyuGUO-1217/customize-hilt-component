package com.kaku.data.repository

import com.kaku.data.di.MyScope
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.update

@MyScope
class DefaultRepository @Inject constructor() : IRepository {
    override val currentRepoInfo: Flow<String> = flow {
        emit("${this@DefaultRepository}")
    }

    private val _num = MutableStateFlow(0)
    override val num: Flow<Int> = _num.asStateFlow()

    override fun add() {
        _num.update {
            it + 1
        }
    }

    override fun reduce() {
        _num.update {
            it - 1
        }
    }
}
