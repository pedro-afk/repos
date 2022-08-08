package com.example.portifolio.domain

import com.example.portifolio.core.UseCase
import com.example.portifolio.data.model.Repositories
import com.example.portifolio.data.repositories.RepoRepository
import kotlinx.coroutines.flow.Flow

class ListUserRepositoriesUseCase(private val repository: RepoRepository): UseCase<String, List<Repositories>>() {
    override suspend fun execute(param: String): Flow<List<Repositories>> {
        return repository.listRepositories(param)
    }

}