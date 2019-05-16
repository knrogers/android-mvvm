package com.roguekingapps.bgdb

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: BoardGamesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DaggerMainActivityComponent.builder()
            .mainActivityModule(MainActivityModule(this))
            .boardGamesViewModelModule(BoardGamesViewModelModule())
            .build()
            .inject(this)
        // println("viewModel is: $viewModel")
    }

}
