package com.roguekingapps.bgdb.launcher.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.roguekingapps.bgdb.R
import com.roguekingapps.bgdb.application.BGDbApplication
import com.roguekingapps.bgdb.boardgame.viewmodel.BoardGamesViewModel
import com.roguekingapps.bgdb.launcher.di.DaggerMainActivityComponent
import kotlinx.android.synthetic.main.activity_main.mainTextView
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var viewModel: BoardGamesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DaggerMainActivityComponent.factory()
            .create(this, (application as BGDbApplication).applicationComponent)
            .inject(this)
        viewModel.getBoardGames()

        viewModel.boardGames.observe(this, Observer {
            mainTextView.text = it.toString()
        })
    }

}
