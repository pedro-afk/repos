package com.example.portifolio.data.repositories

import com.example.portifolio.data.model.Repositories
import kotlinx.coroutines.flow.Flow

interface RepoRepository {
    suspend fun listRepositories(user: String): Flow<List<Repositories>>
}