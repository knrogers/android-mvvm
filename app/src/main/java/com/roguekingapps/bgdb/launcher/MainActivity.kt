package com.roguekingapps.bgdb.launcher

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.roguekingapps.bgdb.R
import com.roguekingapps.bgdb.launcher.di.MainActivityModule
import com.roguekingapps.bgdb.boardgame.di.BoardGamesViewModelModule
import com.roguekingapps.bgdb.boardgame.viewmodel.BoardGamesViewModel
import com.roguekingapps.bgdb.launcher.di.DaggerMainActivityComponent
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
    }

}
