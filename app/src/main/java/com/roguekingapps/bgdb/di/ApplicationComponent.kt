package com.roguekingapps.bgdb.di

import com.roguekingapps.bgdb.application.BGDbApplication
import com.roguekingapps.bgdb.util.ViewModelFactory
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ViewModelFactoryModule::class])
interface ApplicationComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: BGDbApplication): ApplicationComponent
    }

    val viewModelFactory: ViewModelFactory

}
