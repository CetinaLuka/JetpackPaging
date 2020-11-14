package com.i.jetpackpaging

import androidx.paging.DataSource
import com.i.paging.models.Repository

class DataSourceFactory: DataSource.Factory<Int, Repository>(){
    override fun create(): DataSource<Int, Repository> {
        return RepositoryDataSource()
    }

}