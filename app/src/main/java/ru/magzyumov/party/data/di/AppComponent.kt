package ru.magzyumov.party.data.di

import dagger.Component
import ru.magzyumov.party.data.repository.LocalPartyRepository
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(repository: LocalPartyRepository)
}