package com.i.jetpackpaging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.paging.PagedList
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repoViewModel = ViewModelProviders.of(this)[RepositoryViewModel::class.java]
        val decoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        seznam.addItemDecoration(decoration)
        seznam.layoutManager = LinearLayoutManager(this)
        val adapter = RecyclerViewAdapter()
        repoViewModel.vrniPodatke().observe(this, Observer { repozitoriji ->
            adapter.submitList(repozitoriji)
        })
        seznam.adapter = adapter
    }
}