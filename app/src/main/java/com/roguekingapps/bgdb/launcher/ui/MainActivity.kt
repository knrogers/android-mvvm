package com.roguekingapps.bgdb.launcher.ui

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.roguekingapps.bgdb.R
import com.roguekingapps.bgdb.boardgame.viewmodel.BoardGamesViewModel
import com.roguekingapps.bgdb.launcher.di.DaggerMainActivityComponent
import com.roguekingapps.bgdb.launcher.di.MainActivityComponent
import kotlinx.android.synthetic.main.activity_main.mainTextView

class MainActivity : AppCompatActivity() {

    private val component: MainActivityComponent by lazy {
        DaggerMainActivityComponent.factory()
            .create(this)
    }

    private val viewModel: BoardGamesViewModel by lazy { component.viewModel }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.getBoardGames()

        viewModel.boardGames.observe(this, Observer {
            mainTextView.text = it.toString()
        })
    }

}
