package com.practice.hiltpractice.domain

import com.practice.hiltpractice.data.Service
import javax.inject.Inject

interface Repository {
    fun retrieve(): String
}

class RepositoryImpl @Inject constructor(private val service: Service) : Repository {
    override fun retrieve() = service.httpText()
}
