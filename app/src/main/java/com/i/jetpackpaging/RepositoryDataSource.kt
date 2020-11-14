package com.i.jetpackpaging

import android.util.Log
import androidx.paging.PageKeyedDataSource
import androidx.paging.PositionalDataSource
import com.i.paging.models.Repository

class RepositoryDataSource: PageKeyedDataSource<Int, Repository>() {
    private val githubService = GithubService.create()

    companion object {
        const val FIRST_PAGE = 1
        const val PAGE_SIZE = 10
        const val PREFETCH_DISTANCE = 2
    }

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Repository>) {
        searchRepos(
            githubService,
            "Android",
            FIRST_PAGE,
            params.requestedLoadSize,
            { repos ->
                if (repos.size > 0)
                    callback.onResult(repos, null, FIRST_PAGE+1)
            },
            { error ->
                Log.i("paging", "Napaka $error")
            })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Repository>) {
        searchRepos(
            githubService,
            "Android",
            params.key,
            params.requestedLoadSize,
            { repos ->
                if (repos.size > 0)
                    callback.onResult(repos, params.key+1)
            },
            { error ->
                Log.i("paging", "Napaka $error")
            })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Repository>) {
        Log.i("paging", "before ${params.key}, ${params.requestedLoadSize}")
    }
}