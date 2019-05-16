package com.roguekingapps.bgdb

import dagger.Component

@ViewModelScope
@Component(modules = [BoardGamesViewModelModule::class])
interface BoardGamesViewModelComponent {

    fun inject(viewModel: BoardGamesViewModel)

}
