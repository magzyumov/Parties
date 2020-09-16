package ru.magzyumov.party.data.repository

import androidx.lifecycle.LiveData
import ru.magzyumov.party.data.entity.PartyEntity

interface Repository {
    fun getParty(): LiveData<PartyEntity>
}