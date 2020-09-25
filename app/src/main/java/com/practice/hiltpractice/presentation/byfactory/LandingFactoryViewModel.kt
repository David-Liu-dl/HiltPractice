package com.practice.hiltpractice.presentation.byfactory

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.practice.hiltpractice.domain.Repository
import com.practice.hiltpractice.presentation.byfactory.LandingFactoryFragment.Companion.RETAINED_INFO


class LandingFactoryViewModel(
    private val handle: SavedStateHandle,
    private val repository: Repository,
    private val hostName: String
) : ViewModel() {

    fun loadContent(): String = """
        ${repository.retrieve()} in $hostName
        ViewModel-ID: ${System.identityHashCode(this)}
    """.trimIndent()

    fun loadBundle(): String? = handle[RETAINED_INFO]

    fun saveBundle(data: String) {
        handle[RETAINED_INFO] = data
    }
}