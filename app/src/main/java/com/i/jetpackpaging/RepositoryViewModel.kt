package com.i.jetpackpaging

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.i.paging.models.Repository

class RepositoryViewModel: ViewModel() {
    private var dataSource = DataSourceFactory().create()
    private lateinit var repozitoriji: LiveData<PagedList<Repository>>

    init{
        val config = PagedList.Config.Builder()
            .setPrefetchDistance(RepositoryDataSource.PREFETCH_DISTANCE)
            .setInitialLoadSizeHint(RepositoryDataSource.PAGE_SIZE)
            .setPageSize(RepositoryDataSource.PAGE_SIZE)
            .setEnablePlaceholders(true)
            .build()
        repozitoriji = LivePagedListBuilder(DataSourceFactory(), config).build()
    }

    fun vrniPodatke(): LiveData<PagedList<Repository>> {
        return repozitoriji
    }
}