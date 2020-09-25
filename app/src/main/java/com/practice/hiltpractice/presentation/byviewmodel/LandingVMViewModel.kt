package com.practice.hiltpractice.presentation.byviewmodel

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.practice.hiltpractice.domain.Repository
import com.practice.hiltpractice.presentation.byviewmodel.LandingVMFragment.Companion.RETAINED_INFO


class LandingVMViewModel @ViewModelInject constructor(
    @Assisted private val handle: SavedStateHandle,
    private val repository: Repository) : ViewModel() {

    lateinit var hostName: String

    fun loadContent(): String = """
        ${repository.retrieve()} in $hostName
        ViewModel-ID: ${System.identityHashCode(this)}
    """.trimIndent()

    fun loadBundle(): String? = handle[RETAINED_INFO]

    fun saveBundle(data: String) {
        handle[RETAINED_INFO] = data
    }
}