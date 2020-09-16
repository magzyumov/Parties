package ru.magzyumov.party

import android.app.Application
import ru.magzyumov.party.data.di.AppComponent
import ru.magzyumov.party.data.di.AppModule
import ru.magzyumov.party.data.di.DaggerAppComponent

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        component = generateAppComponent()
    }

    private fun generateAppComponent(): AppComponent {
        return DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
    }

    companion object{
        private lateinit var component: AppComponent

        fun getComponent(): AppComponent = component
    }
}