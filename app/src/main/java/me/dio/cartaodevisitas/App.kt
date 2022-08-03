package me.dio.cartaodevisitas

import android.app.Application
import me.dio.cartaodevisitas.data.AppDatabase
import me.dio.cartaodevisitas.data.BusinessCardRepository

class App : Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { BusinessCardRepository(database.businessDao()) }
}