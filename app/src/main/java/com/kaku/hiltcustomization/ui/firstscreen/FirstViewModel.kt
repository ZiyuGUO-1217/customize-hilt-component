package com.kaku.hiltcustomization.ui.firstscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kaku.data.repository.IRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

@HiltViewModel
class FirstViewModel @Inject constructor(
    private val repo: IRepository
): ViewModel() {

    val repoInfo: StateFlow<String> = repo.currentRepoInfo
        .map { "current repo: $it" }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = "current repo: null"
        )

    val number: StateFlow<String> = repo.num
        .map { it.toString() }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = "null"
        )

    fun addNum() {
        repo.add()
    }

    fun reduceNum() {
        repo.reduce()
    }
}
