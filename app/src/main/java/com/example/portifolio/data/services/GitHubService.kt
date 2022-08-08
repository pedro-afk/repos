package com.example.portifolio.data.services

import com.example.portifolio.data.model.Repositories
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {
    @GET("users/{user}/repos")
    suspend fun listRepositories(@Path("user") user: String) : List<Repositories>
}