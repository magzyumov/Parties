package ru.magzyumov.party.ui.fragments.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import ru.magzyumov.party.data.entity.PartyEntity
import ru.magzyumov.party.data.repository.LocalPartyRepository
import ru.magzyumov.party.data.repository.Repository

class PartyDetailViewModel: ViewModel() {
    private val partyRepository: Repository = LocalPartyRepository()

    fun getParty(): LiveData<PartyEntity> {
        return partyRepository.getParty()
    }

}