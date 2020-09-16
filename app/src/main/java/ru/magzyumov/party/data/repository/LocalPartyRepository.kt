package ru.magzyumov.party.data.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import ru.magzyumov.party.App
import ru.magzyumov.party.data.entity.PartyEntity
import java.io.IOException
import javax.inject.Inject

class LocalPartyRepository: Repository {
    private val gson = Gson()

    @Inject
    lateinit var applicationContext: Context

    init {
        App.getComponent().inject(this)
    }

    private fun getJsonDataFromAsset(context: Context, fileName: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }

    override fun getParty(): LiveData<PartyEntity> {
        val party = MutableLiveData<PartyEntity>()
        party.postValue(gson.fromJson(getJsonDataFromAsset(applicationContext,"party.json"), PartyEntity::class.java))
        return party
    }

}